package com.project.padc.nyinyi.padctedtalks.mvp.views;

import com.project.padc.nyinyi.padctedtalks.data.vos.TalksInPlaylist;
import com.project.padc.nyinyi.padctedtalks.data.vos.TedTalkVO;

/**
 * Created by user on 1/26/18.
 */

public interface TedTalksInPlayListView {

    void navigateToTedTalkDetailView(TalksInPlaylist tedTalkVO);
}
