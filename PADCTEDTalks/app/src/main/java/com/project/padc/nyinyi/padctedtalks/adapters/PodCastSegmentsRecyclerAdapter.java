package com.project.padc.nyinyi.padctedtalks.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.project.padc.nyinyi.padctedtalks.R;
import com.project.padc.nyinyi.padctedtalks.data.vos.Segment;
import com.project.padc.nyinyi.padctedtalks.data.vos.TedPodcast;
import com.project.padc.nyinyi.padctedtalks.viewholder.PodCastSegmentsViewHolder;
import com.project.padc.nyinyi.padctedtalks.viewholder.TedPodCastViewHolder;

/**
 * Created by user on 1/27/18.
 */

public class PodCastSegmentsRecyclerAdapter extends BaseRecyclerAdapter<PodCastSegmentsViewHolder,Segment> {


    public PodCastSegmentsRecyclerAdapter(Context context) {
        super(context);
    }

    @Override
    public PodCastSegmentsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mLayoutInflator.inflate(R.layout.item_list_pod_cast_segments,parent,false);
        PodCastSegmentsViewHolder vh = new PodCastSegmentsViewHolder(view);
        return vh;
    }
}
