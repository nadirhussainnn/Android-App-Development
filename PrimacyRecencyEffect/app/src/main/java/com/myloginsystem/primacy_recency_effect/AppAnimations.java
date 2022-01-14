package com.myloginsystem.primacy_recency_effect;

import android.app.Activity;
import android.os.Build;
import android.transition.Slide;
import android.view.Gravity;
import android.view.animation.AccelerateDecelerateInterpolator;

public class AppAnimations {

    Activity context;
    AppAnimations(Activity context){
        this.context=context;
    }
    public void setAnimation()
    {
        if(Build.VERSION.SDK_INT>20) {
            Slide slide = new Slide();
            slide.setSlideEdge(Gravity.LEFT);
            slide.setDuration(400);
            slide.setInterpolator(new AccelerateDecelerateInterpolator());
            context.getWindow().setExitTransition(slide);
            context.getWindow().setEnterTransition(slide);
        }
    }
}
