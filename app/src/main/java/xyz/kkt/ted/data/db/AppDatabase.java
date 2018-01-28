/*
 * Copyright 2017, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package xyz.kkt.ted.data.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import xyz.kkt.ted.data.vos.SpeakerVO;
import xyz.kkt.ted.data.vos.TagVO;
import xyz.kkt.ted.data.vos.TalkTagVO;
import xyz.kkt.ted.data.vos.TalksVO;


@Database(entities = {TalksVO.class, SpeakerVO.class, TagVO.class, TalkTagVO.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    private static final String DB_NAME = "TED.DB";

    private static AppDatabase INSTANCE;

    public abstract TalksDao talksDao();//RestaurantDao restaurantDao; name must be same but start with small letter

    public abstract TagsDao tagsDao();//RestaurantDao restaurantDao; name must be same but start with small letter

    public abstract SpeakersDao speakersDao();//RestaurantDao restaurantDao; name must be same but start with small letter

    public abstract TalkTagDao talkTagDao();//RestaurantDao restaurantDao; name must be same but start with small letter

    public static AppDatabase getInDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE =
                    Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, DB_NAME)
                            .allowMainThreadQueries() //Remove this after testing. Access to DB should always be from background thread.
                            .build();
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }
}