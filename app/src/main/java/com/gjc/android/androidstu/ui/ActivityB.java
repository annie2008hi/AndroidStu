package com.gjc.android.androidstu.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.gjc.android.androidstu.MainActivity;
import com.gjc.android.androidstu.R;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.TextHttpResponseHandler;

import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by gjc on 2015/8/19.
 */
public class ActivityB extends Activity {
    private Button mStartActC;
    private Button mStartActA;
    private Button mStartAsync;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
        initView();
    }

    private void initView() {

        mStartActC = (Button) findViewById(R.id.start_activity_c);
        mStartActC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityB.this, ActivityC.class);
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
        mStartAsync = (Button) findViewById(R.id.start_async_client);
        mStartAsync.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AsyncHttpClient client = new AsyncHttpClient();
//                client.get("https://www.baidu.com", new AsyncHttpResponseHandler() {
//                    @Override
//                    public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
//                        //called when HTTP status is "200OK"
//                        mStartAsync.setText("responseBody" + responseBody.toString());
//                    }
//
//                    @Override
//                    public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
//                        //called when response HTTP status is "4XX" (eg. 401, 403, 404)
//                    }
//                });




//                client.get("https://www.baidu.com", new TextHttpResponseHandler() {
//                    @Override
//                    public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
//
//                    }
//
//                    @Override
//                    public void onSuccess(int statusCode, Header[] headers, String responseString) {
//                        Log.d("AsyncOnSuccess", responseString);
//                    }
//                });

                client.get("https://www.baidu.com", new JsonHttpResponseHandler(){
                    @Override
                    public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                        super.onSuccess(statusCode, headers, response);
                    }

                    @Override
                    public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                        super.onSuccess(statusCode, headers, response);
                    }

                    @Override
                    public void onSuccess(int statusCode, Header[] headers, String responseString) {
                        super.onSuccess(statusCode, headers, responseString);
                    }
                });
            }
        });
    }
}
