package com.gjc.android.androidstu.ui.car;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.gjc.android.androidstu.R;
import com.gjc.android.androidstu.utils.SideBar;

/**
 * Created by gjc on 2015/8/31.
 */
public class CarBrandSelectActivity extends Activity {
    private SideBar mSidebar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_brand_select);
        initView();
    }
    private void initView() {
        mSidebar = (SideBar) findViewById(R.id.side_bar);
        mSidebar.setVisibility(View.VISIBLE);
    }
}
