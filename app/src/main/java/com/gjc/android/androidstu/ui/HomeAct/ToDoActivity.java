package com.gjc.android.androidstu.ui.HomeAct;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.gjc.android.androidstu.R;

/**
 * Created by gjc on 2015/9/11.
 */
public class ToDoActivity extends Activity {
    private Button mAlertDialogBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_todo);
        initView();
    }
    private void initView() {
        mAlertDialogBtn = (Button) findViewById(R.id.alert_dialog);
        mAlertDialogBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog();
            }
        });
    }
    private void alertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Confirmation?")
                .setCancelable(false)

                .setPositiveButton("Cancel----Postitive", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                })
                .setNegativeButton("OK----Neagtive", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                })
                .create().show();
    }
}
