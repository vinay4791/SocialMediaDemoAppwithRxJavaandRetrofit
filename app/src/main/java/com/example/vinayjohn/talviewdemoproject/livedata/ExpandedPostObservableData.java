package com.example.vinayjohn.talviewdemoproject.livedata;

import android.arch.lifecycle.MutableLiveData;

import com.example.vinayjohn.talviewdemoproject.response.PostsModel;

/**
 * Created by vinayjohn on 26/07/18.
 */

public class ExpandedPostObservableData {
    private MutableLiveData<PostsModel> postsMutableLiveData;

    public ExpandedPostObservableData() {
        postsMutableLiveData = new MutableLiveData<>();
    }

    public MutableLiveData<PostsModel> getPostsObservable() {
        return this.postsMutableLiveData;
    }

    public void publishPostsDataObservable(PostsModel post) {
        postsMutableLiveData.postValue(post);
    }
}
