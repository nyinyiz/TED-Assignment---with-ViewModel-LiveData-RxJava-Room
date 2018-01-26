package com.project.padc.nyinyi.padctedtalks.activities;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.project.padc.nyinyi.padctedtalks.R;
import com.project.padc.nyinyi.padctedtalks.data.models.TedModel;
import com.project.padc.nyinyi.padctedtalks.data.vos.TedTalkVO;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TedTalkDetailActivity extends BaseActivity {

    private static final String TED_TALK_ID = "tedTalkId";

    @BindView(R.id.iv_ted_talk_back_drop)
    ImageView ivTedTalkBackDrop;
    @BindView(R.id.tv_talks_speaker)
    TextView tvTalksSpeaker;
    @BindView(R.id.tv_talks_title)
    TextView tvTalkTitle;
    @BindView(R.id.tv_talk_des)
    TextView tvTalkDes;
    @BindView(R.id.tv_time_duration)
    TextView tvTimeDuration;


    private TedModel mTedModel;
    private String mTedTalkId;
    private TedTalkVO mTedTalkVO;

    public static Intent newIntent(Context context,String tedtalkId)
    {
        Intent intent = new Intent(context,TedTalkDetailActivity.class);
        intent.putExtra(TED_TALK_ID,tedtalkId);
        return intent;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ted_talk_detail);
        ButterKnife.bind(this,this);

        mTedTalkId = getIntent().getStringExtra(TED_TALK_ID);

        mTedModel = ViewModelProviders.of(this).get(TedModel.class);
        mTedModel.initDatabase(getApplicationContext());
        mTedTalkVO = mTedModel.getTedTalkByID(Long.parseLong(mTedTalkId));

        if (mTedTalkVO != null)
        {
            Glide.with(this)
                    .load(mTedTalkVO.getImageUrl())
                    .placeholder(R.drawable.place_holder_promotion)
                    .centerCrop()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(ivTedTalkBackDrop);

            tvTalksSpeaker.setText(mTedTalkVO.getSpeaker().getName());
            tvTalkTitle.setText(mTedTalkVO.getTitle());
            tvTalkDes.setText(mTedTalkVO.getDescription());

            long timeMin = mTedTalkVO.getDurationInSec() / 60 ;
            long timeSec = mTedTalkVO.getDurationInSec() % 60 ;
            tvTimeDuration.setText(timeMin +":"+timeSec);

        }
    }
}
