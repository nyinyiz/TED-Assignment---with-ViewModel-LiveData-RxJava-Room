
package com.project.padc.nyinyi.padctedtalks.data.vos;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;
import com.project.padc.nyinyi.padctedtalks.utils.TedTalkConstants;

@Entity(tableName = TedTalkConstants.TED_SEARCH_TABLE_NAME)//table name py tr
public class Result {

    @PrimaryKey(autoGenerate = true)
    private long segment_Id;

    @SerializedName("description")
    private String mDescription;

    @SerializedName("imageUrl")
    private String mImageUrl;

    @SerializedName("result_id")
    private Long mResultId;

    @SerializedName("result_type")
    private String mResultType;

    @SerializedName("search_result_id")
    private Long mSearchResultId;

    @SerializedName("title")
    private String mTitle;

    public long getSegment_Id() {
        return segment_Id;
    }

    public void setSegment_Id(long segment_Id) {
        this.segment_Id = segment_Id;
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

    public Long getResultId() {
        return mResultId;
    }

    public void setResultId(Long resultId) {
        mResultId = resultId;
    }

    public String getResultType() {
        return mResultType;
    }

    public void setResultType(String resultType) {
        mResultType = resultType;
    }

    public Long getSearchResultId() {
        return mSearchResultId;
    }

    public void setSearchResultId(Long searchResultId) {
        mSearchResultId = searchResultId;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

}
