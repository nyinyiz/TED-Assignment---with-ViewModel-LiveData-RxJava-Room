package com.project.padc.nyinyi.padctedtalks.fragments;

import android.annotation.SuppressLint;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.project.padc.nyinyi.padctedtalks.R;
import com.project.padc.nyinyi.padctedtalks.activities.TedTalkDetailActivity;
import com.project.padc.nyinyi.padctedtalks.adapters.TalksRecyclerAdapter;
import com.project.padc.nyinyi.padctedtalks.components.EmptyViewPod;
import com.project.padc.nyinyi.padctedtalks.components.SmartRecyclerView;
import com.project.padc.nyinyi.padctedtalks.data.models.TedModel;
import com.project.padc.nyinyi.padctedtalks.data.vos.TedTalkVO;
import com.project.padc.nyinyi.padctedtalks.mvp.presenters.TedTalksPresenter;
import com.project.padc.nyinyi.padctedtalks.mvp.views.TedTalksView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by user on 1/22/18.
 */

@SuppressLint("ValidFragment")
public class TalksFragments extends Fragment implements TedTalksView {

    @BindView(R.id.rv_talks)
    SmartRecyclerView rvTalks;
    @BindView(R.id.vp_empty_news)
    EmptyViewPod vpEmptyNews;

    Context context;

    private TalksRecyclerAdapter adapter;
    private TedModel mTedModel;

    private TedTalksPresenter mTalksPresenter;

    public TalksFragments(Context context) {
        this.context = context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mTalksPresenter = new TedTalksPresenter();
        mTalksPresenter.onCreate(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_talks,container,false);
        ButterKnife.bind(this,view);

        rvTalks.setEmptyView(vpEmptyNews);
        rvTalks.setLayoutManager(new LinearLayoutManager(getContext(),
                LinearLayoutManager.VERTICAL, false));
        adapter = new TalksRecyclerAdapter(getContext(),mTalksPresenter);
        rvTalks.setAdapter(adapter);

        mTedModel = ViewModelProviders.of(this).get(TedModel.class);
        mTedModel.loadTedTalkList();
        mTedModel.initDatabase(context);
        mTedModel.getTedTalks().observe(this, new Observer<List<TedTalkVO>>() {
            @Override
            public void onChanged(@Nullable List<TedTalkVO> tedTalksVOs) {
                adapter.setNewData(tedTalksVOs);
            }
        });

        return view;
    }

    @Override
    public void navigateToTedTalkDetailView(TedTalkVO tedTalkVO) {
        Intent intent = TedTalkDetailActivity.newIntent(getContext(),tedTalkVO.getTalkId()+"");
        context.startActivity(intent);
    }
}
