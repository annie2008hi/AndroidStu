package com.gjc.android.androidstu.widget;

import android.app.Dialog;
import android.content.Context;

import com.gjc.android.androidstu.R;

/**
 * Created by gjc on 2015/9/17.
 */
public class ShowHUDDialog extends Dialog {
    public ShowHUDDialog(Context context, int theme) {
        super(context, theme);
    }

    public ShowHUDDialog(Context context) {
        super(context);
    }

    protected ShowHUDDialog(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    public static ShowHUDDialog show(Context context, CharSequence message,
                                     boolean indeterminate, boolean cancelable,
                                     OnCancelListener cancelListener) {
        ShowHUDDialog dialog = new ShowHUDDialog(context, R.style.ShowHUDDialog);
        dialog.setTitle("Please Wait");
        dialog.setContentView(R.layout.progress_hud);
        return dialog;
    }
}
