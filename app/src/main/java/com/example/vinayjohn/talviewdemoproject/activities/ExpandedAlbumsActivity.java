package com.example.vinayjohn.talviewdemoproject.activities;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.vinayjohn.talviewdemoproject.R;
import com.example.vinayjohn.talviewdemoproject.adapter.PhotoListCustomAdapter;
import com.example.vinayjohn.talviewdemoproject.api.ApiClient;
import com.example.vinayjohn.talviewdemoproject.api.ApiInterface;
import com.example.vinayjohn.talviewdemoproject.livedata.AlbumsObservableData;
import com.example.vinayjohn.talviewdemoproject.livedata.ExpandedPostObservableData;
import com.example.vinayjohn.talviewdemoproject.livedata.PhotosObservableData;
import com.example.vinayjohn.talviewdemoproject.response.PhotosModel;
import com.example.vinayjohn.talviewdemoproject.viewmodel.AlbumsViewModel;
import com.example.vinayjohn.talviewdemoproject.viewmodel.ExpandedAlbumViewModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by vinayjohn on 25/07/18.
 */

public class ExpandedAlbumsActivity extends ToolbarActivity implements PhotoListCustomAdapter.OnPhotoListCustomAdapterItemClickListener {


    private PhotoListCustomAdapter adapter;
    private RecyclerView recyclerView;
    private RelativeLayout progressBar;
    private ExpandedAlbumViewModel expandedAlbumViewModel;
    private PhotosObservableData photosObservableData;
    private String albumId;

    public static void start(Context context, String albumId) {
        Intent intent = new Intent(context, ExpandedAlbumsActivity.class);
        intent.putExtra("albumId", albumId);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expanded_albums);

        Bundle bundle = getIntent().getExtras();
        albumId = bundle.getString("albumId");
        initialize();
        initializeLiveDataObservables();
        fetchData();
    }


    private void initialize() {
        initToolBar("Photos", null);
        expandedAlbumViewModel = ViewModelProviders.of(this).get(ExpandedAlbumViewModel.class);
        progressBar = findViewById(R.id.progress_bar);
    }


    private void initializeLiveDataObservables() {
        photosObservableData = new PhotosObservableData();
        photosObservableData.getPhotosObservable().observe(this, photosResponse -> {
            generateDataList(photosResponse);
        });
    }


    private void fetchData() {
        progressBar.setVisibility(View.VISIBLE);
        expandedAlbumViewModel.doGetPosts(photosObservableData, albumId);
    }

    /*Method to generate List of data using RecyclerView with custom adapter*/
    private void generateDataList(List<PhotosModel> photoList) {
        progressBar.setVisibility(View.GONE);
        recyclerView = findViewById(R.id.photos_recycler_view);
        adapter = new PhotoListCustomAdapter(this, photoList, this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(ExpandedAlbumsActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onPhotoListCustomAdapterItemClick(String photoUrl) {
        ExpandedPhotoActivity.start(this, photoUrl);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
