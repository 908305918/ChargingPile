package com.cms.charging.app.detail;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.cms.charging.R;
import com.cms.charging.databinding.DetailActivityBinding;
import com.squareup.picasso.Picasso;

/**
 * Created by WD on 2017/11/30.
 */

public class DetailActivity extends AppCompatActivity {
    private DetailActivityBinding mBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_detail);
        initViews();
    }

    private void initViews() {
        try {
            String title = getIntent().getStringExtra("title");
            int imgId = getIntent().getIntExtra("image", 0);

            mBinding.title.setText(title);
            mBinding.image.setImageResource(imgId);
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
