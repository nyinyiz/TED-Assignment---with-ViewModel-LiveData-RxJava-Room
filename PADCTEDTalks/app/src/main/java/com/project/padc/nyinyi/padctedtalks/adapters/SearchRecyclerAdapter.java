package com.project.padc.nyinyi.padctedtalks.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import com.project.padc.nyinyi.padctedtalks.R;
import com.project.padc.nyinyi.padctedtalks.data.vos.Result;
import com.project.padc.nyinyi.padctedtalks.viewholder.SearchViewHolder;

/**
 * Created by user on 1/27/18.
 */

public class SearchRecyclerAdapter extends BaseRecyclerAdapter<SearchViewHolder,Result> {

    public SearchRecyclerAdapter(Context context) {
        super(context);
    }

    @Override
    public SearchViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mLayoutInflator.inflate(R.layout.item_list_talks_in_playlist,parent,false);
        SearchViewHolder vh = new SearchViewHolder(view);
        return vh;
    }
}
