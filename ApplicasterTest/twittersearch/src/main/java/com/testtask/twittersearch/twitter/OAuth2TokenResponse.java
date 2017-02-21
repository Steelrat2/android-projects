package com.testtask.twittersearch.twitter;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Dmitriy on 14.02.2017.
 */

public class OAuth2TokenResponse {
    @SerializedName("token_type")
    public String token_type;
    @SerializedName("access_token")
    public String access_token;
}
