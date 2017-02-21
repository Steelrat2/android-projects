package com.testtask.twittersearch.twitter;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Dmitriy on 14.02.2017.
 */

public class Urls {

    @SerializedName("url")
    public String url;
    @SerializedName("expanded_url")
    public String expanded_url;
    @SerializedName("display_url")
    public String display_url;
    @SerializedName("indices")
    public List<Integer> indices;
}
