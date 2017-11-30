package com.cms.charging.app.main.home;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.cms.charging.R;
import com.cms.charging.app.base.BaseFragmnet;
import com.cms.charging.common.view.MarqueeTextView;
import com.cms.charging.common.vlayout.BaseDelegateAdapter;
import com.cms.charging.common.vlayout.ViewHolder;
import com.cms.charging.databinding.HomeFragmentBinding;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by WD on 2017/11/30.
 */

public class HomeFragment extends BaseFragmnet {
    private HomeFragmentBinding mBinding;
    private DelegateAdapter mMainAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
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

        BaseDelegateAdapter marqueeAdapter = new BaseDelegateAdapter(activity) {
            @Override
            public int obtainItemLayoutId(int viewType) {
                return R.layout.item_home_message;
            }

            @Override
            public void convert(ViewHolder holder, int position, int viewType) {
                MarqueeTextView view = holder.findView(R.id.marquee);
                view.setText("根据技术进步和市场供求，实施风电、光伏等新能源标杆上网电价退坡机制，2020年实现风电与燃煤发电上网电价相当、光伏上网电价与电网销售电价相当。");
                view.init();
                view.startScroll();
            }

            @Override
            public LayoutHelper onCreateLayoutHelper() {
                return new SingleLayoutHelper();
            }
        };
        adapters.add(marqueeAdapter);

        BaseDelegateAdapter gridAdapter = new BaseDelegateAdapter(activity) {
            private final int[] IMG_IDS = new int[]{R.drawable.home_img_1, R.drawable.home_img_2,
                    R.drawable.home_img_3, R.drawable.home_img_4, R.drawable.home_img_5};
            private final String[] TITLES = new String[]{"最大电压", "最大电流", "最大需量",
                    "功率因数", "总电量"};
            private final String[] TEXTS = new String[]{"0V", "0A", "0kwh", "0", "0kwh"};

            @Override
            public int obtainItemLayoutId(int viewType) {
                return R.layout.item_home_entrance;
            }

            @Override
            public void convert(ViewHolder holder, int position, int viewType) {
                ImageView imageView = holder.findView(R.id.entrance_image);
                imageView.setImageResource(IMG_IDS[position]);
                holder.setText(R.id.entrance_text1, TITLES[position]);
                holder.setText(R.id.entrance_text2, TEXTS[position]);

                if (position < 3) {
                    holder.setVisibility(R.id.bottom, View.VISIBLE);
                } else {
                    holder.setVisibility(R.id.bottom, View.GONE);
                }

                if (position % 3 < 2) {
                    holder.setVisibility(R.id.right, View.VISIBLE);
                } else {
                    holder.setVisibility(R.id.right, View.GONE);
                }

            }

            @Override
            public LayoutHelper onCreateLayoutHelper() {
                GridLayoutHelper helper = new GridLayoutHelper(3, 5);
                helper.setMargin(0, 0, 0, 0);
                helper.setAutoExpand(false);
                return helper;
            }
        };
        adapters.add(gridAdapter);

        mMainAdapter.addAdapters(adapters);
    }
}
