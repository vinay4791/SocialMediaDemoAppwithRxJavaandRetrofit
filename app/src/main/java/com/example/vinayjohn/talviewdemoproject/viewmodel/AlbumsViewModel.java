package com.example.vinayjohn.talviewdemoproject.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import com.example.vinayjohn.talviewdemoproject.api.ServiceManager;
import com.example.vinayjohn.talviewdemoproject.livedata.AlbumsObservableData;
import com.example.vinayjohn.talviewdemoproject.response.AlbumsModel;

import java.util.List;

import rx.Observer;
import rx.Subscription;

/**
 * Created by vinayjohn on 26/07/18.
 */

public class AlbumsViewModel extends AndroidViewModel {
    private ServiceManager serviceManager;
    Subscription albumsSubsription = null;

    public AlbumsViewModel(@NonNull Application application) {
        super(application);
        serviceManager = new ServiceManager();
    }

    public void doGetPosts(AlbumsObservableData observableData) {
        albumsSubsription = serviceManager.getAlbums().subscribe((new Observer<List<AlbumsModel>>() {


            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(List<AlbumsModel> albums) {
                observableData.publishAlbumsDataObservable(albums);
            }
        }));

    }

    @Override
    protected void onCleared() {
        super.onCleared();
        if (!albumsSubsription.isUnsubscribed() && albumsSubsription != null) {
            albumsSubsription.unsubscribe();
        }
    }
}
