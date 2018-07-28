package com.example.vinayjohn.talviewdemoproject.response;

/**
 * Created by vinayjohn on 25/07/18.
 */

public class AlbumsModel {
    private String id;

    private String title;

    private String userId;

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getTitle ()
    {
        return title;
    }

    public void setTitle (String title)
    {
        this.title = title;
    }

    public String getUserId ()
    {
        return userId;
    }

    public void setUserId (String userId)
    {
        this.userId = userId;
    }
}
