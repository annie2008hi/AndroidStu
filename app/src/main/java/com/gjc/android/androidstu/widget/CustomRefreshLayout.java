package com.gjc.android.androidstu.widget;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.AttributeSet;
import android.widget.ListView;

import com.gjc.android.androidstu.R;

/**
 * Created by gjc on 2015/9/18.
 */
public class CustomRefreshLayout extends SwipeRefreshLayout {
    public CustomRefreshLayout(Context context) {
//        super(context);
        this(context, null);
        this.setColorSchemeColors(
                R.color.cyan, R.color.light_green,
                R.color.pink, R.color.yel);
    }

    public CustomRefreshLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.setColorSchemeColors(
                R.color.cyan, R.color.light_green,
                R.color.pink, R.color.yel);
    }
    public void setFooterView(Context context, ListView listView, int layoutId) {

    }
}
