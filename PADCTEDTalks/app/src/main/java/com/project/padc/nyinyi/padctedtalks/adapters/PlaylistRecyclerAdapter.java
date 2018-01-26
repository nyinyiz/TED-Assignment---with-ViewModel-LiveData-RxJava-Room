package com.project.padc.nyinyi.padctedtalks.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.project.padc.nyinyi.padctedtalks.R;
import com.project.padc.nyinyi.padctedtalks.data.vos.TedPlaylistVO;
import com.project.padc.nyinyi.padctedtalks.data.vos.TedTalkVO;
import com.project.padc.nyinyi.padctedtalks.delegates.PlayListDelegate;
import com.project.padc.nyinyi.padctedtalks.viewholder.PlayListViewHolder;
import com.project.padc.nyinyi.padctedtalks.viewholder.TalksViewHolder;

/**
 * Created by user on 1/26/18.
 */

public class PlaylistRecyclerAdapter extends BaseRecyclerAdapter<PlayListViewHolder,TedPlaylistVO> {

    private PlayListDelegate mDelegate;

    public PlaylistRecyclerAdapter(Context context, PlayListDelegate delegate) {
        super(context);
        mDelegate = delegate;
    }

    @Override
    public PlayListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mLayoutInflator.inflate(R.layout.item_list_playlist,parent,false);
        PlayListViewHolder vh = new PlayListViewHolder(view,mDelegate);
        return vh;
    }
}
