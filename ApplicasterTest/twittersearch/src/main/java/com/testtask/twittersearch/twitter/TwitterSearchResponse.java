package com.testtask.twittersearch.twitter;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Dmitriy on 14.02.2017.
 */

public class TwitterSearchResponse {
    @SerializedName("statuses")
    public List<Status> statuses;
    @SerializedName("search_metadata")
    public Search_metadata search_metadata;
}
