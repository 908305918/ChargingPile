package com.cms.charging.common.vlayout;

import android.content.Context;
import android.view.ViewGroup;

import com.alibaba.android.vlayout.DelegateAdapter;

/**
 * Created by YJB on 2017/8/15.
 */
public abstract class BaseDelegateAdapter extends DelegateAdapter.Adapter<ViewHolder> {

    protected Context mContext;

    public BaseDelegateAdapter(Context context) {
        this.mContext = context;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return ViewHolder.createViewHolder(mContext, parent, obtainItemLayoutId(viewType));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.updatePosition(position);
        convert(holder, position, getItemViewType(position));
    }

    @Override
    public int getItemCount() {
        return onCreateLayoutHelper().getItemCount();
    }

    public abstract int obtainItemLayoutId(int viewType);

    public abstract void convert(ViewHolder holder, int position, int viewType);
}
