package com.musketeer.ten.ui.fragments;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.musketeer.ten.R;
import com.musketeer.ten.adapters.CriticAdapter;

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
        mAdapter = new CriticAdapter(null);
        mViewpager.setAdapter(mAdapter);
    }

    /**
     * 设置数据
     */
    private void setView() {
        mAdapter.upDataRes(getTempData());


    }

    /**
     * 获取网络数据
     */
    private void getDataFromHttp() {

    }

    /**
     * 获取数据库数据
     */
    private void getDataFromDataBase() {

    }

    /**
     * 伪数据
     */
    private List<View> getTempData() {
        List<View> data = new ArrayList<>();
        for (int i = 0; i < 10; i++) {

//            data.add(view);
        }
        return data;
    }


//-------------------handler监听-------------------------

    @Override
    public boolean handleMessage(Message msg) {

        return false;
    }


}
