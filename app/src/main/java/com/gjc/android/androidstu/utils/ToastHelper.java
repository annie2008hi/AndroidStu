package com.gjc.android.androidstu.utils;

import android.widget.Toast;

import com.gjc.android.androidstu.MyApplication;

/**
 * Created by gjc on 2015/8/27.
 */
public class ToastHelper {
    public static void showLong(CharSequence mess){
        Toast.makeText(MyApplication.getInstance().getApplicationContext(),mess,Toast.LENGTH_LONG).show();
    }
    public static void showShort(CharSequence mess){
        Toast.makeText(MyApplication.getInstance().getApplicationContext(), mess, Toast.LENGTH_SHORT).show();
    }
}
