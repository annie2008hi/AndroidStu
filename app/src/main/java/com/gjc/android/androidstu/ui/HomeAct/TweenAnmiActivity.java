package com.gjc.android.androidstu.ui.HomeAct;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import com.gjc.android.androidstu.R;

/**
 * Created by gjc on 2015/9/17.
 */
public class TweenAnmiActivity extends Activity {
    private Button mStartZoom,
    mStartClickWise, mStartFade, mStartBlink,
    mStartMove, mStartSlide;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tween_anmi);
        initView();
    }
    public void clockwise(View view) {
        ImageView img = (ImageView) findViewById(R.id.tween_img);
        Animation animation = AnimationUtils.loadAnimation(this,R.anim.custome_anmi_scale);
        img.startAnimation(animation);
    }

    public void startAnmi(int animType) {
        ImageView img = (ImageView) findViewById(R.id.tween_img);
        Animation animation = AnimationUtils.loadAnimation(this, animType);
        img.startAnimation(animation);
    }
    private void initView() {
        mStartZoom = (Button) findViewById(R.id.zoom);
        mStartClickWise = (Button) findViewById(R.id.clickwise);
        mStartFade = (Button) findViewById(R.id.fade);
        mStartBlink = (Button) findViewById(R.id.blink);
        mStartMove = (Button) findViewById(R.id.move);
        mStartSlide = (Button) findViewById(R.id.slide);

        mStartZoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startAnmi(R.anim.custome_anmi_scale);
            }
        });
        mStartClickWise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startAnmi(R.anim.clockwise);
            }
        });
        mStartFade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startAnmi(R.anim.fade);
            }
        });
        mStartBlink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startAnmi(R.anim.blink);
            }
        });
        mStartMove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startAnmi(R.anim.move);
            }
        });
        mStartSlide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startAnmi(R.anim.slide);
            }
        });

    }
}
