package xyz.kkt.ted.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import xyz.kkt.ted.R;
import xyz.kkt.ted.data.vos.TalksVO;
import xyz.kkt.ted.viewHolders.TalksViewHolder;


/**
 * Created by Lenovo on 11/8/2017.
 */

public class TalksAdapter extends BaseRecycleAdapter<TalksViewHolder, TalksVO> {

    public TalksAdapter(Context context) {
        super(context);
    }


    @Override
    public TalksViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mLayoutInflater.inflate(R.layout.view_item_talks, parent, false);
        return new TalksViewHolder(itemView);
    }

}
