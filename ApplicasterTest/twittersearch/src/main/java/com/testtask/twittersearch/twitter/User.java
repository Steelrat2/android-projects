package com.testtask.twittersearch.twitter;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Dmitriy on 14.02.2017.
 */

public class User {

    @SerializedName("id")
    public long id;
    @SerializedName("id_str")
    public String id_str;
    @SerializedName("name")
    public String name;
    @SerializedName("screen_name")
    public String screen_name;
    @SerializedName("location")
    public String location;
    @SerializedName("description")
    public String description;
    @SerializedName("url")
    public String url;
    @SerializedName("entities")
    public Entities entities;
    @SerializedName("protected")
    public boolean mProtected;
    @SerializedName("followers_count")
    public int followers_count;
    @SerializedName("friends_count")
    public int friends_count;
    @SerializedName("listed_count")
    public int listed_count;
    @SerializedName("created_at")
    public String created_at;
    @SerializedName("favourites_count")
    public int favourites_count;
    @SerializedName("utc_offset")
    public int utc_offset;
    @SerializedName("time_zone")
    public String time_zone;
    @SerializedName("geo_enabled")
    public boolean geo_enabled;
    @SerializedName("verified")
    public boolean verified;
    @SerializedName("statuses_count")
    public int statuses_count;
    @SerializedName("lang")
    public String lang;
    @SerializedName("contributors_enabled")
    public boolean contributors_enabled;
    @SerializedName("is_translator")
    public boolean is_translator;
    @SerializedName("is_translation_enabled")
    public boolean is_translation_enabled;
    @SerializedName("profile_background_color")
    public String profile_background_color;
    @SerializedName("profile_background_image_url")
    public String profile_background_image_url;
    @SerializedName("profile_background_image_url_https")
    public String profile_background_image_url_https;
    @SerializedName("profile_background_tile")
    public boolean profile_background_tile;
    @SerializedName("profile_image_url")
    public String profile_image_url;
    @SerializedName("profile_image_url_https")
    public String profile_image_url_https;
    @SerializedName("profile_banner_url")
    public String profile_banner_url;
    @SerializedName("profile_link_color")
    public String profile_link_color;
    @SerializedName("profile_sidebar_border_color")
    public String profile_sidebar_border_color;
    @SerializedName("profile_sidebar_fill_color")
    public String profile_sidebar_fill_color;
    @SerializedName("profile_text_color")
    public String profile_text_color;
    @SerializedName("profile_use_background_image")
    public boolean profile_use_background_image;
    @SerializedName("has_extended_profile")
    public boolean has_extended_profile;
    @SerializedName("default_profile")
    public boolean default_profile;
    @SerializedName("default_profile_image")
    public boolean default_profile_image;
    @SerializedName("translator_type")
    public String translator_type;
}
