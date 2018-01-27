package com.project.padc.nyinyi.padctedtalks.network;
import com.project.padc.nyinyi.padctedtalks.network.response.PlaylistResponse;
import com.project.padc.nyinyi.padctedtalks.network.response.SearchResponse;
import com.project.padc.nyinyi.padctedtalks.network.response.TalksResponse;
import com.project.padc.nyinyi.padctedtalks.network.response.TedPodCastsResponse;
import com.project.padc.nyinyi.padctedtalks.utils.TedConstants;

import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by user on 1/25/18.
 */

public interface TedApi {

    @FormUrlEncoded
    @POST(TedConstants.API_POST_TED_TALK)
    Single<TalksResponse> getTedTalkList(
            @Field("access_token") String access_token,
            @Field("page") String page
    );

    @FormUrlEncoded
    @POST(TedConstants.API_POST_TED_PLAY_LIST)
    Single<PlaylistResponse> getTedPlayList(
            @Field("access_token") String access_token,
            @Field("page") String page
    );


    @FormUrlEncoded
    @POST(TedConstants.API_POST_TED_POD_CAST)
    Single<TedPodCastsResponse> getTedPodCast(
            @Field("access_token") String access_token,
            @Field("page") String page
    );

    @FormUrlEncoded
    @POST(TedConstants.API_POST_TED_SEARCH)
    Single<SearchResponse> getTedSearch(
            @Field("access_token") String access_token,
            @Field("page") String page
    );


}
