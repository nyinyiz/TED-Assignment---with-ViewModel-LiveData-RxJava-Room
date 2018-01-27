package com.project.padc.nyinyi.padctedtalks.viewholder;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.project.padc.nyinyi.padctedtalks.R;
import com.project.padc.nyinyi.padctedtalks.data.vos.Segment;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by user on 1/27/18.
 */

public class PodCastSegmentsViewHolder extends BaseViewHolder<Segment> {

    @BindView(R.id.iv_segment)
    ImageView ivSegment;
    @BindView(R.id.tv_segment_title)
    TextView tvSegmentTitle;

    private Segment mSegment;

    public PodCastSegmentsViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }

    @Override
    public void setmData(Segment data) {
        mSegment = data;
    }

    @Override
    public void bind(Context context) {
        if (mSegment != null)
        {
            Glide.with(context).load(mSegment.getImageUrl()).apply(RequestOptions.circleCropTransform()).into(ivSegment);
            tvSegmentTitle.setText(mSegment.getTitle());

        }
    }

    @Override
    public void onClick(View v) {

    }
}
