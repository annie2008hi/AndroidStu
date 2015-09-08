package com.gjc.android.androidstu.ui.car;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gjc.android.androidstu.R;

/**
 * Created by gjc on 2015/8/27.
 */
public class CarActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car);
        initContentView();
    }
    private void initContentView(){
//        LinearLayout linLayout = new LinearLayout(this);
//        linLayout.setOrientation(LinearLayout.VERTICAL);
        LinearLayout linLayout = (LinearLayout) findViewById(R.id.car_ll);

        ViewGroup.LayoutParams lpView = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);

        TextView tv = new TextView(this);
        tv.setText("My Car Page~~");
        tv.setLayoutParams(lpView);
        linLayout.addView(tv);

        Button btn = new Button(this);
        btn.setText("Add New Car");
        linLayout.addView(btn, lpView);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CarActivity.this, CarAddActivity.class);
                CarActivity.this.startActivity(intent);
            }
        });

        LinearLayout.LayoutParams nLpView = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        nLpView.leftMargin = 50;
        nLpView.topMargin = 50;
        TextView toastTv = new TextView(this);
        toastTv.setText("hello message");
        linLayout.addView(toastTv, nLpView);

        ViewGroup.LayoutParams linParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
//        tv.setLayoutParams(linParams);

//        addContentView(linLayout, linParams);
        setContentView(linLayout);
    }
}
