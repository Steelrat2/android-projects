package com.homework.applicastertest;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.testtask.twittersearch.TwitterSearch;
import com.testtask.twittersearch.twitter.Entities;
import com.testtask.twittersearch.twitter.Hashtags;
import com.testtask.twittersearch.twitter.Status;
import com.testtask.twittersearch.twitter.TwitterSearchResponse;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements OnClickListener {

    private final static String TAG = MainActivity.class.getSimpleName();
    protected final static String ATTRIBUTE_TWEET_TEXT = "tweetText";
    protected final static String ATTRIBUTE_TWEET_HASHTAGS = "tweetHashTags";
    protected final static String ATTRIBUTE_TWEET_CREATED = "textCreated";

    private List<Map<String, ?>> mDataArray;
    private SimpleAdapter mSAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button searchButton = (Button)findViewById(R.id.buttonSearch);
        searchButton.setOnClickListener(this);

        String[] fromChan = { ATTRIBUTE_TWEET_TEXT, ATTRIBUTE_TWEET_HASHTAGS, ATTRIBUTE_TWEET_CREATED};
        int[] toChan = { R.id.textViewText, R.id.textViewHashTags, R.id.textCreated};

        mDataArray = new ArrayList<>();
        mSAdapter = new SimpleAdapter(this, mDataArray, R.layout.tweet_layout, fromChan, toChan);

        ListView listView = (ListView)findViewById(R.id.listView);
        listView.setAdapter(mSAdapter);
        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
    }

    @Override
    public void onClick(View v) {
        EditText editTextSearch = (EditText)findViewById(R.id.edittextSearch);
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(editTextSearch.getWindowToken(), 0);
        String hashtag = editTextSearch.getText().toString().trim();
        if(hashtag.length() == 0) {
           dialogBoxMessage(getString(R.string.error), getString(R.string.hastagerror), false);
            return;
        }
        // todo request
        TwitterSearch twitterSearch = new TwitterSearch();
        twitterSearch.searchByHashtag(hashtag, 10, new TwitterSearch.ResultCallback<TwitterSearchResponse>() {
            @Override
            public void result(TwitterSearchResponse twitterSearchResponse, String errorMessage) {
                if(twitterSearchResponse==null) {
                    Log.v(TAG, "errorMessage: " + errorMessage);
                    // todo show dialog box with errorMessage
                    dialogBoxMessage(getString(R.string.error), errorMessage, false);
                }
                else {
                    List<Status> statuses = twitterSearchResponse.statuses;
                    Log.v(TAG, "statuses size=" + statuses.size());
                    // todo update listview
                    updateListView(statuses);
                }
            }
        });
    }

    private void updateListView(List<Status> statuses){
        mDataArray.clear();
        if(statuses != null) {
            for (Status status : statuses) {
                Map<String, Object> map = new HashMap<>();
                map.put(ATTRIBUTE_TWEET_TEXT, status.text);
                StringBuilder sb = new StringBuilder();
                Entities entities = status.entities;
                if (entities != null && entities.hashtags != null) {
                    for (Hashtags hashtag : entities.hashtags) {
                        sb.append(hashtag.text).append(" ");
                    }
                    map.put(ATTRIBUTE_TWEET_HASHTAGS, sb.toString());
                }
                if(StringUtils.isNoneEmpty(status.created_at)) {
                    map.put(ATTRIBUTE_TWEET_CREATED, status.created_at);
                }
                mDataArray.add(map);
            }
        }
        mSAdapter.notifyDataSetChanged();
    }

    private void dialogBoxMessage(String titel, String message, final boolean critical){

        if(isFinishing())
            return;

        AlertDialog.Builder ad = new AlertDialog.Builder(this);
        ad.setTitle(titel);
        ad.setMessage(message);
        if(critical)
            ad.setCancelable(false);

        ad.setNeutralButton(getString(android.R.string.ok), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int arg1) {
                if(critical)
                    System.exit(-1);
            }
        });
        ad.show();
    }
}
