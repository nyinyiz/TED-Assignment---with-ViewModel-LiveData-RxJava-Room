
package com.project.padc.nyinyi.padctedtalks.data.vos;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;
import com.project.padc.nyinyi.padctedtalks.utils.TedTalkConstants;

@Entity(tableName = TedTalkConstants.TED_TALK_TAG_TABLE_NAME)//table name py tr
public class Tag {

    @PrimaryKey(autoGenerate = true)
    private long tag_Id;

    @SerializedName("description")
    private String mDescription;
    @SerializedName("tag")
    private String mTag;
    @SerializedName("tag_id")
    private Long mTagId;

    public long getTag_Id() {
        return tag_Id;
    }

    public void setTag_Id(long tag_Id) {
        this.tag_Id = tag_Id;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public String getTag() {
        return mTag;
    }

    public void setTag(String tag) {
        mTag = tag;
    }

    public Long getTagId() {
        return mTagId;
    }

    public void setTagId(Long tagId) {
        mTagId = tagId;
    }

}
