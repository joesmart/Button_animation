package com.smart.joe;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import com.smart.joe.animation.BlinkAnimation;

public class ButtonAnimationActivity extends Activity implements View.OnClickListener, Animation.AnimationListener {
    private final static String TAG = ButtonAnimationActivity.class.getName();
    private ImageView image;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.i(TAG, "Start activity");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        image = (ImageView) findViewById(R.id.image);
        findViewById(R.id.button1).setOnClickListener(this);
    }

    public void onClick(View view) {
        if (view.getId() == R.id.button1) {
            Animation animation;
            if (image.getVisibility() == View.VISIBLE) {
                animation = new BlinkAnimation(10, true);
                animation.setInterpolator(new DecelerateInterpolator());
            } else {
                animation = new BlinkAnimation(10, false);
                animation.setInterpolator(new AccelerateInterpolator());
            }
            animation.setDuration(1000L);
            animation.setAnimationListener(this);
        }
    }

    public void onAnimationStart(Animation animation) {

    }

    public void onAnimationEnd(Animation animation) {
        image.setVisibility(image.getVisibility() == View.VISIBLE ? View.INVISIBLE : View.VISIBLE);
    }

    public void onAnimationRepeat(Animation animation) {
    }
}
