package xyz.kkt.ted.data.vos;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lenovo on 1/26/2018.
 */

@Entity(tableName = "talk_tag", foreignKeys =
@ForeignKey(entity = TalksVO.class,
        parentColumns = "id",
        childColumns = "talk_in_dummy"))
@ForeignKey(entity = TagVO.class,
        parentColumns = "id",
        childColumns = "tag_in_dummy")
public class TalkTagVO {

    @PrimaryKey(autoGenerate = true)
    private long id;

    @ColumnInfo(name = "talk_in_dummy")
    private long talk_in_dummy;

    @ColumnInfo(name = "tag_in_dummy")
    private long tag_in_dummy;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getTalk_in_dummy() {
        return talk_in_dummy;
    }

    public void setTalk_in_dummy(long talk_in_dummy) {
        this.talk_in_dummy = talk_in_dummy;
    }

    public long getTag_in_dummy() {
        return tag_in_dummy;
    }

    public void setTag_in_dummy(long tag_in_dummy) {
        this.tag_in_dummy = tag_in_dummy;
    }

    public static List<TalkTagVO> toInsertTalkTag(List<TalksVO> talkList) {

        List<TalkTagVO> talkTagList = new ArrayList<>();
        for (TalksVO talk : talkList) {
            for (TagVO tag : talk.getTags()) {
                TalkTagVO talkTag = new TalkTagVO();
                talkTag.setTalk_in_dummy(talk.getId());
                talkTag.setTag_in_dummy(tag.getTagId());
                talkTagList.add(talkTag);
            }
        }
        return talkTagList;
    }

}
