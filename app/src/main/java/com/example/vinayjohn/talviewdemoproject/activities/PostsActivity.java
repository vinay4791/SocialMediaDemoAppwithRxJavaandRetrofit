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
import com.example.vinayjohn.talviewdemoproject.adapter.PostsListCustomAdapter;
import com.example.vinayjohn.talviewdemoproject.livedata.PostsObservableData;
import com.example.vinayjohn.talviewdemoproject.response.PostsModel;
import com.example.vinayjohn.talviewdemoproject.viewmodel.PostsViewModel;

import java.util.List;

/**
 * Created by vinayjohn on 25/07/18.
 */

public class PostsActivity extends ToolbarActivity implements PostsListCustomAdapter.OnPostsListCustomAdapterItemClickListener {

    private PostsListCustomAdapter adapter;
    private RecyclerView recyclerView;
    private RelativeLayout progressBar;
    private PostsViewModel postsViewModel;
    private PostsObservableData observableData;

    public static void start(Context context) {
        Intent intent = new Intent(context, PostsActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posts);
        initialize();
        initializeLiveDataObservables();
        fetchData();
    }

    private void initialize() {
        initToolBar("Posts", null);
        postsViewModel = ViewModelProviders.of(this).get(PostsViewModel.class);
        progressBar = findViewById(R.id.progress_bar);
    }

    private void initializeLiveDataObservables() {
        observableData = new PostsObservableData();
        observableData.getPostsObservable().observe(this, postsResponse -> {
            generateDataList(postsResponse);
        });
    }


    private void fetchData() {
        progressBar.setVisibility(View.VISIBLE);
        postsViewModel.doGetPosts(observableData);
    }


    /*Method to generate List of data using RecyclerView with custom adapter*/
    private void generateDataList(List<PostsModel> postsList) {
        progressBar.setVisibility(View.GONE);
        recyclerView = findViewById(R.id.posts_recycler_view);
        adapter = new PostsListCustomAdapter(this, postsList, this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(PostsActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onPostsListCustomAdapterItemClick(String postsId) {
        ExpandedPostActivity.start(this, postsId);
    }
}
