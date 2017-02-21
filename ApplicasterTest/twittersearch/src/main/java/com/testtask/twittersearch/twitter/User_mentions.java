package com.testtask.twittersearch.twitter;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Dmitriy on 14.02.2017.
 */

public class User_mentions {

    @SerializedName("screen_name")
    public String screen_name;
    @SerializedName("name")
    public String name;
    @SerializedName("id")
    public long id;
    @SerializedName("id_str")
    public String id_str;
    @SerializedName("indices")
    public List<Integer> indices;

}
