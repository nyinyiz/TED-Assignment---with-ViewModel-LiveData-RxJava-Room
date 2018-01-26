package com.project.padc.nyinyi.padctedtalks.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.project.padc.nyinyi.padctedtalks.R;
import com.project.padc.nyinyi.padctedtalks.data.vos.TalksInPlaylist;
import com.project.padc.nyinyi.padctedtalks.data.vos.TedTalkVO;
import com.project.padc.nyinyi.padctedtalks.delegates.TedDelegates;
import com.project.padc.nyinyi.padctedtalks.delegates.TedTalkInPlayListDelegates;
import com.project.padc.nyinyi.padctedtalks.viewholder.TalksInPlayListViewHolder;
import com.project.padc.nyinyi.padctedtalks.viewholder.TalksViewHolder;

/**
 * Created by user on 1/22/18.
 */

public class TalksInPlayListRecyclerAdapter extends BaseRecyclerAdapter<TalksInPlayListViewHolder,TalksInPlaylist> {

    private TedTalkInPlayListDelegates mDelegate;

    public TalksInPlayListRecyclerAdapter(Context context, TedTalkInPlayListDelegates delegates) {
        super(context);
        mDelegate = delegates;

    }

    @Override
    public TalksInPlayListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mLayoutInflator.inflate(R.layout.item_list_talks_in_playlist,parent,false);
        TalksInPlayListViewHolder vh = new TalksInPlayListViewHolder(view,mDelegate);

        return vh;
    }

  /*  @Override
    public void onBindViewHolder(TalksViewHolder holder, int position) {
        super.onBindViewHolder(holder, position);

    }*/

}
