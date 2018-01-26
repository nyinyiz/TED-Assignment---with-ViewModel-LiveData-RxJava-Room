package com.project.padc.nyinyi.padctedtalks;

import android.app.Application;
import android.content.Context;

import com.google.gson.Gson;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.project.padc.nyinyi.padctedtalks.network.TedApi;
import com.project.padc.nyinyi.padctedtalks.network.response.TalksResponse;
import com.project.padc.nyinyi.padctedtalks.utils.TedConstants;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by user on 1/22/18.
 */

public class TedTalksApp extends Application {

    public static final String TAG = "PADC_TED_App";

    @Override
    public void onCreate() {
        super.onCreate();

    }

}
