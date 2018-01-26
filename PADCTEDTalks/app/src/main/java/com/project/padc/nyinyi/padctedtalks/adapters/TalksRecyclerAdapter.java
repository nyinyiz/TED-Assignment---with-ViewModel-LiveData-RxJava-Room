package com.project.padc.nyinyi.padctedtalks.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.project.padc.nyinyi.padctedtalks.R;
import com.project.padc.nyinyi.padctedtalks.data.vos.TedTalkVO;
import com.project.padc.nyinyi.padctedtalks.delegates.TedDelegates;
import com.project.padc.nyinyi.padctedtalks.viewholder.TalksViewHolder;

/**
 * Created by user on 1/22/18.
 */

public class TalksRecyclerAdapter extends BaseRecyclerAdapter<TalksViewHolder,TedTalkVO> {

    private TedDelegates mDelegate;

    public TalksRecyclerAdapter(Context context,TedDelegates delegates) {
        super(context);
        mDelegate = delegates;

    }

    @Override
    public TalksViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mLayoutInflator.inflate(R.layout.item_list_talks,parent,false);
        TalksViewHolder vh = new TalksViewHolder(view,mDelegate);

        return vh;
    }

  /*  @Override
    public void onBindViewHolder(TalksViewHolder holder, int position) {
        super.onBindViewHolder(holder, position);

    }*/

}
