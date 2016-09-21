package com.musketeer.ten.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.musketeer.ten.ui.fragments.CriticFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kevin on 2016/9/21.
 */
public class CriticAdapter extends FragmentPagerAdapter {

    private List<Fragment> data;

    public CriticAdapter(FragmentManager fm,List<Fragment> data) {
        super(fm);

        if (data!=null) {
            this.data = data;
        }else{
            this.data = new ArrayList<>();
        }
    }

    @Override
    public Fragment getItem(int position) {

        return data.get(position);
    }

    @Override
    public int getCount() {
        return data!=null?data.size():0;
    }

    public void upDataRes(List<CriticFragment> data) {
        if (data!=null) {
            this.data.clear();
            this.data.addAll(data);
            notifyDataSetChanged();
        }
    }

}
