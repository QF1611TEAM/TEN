package com.musketeer.ten.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.musketeer.ten.ui.fragments.DiagramShowFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kevin on 2016/9/21.
 */
public class DiagramAdapter extends FragmentPagerAdapter {


    private List<DiagramShowFragment> data;
    public DiagramAdapter(FragmentManager fm,List<DiagramShowFragment> data) {
        super(fm);
        if (data != null) {
            this.data = data;
        }else {
            this.data = new ArrayList<>();
        }
    }

    public void addData(List<DiagramShowFragment> updata){
        data.addAll(updata);
        notifyDataSetChanged();
    }

    @Override
    public DiagramShowFragment getItem(int position) {
        return data.get(position);
    }

    @Override
    public int getCount() {
        return data != null ? data.size() : 0;
    }
}
