package com.gjc.android.androidstu;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.gjc.android.androidstu.adapter.ViewPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gjc on 2015/8/21.
 */
public class GuideActivity extends Activity implements ViewPager.OnPageChangeListener{
    private ViewPager mViewPager;
    private ViewPagerAdapter mViewPagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //set full screen
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN
//                ,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_guide);
        LinearLayout guideLL = (LinearLayout) findViewById(R.id.guide_ll);
        //Activity full screen
        guideLL.setSystemUiVisibility(View.INVISIBLE);
//        guideLL.setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
//        guideLL.setSystemUiVisibility(View.SYSTEM_UI_FLAG_VISIBLE);
        initViews();
        initDots();
    }

    private void initViews(){
        LayoutInflater inflater = LayoutInflater.from(this);
        List<View> views;
        views = new ArrayList<View>();
        View guideOne = inflater.inflate(R.layout.activity_guide_one, null);
        ImageView img = (ImageView) guideOne.findViewById(R.id.img_guide);
        img.setImageResource(R.drawable.ic_guide_one);
        views.add(guideOne);

        View guideTwo = inflater.inflate(R.layout.activity_guide_two,null);
        ImageView img2 = (ImageView) guideTwo.findViewById(R.id.img_guide);
        img2.setImageResource(R.drawable.ic_guide_two);
        views.add(guideTwo);

        View guideThree = inflater.inflate(R.layout.activity_guide_three,null);
        ImageView img3 = (ImageView) guideThree.findViewById(R.id.img_guide);
        img3.setImageResource(R.drawable.ic_guide_three);
        views.add(guideThree);

        View guideFour = inflater.inflate(R.layout.activity_guide_four,null);
        LinearLayout imgll4 = (LinearLayout) guideFour.findViewById(R.id.img_guide);
        imgll4.setBackgroundResource(R.drawable.ic_guide_four);
//        ImageView img4 = (ImageView) guideFour.findViewById(R.id.img_guide);
//        img4.setImageResource(R.drawable.ic_guide_four);
        views.add(guideFour);

        mViewPagerAdapter = new ViewPagerAdapter(views,this);
        mViewPager = (ViewPager) findViewById(R.id.view_pager);
        mViewPager.setAdapter(mViewPagerAdapter);

    }
    private void initDots(){

    }
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
