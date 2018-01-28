package xyz.kkt.ted.viewHolders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.kkt.ted.R;
import xyz.kkt.ted.data.vos.PodcastVO;
import xyz.kkt.ted.data.vos.TalksVO;

/**
 * Created by Lenovo on 11/8/2017.
 */

public class PodcastViewHolder extends BaseViewHolder<PodcastVO> {

    @BindView(R.id.iv_hero_podcast)
    ImageView ivHeroPodcast;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_desc)
    TextView tvDesc;

    private PodcastVO podcastVO;

    public PodcastViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    @Override
    public void setData(PodcastVO data) {

        if (data != null) {
            podcastVO = data;

            RequestOptions requestOptions = new RequestOptions();
            requestOptions.placeholder(R.drawable.dalai_lama);
            requestOptions.error(R.drawable.dalai_lama);

            Glide.with(ivHeroPodcast.getContext())
                    .setDefaultRequestOptions(requestOptions)
                    .load(data.getImageUrl())
                    .into(ivHeroPodcast);

            tvTitle.setText(data.getTitle());
            tvDesc.setText(data.getDescription());

        }

    }

    @Override
    public void onClick(View view) {

    }

}
