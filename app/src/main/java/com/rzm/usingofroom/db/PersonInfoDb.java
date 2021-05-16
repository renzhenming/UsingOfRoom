package com.rzm.usingofroom.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {PersonBean.class, Teacher.class, Father.class}, version = 1, exportSchema = false)
public abstract class PersonInfoDb extends RoomDatabase {
    public abstract PersonInfoDao getPersonDao();

    public abstract TeacherDao getTeacherDao();

    public abstract FatherDao getFatherDao();
}
