package com.example.vinayjohn.talviewdemoproject.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import com.example.vinayjohn.talviewdemoproject.api.ServiceManager;
import com.example.vinayjohn.talviewdemoproject.livedata.ExpandedPostObservableData;
import com.example.vinayjohn.talviewdemoproject.response.PostsModel;

import rx.Observer;
import rx.Subscription;

/**
 * Created by vinayjohn on 26/07/18.
 */

public class ExpandedPostsViewModel extends AndroidViewModel {

    private ServiceManager serviceManager;
    Subscription expandedPostsSubsription = null;

    public ExpandedPostsViewModel(@NonNull Application application) {
        super(application);
        serviceManager = new ServiceManager();
    }

    public void doGetPosts(ExpandedPostObservableData observableData, String postsId) {
        expandedPostsSubsription = serviceManager.getPostDetails(postsId).subscribe((new Observer<PostsModel>() {


            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(PostsModel post) {
                observableData.publishPostsDataObservable(post);
            }
        }));

    }

    @Override
    protected void onCleared() {
        super.onCleared();
        if (!expandedPostsSubsription.isUnsubscribed() && expandedPostsSubsription != null) {
            expandedPostsSubsription.unsubscribe();
        }
    }
}
