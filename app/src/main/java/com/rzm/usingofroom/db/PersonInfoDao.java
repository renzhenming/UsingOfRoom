package com.rzm.usingofroom.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface PersonInfoDao {

    @Insert
    void insert(PersonBean personBean);

    @Delete
    void delete(PersonBean personBean);

    @Update
    void update(PersonBean personBean);

    @Query(value = "select * from PersonBean where name like :name")
    PersonBean findByName(String name);

    @Query(value = "select * from PersonBean")
    List<PersonBean> findAll();
}
