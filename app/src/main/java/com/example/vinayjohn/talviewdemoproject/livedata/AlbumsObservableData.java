package com.example.vinayjohn.talviewdemoproject.livedata;

import android.arch.lifecycle.MutableLiveData;

import com.example.vinayjohn.talviewdemoproject.response.AlbumsModel;

import java.util.List;

/**
 * Created by vinayjohn on 26/07/18.
 */

public class AlbumsObservableData {

    private MutableLiveData<List<AlbumsModel>> albumsListMutableLiveData;

    public AlbumsObservableData() {
        albumsListMutableLiveData = new MutableLiveData<>();
    }

    public MutableLiveData<List<AlbumsModel>> getAlbumsObservable() {
        return this.albumsListMutableLiveData;
    }

    public void publishAlbumsDataObservable(List<AlbumsModel> albumsList) {
        albumsListMutableLiveData.postValue(albumsList);
    }

}
