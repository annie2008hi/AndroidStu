package com.gjc.android.androidstu.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.gjc.android.androidstu.R;
import com.gjc.android.androidstu.ui.LoadImgsActivity;
import com.gjc.android.androidstu.ui.RegExpActivity;
import com.gjc.android.androidstu.ui.SwipeActivity;

/**
 * Created by gjc on 2015/8/20.
 */
public class HomeFragment extends Fragment{
    private Button mStartSwipe;
    private Button mStartLoadImage;
    private Button mStartRegExp;
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
    }
}
