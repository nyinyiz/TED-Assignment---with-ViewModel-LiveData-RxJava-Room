package com.project.padc.nyinyi.padctedtalks.activities;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.project.padc.nyinyi.padctedtalks.R;
import com.project.padc.nyinyi.padctedtalks.adapters.PodCastSegmentsRecyclerAdapter;
import com.project.padc.nyinyi.padctedtalks.adapters.TalksInPlayListRecyclerAdapter;
import com.project.padc.nyinyi.padctedtalks.data.models.TedModel;
import com.project.padc.nyinyi.padctedtalks.data.vos.TedPodcast;
import com.project.padc.nyinyi.padctedtalks.mvp.views.TedPodCastView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PodCastDetailActivity extends BaseActivity {


    private static final String TED_TALK_POD_CAST_ID = "tedTalkPodcastId";

    @BindView(R.id.tool_bar)
    Toolbar toolbar;
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
    private String mTedTalkPodCastId;
    private TedPodcast mTedPodcast;

    private PodCastSegmentsRecyclerAdapter adapter;

    public static Intent newIntent(Context context, String tedtalkPodCastId)
    {
        Intent intent = new Intent(context,PodCastDetailActivity.class);
        intent.putExtra(TED_TALK_POD_CAST_ID,tedtalkPodCastId);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pod_cast_detail);
        ButterKnife.bind(this,this);

        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();

        if (toolbar != null) {
            assert actionBar != null;
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowHomeEnabled(true);
        }

        mTedTalkPodCastId = getIntent().getStringExtra(TED_TALK_POD_CAST_ID);

        rvView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),
                LinearLayoutManager.VERTICAL, false));
        adapter = new PodCastSegmentsRecyclerAdapter(this);
        rvView.setAdapter(adapter);

        mTedModel = ViewModelProviders.of(this).get(TedModel.class);
        mTedModel.initDatabase(getApplicationContext());
        mTedPodcast = mTedModel.getTedPodCastByID(Long.parseLong(mTedTalkPodCastId));

        if (mTedPodcast != null)
        {
            Glide.with(this)
                    .load(mTedPodcast.getImageUrl())
                    .into(ivTedTalkBackDrop);

            tvTalkTitle.setText(mTedPodcast.getTitle());
            tvTalkDes.setText(mTedPodcast.getDescription());

            tvTimeDuration.setText(mTedPodcast.getSegments().size()+" segments");
            adapter.setNewData(mTedPodcast.getSegments());

        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case android.R.id.home:
                onBackPressed();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
