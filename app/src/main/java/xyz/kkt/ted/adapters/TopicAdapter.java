package xyz.kkt.ted.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import xyz.kkt.ted.R;
import xyz.kkt.ted.data.vos.SearchVO;
import xyz.kkt.ted.data.vos.TalksVO;
import xyz.kkt.ted.viewHolders.PodcastViewHolder;
import xyz.kkt.ted.viewHolders.TopicViewHolder;


/**
 * Created by Lenovo on 11/8/2017.
 */

public class TopicAdapter extends BaseRecycleAdapter<TopicViewHolder, SearchVO> {

    public TopicAdapter(Context context) {
        super(context);
    }

    @Override
    public void onBindViewHolder(TopicViewHolder holder, int position) {

    }

    @Override
    public TopicViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mLayoutInflater.inflate(R.layout.view_item_topic, parent, false);
        return new TopicViewHolder(itemView);
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
