package com.cms.charging.app.base;

import android.app.Activity;
import android.support.v4.app.Fragment;

/**
 * Created by WD on 2017/11/30.
 */

public class BaseFragmnet extends Fragment {
    protected Activity activity;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.activity = activity;
    }
}
