package xyz.kkt.ted.viewHolders;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import xyz.kkt.ted.R;
import xyz.kkt.ted.data.vos.TalksVO;

/**
 * Created by Lenovo on 11/8/2017.
 */

public class TalksViewHolder extends BaseViewHolder<TalksVO> {

    private TalksVO talksVO;

    public TalksViewHolder(View itemView) {
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
