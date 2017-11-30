package com.cms.charging.app.main.mine;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.cms.charging.R;
import com.cms.charging.app.detail.DetailActivity;
import com.cms.charging.common.vlayout.BaseDelegateAdapter;
import com.cms.charging.common.vlayout.ViewHolder;
import com.squareup.picasso.Picasso;

/**
 * Created by WD on 2017/11/30.
 */

public class EntranceAdapter extends BaseDelegateAdapter {
    private final static int[] IMG_IDS = new int[]{R.drawable.icon_mine_1, R.drawable.icon_mine_2,
            R.drawable.icon_mine_3, R.drawable.icon_mine_4, R.drawable.icon_mine_5, R.drawable.icon_mine_6};
    private final static String[] TITLES = new String[]{"实时监控", "谐波参数", "电网质量", "电度查询", "运行日志", "系统日志"};


    public EntranceAdapter(Context context) {
        super(context);
    }

    @Override
    public int obtainItemLayoutId(int viewType) {
        return R.layout.item_mine_entrance;
    }

    @Override
    public void convert(ViewHolder holder, final int position, int viewType) {
        holder.setText(R.id.entrance_text, TITLES[position]);
        ImageView imageView = holder.findView(R.id.entrance_image);
        imageView.setImageResource(IMG_IDS[position]);

        holder.getConvertView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (position) {
                    case 0:
                        DetailActivity.start(mContext, "实时监控", R.drawable.img_1);
                        break;
                    case 1:
                        DetailActivity.start(mContext, "谐波参数", R.drawable.img_2);
                        break;
                    case 2:
                        DetailActivity.start(mContext, "电网质量", R.drawable.img_3);
                        break;
                    case 3:
                        DetailActivity.start(mContext, "电度查询", R.drawable.img_4);
                        break;
                    case 4:
                        DetailActivity.start(mContext, "运行日志", 0);
                        break;
                    case 5:
                        DetailActivity.start(mContext, "系统日志", 0);
                        break;
                }
            }
        });
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        GridLayoutHelper helper = new GridLayoutHelper(3, 6);
        helper.setMargin(0, 40, 0, 0);
        helper.setVGap(20);
        return helper;
    }
}
