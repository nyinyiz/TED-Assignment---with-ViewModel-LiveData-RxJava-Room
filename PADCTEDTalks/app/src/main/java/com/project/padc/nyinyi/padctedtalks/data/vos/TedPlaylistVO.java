
package com.project.padc.nyinyi.padctedtalks.data.vos;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;

import java.util.List;
import com.google.gson.annotations.SerializedName;
import com.project.padc.nyinyi.padctedtalks.utils.TedTalkConstants;

@Entity(tableName = TedTalkConstants.TED_PLAY_LIST_TABLE_NAME)//table name py tr
@TypeConverters(TalksInPlaylistTypeConverter.class)
public class TedPlaylistVO {

    @PrimaryKey(autoGenerate = true)
    private long tedPlaylistId;

    @SerializedName("description")
    private String mDescription;

    @SerializedName("imageUrl")
    private String mImageUrl;

    @SerializedName("playlist_id")
    private Long mPlaylistId;

    @SerializedName("talksInPlaylist")
    private List<TalksInPlaylist> mTalksInPlaylist;

    @SerializedName("title")
    private String mTitle;

    @SerializedName("totalTalks")
    private Long mTotalTalks;

    public long getTedPlaylistId() {
        return tedPlaylistId;
    }

    public void setTedPlaylistId(long tedPlaylistId) {
        this.tedPlaylistId = tedPlaylistId;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public String getImageUrl() {
        return mImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        mImageUrl = imageUrl;
    }

    public Long getPlaylistId() {
        return mPlaylistId;
    }

    public void setPlaylistId(Long playlistId) {
        mPlaylistId = playlistId;
    }

    public List<TalksInPlaylist> getTalksInPlaylist() {
        return mTalksInPlaylist;
    }

    public void setTalksInPlaylist(List<TalksInPlaylist> talksInPlaylist) {
        mTalksInPlaylist = talksInPlaylist;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public Long getTotalTalks() {
        return mTotalTalks;
    }

    public void setTotalTalks(Long totalTalks) {
        mTotalTalks = totalTalks;
    }

}
