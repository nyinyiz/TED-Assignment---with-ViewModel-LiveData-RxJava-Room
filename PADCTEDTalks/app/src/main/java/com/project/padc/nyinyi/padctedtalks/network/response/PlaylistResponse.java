
package com.project.padc.nyinyi.padctedtalks.network.response;

import java.util.List;
import com.google.gson.annotations.SerializedName;
import com.project.padc.nyinyi.padctedtalks.data.vos.TedPlaylistVO;

public class PlaylistResponse {

    @SerializedName("apiVersion")
    private String mApiVersion;
    @SerializedName("code")
    private Long mCode;
    @SerializedName("message")
    private String mMessage;
    @SerializedName("page")
    private String mPage;
    @SerializedName("ted_playlists")

    private List<TedPlaylistVO> mTedPlaylistVOS;

    public String getApiVersion() {
        return mApiVersion;
    }

    public void setApiVersion(String apiVersion) {
        mApiVersion = apiVersion;
    }

    public Long getCode() {
        return mCode;
    }

    public void setCode(Long code) {
        mCode = code;
    }

    public String getMessage() {
        return mMessage;
    }

    public void setMessage(String message) {
        mMessage = message;
    }

    public String getPage() {
        return mPage;
    }

    public void setPage(String page) {
        mPage = page;
    }

    public List<TedPlaylistVO> getTedPlaylists() {
        return mTedPlaylistVOS;
    }

    public void setTedPlaylists(List<TedPlaylistVO> tedPlaylistVOS) {
        mTedPlaylistVOS = tedPlaylistVOS;
    }

}
