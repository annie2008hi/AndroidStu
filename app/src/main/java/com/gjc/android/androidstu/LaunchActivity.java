package com.gjc.android.androidstu;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.WindowManager;

/**
 * Created by gjc on 2015/8/20.
 */
public class LaunchActivity extends Activity {
    private boolean mShowGuide;
    private static final String SHARED_PREFERENCE_APP_ENTRANCE_TIME="app_entrance_time";
    private static final int GO_HOME = 1000;
    private static final int GO_GUIDE = 1001;
    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case GO_HOME:
                    goHome();
                    break;
                case GO_GUIDE:
                    goGuide();
                    break;
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //set full screen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN
        ,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_launch);
        init();
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                Intent intent = new Intent(LaunchActivity.this,NewMainHomeActivity.class);
//                LaunchActivity.this.startActivity(intent);
//                LaunchActivity.this.finish();
//            }
//        },1600);
    }
    private void init(){
        SharedPreferences preferences = getSharedPreferences(SHARED_PREFERENCE_APP_ENTRANCE_TIME
                , MODE_PRIVATE);
        mShowGuide = preferences.getBoolean("show_guide",false);

        if(mShowGuide){
            mHandler.sendEmptyMessageDelayed(GO_HOME,1600);
        }else {
            mHandler.sendEmptyMessageDelayed(GO_GUIDE,1600);
        }

    }
    private void goHome(){
        Intent intent = new Intent(LaunchActivity.this,NewMainHomeActivity.class);
        LaunchActivity.this.startActivity(intent);
        LaunchActivity.this.finish();
    }
    private void goGuide(){
        Intent intent = new Intent(LaunchActivity.this,GuideActivity.class);
        LaunchActivity.this.startActivity(intent);
        LaunchActivity.this.finish();
    }
}
