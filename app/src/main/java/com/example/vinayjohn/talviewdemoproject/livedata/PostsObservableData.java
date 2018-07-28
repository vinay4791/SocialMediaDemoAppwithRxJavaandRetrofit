package com.example.vinayjohn.talviewdemoproject.livedata;

import android.arch.lifecycle.MutableLiveData;

import com.example.vinayjohn.talviewdemoproject.response.PostsModel;

import java.util.List;

/**
 * Created by vinayjohn on 26/07/18.
 */

public class PostsObservableData {

    private MutableLiveData<List<PostsModel>> postsListMutableLiveData;

    public PostsObservableData() {
        postsListMutableLiveData = new MutableLiveData<>();
    }

    public MutableLiveData<List<PostsModel>> getPostsObservable() {
        return this.postsListMutableLiveData;
    }

    public void publishPostsDataObservable(List<PostsModel> postsList) {
        postsListMutableLiveData.postValue(postsList);
    }
}
