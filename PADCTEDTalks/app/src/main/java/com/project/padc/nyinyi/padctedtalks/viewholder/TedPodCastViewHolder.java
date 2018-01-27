package com.project.padc.nyinyi.padctedtalks.viewholder;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.project.padc.nyinyi.padctedtalks.R;
import com.project.padc.nyinyi.padctedtalks.data.vos.TedPodcast;
import com.project.padc.nyinyi.padctedtalks.delegates.TedPodCastDelegates;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by user on 1/27/18.
 */

public class TedPodCastViewHolder extends BaseViewHolder<TedPodcast> {

    @BindView(R.id.iv_pod_cast_back_drop)
    ImageView ivPodCastBackDrop;
    @BindView(R.id.tv_pod_cast_title)
    TextView tvPodCastTitle;
    @BindView(R.id.tv_pod_cast_des)
    TextView tvPodCastDes;

    private TedPodcast mTedPodcast;
    private TedPodCastDelegates mDelegate;

    public TedPodCastViewHolder(View itemView,TedPodCastDelegates delegates) {
        super(itemView);
        ButterKnife.bind(this,itemView);
        mDelegate = delegates;
        itemView.setOnClickListener(this);
    }

    @Override
    public void setmData(TedPodcast data) {
        mTedPodcast = data;

    }

    @Override
    public void bind(Context context) {
        if (mTedPodcast != null)
        {
            RequestOptions requestOptions = new RequestOptions();
            requestOptions.placeholder(R.drawable.place_holder_promotion);
            requestOptions.error(R.drawable.place_holder_promotion);

            Glide.with(context)
                    .setDefaultRequestOptions(requestOptions)
                    .load(mTedPodcast.getImageUrl())
                    .into(ivPodCastBackDrop);

            tvPodCastTitle.setText(mTedPodcast.getTitle());
            tvPodCastDes.setText(mTedPodcast.getDescription());

        }
    }

    @Override
    public void onClick(View v) {
        mDelegate.onTapTedItem(mTedPodcast);
    }
}
