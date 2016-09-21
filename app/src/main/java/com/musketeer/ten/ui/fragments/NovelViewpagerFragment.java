package com.musketeer.ten.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.musketeer.ten.R;

/**
 * Created by Kevin on 2016/9/20.
 */
public class NovelViewpagerFragment extends BaseFragment {

    public static final String TAG = NovelViewpagerFragment.class.getSimpleName();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        layout = inflater.inflate(R.layout.novel_viewpager,container,false);
        return layout;
    }
}
