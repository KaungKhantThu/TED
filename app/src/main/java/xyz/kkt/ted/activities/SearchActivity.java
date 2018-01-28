package xyz.kkt.ted.activities;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.kkt.ted.R;
import xyz.kkt.ted.adapters.SpeakerAdapter;
import xyz.kkt.ted.adapters.TopicAdapter;
import xyz.kkt.ted.components.SmartRecyclerView;

/**
 * Created by Lenovo on 1/25/2018.
 */

public class SearchActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    private TopicAdapter mTopicAdapter;
    private SpeakerAdapter mSpeakerAdapter;

    @BindView(R.id.rv_topics)
    SmartRecyclerView rvTopics;

    @BindView(R.id.rv_speakers)
    SmartRecyclerView rvSpeakers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        ButterKnife.bind(this, this);

        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();

        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_arrow_back_24dp);

            actionBar.setTitle("");
            actionBar.setBackgroundDrawable(new ColorDrawable(Color.RED));
        }

        mTopicAdapter = new TopicAdapter(getApplicationContext());
        mSpeakerAdapter = new SpeakerAdapter(getApplicationContext());

        rvTopics.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
        rvTopics.setAdapter(mTopicAdapter);

        rvSpeakers.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
        rvSpeakers.setAdapter(mSpeakerAdapter);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_search, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context, SearchActivity.class);
        return intent;
    }

}
