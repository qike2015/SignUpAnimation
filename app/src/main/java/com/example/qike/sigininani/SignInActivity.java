package com.example.qike.sigininani;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SignInActivity extends AppCompatActivity
{

    private TransitionView mAnimView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.sign_up_activity);

        mAnimView = (TransitionView) findViewById(R.id.ani_view);

        mAnimView.setOnAnimationEndListener(new TransitionView.OnAnimationEndListener()
        {
            @Override
            public void onEnd()
            {
                //跳转到主页面
                gotoHomeActivity();
            }
        });
    }

    private void gotoHomeActivity()
    {
        startActivity(new Intent(this, HomeActivity.class));
        finish();
    }

    public void singUp(View view)
    {
        mAnimView.startAnimation();
    }
}
