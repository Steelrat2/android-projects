package com.testtask.twittersearch;

import android.os.AsyncTask;
import android.util.Log;

import com.testtask.twittersearch.twitter.OAuth2TokenResponse;
import com.testtask.twittersearch.twitter.TwitterSearchResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by Dmitriy on 16.02.2017.
 */

public class TwitterSearch {

    private static final String TAG = TwitterSearch.class.getSimpleName();

    public interface ResultCallback<T> {
        void result(T t, String errorMessage);
    }

    private final static String BASIC = "Basic TjRhdXc1cTVWSDFFcHlnMTZFYnJpbWtrejpGWXFOenBsN2tQSnBKdWZ0UEt0dDV3MkliTnZ2Q3Nhd3dGZGtoWDVIWHk2aUlPZnY5aQ==";

    public void searchByHashtag(String request, int count, ResultCallback<TwitterSearchResponse> callback){
        if(request == null || request.trim().length() == 0) {
            callback.result(null, "Empty request");
            return;
        }
        request = request.trim();
        if('#' != request.charAt(0)) {
            request = "#" + request;
        }
        TAsyncTask firstAsync = new TAsyncTask(callback);
        firstAsync.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, request, String.valueOf(count));
    }

    private static String parseErrorBody(String jsonString) {
        String errorMessages = jsonString;
        try {
            StringBuilder sb = new StringBuilder();
            JSONObject json = new JSONObject(jsonString);
            JSONArray jArray = json.getJSONArray("errors");
            for(int i=0; i<jArray.length(); i++) {
                JSONObject json_data = jArray.getJSONObject(i);
                sb.append(json_data.getString("message")).append(". ");
                sb.append("Code:").append(json_data.getInt("code"));
                if(i<jArray.length()-1)
                    sb.append("\n");
            }
            errorMessages = sb.toString();
        } catch(JSONException e) {
            Log.e(TAG, "JSONException ", e);
        }
        return errorMessages;
    }

    private class TAsyncTask extends AsyncTask<String, Void, TwitterSearchResponse> {

        private ResultCallback<TwitterSearchResponse> mResultCallback;
        private String message = "";

        TAsyncTask(ResultCallback<TwitterSearchResponse> rc ) {
            mResultCallback = rc;
        }

        @Override
        protected TwitterSearchResponse doInBackground(String... params) {
            TwitterSearchResponse twitterSearchResponse = null;
            TwitterApi twitterApi = TwitterClient.getTwitterApi();
            try {
                Call<OAuth2TokenResponse> callAccessToken = twitterApi.accessToken(BASIC, "client_credentials");
                Response<OAuth2TokenResponse> authResponse = callAccessToken.execute();
                if(!authResponse.isSuccessful()){
                    message = parseErrorBody(authResponse.errorBody().string());
                    return null;
                }
                OAuth2TokenResponse auth2TokenResponse = authResponse.body();
                Call<TwitterSearchResponse> callTwitterSearch = twitterApi.searchTweets(
                        "Bearer " + auth2TokenResponse.access_token,
                        params[0], Integer.valueOf(params[1]), false);
                Response<TwitterSearchResponse> responseTwitterSearch = callTwitterSearch.execute();
                if(!responseTwitterSearch.isSuccessful()) {
                    message = parseErrorBody(responseTwitterSearch.errorBody().string());
                    return null;
                }
                twitterSearchResponse = responseTwitterSearch.body();
            } catch (IOException e) {
                Log.e(TAG, "IOException", e);
                message = "IOException: " + e.getLocalizedMessage();
            }
            return twitterSearchResponse;
        }

        @Override
        protected void onPostExecute(TwitterSearchResponse twitterSearchResponse) {
            if(twitterSearchResponse == null) {
                mResultCallback.result(null, message);
            }
            else {
                mResultCallback.result(twitterSearchResponse, "");
            }
        }
    }
}
