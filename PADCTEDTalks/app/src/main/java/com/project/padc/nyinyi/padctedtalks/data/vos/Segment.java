
package com.project.padc.nyinyi.padctedtalks.data.vos;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;
import com.project.padc.nyinyi.padctedtalks.utils.TedTalkConstants;

@Entity(tableName = TedTalkConstants.TED_SEGMENT_TABLE_NAME)//table name py tr
public class Segment {

    @PrimaryKey(autoGenerate = true)
    private long segment_Id;

    @SerializedName("imageUrl")
    private String mImageUrl;
    @SerializedName("segment_id")
    private Long mSegmentId;
    @SerializedName("title")
    private String mTitle;

    public String getImageUrl() {
        return mImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        mImageUrl = imageUrl;
    }

    public Long getSegmentId() {
        return mSegmentId;
    }

    public void setSegmentId(Long segmentId) {
        mSegmentId = segmentId;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

}
