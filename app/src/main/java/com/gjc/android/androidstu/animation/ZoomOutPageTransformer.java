package com.gjc.android.androidstu.animation;

import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;

/**
 * Created by gjc on 2015/8/20.
 */
public class ZoomOutPageTransformer implements ViewPager.PageTransformer {
    private static final float MIN_SCALE = 0.80f;
    private static final float MIN_ALPHA = 0.45F;
    @Override
    public void transformPage(View page, float position) {
        int pageWidth = page.getWidth();
        int pageHeight = page.getHeight();
//        Log.d("ZoomOutPageTransformer", "page=" + page.toString() + "position=" + position);
        if(position<-1){//pages is on the left
//            Log.d("ZoomOutPageTransformer","positon less than -1");
            page.setAlpha(0);

        }else if(position<1){//pages is on the way to current screen page,from right to left
            float scaleFactor = Math.max(MIN_SCALE, 1-Math.abs(position));
            float vertialMargin = pageHeight*(1-scaleFactor)/2;
            float horizontalMargin = pageWidth*(1-scaleFactor)/2;

            if(position<0){//position is [-1,0),
            // pages is on the way out of current screen page,from center to left
                page.setTranslationX(horizontalMargin-vertialMargin/2);
            }else {//position is [0,1),from right to center
                page.setTranslationX(-(horizontalMargin-vertialMargin/2));
            }
            page.setScaleX(scaleFactor);
            page.setScaleY(scaleFactor);
//            page.setAlpha(scaleFactor/2);
            page.setAlpha(MIN_ALPHA +
                    (scaleFactor - MIN_SCALE) /
                            (1 - MIN_SCALE) * (1 - MIN_ALPHA));
        }else {//pages is on the right
            page.setAlpha(0);
        }
    }
}
