package com.testtask.twittersearch.twitter;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Dmitriy on 14.02.2017.
 */

public class Search_metadata {
    @SerializedName("completed_in")
    public float completed_in;
    @SerializedName("max_id")
    public long max_id;
    @SerializedName("max_id_str")
    public String max_id_str;
    @SerializedName("query")
    public String query;
    @SerializedName("refresh_url")
    public String refresh_url;
    @SerializedName("count")
    public int count;
    @SerializedName("since_id")
    public long since_id;
    @SerializedName("since_id_str")
    public String since_id_str;

}
