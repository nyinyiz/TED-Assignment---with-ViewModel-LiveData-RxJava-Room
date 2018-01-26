package com.project.padc.nyinyi.padctedtalks.data.models;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.support.annotation.MainThread;
import android.text.TextUtils;
import android.util.Log;

import com.google.gson.Gson;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.project.padc.nyinyi.padctedtalks.TedTalksApp;
import com.project.padc.nyinyi.padctedtalks.data.db.AppDatabase;
import com.project.padc.nyinyi.padctedtalks.data.vos.TedPlaylistVO;
import com.project.padc.nyinyi.padctedtalks.data.vos.TedPodcast;
import com.project.padc.nyinyi.padctedtalks.data.vos.TedTalkVO;
import com.project.padc.nyinyi.padctedtalks.network.TedApi;
import com.project.padc.nyinyi.padctedtalks.network.response.PlaylistResponse;
import com.project.padc.nyinyi.padctedtalks.network.response.TalksResponse;
import com.project.padc.nyinyi.padctedtalks.network.response.TedPodCastsResponse;
import com.project.padc.nyinyi.padctedtalks.utils.TedConstants;

import org.greenrobot.eventbus.EventBus;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.project.padc.nyinyi.padctedtalks.TedTalksApp.TAG;

/**
 * Created by user on 1/25/18.
 */

public class TedModel extends ViewModel {

    private AppDatabase mAppDatabase;
    private TedApi theApi;


    public TedModel() {
        initTedApi();

    }

    public void loadTedTalkList() {
        theApi.getTedTalkList(TedConstants.ACCESS_TOKEN,TedConstants.PAGE)
                .subscribeOn(Schedulers.io())//observer ka koe srr pyu ml data ko create lot py ml method yl thread
                .observeOn(AndroidSchedulers.mainThread())//
                .subscribe(new Consumer<TalksResponse>() {
                    @Override
                    public void accept(TalksResponse talksResponse) throws Exception {
                        mAppDatabase.tedTalksDao().deleteTedTalk();
                        long[] insertedIds = mAppDatabase.tedTalksDao().insertTedTalks(talksResponse.getTedTalks().toArray(new TedTalkVO[0]));
                        Log.d(TedTalksApp.TAG, "Total inserted count : " + insertedIds.length);
                    }
                });
    }

    public void loadTedPlayList() {
        theApi.getTedPlayList(TedConstants.ACCESS_TOKEN,TedConstants.PAGE)
                .subscribeOn(Schedulers.io())//observer ka koe srr pyu ml data ko create lot py ml method yl thread
                .observeOn(AndroidSchedulers.mainThread())//
                .subscribe(new Consumer<PlaylistResponse>() {
                    @Override
                    public void accept(PlaylistResponse playlistResponse) throws Exception {
                        mAppDatabase.tedTalksDao().deleteTedPlaylist();
                        long[] insertedIds = mAppDatabase.tedTalksDao().insertTedPlayList(playlistResponse.getTedPlaylists().toArray(new TedPlaylistVO[0]));
                        Log.d(TedTalksApp.TAG, "Total inserted count : " + insertedIds.length);
                    }
                });
    }

    public void loadTedPodCast() {
        theApi.getTedPodCast(TedConstants.ACCESS_TOKEN,TedConstants.PAGE)
                .subscribeOn(Schedulers.io())//observer ka koe srr pyu ml data ko create lot py ml method yl thread
                .observeOn(AndroidSchedulers.mainThread())//
                .subscribe(new Consumer<TedPodCastsResponse>() {
                    @Override
                    public void accept(TedPodCastsResponse tedPodCastsResponse) throws Exception {
                        mAppDatabase.tedTalksDao().deleteTedPodCast();
                        long[] insertedIds = mAppDatabase.tedTalksDao().insertTedPodCast(tedPodCastsResponse.getTedPodcasts().toArray(new TedPodcast[0]));
                        Log.d(TedTalksApp.TAG, "Total inserted count : " + insertedIds.length);
                    }
                });
    }


    public void initDatabase(Context context) {
        mAppDatabase = AppDatabase.getInMemoryDatabase(context);
    }

    public LiveData<List<TedTalkVO>> getTedTalks() {
        return mAppDatabase.tedTalksDao().getAllTedTalks();
    }

    public LiveData<List<TedPlaylistVO>> getTedPlayList() {
        return mAppDatabase.tedTalksDao().getAllTedPlayList();
    }

    public LiveData<List<TedPodcast>> getTedPodCast() {
        return mAppDatabase.tedTalksDao().getAllTedPodCast();
    }

    public TedTalkVO getTedTalkByID(long tedTalkId) {
        return mAppDatabase.tedTalksDao().getTedTalksById(tedTalkId);
    }

    public TedPlaylistVO getTedPlayListByID(long tedPlayListId) {
        return mAppDatabase.tedTalksDao().getTedPlayListById(tedPlayListId);
    }


    @Override
    protected void onCleared() {
        super.onCleared();
        AppDatabase.destroyInstance();
    }

    private void initTedApi() {

        final OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(TedConstants.TED_TALK_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build();

        theApi = retrofit.create(TedApi.class);

    }

}
