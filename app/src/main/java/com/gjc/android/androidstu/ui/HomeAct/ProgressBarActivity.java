package com.gjc.android.androidstu.ui.HomeAct;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.gjc.android.androidstu.R;

/**
 * Created by gjc on 2015/9/8.
 */
public class ProgressBarActivity extends Activity {
    private ProgressBar mHorizonBar;
    private ProgressBar mSecondPro;
    private Button mAddPro;
    private int mProgressStatus;
    private Handler mHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_bar);
        initView();
    }

    private void initView() {
        mHorizonBar = (ProgressBar) findViewById(R.id.first_horizontal_bar);
        mSecondPro = (ProgressBar) findViewById(R.id.widget_horizontal_bar);
        mSecondPro.setVisibility(View.VISIBLE);
        mSecondPro.setMax(100);
        mSecondPro.setProgress(36);
        mSecondPro.setSecondaryProgress(68);
        mAddPro = (Button) findViewById(R.id.add_progress);
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (mProgressStatus < 100) {
                    mProgressStatus += 1;
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            mHorizonBar.setProgress(mProgressStatus);
                            mAddPro.setText(mProgressStatus + "/" + mHorizonBar.getMax());
                        }
                    });
                    try {
                        Thread.sleep(63);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (mProgressStatus == 99) {
                        mProgressStatus = 0;
                    }
                }
            }
        }).start();

        mAddPro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mHorizonBar.setProgress(mProgressStatus);
                mProgressStatus += 10;
                if (mProgressStatus == 110) {
                    mProgressStatus = 0;
                }
            }
        });
    }
}
