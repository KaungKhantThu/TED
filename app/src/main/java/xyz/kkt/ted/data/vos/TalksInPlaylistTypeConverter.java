package xyz.kkt.ted.data.vos;

import android.arch.persistence.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

/**
 * Created by user on 1/26/18.
 */

public class TalksInPlaylistTypeConverter {

    @TypeConverter
    public String listToString(List<TalksInPlaylistVO> talksInPlaylistVOS) {
        Gson gson = new Gson();
        return gson.toJson(talksInPlaylistVOS);
    }

    @TypeConverter
    public List<TalksInPlaylistVO> stringToList(String tagStr )  {

        return new Gson().fromJson(tagStr, new TypeToken<List<TalksInPlaylistVO>>(){}.getType());

    }
}
