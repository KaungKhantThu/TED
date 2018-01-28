package xyz.kkt.ted.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.kkt.ted.R;
import xyz.kkt.ted.adapters.PodcastAdapter;
import xyz.kkt.ted.adapters.TalksAdapter;
import xyz.kkt.ted.components.EmptyViewPod;
import xyz.kkt.ted.components.SmartRecyclerView;
import xyz.kkt.ted.components.SmartScrollListener;

/**
 * Created by Lenovo on 11/8/2017.
 */

public class PodcastFragment extends BaseFragment {

    private SmartScrollListener mSmartScrollListener;

    private PodcastAdapter mPodcastAdapter;


    @BindView(R.id.vp_empty_podcast)
    EmptyViewPod vpEmptyPodcast;

    @BindView(R.id.rv_podcast)
    SmartRecyclerView rvPodcast;

    @BindView(R.id.swipe_refresh_layout)
    SwipeRefreshLayout swipeRefreshLayout;


    public static PodcastFragment newInstance() {
        PodcastFragment fragment = new PodcastFragment();
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        // mMovieItemDelegate = (MovieItemDelegate) context;

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mPodcastAdapter = new PodcastAdapter(getContext());

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_podcast, container, false);
        ButterKnife.bind(this, view);

        rvPodcast.setEmptyView(vpEmptyPodcast);
        rvPodcast.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        rvPodcast.setAdapter(mPodcastAdapter);

        mSmartScrollListener = new SmartScrollListener(new SmartScrollListener.OnSmartScrollListener() {
            @Override
            public void onListEndReach() {
                Snackbar.make(rvPodcast, "Loading new data.", Snackbar.LENGTH_LONG).show();
                swipeRefreshLayout.setRefreshing(true);
                //TODO call one more network call
            }
        });

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener()

        {
            @Override
            public void onRefresh() {
                //TODO call onForceRefresh
            }
        });

        rvPodcast.addOnScrollListener(mSmartScrollListener);

        return view;
    }
}
