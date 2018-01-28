package xyz.kkt.ted.fragments;


import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.kkt.ted.R;
import xyz.kkt.ted.adapters.TalksAdapter;
import xyz.kkt.ted.components.EmptyViewPod;
import xyz.kkt.ted.components.SmartRecyclerView;
import xyz.kkt.ted.components.SmartScrollListener;
import xyz.kkt.ted.data.models.TEDModel;
import xyz.kkt.ted.data.vos.TalksVO;

/**
 * Created by Lenovo on 11/8/2017.
 */

public class TalksFragment extends BaseFragment {

    private SmartScrollListener mSmartScrollListener;

    private TalksAdapter mTalksAdapter;

    private TEDModel mTedModel;

    @BindView(R.id.vp_empty_talk)
    EmptyViewPod vpEmptyTalk;

    @BindView(R.id.rv_talks)
    SmartRecyclerView rvTalks;

    @BindView(R.id.swipe_refresh_layout)
    SwipeRefreshLayout swipeRefreshLayout;


    public static TalksFragment newInstance() {
        TalksFragment fragment = new TalksFragment();
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

        mTalksAdapter = new TalksAdapter(getContext());

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_talks, container, false);
        ButterKnife.bind(this, view);

        rvTalks.setEmptyView(vpEmptyTalk);
        rvTalks.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        rvTalks.setAdapter(mTalksAdapter);

        /*mSmartScrollListener = new SmartScrollListener(new SmartScrollListener.OnSmartScrollListener() {
            @Override
            public void onListEndReach() {
                Snackbar.make(rvTalks, "Loading new data.", Snackbar.LENGTH_LONG).show();
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

        rvTalks.addOnScrollListener(mSmartScrollListener);*/

        mTedModel = ViewModelProviders.of(this).get(TEDModel.class);
        //mTedModel.initDatabase(getContext());
        mTedModel.callTalkApi();
        if (mTedModel.getTalks() != null) {
//            mTalksAdapter.setNewData(mTedModel.getTalks());
            mTedModel.getTalks().observe(this, new Observer<List<TalksVO>>() {
                @Override
                public void onChanged(@Nullable List<TalksVO> talksVOS) {
                    mTalksAdapter.setNewData(talksVOS);
                }
            });
        }
        return view;
    }
}
