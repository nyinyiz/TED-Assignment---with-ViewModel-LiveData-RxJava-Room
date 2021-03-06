package com.project.padc.nyinyi.padctedtalks.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.project.padc.nyinyi.padctedtalks.R;
import com.project.padc.nyinyi.padctedtalks.data.vos.TedPodcast;
import com.project.padc.nyinyi.padctedtalks.delegates.TedPodCastDelegates;
import com.project.padc.nyinyi.padctedtalks.viewholder.TedPodCastViewHolder;

/**
 * Created by user on 1/27/18.
 */

public class TedPodCastRecyclerAdapter extends BaseRecyclerAdapter<TedPodCastViewHolder,TedPodcast> {

    private TedPodCastDelegates mDelegate;

    public TedPodCastRecyclerAdapter(Context context,TedPodCastDelegates delegates) {
        super(context);
        mDelegate = delegates;
    }

    @Override
    public TedPodCastViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mLayoutInflator.inflate(R.layout.item_list_pod_cast,parent,false);
        TedPodCastViewHolder vh = new TedPodCastViewHolder(view,mDelegate);
        return vh;
    }

  /*  @Override
    public int getItemCount() {
        return 5;
    }*/
}
