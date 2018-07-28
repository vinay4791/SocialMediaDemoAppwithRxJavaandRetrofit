package com.example.vinayjohn.talviewdemoproject.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import com.example.vinayjohn.talviewdemoproject.api.ServiceManager;
import com.example.vinayjohn.talviewdemoproject.livedata.PostsObservableData;
import com.example.vinayjohn.talviewdemoproject.response.PostsModel;

import java.util.List;

import rx.Observer;
import rx.Subscription;

/**
 * Created by vinayjohn on 26/07/18.
 */

public class PostsViewModel extends AndroidViewModel {

    private ServiceManager serviceManager;
    Subscription postSubsription = null;

    public PostsViewModel(@NonNull Application application) {
        super(application);
        serviceManager = new ServiceManager();
    }

    public void doGetPosts(PostsObservableData observableData) {
        postSubsription = serviceManager.getPosts().subscribe((new Observer<List<PostsModel>>() {


            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(List<PostsModel> postsModels) {
                observableData.publishPostsDataObservable(postsModels);
            }
        }));

    }

    @Override
    protected void onCleared() {
        super.onCleared();
        if (!postSubsription.isUnsubscribed() && postSubsription != null) {
            postSubsription.unsubscribe();
        }
    }
}
