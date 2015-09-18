package com.gjc.android.androidstu.ui.HomeAct;

import android.app.Activity;
import android.graphics.drawable.ClipDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.gjc.android.androidstu.R;

/**
 * Created by gjc on 2015/9/9.
 */
public class ShapeActivity extends Activity {
    private ImageView mClipImg;

    private TextView mScrollTv;

    private TextView mGetVcode;
    private int mRestTime = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shape);
        initView();

    }
    private void initView() {
        mClipImg = (ImageView) findViewById(R.id.clip_img);
        ClipDrawable cdraw = (ClipDrawable)mClipImg.getBackground();
        cdraw.setLevel(4500);
        /**
         *ClipDrawable 内部预设了一个最大的level值，10000
         * 若level为0，图片不显示，为10000，显示全部图像，其余value/10000,显示，4500，表示显示45%
         */

        mScrollTv = (TextView) findViewById(R.id.my_scroll_tv);
        mScrollTv.requestFocus();
        mScrollTv.setMovementMethod(new ScrollingMovementMethod());

        mGetVcode = (TextView) findViewById(R.id.get_vcode);
        mGetVcode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handler.postDelayed(runnable,1000);
            }
        });
    }

    Handler handler = new Handler();
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            mRestTime++;
            mGetVcode.setText("resttime"+mRestTime);
            handler.postDelayed(this,1000);
        }
    };
}
