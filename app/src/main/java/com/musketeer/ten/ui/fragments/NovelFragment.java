package com.musketeer.ten.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.musketeer.ten.R;
import com.musketeer.ten.adapters.NovelAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Kevin on 2016/9/20.
 */
public class NovelFragment extends BaseFragment {

    public static final String TAG = NovelFragment.class.getSimpleName();
    @BindView(R.id.novel_data_shi)
    ImageView mNovelDataShi;
    @BindView(R.id.novel_data_ge)
    ImageView mNovelDataGe;
    @BindView(R.id.novel_week)
    ImageView mNovelWeek;
    @BindView(R.id.novel_month)
    ImageView mNovelMonth;
    @BindView(R.id.novel_Viewpager)
    ViewPager mNovelViewpager;
    private NovelAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        layout = inflater.inflate(R.layout.novelfragment, container, false);
        ButterKnife.bind(this, layout);
        return layout;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
    }

    private void initView() {
        List<NovelViewpagerFragment> data = new ArrayList<>();
        for (int i = 0; i <10; i++) {
            NovelViewpagerFragment viewpagerFragment = new NovelViewpagerFragment();
            data.add(viewpagerFragment);
        }
        adapter = new NovelAdapter(getFragmentManager(),data);
        mNovelViewpager.setAdapter(adapter);
    }
}
