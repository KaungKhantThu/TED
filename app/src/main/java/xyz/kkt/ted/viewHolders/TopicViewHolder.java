package xyz.kkt.ted.viewHolders;

import android.view.View;

import butterknife.ButterKnife;
import xyz.kkt.ted.data.vos.TalksVO;

/**
 * Created by Lenovo on 11/8/2017.
 */

public class TopicViewHolder extends BaseViewHolder<TalksVO> {

    private TalksVO talksVO;

    public TopicViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    @Override
    public void setData(TalksVO data) {

        talksVO = data;

    }

    @Override
    public void onClick(View view) {

    }

}
