package xyz.kkt.ted.data.vos;

import android.arch.persistence.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

/**
 * Created by user on 1/25/18.
 */

public class SegmentTypeConverter {

    @TypeConverter
    public String listToString(List<SegmentVO> segments) {
        Gson gson = new Gson();
        return gson.toJson(segments);
    }

    @TypeConverter
    public List<SegmentVO> stringToList(String tagStr) {

        return new Gson().fromJson(tagStr, new TypeToken<List<SegmentVO>>() {
        }.getType());

    }

}
