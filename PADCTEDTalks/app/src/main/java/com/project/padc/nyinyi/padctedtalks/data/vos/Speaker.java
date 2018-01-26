
package com.project.padc.nyinyi.padctedtalks.data.vos;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;
import com.project.padc.nyinyi.padctedtalks.utils.TedTalkConstants;

@Entity(tableName = TedTalkConstants.TED_TALK_SPEAKER_TABLE_NAME)//table name py tr
public class Speaker {

    @PrimaryKey(autoGenerate = true)
    private long speakId;

    @SerializedName("name")
    private String mName;
    @SerializedName("speaker_id")
    private Long mSpeakerId;

    public long getSpeakId() {
        return speakId;
    }

    public void setSpeakId(long speakId) {
        this.speakId = speakId;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public Long getSpeakerId() {
        return mSpeakerId;
    }

    public void setSpeakerId(Long speakerId) {
        mSpeakerId = speakerId;
    }

}
