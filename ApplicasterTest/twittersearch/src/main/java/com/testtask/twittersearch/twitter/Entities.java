package com.testtask.twittersearch.twitter;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Dmitriy on 14.02.2017.
 */

public class Entities {

    @SerializedName("hashtags")
    public List<Hashtags> hashtags;
    @SerializedName("symbols")
    public List<Hashtags> symbols;
    @SerializedName("user_mentions")
    public List<User_mentions> user_mentions;
    @SerializedName("urls")
    public List<Urls> urls;
    @SerializedName("url")
    public Url url;
    @SerializedName("description")
    public Description description;
}
