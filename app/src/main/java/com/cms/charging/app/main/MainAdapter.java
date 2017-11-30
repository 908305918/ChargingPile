package com.cms.charging.app.main;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;

import java.util.List;

/**
 * Created by WD on 2017/8/15.
 */

public class MainAdapter extends FragmentStatePagerAdapter {

    private List<Fragment> mDataList;

    public MainAdapter(FragmentManager fm, List<Fragment> list) {
        super(fm);
        mDataList = list;
    }

    @Override
    public Fragment getItem(int position) {
        return mDataList.get(position);
    }

    @Override
    public int getCount() {
        return mDataList.size();
    }

    @Override
    public int getItemPosition(Object object) {
        return PagerAdapter.POSITION_NONE;
    }

}
