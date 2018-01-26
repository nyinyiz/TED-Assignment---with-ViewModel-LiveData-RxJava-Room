
package com.project.padc.nyinyi.padctedtalks.data.vos;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.util.List;
import com.google.gson.annotations.SerializedName;
import com.project.padc.nyinyi.padctedtalks.utils.TedTalkConstants;

@Entity(tableName = TedTalkConstants.TALK_PLAY_LIST_TABLE_NAME)//table name py tr
public class TalksInPlaylist {

    @PrimaryKey(autoGenerate = true)
    private long talkInPlayListId;

    @SerializedName("description")
    private String mDescription;

    @SerializedName("durationInSec")
    private Long mDurationInSec;

    @SerializedName("imageUrl")
    private String mImageUrl;

    @SerializedName("speaker")
    @Embedded
    private Speaker mSpeaker;

    @SerializedName("tag")
    private List<Tag> mTag;

    @SerializedName("talk_id")
    private Long mTalkId;

    @SerializedName("title")
    private String mTitle;

    public long getTalkInPlayListId() {
        return talkInPlayListId;
    }

    public void setTalkInPlayListId(long talkInPlayListId) {
        this.talkInPlayListId = talkInPlayListId;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public Long getDurationInSec() {
        return mDurationInSec;
    }

    public void setDurationInSec(Long durationInSec) {
        mDurationInSec = durationInSec;
    }

    public String getImageUrl() {
        return mImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        mImageUrl = imageUrl;
    }

    public Speaker getSpeaker() {
        return mSpeaker;
    }

    public void setSpeaker(Speaker speaker) {
        mSpeaker = speaker;
    }

    public List<Tag> getTag() {
        return mTag;
    }

    public void setTag(List<Tag> tag) {
        mTag = tag;
    }

    public Long  getTalkId() {
        return mTalkId;
    }

    public void setTalkId(Long talkId) {
        mTalkId = talkId;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

}
