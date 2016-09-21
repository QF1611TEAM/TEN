package com.musketeer.ten.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.musketeer.ten.Beans.CriticBeanBody;
import com.musketeer.ten.R;
import com.musketeer.ten.http.CriticParams;
import com.squareup.picasso.Picasso;

import org.xutils.common.Callback;
import org.xutils.x;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Kevin on 2016/9/21.
 */
public class CriticChildFragment extends BaseFragment {

    private static final String TAG = CriticFragment.class.getSimpleName();
    //
    @BindView(R.id.image_critic_item)
    ImageView mImageCriticItem;
    @BindView(R.id.title_critic)
    TextView mTitleCritic;
    @BindView(R.id.critic_author_times)
    TextView mCriticAuthorTimes;
    @BindView(R.id.critic_text1)
    TextView mCriticText1;
    @BindView(R.id.critic_image1)
    ImageView mCriticImage1;
    @BindView(R.id.critic_text2)
    TextView mCriticText2;
    @BindView(R.id.critic_realtitle)
    TextView mCriticRealtitle;
    @BindView(R.id.critic_image2)
    ImageView mCriticImage2;
    @BindView(R.id.critic_text3)
    TextView mCriticText3;
    @BindView(R.id.critic_text4)
    TextView mCriticText4;
    @BindView(R.id.critic_text5)
    TextView mCriticText5;
    @BindView(R.id.critic_image3)
    ImageView mCriticImage3;
    @BindView(R.id.critic_image4)
    ImageView mCriticImage4;
    @BindView(R.id.critic_author)
    TextView mCriticAuthor;
    @BindView(R.id.critic_authorbrief)
    TextView mCriticAuthorbrief;
    //
    private int id = 100035;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        layout = inflater.inflate(R.layout.fragmnet_cirticchild, container, false);
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

    }

    /**
     * 设置数据
     */
    private void setView() {
        getDataFromHttp();
    }

    /**
     * 网络获取数据
     */
    private void getDataFromHttp() {
        CriticParams params = new CriticParams();
        params.id = id;
        x.http().get(params, new Callback.CommonCallback<CriticBeanBody>() {
            @Override
            public void onSuccess(CriticBeanBody result) {
                Log.e(TAG, "onSuccess: " + result);
                if (result != null) {
                    refreshUI(result);
                }
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
     * 更新UI
     *
     * @param result
     */
    private void refreshUI(CriticBeanBody result) {
        mTitleCritic.setText(result.getTitle());
        mCriticAuthor.setText("作者是：" + result.getAuthor() + "\t|\t阅读次数：" + result.getTimes());
        mCriticText1.setText(result.getText1());
        mCriticText2.setText(result.getText2());
        mCriticText3.setText(result.getText3());
        mCriticText4.setText(result.getText4());
        mCriticRealtitle.setText(result.getRealtitle());
        mCriticAuthorbrief.setText(result.getAuthorbrief());
        Picasso.with(getActivity()).load(result.getImage1()).into(mCriticImage1);
    }


}
