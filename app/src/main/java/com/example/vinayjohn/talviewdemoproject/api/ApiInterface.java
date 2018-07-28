package com.example.vinayjohn.talviewdemoproject.api;

import com.example.vinayjohn.talviewdemoproject.response.AlbumsModel;
import com.example.vinayjohn.talviewdemoproject.response.CommentsModel;
import com.example.vinayjohn.talviewdemoproject.response.PhotosModel;
import com.example.vinayjohn.talviewdemoproject.response.PostsModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by vinayjohn on 25/07/18.
 */

public interface ApiInterface {

    @GET("/albums/{albumId}/photos")
    Call<List<PhotosModel>> getAllPhotos(@Path("albumId") String albumId);

    @GET("/albums")
    Call<List<AlbumsModel>> getAllAlbums();

    @GET("/posts/{postId}/comments")
    Call<List<CommentsModel>> getAllComments(@Path("postId") String postId);

    @GET("/posts")
    Observable<List<PostsModel>> getAllPosts();

    @GET("/posts/{postId}/comments")
    Observable<List<CommentsModel>> getComments(@Path("postId") String postId);

    @GET("/posts/{postId}")
    Observable<PostsModel> getPostDetails(@Path("postId") String postId);

    @GET("/albums")
    Observable<List<AlbumsModel>> getAlbums();

    @GET("/albums/{albumId}/photos")
    Observable<List<PhotosModel>> getPhotos(@Path("albumId") String albumId);
}
