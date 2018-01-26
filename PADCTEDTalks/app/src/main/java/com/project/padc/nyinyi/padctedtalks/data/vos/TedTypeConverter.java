package com.project.padc.nyinyi.padctedtalks.data.vos;

import android.arch.persistence.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.util.List;

import io.reactivex.functions.Function;

/**
 * Created by user on 1/25/18.
 */

public class TedTypeConverter {

    @TypeConverter
    public String listToString(List<Tag> tags) {
        Gson gson = new Gson();
        return gson.toJson(tags);
    }

    @TypeConverter
    public List<Tag> stringToList(String tagStr )  {

        return new Gson().fromJson(tagStr, new TypeToken<List<Tag>>(){}.getType());

    }

}
