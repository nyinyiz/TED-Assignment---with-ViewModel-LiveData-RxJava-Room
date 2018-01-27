package com.project.padc.nyinyi.padctedtalks.fragments;

import android.annotation.SuppressLint;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.project.padc.nyinyi.padctedtalks.R;
import com.project.padc.nyinyi.padctedtalks.adapters.SearchRecyclerAdapter;
import com.project.padc.nyinyi.padctedtalks.adapters.TalksRecyclerAdapter;
import com.project.padc.nyinyi.padctedtalks.data.models.TedModel;
import com.project.padc.nyinyi.padctedtalks.data.vos.Result;
import com.project.padc.nyinyi.padctedtalks.data.vos.TedPlaylistVO;
import com.project.padc.nyinyi.padctedtalks.mvp.presenters.TedTalkPlayListPresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by user on 1/27/18.
 */

@SuppressLint("ValidFragment")
public class SearchFragment extends Fragment {

    private static final String PLAY_LIST = "playlist";
    private static final String TALK = "talk";

    @BindView(R.id.rv_playlist)
    RecyclerView rvPlaylist;
    @BindView(R.id.rv_talk)
    RecyclerView rvTalk;

    Context context;
    String searchResult = " ";

    private SearchRecyclerAdapter adapterPlaylist;
    private SearchRecyclerAdapter adapterTalk;

    private TedModel mTedModel;

    public SearchFragment(Context context,String searchValue) {
        this.context = context;
        searchResult = searchValue;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search,container,false);
        ButterKnife.bind(this,view);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext()){
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };

        rvPlaylist.setLayoutManager(linearLayoutManager);
        adapterPlaylist = new SearchRecyclerAdapter(context);
        rvPlaylist.setAdapter(adapterPlaylist);

        rvTalk.setLayoutManager(new LinearLayoutManager(getContext()){
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        });
        adapterTalk = new SearchRecyclerAdapter(context);
        rvTalk.setAdapter(adapterTalk);

        mTedModel = ViewModelProviders.of(this).get(TedModel.class);
        mTedModel.loadTedSearch();
        mTedModel.initDatabase(context);
        mTedModel.getSearchDataByValue(searchResult,PLAY_LIST).observe(this, new Observer<List<Result>>() {
            @Override
            public void onChanged(@Nullable List<Result> results) {
                adapterPlaylist.setNewData(results);

            }
        });
        mTedModel.getSearchDataByValue(searchResult,TALK).observe(this, new Observer<List<Result>>() {
            @Override
            public void onChanged(@Nullable List<Result> results) {
                adapterTalk.setNewData(results);

            }
        });

        return view;
    }

}
