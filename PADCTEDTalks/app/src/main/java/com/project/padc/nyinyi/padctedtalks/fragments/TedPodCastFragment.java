package com.project.padc.nyinyi.padctedtalks.fragments;

import android.annotation.SuppressLint;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.project.padc.nyinyi.padctedtalks.R;
import com.project.padc.nyinyi.padctedtalks.adapters.TalksRecyclerAdapter;
import com.project.padc.nyinyi.padctedtalks.adapters.TedPodCastRecyclerAdapter;
import com.project.padc.nyinyi.padctedtalks.components.EmptyViewPod;
import com.project.padc.nyinyi.padctedtalks.components.SmartRecyclerView;
import com.project.padc.nyinyi.padctedtalks.data.models.TedModel;
import com.project.padc.nyinyi.padctedtalks.data.vos.TedPodcast;
import com.project.padc.nyinyi.padctedtalks.data.vos.TedTalkVO;
import com.project.padc.nyinyi.padctedtalks.mvp.presenters.TedTalksPresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by user on 1/27/18.
 */

@SuppressLint("ValidFragment")
public class TedPodCastFragment extends Fragment {

    @BindView(R.id.rv_talks)
    SmartRecyclerView rvTalks;
    @BindView(R.id.vp_empty_news)
    EmptyViewPod vpEmptyNews;

    Context context;

    private TedPodCastRecyclerAdapter adapter;
    private TedModel mTedModel;

    public TedPodCastFragment(Context context) {
        this.context = context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_talks,container,false);
        ButterKnife.bind(this,view);

        rvTalks.setEmptyView(vpEmptyNews);
        rvTalks.setLayoutManager(new LinearLayoutManager(getContext(),
                LinearLayoutManager.VERTICAL, false));
        adapter = new TedPodCastRecyclerAdapter(getContext());
        rvTalks.setAdapter(adapter);

        mTedModel = ViewModelProviders.of(this).get(TedModel.class);
        mTedModel.loadTedPodCast();
        mTedModel.initDatabase(context);
        mTedModel.getTedPodCast().observe(this, new Observer<List<TedPodcast>>() {
            @Override
            public void onChanged(@Nullable List<TedPodcast> tedTalksVOs) {
                adapter.setNewData(tedTalksVOs);
            }
        });

        return view;
    }
}
