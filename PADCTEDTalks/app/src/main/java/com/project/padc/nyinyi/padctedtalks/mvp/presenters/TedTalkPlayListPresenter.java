package com.project.padc.nyinyi.padctedtalks.mvp.presenters;

import com.project.padc.nyinyi.padctedtalks.data.vos.TedPlaylistVO;
import com.project.padc.nyinyi.padctedtalks.data.vos.TedTalkVO;
import com.project.padc.nyinyi.padctedtalks.delegates.PlayListDelegate;
import com.project.padc.nyinyi.padctedtalks.delegates.TedDelegates;
import com.project.padc.nyinyi.padctedtalks.mvp.views.TedTalkPlayListView;
import com.project.padc.nyinyi.padctedtalks.mvp.views.TedTalksView;

/**
 * Created by user on 1/27/18.
 */

public class TedTalkPlayListPresenter extends BasePresenter<TedTalkPlayListView> implements PlayListDelegate {

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {

    }


    @Override
    public void onTapPlayList(TedPlaylistVO tedPlaylistVO) {
        mView.navigateToTedTalkPlayListDetailView(tedPlaylistVO);
    }
}
