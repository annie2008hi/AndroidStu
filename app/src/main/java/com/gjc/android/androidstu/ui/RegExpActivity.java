package com.gjc.android.androidstu.ui;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.gjc.android.androidstu.MyApplication;
import com.gjc.android.androidstu.R;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by gjc on 2015/8/27.
 */
public class RegExpActivity extends Activity {
    private EditText mLicense, mPhone, mNum;
    private Button mJud;
    private TextView mTos;
    private MyApplication app;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg_exp);
        initView();
    }
    private void initView(){
        mLicense = (EditText) findViewById(R.id.reg_exp_licenumber);
        mPhone =(EditText) findViewById(R.id.reg_exp_telphone);
        mNum = (EditText) findViewById(R.id.reg_exp_numlength);
        mJud = (Button) findViewById(R.id.judge);
        mJud.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                isLicenseNumber();
                matStr();
            }
        });
        mTos = (TextView) findViewById(R.id.reg_exp_toast);
        app = (MyApplication)this.getApplication();
        mTos.setText("default:"+app.getGlobalString());
    }
    private boolean isLicenseNumber(){
        String licStr = mLicense.getText().toString();
        if(TextUtils.isEmpty(licStr)){
            return false;
        }
        Pattern p = Pattern.compile("");
        Matcher m = p.matcher(licStr);
        return m.matches();
    }

    private void matStr(){
        String patStr = "";
        String matStr = "";
        if(!TextUtils.isEmpty(mLicense.getText().toString())){
            patStr = mLicense.getText().toString();

        }
        if(!TextUtils.isEmpty(mPhone.getText().toString())){
            matStr = mPhone.getText().toString();
        }
        Pattern pattern = Pattern.compile(patStr);
        Matcher matcher = pattern.matcher(matStr);
        if(matcher.matches()){
            mJud.setText("matches");
        }else
        {
            mJud.setText("Not matche");
        }
    }
}
