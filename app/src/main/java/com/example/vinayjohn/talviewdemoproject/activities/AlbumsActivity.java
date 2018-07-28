package com.example.vinayjohn.talviewdemoproject.activities;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;

import com.example.vinayjohn.talviewdemoproject.R;
import com.example.vinayjohn.talviewdemoproject.adapter.AlbumListCustomAdapter;
import com.example.vinayjohn.talviewdemoproject.livedata.AlbumsObservableData;
import com.example.vinayjohn.talviewdemoproject.response.AlbumsModel;
import com.example.vinayjohn.talviewdemoproject.viewmodel.AlbumsViewModel;

import java.util.List;

/**
 * Created by vinayjohn on 25/07/18.
 */

public class AlbumsActivity extends ToolbarActivity implements AlbumListCustomAdapter.OnAlbumListCustomAdapterItemClickListener {

    private AlbumListCustomAdapter adapter;
    private RecyclerView recyclerView;
    private RelativeLayout progressBar;
    private AlbumsObservableData albumsObservableData;
    private AlbumsViewModel albumsViewModel;

    public static void start(Context context) {
        Intent intent = new Intent(context, AlbumsActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_albums);
        initialize();
        initializeLiveDataObservables();
        fetchData();
    }


    private void initialize() {
        initToolBar("Albums", null);
        albumsViewModel = ViewModelProviders.of(this).get(AlbumsViewModel.class);
        progressBar = findViewById(R.id.progress_bar);
    }


    private void initializeLiveDataObservables() {
        albumsObservableData = new AlbumsObservableData();
        albumsObservableData.getAlbumsObservable().observe(this, postsResponse -> {
            generateDataList(postsResponse);
        });
    }


    private void fetchData() {
        progressBar.setVisibility(View.VISIBLE);
        albumsViewModel.doGetPosts(albumsObservableData);
    }

    /*Method to generate List of data using RecyclerView with custom adapter*/
    private void generateDataList(List<AlbumsModel> photoList) {
        progressBar.setVisibility(View.GONE);
        recyclerView = findViewById(R.id.albums_recycler_view);
        adapter = new AlbumListCustomAdapter(this, photoList, this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(AlbumsActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onAlbumListCustomAdapterItemClick(String albumId) {
        ExpandedAlbumsActivity.start(this, albumId);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

}
