package com.testtask.twittersearch;

import com.testtask.twittersearch.twitter.OAuth2TokenResponse;
import com.testtask.twittersearch.twitter.TwitterSearchResponse;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by Dmitriy on 14.02.2017.
 */

public interface TwitterApi {

    @FormUrlEncoded
    @Headers("Connection: Keep-Alive")
    @POST("oauth2/token")
    Call<OAuth2TokenResponse> accessToken(@Header("Authorization") String basicAuthorization,
                                          @Field("grant_type") String body); //grant_type=client_credentials

    @GET("1.1/search/tweets.json")
    Call<TwitterSearchResponse> searchTweets(@Header("Authorization") String bearerAuthorization,
                                             @Query("q") String q,
                                             @Query("count") int count,
                                             @Query("include_entities") boolean include_entities);

}
