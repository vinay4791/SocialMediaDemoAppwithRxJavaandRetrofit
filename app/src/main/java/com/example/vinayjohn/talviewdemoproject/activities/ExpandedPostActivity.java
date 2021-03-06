package com.example.vinayjohn.talviewdemoproject.activities;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.vinayjohn.talviewdemoproject.R;
import com.example.vinayjohn.talviewdemoproject.adapter.CommentsListCustomAdapter;
import com.example.vinayjohn.talviewdemoproject.livedata.ExpandedPostObservableData;
import com.example.vinayjohn.talviewdemoproject.response.CommentsModel;
import com.example.vinayjohn.talviewdemoproject.viewmodel.ExpandedPostsViewModel;

import java.util.List;

/**
 * Created by vinayjohn on 25/07/18.
 */

public class ExpandedPostActivity extends ToolbarActivity {

    private CommentsListCustomAdapter adapter;
    private RecyclerView recyclerView;
    private String postsId;
    private RelativeLayout progressBar;
    private ExpandedPostsViewModel expandedPostsViewModel;
    private ExpandedPostObservableData expandedPostObservableData;
    private TextView postsTitle, postsBody;

    public static void start(Context context, String postsId) {
        Intent intent = new Intent(context, ExpandedPostActivity.class);
        intent.putExtra("postsId", postsId);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expanded_posts);

        Bundle bundle = getIntent().getExtras();
        postsId = bundle.getString("postsId");
        initialize();
        initializeLiveDataObservables();
        fetchData();
    }


    protected void initialize() {
        initToolBar("Post", null);
        expandedPostsViewModel = ViewModelProviders.of(this).get(ExpandedPostsViewModel.class);
        progressBar = findViewById(R.id.progress_bar);
        postsTitle = findViewById(R.id.posts_title);
        postsBody = findViewById(R.id.posts_body);
    }


    protected void initializeLiveDataObservables() {
        expandedPostObservableData = new ExpandedPostObservableData();
        expandedPostObservableData.getPostsObservable().observe(this, post -> {
            setPostDetails(post.getTitle(), post.getBody());
        });
        expandedPostObservableData.getCommentsMutableLiveData().observe(this, commentsModelList -> {
            generateDataList(commentsModelList);
        });
    }

    protected void fetchData() {
        progressBar.setVisibility(View.VISIBLE);
        expandedPostsViewModel.doGetPosts(expandedPostObservableData, postsId);
        expandedPostsViewModel.doGetComments(expandedPostObservableData,postsId);
    }

    private void generateDataList(List<CommentsModel> commentsModel) {
        progressBar.setVisibility(View.GONE);
        recyclerView = findViewById(R.id.comments_recycler_view);
        adapter = new CommentsListCustomAdapter(this, commentsModel);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(ExpandedPostActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    private void setPostDetails(String title, String body) {
        postsTitle.setText(title);
        postsBody.setText(body);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

}
