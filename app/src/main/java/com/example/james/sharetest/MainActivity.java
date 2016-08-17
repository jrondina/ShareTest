package com.example.james.sharetest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;

public class MainActivity extends AppCompatActivity {

    Button tweetButton;
    EditText tweetEdit;
    String tweet;
    Twitter twitter;

    public static final String TAG = "ShareTest";
    public static final String CONSUMER_KEY = " 6FCKnOeCVFehIiunrWnL6itSO";
    public static final String CONSUMER_SECRET = "c7kGW8TLiHywj367U1b8ScCSE1g86NZp2H1A3FHasfXrXlNf5u";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tweetEdit = (EditText) findViewById(R.id.editStatus);
        tweetButton = (Button) findViewById(R.id.statusButton);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                tweet = tweetEdit.getText().toString();
                twitter = TwitterFactory.getSingleton();

                twitter.setOAuthConsumer(CONSUMER_KEY, CONSUMER_SECRET);

                try {
                    Status status = twitter.updateStatus(tweet);
                    Log.i(TAG, "onClick: Updated Status with " + tweet);
                } catch (TwitterException e) {
                    Log.e(TAG, "onClick: Unable to send tweet", e);
                }

            }
        };

        tweetButton.setOnClickListener(listener);

    }
}
