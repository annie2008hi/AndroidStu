package com.gjc.android.androidstu.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.gjc.android.androidstu.MainActivity;
import com.gjc.android.androidstu.R;

/**
 * Created by gjc on 2015/8/19.
 */
public class ActivityB extends Activity {
    private Button mStartActC;
    private Button mStartActA;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
        mStartActC = (Button) findViewById(R.id.start_activity_c);
        mStartActC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityB.this,ActivityC.class);
                ActivityB.this.startActivity(intent);
            }
        });
        mStartActA = (Button) findViewById(R.id.start_activity_a);
        mStartActA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityB.this, MainActivity.class);
                ActivityB.this.startActivity(intent);
            }
        });
    }
}
