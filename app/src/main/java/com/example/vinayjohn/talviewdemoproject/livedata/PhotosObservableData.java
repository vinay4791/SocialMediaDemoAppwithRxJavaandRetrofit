package com.example.vinayjohn.talviewdemoproject.livedata;

import android.arch.lifecycle.MutableLiveData;

import com.example.vinayjohn.talviewdemoproject.response.PhotosModel;

import java.util.List;

/**
 * Created by vinayjohn on 26/07/18.
 */

public class PhotosObservableData {

    private MutableLiveData<List<PhotosModel>> photosListMutableLiveData;

    public PhotosObservableData() {
        photosListMutableLiveData = new MutableLiveData<>();
    }

    public MutableLiveData<List<PhotosModel>> getPhotosObservable() {
        return this.photosListMutableLiveData;
    }

    public void publishPhotosDataObservable(List<PhotosModel> photosList) {
        photosListMutableLiveData.postValue(photosList);
    }
}
