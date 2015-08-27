package com.gjc.android.androidstu;

import android.app.Application;

/**
 * Created by gjc on 2015/8/27.
 */
public class MyApplication extends Application {
    private static MyApplication mInstance;
    private static final String GLOBAL_STRING = "HelloCaD";
    private String mGlobalStr;

    @Override
    public void onCreate() {
        super.onCreate();
        setGlobalString(GLOBAL_STRING);
    }

    public static MyApplication getInstance(){
        if (mInstance == null){
           synchronized (MyApplication.class) {
               if (mInstance == null) {
                   mInstance = new MyApplication();
               }
           }
        }
        return mInstance;
    }

    public void setGlobalString(String str){
        this.mGlobalStr = str;
    }
    public String getGlobalString(){
        return mGlobalStr;
    }
}
