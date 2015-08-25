package com.gjc.android.androidstu.ui;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.gjc.android.androidstu.R;

/**
 * Created by gjc on 2015/8/19.
 */
public class ActivityC extends Activity {
    private Button mStartActD;
    private Button mStartActB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c);
        mStartActD = (Button) findViewById(R.id.start_activity_d);
        mStartActD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Uri google = Uri.parse("http://www.google.com");
//                Intent intent = new Intent(Intent.ACTION_VIEW,google);
//                Uri tel = Uri.parse("tel:123456");
//                Intent intent = new Intent(Intent.ACTION_VIEW,tel);
//                Uri geo = Uri.parse("geo:30.231512,120.325699");
//                Intent intent = new Intent(Intent.ACTION_VIEW,geo); //crashed
                Intent intent = new Intent(ActivityC.this,ActivityD.class);
                ActivityC.this.startActivity(intent);
            }
        });
        mStartActB = (Button) findViewById(R.id.start_activity_b);
        mStartActB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityC.this,ActivityB.class);
                ActivityC.this.startActivity(intent);
            }
        });
    }
}
