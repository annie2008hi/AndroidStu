package com.gjc.android.androidstu.ui;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.gjc.android.androidstu.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by gjc on 2015/8/25.
 */
public class SwipeActivity extends Activity {
    private ListView mListView;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private Adapter mAdapter;
    private String[] catArray;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe);
        initView();
    }
    private void initView(){
        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_fl);
        mListView = (ListView) findViewById(R.id.list_item);
        catArray = getResources().getStringArray(R.array.cat_names);
        mAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1
                ,catArray);
        mListView.setAdapter((ListAdapter) mAdapter);
        View view = LayoutInflater.from(SwipeActivity.this).inflate(R.layout.header_view_swipe,null);
        mListView.addHeaderView(view);
        mListView.setHeaderDividersEnabled(true);
        //Enables or disables the drawing of the divider for header views？
        view = LayoutInflater.from(SwipeActivity.this).inflate(R.layout.footview_swipe,null);
        mListView.addFooterView(view);
        mListView.setFooterDividersEnabled(true);
        //Enables or disables the drawing of the divider for footer views?
        //customiza color of anmi
        //setColorSchemeColors not work
//        mSwipeRefreshLayout.setColorSchemeColors(
//                R.color.sienna,
//                R.color.pink,
//                R.color.light_green,
//                R.color.cyan
//        );
        //customize color of anmi ,setColorScheme worked
//        mSwipeRefreshLayout.setColorScheme(
//                R.color.sienna,
//                R.color.pink,
//                R.color.light_green,
//                R.color.cyan
//        );

        mSwipeRefreshLayout.setColorScheme(
                android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light
        );


        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshContent();
            }
        });
    }
    private void refreshContent(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mAdapter = new ArrayAdapter<String>(SwipeActivity.this
                        , android.R.layout.simple_list_item_1
                        , getNewCat());
                mListView.setAdapter((ListAdapter) mAdapter);
                mSwipeRefreshLayout.setRefreshing(false);
            }
        }, 8400);
    }
    private List<String> getNewCat(){
        List<String> newCatNames = new ArrayList<String>();
        for (int i = 0; i < catArray.length; i++){
            int randCatIndex = new Random().nextInt(catArray.length - 1);
            newCatNames.add(getCat(randCatIndex));
        }
        return newCatNames;
    }
    private String getCat(int ind){
        catArray = getResources().getStringArray(R.array.cat_names);
        return catArray[ind];
    }
}
