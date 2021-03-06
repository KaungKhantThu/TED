package xyz.kkt.ted.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import xyz.kkt.ted.R;
import xyz.kkt.ted.data.vos.PodcastVO;
import xyz.kkt.ted.data.vos.TalksVO;
import xyz.kkt.ted.viewHolders.TalksViewHolder;
import xyz.kkt.ted.viewHolders.PodcastViewHolder;


/**
 * Created by Lenovo on 11/8/2017.
 */

public class PodcastAdapter extends BaseRecycleAdapter<PodcastViewHolder, PodcastVO> {

    public PodcastAdapter(Context context) {
        super(context);
    }

    @Override
    public PodcastViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mLayoutInflater.inflate(R.layout.view_item_podcast, parent, false);
        return new PodcastViewHolder(itemView);
    }

}
