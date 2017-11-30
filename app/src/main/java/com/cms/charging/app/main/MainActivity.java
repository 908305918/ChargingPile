package com.cms.charging.app.main;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.cms.charging.R;
import com.cms.charging.app.base.BaseActivity;
import com.cms.charging.app.main.home.HomeFragment;
import com.cms.charging.app.main.mine.MineFragment;
import com.cms.charging.app.main.service.ServiceFragment;
import com.cms.charging.app.main.settings.SettingFragment;
import com.cms.charging.databinding.MainActivityBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity implements View.OnClickListener {
    private View[] TAB_VIEWS = new View[4];
    private MainActivityBinding mBinding;
    private List<Fragment> mFragmentList;
    private MainAdapter mAdapter;
    private View mCurrentView; //当前Tab的View

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mBinding.setEvent(this);
        TAB_VIEWS[0] = mBinding.llTab1;
        TAB_VIEWS[1] = mBinding.llTab2;
        TAB_VIEWS[2] = mBinding.llTab3;
        TAB_VIEWS[3] = mBinding.llTab4;

        initViewPager();
        this.onClick(mBinding.llTab1);

    }


    private void initViewPager() {
        try {
            mBinding.mainViewPager.setOffscreenPageLimit(3);
            mBinding.mainViewPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
                @Override
                public void onPageSelected(int position) {
                    super.onPageSelected(position);
                    onClick(TAB_VIEWS[position]);
                }
            });

            mFragmentList = new ArrayList<>();
            mFragmentList.add(new HomeFragment());
            mFragmentList.add(new MineFragment());
            mFragmentList.add(new ServiceFragment());
            mFragmentList.add(new SettingFragment());

            mAdapter = new MainAdapter(getSupportFragmentManager(), mFragmentList);
            mBinding.mainViewPager.setAdapter(mAdapter);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void onClick(View v) {
        if (mCurrentView != null) {
            mCurrentView.setSelected(false);
        }
        mCurrentView = v;
        mCurrentView.setSelected(true);
        switch (v.getId()) {
            case R.id.ll_tab_1:
                mBinding.mainViewPager.setCurrentItem(0);
                break;
            case R.id.ll_tab_2:
                mBinding.mainViewPager.setCurrentItem(1);
                break;
            case R.id.ll_tab_3:
                mBinding.mainViewPager.setCurrentItem(2);
                break;
            case R.id.ll_tab_4:
                mBinding.mainViewPager.setCurrentItem(3);
                break;
        }
    }
}
