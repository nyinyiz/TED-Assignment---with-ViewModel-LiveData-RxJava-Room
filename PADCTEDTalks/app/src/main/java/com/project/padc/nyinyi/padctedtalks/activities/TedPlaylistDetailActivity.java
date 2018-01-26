package com.project.padc.nyinyi.padctedtalks.activities;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.project.padc.nyinyi.padctedtalks.R;
import com.project.padc.nyinyi.padctedtalks.adapters.TalksInPlayListRecyclerAdapter;
import com.project.padc.nyinyi.padctedtalks.adapters.TalksRecyclerAdapter;
import com.project.padc.nyinyi.padctedtalks.data.models.TedModel;
import com.project.padc.nyinyi.padctedtalks.data.vos.TalksInPlaylist;
import com.project.padc.nyinyi.padctedtalks.data.vos.TedPlaylistVO;
import com.project.padc.nyinyi.padctedtalks.data.vos.TedTalkVO;
import com.project.padc.nyinyi.padctedtalks.delegates.TedDelegates;
import com.project.padc.nyinyi.padctedtalks.delegates.TedTalkInPlayListDelegates;
import com.project.padc.nyinyi.padctedtalks.mvp.presenters.TedTalkPlayListPresenter;
import com.project.padc.nyinyi.padctedtalks.mvp.presenters.TedTalksInPlayListPresenter;
import com.project.padc.nyinyi.padctedtalks.mvp.presenters.TedTalksPresenter;
import com.project.padc.nyinyi.padctedtalks.mvp.views.TedTalksInPlayListView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TedPlaylistDetailActivity extends BaseActivity implements TedTalksInPlayListView {

    private static final String TED_TALK_PLAY_LIST_ID = "tedTalkPlayListId";

    @BindView(R.id.iv_talk_playlist_back_drop)
    ImageView ivTalkPlayListBackDrop;
    @BindView(R.id.iv_ted_talk_back_drop)
    ImageView ivTedTalkBackDrop;
    @BindView(R.id.tv_talks_title)
    TextView tvTalkTitle;
    @BindView(R.id.tv_talk_des)
    TextView tvTalkDes;
    @BindView(R.id.tv_time_duration)
    TextView tvTimeDuration;
    @BindView(R.id.rv_view)
    RecyclerView rvView;

    private TedModel mTedModel;
    private String mTedTalkPlayListId;
    private TedPlaylistVO mTedPlaylistVO;

    private TalksInPlayListRecyclerAdapter adapter;

    private TedTalksInPlayListPresenter mTalksPresenter;

    public static Intent newIntent(Context context, String tedtalkPlayListId)
    {
        Intent intent = new Intent(context,TedPlaylistDetailActivity.class);
        intent.putExtra(TED_TALK_PLAY_LIST_ID,tedtalkPlayListId);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ted_playlist_detail);
        ButterKnife.bind(this,this);

        mTedTalkPlayListId = getIntent().getStringExtra(TED_TALK_PLAY_LIST_ID);

        mTalksPresenter = new TedTalksInPlayListPresenter();
        mTalksPresenter.onCreate(this);

        rvView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),
                LinearLayoutManager.VERTICAL, false));
        adapter = new TalksInPlayListRecyclerAdapter(this,mTalksPresenter);
        rvView.setAdapter(adapter);


        mTedModel = ViewModelProviders.of(this).get(TedModel.class);
        mTedModel.initDatabase(getApplicationContext());
        mTedPlaylistVO = mTedModel.getTedPlayListByID(Long.parseLong(mTedTalkPlayListId));

        if (mTedPlaylistVO != null)
        {
            Glide.with(this)
                    .load(mTedPlaylistVO.getImageUrl())
                    .placeholder(R.drawable.place_holder_promotion)
                    .centerCrop()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(ivTedTalkBackDrop);

            Glide.with(this)
                    .load(mTedPlaylistVO.getImageUrl())
                    .placeholder(R.drawable.place_holder_promotion)
                    .centerCrop()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(ivTalkPlayListBackDrop);

            tvTalkTitle.setText(mTedPlaylistVO.getTitle());
            tvTalkDes.setText(mTedPlaylistVO.getDescription());

            String talkAndTime = mTedPlaylistVO.getTotalTalks() +" talks | ";

            long totalDurationInSec = 0;
            for (int i = 0 ; i < mTedPlaylistVO.getTalksInPlaylist().size() ; i++)
            {
                totalDurationInSec += mTedPlaylistVO.getTalksInPlaylist().get(i).getDurationInSec();
            }

            long timeMin = totalDurationInSec / 60 ;
            long timeSec = totalDurationInSec % 60 ;

            tvTimeDuration .setText(talkAndTime+timeMin +":"+timeSec);

            adapter.setNewData(mTedPlaylistVO.getTalksInPlaylist());

        }
    }


    @Override
    public void navigateToTedTalkDetailView(TalksInPlaylist tedTalkVO) {
        Intent intent = TedTalkDetailActivity.newIntent(getApplicationContext(),tedTalkVO.getTalkId()+"");
        startActivity(intent);
    }
}
