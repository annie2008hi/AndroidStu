package com.gjc.android.androidstu.ui.car;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.gjc.android.androidstu.R;

/**
 * Created by gjc on 2015/8/31.
 */
public class CarAddActivity extends Activity {
    private LinearLayout mCarBrand, mCarType;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_car);
        initView();
    }
    private void initView() {
        mCarBrand = (LinearLayout) findViewById(R.id.car_brand);
        mCarBrand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CarAddActivity.this, CarBrandSelectActivity.class);
                CarAddActivity.this.startActivity(intent);
            }
        });
        mCarType = (LinearLayout) findViewById(R.id.car_type);
        mCarType.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CarAddActivity.this, CarAddActivity.class);
                CarAddActivity.this.startActivity(intent);
            }
        });
    }
}
