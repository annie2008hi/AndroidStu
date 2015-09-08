package com.gjc.android.androidstu.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;

import com.gjc.android.androidstu.R;
import com.gjc.android.androidstu.ui.HomeAct.DecimalFormatActivity;
import com.gjc.android.androidstu.ui.HomeAct.ProgressBarActivity;
import com.gjc.android.androidstu.ui.HomeAct.WebViewActivity;
import com.gjc.android.androidstu.ui.LoadImgsActivity;
import com.gjc.android.androidstu.ui.RegExpActivity;
import com.gjc.android.androidstu.ui.SwipeActivity;
import com.gjc.android.androidstu.ui.car.CarActivity;

/**
 * Created by gjc on 2015/8/20.
 */
public class HomeFragment extends Fragment{
    private Button mStartSwipe;
    private Button mStartLoadImage;
    private Button mStartRegExp;
    private Button mStartCarAct;
    private Button mStartDemical;
    private Button mStartWebView;
    private Button mStartProBar;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home,null);
        initView(view);
        return view;
    }
    private void initView(View view){
        mStartSwipe = (Button) view.findViewById(R.id.start_swipe);
        mStartSwipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SwipeActivity.class);
                getActivity().startActivity(intent);
            }
        });
        mStartLoadImage = (Button) view.findViewById(R.id.start_image_loader);
        mStartLoadImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), LoadImgsActivity.class);
                getActivity().startActivity(intent);
            }
        });
        mStartRegExp  = (Button) view.findViewById(R.id.start_reg_exp);
        mStartRegExp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), RegExpActivity.class);
                getActivity().startActivity(intent);
            }
        });
        mStartCarAct = (Button) view.findViewById(R.id.start_car_act);
        mStartCarAct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), CarActivity.class);
                getActivity().startActivity(intent);
            }
        });
        mStartDemical = (Button) view.findViewById(R.id.start_demical_format);
        mStartDemical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), DecimalFormatActivity.class);
                getActivity().startActivity(intent);
            }
        });
        mStartWebView = (Button) view.findViewById(R.id.start_webview);
        mStartWebView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), WebViewActivity.class);
                intent.putExtra("data","http://www.baidu.com");
                getActivity().startActivity(intent);
            }
        });
        mStartProBar = (Button) view.findViewById(R.id.start_progress_bar);
        mStartProBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ProgressBarActivity.class);
                getActivity().startActivity(intent);
            }
        });
    }
}
