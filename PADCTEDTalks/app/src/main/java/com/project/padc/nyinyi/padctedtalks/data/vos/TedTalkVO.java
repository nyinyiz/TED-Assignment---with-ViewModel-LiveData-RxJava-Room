
package com.project.padc.nyinyi.padctedtalks.data.vos;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;

import java.util.List;
import com.google.gson.annotations.SerializedName;
import com.project.padc.nyinyi.padctedtalks.utils.TedTalkConstants;

@Entity(tableName = TedTalkConstants.TED_TALK_TABLE_NAME)//table name py tr
@TypeConverters(TedTypeConverter.class)
public class TedTalkVO {

    @PrimaryKey(autoGenerate = true)
    private long talkId;

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

    public long getId() {
        return talkId;
    }

    public void setId(long id) {
        this.talkId = id;
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

    public Long getTalkId() {
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
