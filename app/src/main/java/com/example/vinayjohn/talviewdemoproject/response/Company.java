package com.example.vinayjohn.talviewdemoproject.response;

/**
 * Created by vinayjohn on 25/07/18.
 */

public class Company {
    private String catchPhrase;

    public String getCatchPhrase() {
        return catchPhrase;
    }

    public void setCatchPhrase(String catchPhrase) {
        this.catchPhrase = catchPhrase;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBs() {
        return bs;
    }

    public void setBs(String bs) {
        this.bs = bs;
    }

    private String name;

    private String bs;
}
