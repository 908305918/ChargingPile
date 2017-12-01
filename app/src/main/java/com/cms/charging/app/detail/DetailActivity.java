package com.cms.charging.app.detail;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;

import com.cms.charging.R;
import com.cms.charging.app.base.BaseActivity;
import com.cms.charging.databinding.DetailActivityBinding;
import com.squareup.picasso.Picasso;

/**
 * Created by WD on 2017/11/30.
 */

public class DetailActivity extends BaseActivity {
    private DetailActivityBinding mBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_detail);
        initViews();
    }

    private void initViews() {
        mBinding.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        try {
            String title = getIntent().getStringExtra("title");
            int imgId = getIntent().getIntExtra("image", 0);

            mBinding.title.setText(title);
            DisplayMetrics metrics = getResources().getDisplayMetrics();
            Picasso.with(this).load(imgId).resize(metrics.widthPixels, metrics.heightPixels - (int) (45 * metrics.density)).into(mBinding.image);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void start(Context context, String title, int imgId) {
        Intent intent = new Intent(context, DetailActivity.class);
        intent.putExtra("title", title);
        intent.putExtra("image", imgId);
        context.startActivity(intent);
    }
}
