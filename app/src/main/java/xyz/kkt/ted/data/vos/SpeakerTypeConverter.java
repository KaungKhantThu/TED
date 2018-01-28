package xyz.kkt.ted.data.vos;

import android.arch.persistence.room.TypeConverter;

import com.google.gson.Gson;


/**
 * Created by aung on 7/28/17.
 */

public class SpeakerTypeConverter {

    @TypeConverter
    public static String convertObjToString(SpeakerVO speaker) {
        String str = "";
        Gson gson = new Gson();
        String jsonString = gson.toJson(speaker);
        str = str + jsonString;
        return str;
    }

    @TypeConverter
    public static SpeakerVO convertStringToObj(String speakerString) {
        Gson gson = new Gson();
        return gson.fromJson(speakerString, SpeakerVO.class);
    }
}
