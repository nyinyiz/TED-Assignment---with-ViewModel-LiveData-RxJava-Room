package com.project.padc.nyinyi.padctedtalks.mvp.presenters;

import com.project.padc.nyinyi.padctedtalks.data.vos.TedPodcast;
import com.project.padc.nyinyi.padctedtalks.delegates.TedPodCastDelegates;
import com.project.padc.nyinyi.padctedtalks.mvp.views.TedPodCastView;

/**
 * Created by user on 1/27/18.
 */

public class TedPodCastPresenter extends BasePresenter<TedPodCastView> implements TedPodCastDelegates {

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void onTapTedItem(TedPodcast tedPodcast) {
        mView.navigateToTedPodCastDetailView(tedPodcast);
    }
}
