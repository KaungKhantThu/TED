package xyz.kkt.ted.viewHolders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.kkt.ted.R;
import xyz.kkt.ted.data.vos.PlaylistVO;
import xyz.kkt.ted.data.vos.TalksVO;

/**
 * Created by Lenovo on 11/8/2017.
 */

public class PlaylistViewHolder extends BaseViewHolder<PlaylistVO> {

    @BindView(R.id.iv_hero_playlist)
    ImageView ivHeroPlaylist;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_no_of_talks)
    TextView tvNoOfTalks;
    @BindView(R.id.tv_duration)
    TextView tvDuration;

    private PlaylistVO playlistVO;

    public PlaylistViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    @Override
    public void setData(PlaylistVO data) {
        if (data != null) {
            playlistVO = data;

            RequestOptions requestOptions = new RequestOptions();
            requestOptions.placeholder(R.drawable.dalai_lama);
            requestOptions.error(R.drawable.dalai_lama);

            Glide.with(ivHeroPlaylist.getContext())
                    .setDefaultRequestOptions(requestOptions)
                    .load(data.getImageUrl())
                    .into(ivHeroPlaylist);

            tvNoOfTalks.setText(String.valueOf(data.getTotalTalks()) + "talks");
            tvTitle.setText(data.getTitle());
            long totalDurationInSec = 0;
            for (int i = 0; i < data.getTalksInPlaylistLists().size(); i++) {
                totalDurationInSec += data.getTalksInPlaylistLists().get(i).getDurationInSec();
            }

            long timeMin = totalDurationInSec / 60;
            long timeSec = totalDurationInSec % 60;

            tvDuration.setText(timeMin + ":" + timeSec);
        }
    }

    @Override
    public void onClick(View view) {

    }

}
