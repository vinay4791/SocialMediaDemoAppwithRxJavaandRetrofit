package com.example.vinayjohn.talviewdemoproject.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Menu;
import android.widget.TextView;

import com.example.vinayjohn.talviewdemoproject.R;

public abstract class ToolbarActivity extends AppCompatActivity {

    TextView tvToolbarTitle;
    Toolbar toolbar;
    Integer menuResourseId = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toolbar);
    }

    public void initToolBar(String title, Integer menuResourseId) {
        this.menuResourseId = menuResourseId;
        toolbar = findViewById(R.id.toolbar);
        tvToolbarTitle = findViewById(R.id.toolbar_title);
        setSupportActionBar(toolbar);
        // add back arrow to toolbar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        toolbar.setNavigationOnClickListener(view -> onBackPressed());
        setToolbarTitle(title);
    }

    public void setToolbarTitle(String title) {
        if (!TextUtils.isEmpty(title)) {
            tvToolbarTitle.setText(title);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (menuResourseId != null) {
            getMenuInflater().inflate(menuResourseId, menu);
        }
        return true;
    }

}
