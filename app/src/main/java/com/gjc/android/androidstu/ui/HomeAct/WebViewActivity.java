package com.gjc.android.androidstu.ui.HomeAct;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.gjc.android.androidstu.R;

/**
 * Created by gjc on 2015/9/8.
 */
public class WebViewActivity extends Activity {
    private WebView mWebVIew;

    private static final int PROGRESS = 0x1;

    private ProgressBar mProgress;
    private int mProgressStatus = 0;
    private Handler mHandler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        initView();
    }
    private void initView() {
        //need to add permission in androidManifest android.permission.INTERNET
        //don not add permission will get webpage not available
        mWebVIew = (WebView) findViewById(R.id.web_view);
        //if WebPage has javasCript nedd to add this
        mWebVIew.getSettings().setJavaScriptEnabled(true);
        //if want to show in app, not show in browser of system
        mWebVIew.requestFocus();
        mWebVIew.loadUrl("http://www.baidu.com");
        mProgress = (ProgressBar) findViewById(R.id.progress_bar);

        mWebVIew.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                mProgress.setVisibility(View.GONE);
            }
        });


        mWebVIew.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
//                super.onProgressChanged(view, newProgress);
                mProgress.setProgress(PROGRESS);
            }
        });
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                while (mProgressStatus <100) {
//                    mProgressStatus +=10 ;
//                    mHandler.post(new Runnable() {
//                        @Override
//                        public void run() {
//                            mProgress.setProgress(mProgressStatus);
//                        }
//                    });
//                }
//            }
//        }).start();
    }
}
