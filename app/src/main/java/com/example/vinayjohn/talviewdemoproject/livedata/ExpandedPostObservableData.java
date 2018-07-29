package com.example.vinayjohn.talviewdemoproject.livedata;

import android.arch.lifecycle.MutableLiveData;

import com.example.vinayjohn.talviewdemoproject.response.CommentsModel;
import com.example.vinayjohn.talviewdemoproject.response.PostsModel;

import java.util.List;

/**
 * Created by vinayjohn on 26/07/18.
 */

public class ExpandedPostObservableData {
    private MutableLiveData<PostsModel> postsMutableLiveData;
    private MutableLiveData<List<CommentsModel>> commentsMutableLiveData;

    public ExpandedPostObservableData() {
        postsMutableLiveData = new MutableLiveData<>();
        commentsMutableLiveData = new MutableLiveData<>();
    }

    public MutableLiveData<PostsModel> getPostsObservable() {
        return this.postsMutableLiveData;
    }

    public void publishPostsDataObservable(PostsModel post) {
        postsMutableLiveData.postValue(post);
    }

    public MutableLiveData<List<CommentsModel>> getCommentsMutableLiveData() {
        return this.commentsMutableLiveData;
    }

    public void publishPostsDataObservable(List<CommentsModel> commentsModelList) {
        commentsMutableLiveData.postValue(commentsModelList);
    }
}
