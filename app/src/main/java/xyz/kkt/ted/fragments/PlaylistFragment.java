package xyz.kkt.ted.fragments;


import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.kkt.ted.R;
import xyz.kkt.ted.adapters.PlaylistAdapter;
import xyz.kkt.ted.adapters.TalksAdapter;
import xyz.kkt.ted.components.EmptyViewPod;
import xyz.kkt.ted.components.SmartRecyclerView;
import xyz.kkt.ted.components.SmartScrollListener;
import xyz.kkt.ted.data.models.TEDModel;
import xyz.kkt.ted.data.vos.PlaylistVO;
import xyz.kkt.ted.data.vos.PodcastVO;

/**
 * Created by Lenovo on 11/8/2017.
 */

public class PlaylistFragment extends BaseFragment {

    private SmartScrollListener mSmartScrollListener;

    private PlaylistAdapter mPlaylistAdapter;

    private TEDModel mTedModel;

    @BindView(R.id.vp_empty_playlist)
    EmptyViewPod vpEmptyPlaylist;

    @BindView(R.id.rv_playlist)
    SmartRecyclerView rvPlaylist;

    @BindView(R.id.swipe_refresh_layout)
    SwipeRefreshLayout swipeRefreshLayout;


    public static PlaylistFragment newInstance() {
        PlaylistFragment fragment = new PlaylistFragment();
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

        mPlaylistAdapter = new PlaylistAdapter(getContext());

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_playlist, container, false);
        ButterKnife.bind(this, view);

        rvPlaylist.setEmptyView(vpEmptyPlaylist);
        rvPlaylist.setLayoutManager(new GridLayoutManager(getContext(), 2, LinearLayoutManager.VERTICAL, false));

        rvPlaylist.setAdapter(mPlaylistAdapter);

        /*mSmartScrollListener = new SmartScrollListener(new SmartScrollListener.OnSmartScrollListener() {
            @Override
            public void onListEndReach() {
                Snackbar.make(rvPlaylist, "Loading new data.", Snackbar.LENGTH_LONG).show();
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

        rvPlaylist.addOnScrollListener(mSmartScrollListener);*/

        mTedModel = ViewModelProviders.of(this).get(TEDModel.class);
        mTedModel.initDatabase(getContext());
        mTedModel.callPlaylistApi();
        if (mTedModel.getTedPlayList() != null) {
//            mTalksAdapter.setNewData(mTedModel.getTalks());
            mTedModel.getTedPlayList().observe(this, new Observer<List<PlaylistVO>>() {
                @Override
                public void onChanged(@Nullable List<PlaylistVO> playlistList) {
                    mPlaylistAdapter.setNewData(playlistList);
                }
            });
        }
        return view;
    }
}
