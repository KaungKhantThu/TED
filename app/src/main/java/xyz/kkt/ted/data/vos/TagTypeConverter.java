package xyz.kkt.ted.data.vos;

import android.arch.persistence.room.TypeConverter;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aung on 7/28/17.
 */

public class TagTypeConverter {
    public static String strSeparator = "__,__";

    @TypeConverter
    public static String convertListToString(List<TagVO> tag) {
        TagVO[] videoArray = new TagVO[tag.size()];
        for (int i = 0; i <= tag.size() - 1; i++) {
            videoArray[i] = tag.get(i);
        }
        String str = "";
        Gson gson = new Gson();
        for (int i = 0; i < videoArray.length; i++) {
            String jsonString = gson.toJson(videoArray[i]);
            str = str + jsonString;
            if (i < videoArray.length - 1) {
                str = str + strSeparator;
            }
        }
        return str;
    }

    @TypeConverter
    public static List<TagVO> convertStringToList(String videoString) {
        String[] tagArray = videoString.split(strSeparator);
        List<TagVO> tags = new ArrayList<TagVO>();
        Gson gson = new Gson();
        for (int i = 0; i < tagArray.length - 1; i++) {
            tags.add(gson.fromJson(tagArray[i], TagVO.class));
        }
        return tags;
    }


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
