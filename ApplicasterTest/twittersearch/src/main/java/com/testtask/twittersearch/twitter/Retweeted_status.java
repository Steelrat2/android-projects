package com.testtask.twittersearch.twitter;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Dmitriy on 14.02.2017.
 */

public class Retweeted_status {

    @SerializedName("created_at")
    public String created_at;
    @SerializedName("id")
    public long id;
    @SerializedName("id_str")
    public String id_str;
    @SerializedName("text")
    public String text;
    @SerializedName("truncated")
    public boolean truncated;
    @SerializedName("entities")
    public Entities entities;
    @SerializedName("metadata")
    public Metadata metadata;
    @SerializedName("source")
    public String source;
    @SerializedName("user")
    public User user;
    @SerializedName("is_quote_status")
    public boolean is_quote_status;
    @SerializedName("quoted_status_id")
    public long quoted_status_id;
    @SerializedName("quoted_status_id_str")
    public String quoted_status_id_str;
    @SerializedName("retweet_count")
    public int retweet_count;
    @SerializedName("favorite_count")
    public int favorite_count;
    @SerializedName("favorited")
    public boolean favorited;
    @SerializedName("retweeted")
    public boolean retweeted;
    @SerializedName("possibly_sensitive")
    public boolean possibly_sensitive;
    @SerializedName("lang")
    public String lang;

}
