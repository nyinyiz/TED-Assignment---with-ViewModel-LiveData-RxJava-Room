package com.project.padc.nyinyi.padctedtalks.viewholder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by user on 1/22/18.
 */

public abstract class BaseViewHolder<W> extends RecyclerView.ViewHolder implements View.OnClickListener{
    private W mData;

    public BaseViewHolder(View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);
    }

    public abstract void setmData(W data);

    public abstract void bind(Context context);
}
