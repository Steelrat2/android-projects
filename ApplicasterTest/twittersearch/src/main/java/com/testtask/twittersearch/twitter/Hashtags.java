package com.testtask.twittersearch.twitter;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Dmitriy on 14.02.2017.
 */

public class Hashtags {
    @SerializedName("text")
    public String text;
    @SerializedName("indices")
    public List<Integer> indices;
}
