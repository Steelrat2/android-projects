package com.testtask.twittersearch.twitter;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Dmitriy on 14.02.2017.
 */

public class Description {

    @SerializedName("urls")
    public List<Urls> urls;
}
