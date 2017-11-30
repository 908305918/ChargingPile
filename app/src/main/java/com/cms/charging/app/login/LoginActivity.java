package com.cms.charging.app.login;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.cms.charging.R;
import com.cms.charging.app.base.BaseActivity;
import com.cms.charging.app.main.MainActivity;
import com.cms.charging.databinding.LoginActivityBinding;

/**
 * Created by YJB on 2017/11/30.
 */

public class LoginActivity extends BaseActivity {
    private LoginActivityBinding mBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_login);

        mBinding.login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
