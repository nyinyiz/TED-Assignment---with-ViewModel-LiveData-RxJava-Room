package com.project.padc.nyinyi.padctedtalks.mvp.presenters;

import com.project.padc.nyinyi.padctedtalks.data.vos.TalksInPlaylist;
import com.project.padc.nyinyi.padctedtalks.data.vos.TedTalkVO;
import com.project.padc.nyinyi.padctedtalks.delegates.TedDelegates;
import com.project.padc.nyinyi.padctedtalks.delegates.TedTalkInPlayListDelegates;
import com.project.padc.nyinyi.padctedtalks.mvp.views.TedTalksInPlayListView;
import com.project.padc.nyinyi.padctedtalks.mvp.views.TedTalksView;

/**
 * Created by user on 1/26/18.
 */

public class TedTalksInPlayListPresenter extends BasePresenter<TedTalksInPlayListView> implements TedTalkInPlayListDelegates {

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void onTapTedItem(TalksInPlaylist tedTalkVO) {
        mView.navigateToTedTalkDetailView(tedTalkVO);
    }
}
