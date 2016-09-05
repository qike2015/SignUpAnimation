package com.example.qike.sigininani;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AccelerateInterpolator;

import com.example.qike.sigininani.utils.DensityUtils;

/**
 * 作者：漆可 on 2016/9/1 18:24
 */
public class HomeActivity extends AppCompatActivity
{
    private View rl_title;
    private View iv_menu;
    private View iv_me;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);

        rl_title = findViewById(R.id.rl_title);
        iv_menu = findViewById(R.id.iv_menu);
        iv_me = findViewById(R.id.iv_me);

        rl_title.post(new Runnable()
        {
            @Override
            public void run()
            {
                startAni();
            }
        });
    }

    private void startAni()
    {
        ValueAnimator valueAnimator = ValueAnimator.ofInt(rl_title.getHeight(), DensityUtils.dp2px(this, 50));
        valueAnimator.setInterpolator(new AccelerateInterpolator());

        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
        {
            @Override
            public void onAnimationUpdate(ValueAnimator animation)
            {
                rl_title.getLayoutParams().height = (int) animation.getAnimatedValue();
                rl_title.requestLayout();
            }
        });

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(valueAnimator,
                ObjectAnimator.ofFloat(iv_me, "Alpha", 0.1f, 1.0f),
                ObjectAnimator.ofFloat(iv_menu, "Alpha", 0.1f, 1.0f));
        animatorSet.setDuration(1200);
        animatorSet.start();
    }
}
