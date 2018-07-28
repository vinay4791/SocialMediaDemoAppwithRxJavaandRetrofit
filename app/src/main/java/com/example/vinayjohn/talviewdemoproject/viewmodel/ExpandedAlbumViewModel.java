package com.example.vinayjohn.talviewdemoproject.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import com.example.vinayjohn.talviewdemoproject.api.ServiceManager;
import com.example.vinayjohn.talviewdemoproject.livedata.PhotosObservableData;
import com.example.vinayjohn.talviewdemoproject.response.PhotosModel;

import java.util.List;

import rx.Observer;
import rx.Subscription;

/**
 * Created by vinayjohn on 26/07/18.
 */

public class ExpandedAlbumViewModel extends AndroidViewModel {
    private ServiceManager serviceManager;
    Subscription photosSubsription = null;

    public ExpandedAlbumViewModel(@NonNull Application application) {
        super(application);
        serviceManager = new ServiceManager();
    }

    public void doGetPosts(PhotosObservableData observableData, String albumId) {
        photosSubsription = serviceManager.getPhotos(albumId).subscribe((new Observer<List<PhotosModel>>() {


            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(List<PhotosModel> photos) {
                observableData.publishPhotosDataObservable(photos);
            }
        }));

    }

    @Override
    protected void onCleared() {
        super.onCleared();
        if (!photosSubsription.isUnsubscribed() && photosSubsription != null) {
            photosSubsription.unsubscribe();
        }
    }
}
