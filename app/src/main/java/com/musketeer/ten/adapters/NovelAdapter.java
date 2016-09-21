package com.musketeer.ten.adapters;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.musketeer.ten.ui.fragments.NovelViewpagerFragment;

import java.util.List;

/**
 * Created by Kevin on 2016/9/21.
 */
public class NovelAdapter extends FragmentPagerAdapter{
    private List<NovelViewpagerFragment> data;

    public NovelAdapter(FragmentManager fm, List<NovelViewpagerFragment> data) {
        super(fm);
        this.data = data;
    }

    @Override
    public NovelViewpagerFragment getItem(int position) {
        return data.get(position);
    }

    @Override
    public int getCount() {
        return data.size();
    }
}
