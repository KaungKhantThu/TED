package xyz.kkt.ted.viewHolders;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import xyz.kkt.ted.R;
import xyz.kkt.ted.data.vos.TalksVO;

/**
 * Created by Lenovo on 11/8/2017.
 */

public class TalksViewHolder extends BaseViewHolder<TalksVO> {

    @BindView(R.id.iv_hero_talk)
    ImageView ivHeroTalk;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_time)
    TextView tvTime;

    private TalksVO talksVO;

    public TalksViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    @Override
    public void setData(TalksVO data) {

        talksVO = data;

        RequestOptions requestOptions = new RequestOptions();
        requestOptions.placeholder(R.drawable.dalai_lama);
        requestOptions.error(R.drawable.dalai_lama);

        Glide.with(ivHeroTalk.getContext())
                .setDefaultRequestOptions(requestOptions)
                .load(data.getImageUrl())
                .into(ivHeroTalk);

        tvName.setText(data.getSpeaker().getName());
        tvTitle.setText(data.getTitle());

        long timeMin = data.getDurationInSec() / 60;
        long timeSec = data.getDurationInSec() % 60;
        tvTime.setText(timeMin + ":" + timeSec);

    }

    @Override
    public void onClick(View view) {

    }

}
