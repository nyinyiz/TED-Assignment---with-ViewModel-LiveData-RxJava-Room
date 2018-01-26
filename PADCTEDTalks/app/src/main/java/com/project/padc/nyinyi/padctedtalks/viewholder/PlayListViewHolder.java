package com.project.padc.nyinyi.padctedtalks.viewholder;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.project.padc.nyinyi.padctedtalks.R;
import com.project.padc.nyinyi.padctedtalks.data.vos.TedPlaylistVO;
import com.project.padc.nyinyi.padctedtalks.data.vos.TedTalkVO;
import com.project.padc.nyinyi.padctedtalks.delegates.PlayListDelegate;
import com.project.padc.nyinyi.padctedtalks.delegates.TedDelegates;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by user on 1/26/18.
 */

public class PlayListViewHolder extends BaseViewHolder<TedPlaylistVO>  {

    @BindView(R.id.iv_playlist_back_drop)
    ImageView ivPlayListBackDrop;
    @BindView(R.id.tv_play_list_time)
    TextView tvPlayListTime;
    @BindView(R.id.tv_play_list_title)
    TextView tvPlayListTitle;

    private TedPlaylistVO mTedPlaylistVO;
    private PlayListDelegate mDelegate;

    public PlayListViewHolder(View itemView, PlayListDelegate delegate) {
        super(itemView);
        ButterKnife.bind(this,itemView);
        mDelegate = delegate;
        itemView.setOnClickListener(this);

    }

    @Override
    public void setmData(TedPlaylistVO data) {

        mTedPlaylistVO = data;
    }

    @Override
    public void bind(Context context) {
        Glide.with(context)
                .load(mTedPlaylistVO.getImageUrl())
                .placeholder(R.drawable.place_holder_promotion)
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(ivPlayListBackDrop);

        tvPlayListTitle.setText(mTedPlaylistVO.getTitle());

        String talkAndTime = mTedPlaylistVO.getTotalTalks() +" talks | ";

        long totalDurationInSec = 0;
        for (int i = 0 ; i < mTedPlaylistVO.getTalksInPlaylist().size() ; i++)
        {
            totalDurationInSec += mTedPlaylistVO.getTalksInPlaylist().get(i).getDurationInSec();
        }

        long timeMin = totalDurationInSec / 60 ;
        long timeSec = totalDurationInSec % 60 ;

        tvPlayListTime.setText(talkAndTime+timeMin +":"+timeSec);


    }

    @Override
    public void onClick(View v) {
        mDelegate.onTapPlayList(mTedPlaylistVO);
    }
}
