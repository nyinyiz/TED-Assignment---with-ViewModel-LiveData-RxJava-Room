package com.project.padc.nyinyi.padctedtalks.fragments;

import android.annotation.SuppressLint;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.project.padc.nyinyi.padctedtalks.R;
import com.project.padc.nyinyi.padctedtalks.activities.TedPlaylistDetailActivity;
import com.project.padc.nyinyi.padctedtalks.activities.TedTalkDetailActivity;
import com.project.padc.nyinyi.padctedtalks.adapters.PlaylistRecyclerAdapter;
import com.project.padc.nyinyi.padctedtalks.adapters.TalksRecyclerAdapter;
import com.project.padc.nyinyi.padctedtalks.components.EmptyViewPod;
import com.project.padc.nyinyi.padctedtalks.components.SmartRecyclerView;
import com.project.padc.nyinyi.padctedtalks.data.models.TedModel;
import com.project.padc.nyinyi.padctedtalks.data.vos.TedPlaylistVO;
import com.project.padc.nyinyi.padctedtalks.data.vos.TedTalkVO;
import com.project.padc.nyinyi.padctedtalks.mvp.presenters.TedTalkPlayListPresenter;
import com.project.padc.nyinyi.padctedtalks.mvp.views.TedTalkPlayListView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by user on 1/26/18.
 */

@SuppressLint("ValidFragment")
public class PlayListFragments extends Fragment implements TedTalkPlayListView {

    @BindView(R.id.rv_talks)
    SmartRecyclerView rvTalks;
    @BindView(R.id.vp_empty_news)
    EmptyViewPod vpEmptyNews;

    Context context;

    private PlaylistRecyclerAdapter adapter;
    private TedModel mTedModel;
    private TedTalkPlayListPresenter mPresenter;

    public PlayListFragments(Context context) {
        this.context = context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = new TedTalkPlayListPresenter();
        mPresenter.onCreate(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_play_list,container,false);
        ButterKnife.bind(this,view);

        rvTalks.setEmptyView(vpEmptyNews);
        rvTalks.setLayoutManager(new GridLayoutManager(getContext(),2));
        adapter = new PlaylistRecyclerAdapter(getContext(),mPresenter);
        rvTalks.setAdapter(adapter);

        mTedModel = ViewModelProviders.of(this).get(TedModel.class);
        mTedModel.loadTedPlayList();
        mTedModel.initDatabase(context);
        mTedModel.getTedPlayList().observe(this, new Observer<List<TedPlaylistVO>>() {
            @Override
            public void onChanged(@Nullable List<TedPlaylistVO> tedPlaylistVOS) {
                adapter.setNewData(tedPlaylistVOS);
            }
        });

        return view;

    }

    @Override
    public void navigateToTedTalkPlayListDetailView(TedPlaylistVO tedPlaylistVO) {
        Intent intent = TedPlaylistDetailActivity.newIntent(getContext(),tedPlaylistVO.getPlaylistId()+"");
        context.startActivity(intent);
    }
}
