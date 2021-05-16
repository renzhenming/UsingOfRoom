package com.rzm.usingofroom.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface FatherDao {

    @Insert
    void insert(Father father);

    @Delete
    void delete(Father father);

    @Update
    void update(Father father);

    @Query(value = "select * from Father where name like :name")
    Father findByName(String name);

    @Query(value = "select * from Father")
    List<Father> findAll();
}
