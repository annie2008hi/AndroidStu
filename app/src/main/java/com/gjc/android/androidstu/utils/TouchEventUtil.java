package com.gjc.android.androidstu.utils;

import android.view.MotionEvent;

/**
 * Created by gjc on 2015/9/10.
 */
public class TouchEventUtil {
    public static String getTouchAction(int actionId) {
        String actionName = "Unknownid  = " + actionId;
        switch (actionId) {
            case MotionEvent.ACTION_DOWN:
                actionName = "action_down";
                break;
            case MotionEvent.ACTION_MOVE:
                actionName = "action_move";
                break;
            case MotionEvent.ACTION_UP:
                actionName = "action_up";
                break;
            case MotionEvent.ACTION_CANCEL:
                actionName = "action_cancel";
                break;
            case MotionEvent.ACTION_OUTSIDE:
                actionName = "action_outside";
                break;
        }
        return actionName;
    }
}
