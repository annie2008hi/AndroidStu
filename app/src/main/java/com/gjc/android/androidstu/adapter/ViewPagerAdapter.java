package com.gjc.android.androidstu.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.gjc.android.androidstu.NewMainHomeActivity;
import com.gjc.android.androidstu.R;

import java.util.List;

/**
 * Created by gjc on 2015/8/21.
 */
public class ViewPagerAdapter extends PagerAdapter {
    private List<View> views;
    private Activity activity;
    private static final String SHARED_PREFERENCE_APP_ENTRANCE_TIME="app_entrance_time";
    public ViewPagerAdapter (List<View> views,Activity activity){
        this.views = views;
        this.activity = activity;
    }

    //remove the view of container at position
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
//        super.destroyItem(container, position, object);
        ((ViewPager)container).removeView(views.get(position));
    }

    @Override
    public int getCount() {
        if(views != null){
            return views.size();
        }
        return 0;
    }
    //init view at container position
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ((ViewPager) container).addView(views.get(position),0);
        if(position == views.size() - 1){
            Button button = (Button) container.findViewById(R.id.start_home);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    setGuided();
                    goHome();
                }
            });
        }
        return views.get(position);
//        return super.instantiateItem(container, position);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view == object);
    }
    private void goHome(){
        Intent intent = new Intent(activity,NewMainHomeActivity.class);
        activity.startActivity(intent);
        activity.finish();
    }
    private void setGuided(){
        SharedPreferences preferences = activity.getSharedPreferences(
                SHARED_PREFERENCE_APP_ENTRANCE_TIME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean("show_guide",true);
        editor.commit();
    }
}
