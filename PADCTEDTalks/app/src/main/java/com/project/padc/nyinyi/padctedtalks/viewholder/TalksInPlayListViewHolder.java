package com.project.padc.nyinyi.padctedtalks.viewholder;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.project.padc.nyinyi.padctedtalks.R;
import com.project.padc.nyinyi.padctedtalks.data.vos.TalksInPlaylist;
import com.project.padc.nyinyi.padctedtalks.data.vos.TedTalkVO;
import com.project.padc.nyinyi.padctedtalks.delegates.TedDelegates;
import com.project.padc.nyinyi.padctedtalks.delegates.TedTalkInPlayListDelegates;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by user on 1/22/18.
 */

public class TalksInPlayListViewHolder extends BaseViewHolder<TalksInPlaylist> {

    @BindView(R.id.iv_talks_in_play_list_back_drop)
    ImageView ivTalkBackDrop;
    @BindView(R.id.tv_talks_speaker)
    TextView tvTalksSpeaker;
    @BindView(R.id.tv_talks_title)
    TextView tvTalksTitle;

    private TalksInPlaylist mtedTalkVO;
    private TedTalkInPlayListDelegates mDelegate;


    public TalksInPlayListViewHolder(View itemView, TedTalkInPlayListDelegates tedDelegates) {
        super(itemView);
        ButterKnife.bind(this,itemView);
        mDelegate = tedDelegates;
        itemView.setOnClickListener(this);

    }

    @Override
    public void setmData(TalksInPlaylist data) {

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

    }

    @Override
    public void onClick(View v) {
        mDelegate.onTapTedItem(mtedTalkVO);
    }
}
