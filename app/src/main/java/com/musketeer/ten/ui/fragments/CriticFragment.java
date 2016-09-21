package com.musketeer.ten.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.musketeer.ten.R;
import com.musketeer.ten.adapters.CriticAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Kevin on 2016/9/20.
 */
public class CriticFragment extends BaseFragment {
    public static final String TAG = CriticFragment.class.getSimpleName();
    @BindView(R.id.critic_viewpager)
    ViewPager mViewpager;
    private CriticAdapter mAdapter;

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



    }

}
