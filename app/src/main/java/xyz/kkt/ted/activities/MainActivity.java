package xyz.kkt.ted.activities;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import xyz.kkt.ted.R;
import xyz.kkt.ted.adapters.TEDTabAdapter;
import xyz.kkt.ted.data.models.TEDModel;
import xyz.kkt.ted.fragments.PlaylistFragment;
import xyz.kkt.ted.fragments.PodcastFragment;
import xyz.kkt.ted.fragments.TalksFragment;

public class MainActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.tl_ted)
    TabLayout tabLayout;

    @BindView(R.id.pager_ted)
    ViewPager viewPager;

    @BindView(R.id.fab)
    FloatingActionButton fab;

    private TEDTabAdapter mTedTabAdapter;

    private TEDModel mTedModel;

    private int[] imgIds = {
            R.drawable.ic_list_24dp,
            R.drawable.ic_playlist_play_24dp,
            R.drawable.ic_keyboard_voice_24dp,
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this, this);

        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();

        if (actionBar != null) {
            actionBar.setTitle(getString(R.string.title_ted));
        }

        mTedTabAdapter = new TEDTabAdapter(getSupportFragmentManager());

        mTedTabAdapter.addTap(TalksFragment.newInstance());
        mTedTabAdapter.addTap(PlaylistFragment.newInstance());
        mTedTabAdapter.addTap(PodcastFragment.newInstance());

        viewPager.setAdapter(mTedTabAdapter);
        viewPager.setOffscreenPageLimit(mTedTabAdapter.getCount());//load all the fragments

        tabLayout.setupWithViewPager(viewPager);//connect viewpager and tablayout


        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            tabLayout.getTabAt(i).setIcon(imgIds[i]);
        }

        tabLayout.setOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(viewPager) {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                super.onTabSelected(tab);

                int tabIconColor = ContextCompat.getColor(getApplicationContext(), R.color.tab_selected);
                tab.getIcon().setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                super.onTabUnselected(tab);

                int tabIconColor = ContextCompat.getColor(getApplicationContext(), R.color.tab_unselected);
                tab.getIcon().setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                super.onTabReselected(tab);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @OnClick(R.id.fab)
    public void navigate_to_search_activity() {
        Intent intent = SearchActivity.newIntent(getApplicationContext());
        startActivity(intent);
    }

}
