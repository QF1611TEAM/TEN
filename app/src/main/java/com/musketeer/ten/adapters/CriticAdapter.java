package com.musketeer.ten.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;

import com.musketeer.ten.R;
import com.musketeer.ten.ui.fragments.CriticChildFragment;
import com.musketeer.ten.ui.fragments.CriticFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kevin on 2016/9/21.
 */
public class CriticAdapter extends FragmentPagerAdapter {

    private static final String TAG = CriticFragment.class.getSimpleName();
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

    public void upDataRes(List<CriticChildFragment> data) {
        Log.e(TAG, "更新适配器： "+data.toString());
        if (data!=null) {
            this.data.clear();
            this.data.addAll(data);
            notifyDataSetChanged();
        }
    }

}
