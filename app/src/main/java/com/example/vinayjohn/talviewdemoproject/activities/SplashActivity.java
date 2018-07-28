package com.example.vinayjohn.talviewdemoproject.activities;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.example.vinayjohn.talviewdemoproject.R;

/**
 * Created by vinayjohn on 26/07/18.
 */

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
    }


    @Override
    protected void onResume() {
        super.onResume();
        new Handler().postDelayed(() -> {
            MainActivity.start(this);
            finish();
        }, 1000);
    }
}
