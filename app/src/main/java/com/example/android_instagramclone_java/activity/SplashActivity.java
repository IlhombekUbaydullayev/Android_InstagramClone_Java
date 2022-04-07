package com.example.android_instagramclone_java.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.WindowManager;
import com.example.android_instagramclone_java.R;

/**
 * In SplashActivity, user can visit to SignInActivity or MainActivity
 **/


public class SplashActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);
        
        InitViews();
    }
    private void InitViews() {
        countDownTimer();
    }
    private void countDownTimer() {
        new CountDownTimer(2000,1000) {

            @Override
            public void onTick(long l) {}
            @Override
            public void onFinish() {
                openSignActivity();
            }
        }.start();
    }
    void openSignActivity() {
        Intent intent = new Intent(this,SignInActivity.class);
        startActivity(intent);
        finish();
    }
}