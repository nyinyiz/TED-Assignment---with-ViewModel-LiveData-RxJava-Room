package com.project.padc.nyinyi.padctedtalks.data.db;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.project.padc.nyinyi.padctedtalks.data.vos.TedPlaylistVO;
import com.project.padc.nyinyi.padctedtalks.data.vos.TedPodcast;
import com.project.padc.nyinyi.padctedtalks.data.vos.TedTalkVO;
import com.project.padc.nyinyi.padctedtalks.utils.TedTalkConstants;

import java.util.List;

/**
 * Created by user on 1/25/18.
 */

@Dao
public interface TedTalkDao {


    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long insertTedTalks(TedTalkVO tedTalkVO); // vo obj y' id ko return pyan tl

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long[] insertTedTalks(TedTalkVO... tedTalkVOS);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long[] insertTedPlayList(TedPlaylistVO... tedPlaylistVOS);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long[] insertTedPodCast(TedPodcast... tedPodcastsVOS);


    @Query("SELECT * FROM "+ TedTalkConstants.TED_TALK_TABLE_NAME)
    LiveData<List<TedTalkVO>> getAllTedTalks();

    @Query("SELECT * FROM "+ TedTalkConstants.TED_TALK_TABLE_NAME+" WHERE mTalkId = :tedTalkId LIMIT 1" )
    TedTalkVO getTedTalksById(long tedTalkId);

    @Query("SELECT * FROM "+ TedTalkConstants.TED_PLAY_LIST_TABLE_NAME+" WHERE mPlaylistId = :tedPlayListId LIMIT 1" )
    TedPlaylistVO getTedPlayListById(long tedPlayListId);

    @Query("SELECT * FROM "+ TedTalkConstants.TED_PLAY_LIST_TABLE_NAME)
    LiveData<List<TedPlaylistVO>> getAllTedPlayList();

    @Query("SELECT * FROM "+ TedTalkConstants.TED_POD_CAST_TABLE_NAME)
    LiveData<List<TedPodcast>> getAllTedPodCast();

    @Query("DELETE FROM "+TedTalkConstants.TED_TALK_TABLE_NAME)
    void deleteTedTalk();

    @Query("DELETE FROM "+TedTalkConstants.TED_PLAY_LIST_TABLE_NAME)
    void deleteTedPlaylist();

    @Query("DELETE FROM "+TedTalkConstants.TED_POD_CAST_TABLE_NAME)
    void deleteTedPodCast();

}
