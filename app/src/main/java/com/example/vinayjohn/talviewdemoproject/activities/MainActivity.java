package com.example.vinayjohn.talviewdemoproject.activities;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.vinayjohn.talviewdemoproject.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView albumsTv;
    private TextView postsTv;

    public static void start(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
    }


    private void initialize() {
        albumsTv = findViewById(R.id.album_btn);
        postsTv = findViewById(R.id.posts_btn);
        albumsTv.setOnClickListener(this);
        postsTv.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.album_btn:
                AlbumsActivity.start(this);
                break;
            case R.id.posts_btn:
                PostsActivity.start(this);
                break;

        }
    }
}
