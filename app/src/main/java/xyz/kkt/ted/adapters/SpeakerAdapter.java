package xyz.kkt.ted.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import xyz.kkt.ted.R;
import xyz.kkt.ted.data.vos.TalksVO;
import xyz.kkt.ted.viewHolders.SpeakerViewHolder;
import xyz.kkt.ted.viewHolders.TopicViewHolder;


/**
 * Created by Lenovo on 11/8/2017.
 */

public class SpeakerAdapter extends BaseRecycleAdapter<SpeakerViewHolder, TalksVO> {

    public SpeakerAdapter(Context context) {
        super(context);
    }

    @Override
    public void onBindViewHolder(SpeakerViewHolder holder, int position) {

    }

    @Override
    public SpeakerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mLayoutInflater.inflate(R.layout.view_item_speaker, parent, false);
        return new SpeakerViewHolder(itemView);
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
