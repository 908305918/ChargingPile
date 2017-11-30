package com.cms.charging.app.main.mine;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.cms.charging.R;
import com.cms.charging.app.base.BaseFragmnet;
import com.cms.charging.common.vlayout.BaseDelegateAdapter;
import com.cms.charging.common.vlayout.ViewHolder;
import com.cms.charging.databinding.MineFragmentBinding;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by WD on 2017/11/30.
 */

public class MineFragment extends BaseFragmnet {
    private MineFragmentBinding mBinding;
    private DelegateAdapter mMainAdapter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_mine, container, false);
        mBinding = DataBindingUtil.bind(rootView);
        initViews();
        return rootView;
    }

    private void initViews() {
        VirtualLayoutManager layoutManager = new VirtualLayoutManager(getActivity());
        mBinding.recyclerView.setLayoutManager(layoutManager);
        mMainAdapter = new DelegateAdapter(layoutManager);
        mBinding.recyclerView.setAdapter(mMainAdapter);

        List<DelegateAdapter.Adapter> adapters = new LinkedList<>();

        BaseDelegateAdapter imgAdapter = new BaseDelegateAdapter(activity) {
            @Override
            public int obtainItemLayoutId(int viewType) {
                return R.layout.item_mine_image;
            }

            @Override
            public void convert(ViewHolder holder, int position, int viewType) {

            }

            @Override
            public LayoutHelper onCreateLayoutHelper() {
                return new SingleLayoutHelper();
            }
        };
        adapters.add(imgAdapter);

        EntranceAdapter entranceAdapter = new EntranceAdapter(activity);
        adapters.add(entranceAdapter);

        mMainAdapter.addAdapters(adapters);

    }
}
