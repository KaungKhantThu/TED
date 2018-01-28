package xyz.kkt.ted.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import xyz.kkt.ted.R;
import xyz.kkt.ted.data.vos.PlaylistVO;
import xyz.kkt.ted.data.vos.TalksVO;
import xyz.kkt.ted.viewHolders.PlaylistViewHolder;


/**
 * Created by Lenovo on 11/8/2017.
 */

public class PlaylistAdapter extends BaseRecycleAdapter<PlaylistViewHolder, PlaylistVO> {

    public PlaylistAdapter(Context context) {
        super(context);
    }

    @Override
    public PlaylistViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mLayoutInflater.inflate(R.layout.view_item_playlist, parent, false);
        return new PlaylistViewHolder(itemView);
    }

}
