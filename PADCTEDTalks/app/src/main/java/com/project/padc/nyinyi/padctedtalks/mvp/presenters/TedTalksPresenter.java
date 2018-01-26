package com.project.padc.nyinyi.padctedtalks.mvp.presenters;

import com.project.padc.nyinyi.padctedtalks.data.vos.TedTalkVO;
import com.project.padc.nyinyi.padctedtalks.delegates.TedDelegates;
import com.project.padc.nyinyi.padctedtalks.mvp.views.TedTalksView;

/**
 * Created by user on 1/26/18.
 */

public class TedTalksPresenter extends BasePresenter<TedTalksView> implements TedDelegates {

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void onTapTedItem(TedTalkVO tedTalkVO) {
        mView.navigateToTedTalkDetailView(tedTalkVO);
    }
}
