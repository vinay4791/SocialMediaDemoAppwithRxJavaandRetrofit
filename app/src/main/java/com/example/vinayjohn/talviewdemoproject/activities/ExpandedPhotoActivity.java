package com.example.vinayjohn.talviewdemoproject.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.example.vinayjohn.talviewdemoproject.R;

/**
 * Created by vinayjohn on 25/07/18.
 */

public class ExpandedPhotoActivity extends AppCompatActivity {
    public static void start(Context context,String imageUrl) {
        Intent intent = new Intent(context, ExpandedPhotoActivity.class);
        intent.putExtra("photoUrl",imageUrl);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expanded_photo);
        Bundle bundle = getIntent().getExtras();

        initializePhoto(bundle.getString("photoUrl"));
    }

    private void initializePhoto(String photoUrl) {
        ImageView photoImageView = findViewById(R.id.expanded_img);
        RequestOptions requestOptions = new RequestOptions()
                .diskCacheStrategy(DiskCacheStrategy.NONE) // because file name is always same
                .skipMemoryCache(true);
        Glide.with(this)
                .load(photoUrl)
                .apply(requestOptions)
                .into(photoImageView);

    }
}
