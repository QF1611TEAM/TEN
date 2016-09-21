package com.musketeer.ten.ui.fragments;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.musketeer.ten.Beans.CriticBean;
import com.musketeer.ten.R;
import com.musketeer.ten.adapters.CriticAdapter;
import com.musketeer.ten.constants.HttpConstant;
import com.musketeer.ten.http.CriticParams;

import org.xutils.DbManager;
import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by Kevin on 2016/9/20.
 */
public class CriticFragment extends BaseFragment implements Handler.Callback {
    public static final String TAG = CriticFragment.class.getSimpleName();
    @BindView(R.id.critic_viewpager)
    ViewPager mViewpager;

    //
    private CriticAdapter mAdapter;
    //
    private Handler mHandler = new Handler(this);
    //
    DbManager.DaoConfig mConfig = new DbManager.DaoConfig()
            .setDbName("CirticDataBase");

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        layout = inflater.inflate(R.layout.criticfragment, container, false);
        ButterKnife.bind(this, layout);
        return layout;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        setView();
    }

    /**
     * 初始化控件
     */
    private void initView() {
        mAdapter = new CriticAdapter(getFragmentManager(), getTempData());
        mViewpager.setAdapter(mAdapter);
    }

    /**
     * 设置数据
     */
    private void setView() {
        getDataFromHttp();
    }

    /**
     * 获取网络数据
     */
    private void getDataFromHttp() {

        RequestParams requestParams = new RequestParams(HttpConstant.CIRTIC_URL);

        x.http().get(requestParams, new Callback.CommonCallback<CriticBean>() {
            @Override
            public void onSuccess(CriticBean result) {
                Log.e(TAG, "onSuccess: " + result.toString());
                
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Log.e(TAG, "onError: " + ex.getMessage());
            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }

    /**
     * 获取数据库数据
     */
    private void getDataFromDataBase() {

    }

    /**
     * 伪数据
     */
    private List<Fragment> getTempData() {

        List<Fragment> data = new ArrayList<>();

        for (int i = 0; i < 10; i++) {

            CriticChildFragment fragment = new CriticChildFragment();

            data.add(fragment);
        }
        return data;
    }


//-------------------handler监听-------------------------

    @Override
    public boolean handleMessage(Message msg) {

        return false;
    }


}
