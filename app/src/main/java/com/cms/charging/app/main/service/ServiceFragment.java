package com.cms.charging.app.main.service;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.cms.charging.R;
import com.cms.charging.app.base.BaseFragmnet;
import com.cms.charging.databinding.ServiceFragmentBinding;
import com.cms.charging.databinding.SettingFragmentBinding;

/**
 * Created by WD on 2017/11/30.
 */

public class ServiceFragment extends BaseFragmnet {
    private ServiceFragmentBinding mBinding;
    private BaseQuickAdapter<String, BaseViewHolder> mAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_service, container, false);
        mBinding = DataBindingUtil.bind(rootView);
        initViews();
        return rootView;
    }

    private void initViews() {
        mBinding.recyclerView.setLayoutManager(new LinearLayoutManager(activity));
        mBinding.recyclerView.addItemDecoration(new DividerItemDecoration(activity, DividerItemDecoration.VERTICAL));
        mAdapter = new BaseQuickAdapter<String, BaseViewHolder>(R.layout.item_service) {
            @Override
            protected void convert(BaseViewHolder helper, String item) {
                helper.setText(R.id.item_text, item);
            }
        };
        mAdapter.addData("服务热线：400-0571-871");
        mAdapter.addData("邮箱：hznrkj@126.com");
        mAdapter.addData("传真：0571-88937916");
        mAdapter.addData("杭州继保南瑞电子科技有限公司");
        mAdapter.addData("www.hznrkj.com");
        mBinding.recyclerView.setAdapter(mAdapter);
    }
}
