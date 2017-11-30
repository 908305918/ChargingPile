package com.cms.charging.app.detail;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.cms.charging.R;
import com.cms.charging.databinding.SysInfoActivityBinding;

/**
 * Created by WD on 2017/11/30.
 */

public class SystemInfoActivity extends AppCompatActivity {
    private SysInfoActivityBinding mBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_system_info);

        initViews();
    }

    private void initViews() {

        mBinding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mBinding.recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        BaseQuickAdapter<String, BaseViewHolder> mAdapter = new BaseQuickAdapter<String, BaseViewHolder>(R.layout.item_service) {
            @Override
            protected void convert(BaseViewHolder helper, String item) {
                helper.setText(R.id.item_text, item);
            }
        };
        mAdapter.addData("软件信息：VIP-CDZ-9001");
        mAdapter.addData("软件版本：");
        mAdapter.addData("校验码：9507");
        mAdapter.addData("杭州继保南瑞电子科技有限公司");
        mAdapter.addData("www.hznrkj.com");
        mBinding.recyclerView.setAdapter(mAdapter);

    }
}
