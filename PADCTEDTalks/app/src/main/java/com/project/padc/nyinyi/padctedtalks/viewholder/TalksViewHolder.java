package com.project.padc.nyinyi.padctedtalks.viewholder;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.project.padc.nyinyi.padctedtalks.R;
import com.project.padc.nyinyi.padctedtalks.data.vos.TedTalkVO;
import com.project.padc.nyinyi.padctedtalks.delegates.TedDelegates;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by user on 1/22/18.
 */

public class TalksViewHolder extends BaseViewHolder<TedTalkVO> {

    @BindView(R.id.iv_talks_back_drop)
    ImageView ivTalkBackDrop;
    @BindView(R.id.tv_talks_speaker)
    TextView tvTalksSpeaker;
    @BindView(R.id.tv_talks_title)
    TextView tvTalksTitle;
    @BindView(R.id.tv_time_duration)
    TextView tvTimeDuration;

    private TedTalkVO mtedTalkVO;
    private TedDelegates mDelegate;


    public TalksViewHolder(View itemView,TedDelegates tedDelegates) {
        super(itemView);
        ButterKnife.bind(this,itemView);
        mDelegate = tedDelegates;
        itemView.setOnClickListener(this);

    }

    @Override
    public void setmData(TedTalkVO data) {

        mtedTalkVO = data;
    }

    @Override
    public void bind(Context context) {

        Glide.with(context)
                .load(mtedTalkVO.getImageUrl())
                .placeholder(R.drawable.place_holder_promotion)
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(ivTalkBackDrop);

        tvTalksSpeaker.setText(mtedTalkVO.getSpeaker().getName());
        tvTalksTitle.setText(mtedTalkVO.getTitle());

        long timeMin = mtedTalkVO.getDurationInSec() / 60 ;
        long timeSec = mtedTalkVO.getDurationInSec() % 60 ;
        tvTimeDuration.setText(timeMin +":"+timeSec);

    }

    @Override
    public void onClick(View v) {
        mDelegate.onTapTedItem(mtedTalkVO);
    }
}
