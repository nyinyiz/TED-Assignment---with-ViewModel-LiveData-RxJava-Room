
package com.project.padc.nyinyi.padctedtalks.data.vos;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;

import java.util.List;
import com.google.gson.annotations.SerializedName;
import com.project.padc.nyinyi.padctedtalks.utils.TedTalkConstants;

@Entity(tableName = TedTalkConstants.TED_POD_CAST_TABLE_NAME)//table name py tr
@TypeConverters(SegmentTypeConverter.class)
public class TedPodcast {

    @PrimaryKey(autoGenerate = true)
    private long tedPodCastId;

    @SerializedName("description")
    private String mDescription;

    @SerializedName("imageUrl")
    private String mImageUrl;

    @SerializedName("podcast_id")
    private Long mPodcastId;

    @SerializedName("segments")
    private List<Segment> mSegments;

    @SerializedName("title")
    private String mTitle;

    public long getTedPodCastId() {
        return tedPodCastId;
    }

    public void setTedPodCastId(long tedPodCastId) {
        this.tedPodCastId = tedPodCastId;
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

    public Long getPodcastId() {
        return mPodcastId;
    }

    public void setPodcastId(Long podcastId) {
        mPodcastId = podcastId;
    }

    public List<Segment> getSegments() {
        return mSegments;
    }

    public void setSegments(List<Segment> segments) {
        mSegments = segments;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

}
