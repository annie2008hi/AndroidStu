package com.gjc.android.androidstu.ui.HomeAct;

import android.app.Activity;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.gjc.android.androidstu.R;

import java.text.DecimalFormat;

/**
 * Created by gjc on 2015/9/7.
 */
public class DecimalFormatActivity extends Activity {
    private EditText mInput;
    private Button mHit;
    private TextView mMyText;
    private TextView mNewTv;
    private EditText mInputDouble, mLongDouble;
    private Button mGetInt, mGetSpanTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demical_format);
        initView();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    private void initView() {
        mInput = (EditText) findViewById(R.id.input);
        mHit = (Button) findViewById(R.id.hit);
        mHit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!TextUtils.isEmpty(mInput.getText().toString())) {
                    mHit.setText(saveTwoDemical(Double.parseDouble(mInput.getText().toString())));
                }
            }
        });
        mMyText = (TextView) findViewById(R.id.mytext);
        Spannable myt = new SpannableString("Text00");
        myt.setSpan(new AbsoluteSizeSpan(35),0,4, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        myt.setSpan(new AbsoluteSizeSpan(15), 4, 6, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        mMyText.setText(myt);

        mLongDouble = (EditText) findViewById(R.id.input_long_double);
        mGetSpanTv = (Button) findViewById(R.id.get_diff_size_textview);
        mGetSpanTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Spannable diffSizeTv = new SpannableString(saveTwoDemical(Double.parseDouble(mLongDouble.getText().toString())));
                //if input number length is less than 2,e.g 0 it will crash
                diffSizeTv.setSpan(new AbsoluteSizeSpan(86),0,diffSizeTv.length()-2,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                diffSizeTv.setSpan(new AbsoluteSizeSpan(54),diffSizeTv.length()-2,diffSizeTv.length(),Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                mGetSpanTv.setText(diffSizeTv);
            }
        });
//        mMyText.startAnimation((Animation) AnimationUtils.loadAnimation(this, R.anim.trans_scroll_horizon));

//        mNewTv = (TextView) findViewById(R.id.reward_new_info);
////        mNewTv.setMovementMethod(new ScrollingMovementMethod());
//        mNewTv.requestFocus();
//        mNewTv.setHorizontallyScrolling(true);
//        TextView test = (TextView) findViewById(R.id.test);
//        test.requestFocus();

        mInputDouble = (EditText) findViewById(R.id.input_double);
        mGetInt = (Button) findViewById(R.id.get_int);
        mGetInt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //取整 将double 转成 int型
//                mGetInt.setText("" + (int) Double.parseDouble(mInputDouble.getText().toString()));
                //四舍五入 取整 对double
                mGetInt.setText(saveRoundDemical(Double.parseDouble(mInputDouble.getText().toString())));
            }
        });
    }

    private String saveRoundDemical(double prevNum) {
        DecimalFormat df = new DecimalFormat("#");
        if (prevNum == 0) {
            return "0";
        }
        if (prevNum < 1 && prevNum > 0) {
            return "0" + df.format(prevNum);
        }
        if (prevNum < 0 && prevNum > -1) {
            return "-0" + df.format(-prevNum);
        }
        return df.format(prevNum);
    }

    private String saveTwoDemical(double prevNum) {
        DecimalFormat df = new DecimalFormat("#.00");
        if (prevNum == 0) {
            return "0";
        }
        if (prevNum < 1 && prevNum > 0) {
            return "0" + df.format(prevNum);
        }
        if (prevNum < 0 && prevNum > -1) {
            return "-0" + df.format(-prevNum);
        }
        return df.format(prevNum);
    }


    public static String rateDoubleTwoStr(double number) {
        java.text.DecimalFormat df = new java.text.DecimalFormat("#.0");
        if (number == 0) {
            return "0";
        } else if (number < 1.0 && number > 0) {
            return "0" + df.format(number);
        } else if (number < 0 && number > -1.0) {
            return "-0" + df.format(Math.abs(number));
        }

        return df.format(number);
    }
}
