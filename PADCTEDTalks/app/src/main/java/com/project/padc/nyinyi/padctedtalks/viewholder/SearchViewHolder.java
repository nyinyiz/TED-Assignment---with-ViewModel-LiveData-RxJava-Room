package com.project.padc.nyinyi.padctedtalks.viewholder;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.project.padc.nyinyi.padctedtalks.R;
import com.project.padc.nyinyi.padctedtalks.data.vos.Result;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by user on 1/27/18.
 */

public class SearchViewHolder extends BaseViewHolder<Result> {

    @BindView(R.id.iv_talks_in_play_list_back_drop)
    ImageView ivTalkBackDrop;
    @BindView(R.id.tv_talks_speaker)
    TextView tvTalksSpeaker;
    @BindView(R.id.tv_talks_title)
    TextView tvTalksTitle;

    private Result mResult;

    public SearchViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }

    @Override
    public void setmData(Result data) {
        mResult = data;
    }

    @Override
    public void bind(Context context) {
        RequestOptions requestOptions = new RequestOptions();
        requestOptions.placeholder(R.drawable.place_holder_promotion);
        requestOptions.error(R.drawable.place_holder_promotion);

        Glide.with(context)
                .setDefaultRequestOptions(requestOptions)
                .load(mResult.getImageUrl())
                .into(ivTalkBackDrop);

        tvTalksSpeaker.setText(mResult.getTitle());
        tvTalksTitle.setText(mResult.getDescription());
    }

    @Override
    public void onClick(View v) {

    }
}
