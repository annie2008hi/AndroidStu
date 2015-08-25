package com.gjc.android.androidstu;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;

import com.gjc.android.androidstu.adapter.CollectionPagerAdapter;
import com.gjc.android.androidstu.animation.DepthPageTransformer;

/**
 * Created by gjc on 2015/8/20.
 */
public class NewMainHomeActivity extends FragmentActivity {
    ViewPager mViewPager;
    CollectionPagerAdapter pagerAdapter;
    PagerTabStrip mPagerTabStrip;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_home_main);
        pagerAdapter = new CollectionPagerAdapter(getSupportFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.view_pager);
        mPagerTabStrip = (PagerTabStrip) findViewById(R.id.pager_tab_strip);
//        mViewPager.setPageTransformer(true,new ZoomOutPageTransformer());
        mPagerTabStrip.setTextSpacing(50);
        mViewPager.setPageTransformer(true,new DepthPageTransformer());
        mViewPager.setAdapter(pagerAdapter);
    }
}
