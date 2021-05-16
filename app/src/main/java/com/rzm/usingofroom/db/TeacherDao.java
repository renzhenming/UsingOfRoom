package com.rzm.usingofroom.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface TeacherDao {

    @Insert
    void insert(Teacher teacher);

    @Delete
    void delete(Teacher teacher);

    @Update
    void update(Teacher teacher);

    @Query(value = "select * from Teacher where teacher_name like :name")
    Teacher findByName(String name);

    @Query(value = "select * from Teacher")
    List<Teacher> findAll();
}
