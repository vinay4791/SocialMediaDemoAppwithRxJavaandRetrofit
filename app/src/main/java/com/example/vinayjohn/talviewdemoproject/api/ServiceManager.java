package com.example.vinayjohn.talviewdemoproject.api;

import com.example.vinayjohn.talviewdemoproject.response.AlbumsModel;
import com.example.vinayjohn.talviewdemoproject.response.CommentsModel;
import com.example.vinayjohn.talviewdemoproject.response.PhotosModel;
import com.example.vinayjohn.talviewdemoproject.response.PostsModel;

import java.util.List;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by vinayjohn on 26/07/18.
 */

public class ServiceManager {

    private ApiInterface apiInterface;

    public ServiceManager() {
        apiInterface = ApiClient.getRetrofitInstance().create(ApiInterface.class);
    }

    public Observable<List<PostsModel>> getPosts() {
        return apiInterface.getAllPosts().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(response -> {
                    return response;
                });
    }

    public Observable<List<AlbumsModel>> getAlbums() {
        return apiInterface.getAlbums().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(response -> {
                    return response;
                });
    }

    public Observable<List<PhotosModel>> getPhotos(String albumId) {
        return apiInterface.getPhotos(albumId).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(response -> {
                    return response;
                });
    }

    public Observable<List<CommentsModel>> getComments(String commentId) {
        return apiInterface.getComments(commentId).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(response -> {
                    return response;
                });
    }

    public Observable<PostsModel> getPostDetails(String postId) {
        return apiInterface.getPostDetails(postId).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(response -> {
                    return response;
                });
    }

}
