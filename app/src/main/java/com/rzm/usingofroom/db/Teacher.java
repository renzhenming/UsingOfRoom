package com.rzm.usingofroom.db;

import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import static androidx.room.ForeignKey.CASCADE;

@Entity(foreignKeys = @ForeignKey(entity = PersonBean.class,parentColumns = "id",
        childColumns = "teacher_id",onDelete = CASCADE,onUpdate = CASCADE))
public class Teacher {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "teacher_id")
    private int id;
    @ColumnInfo(name = "teacher_name")
    private String name;
    @ColumnInfo(name = "teacher_age")
    private int age;

    @Embedded(prefix = "father")
    private Father father;

    public void setFather(Father father) {
        this.father = father;
    }

    public Father getFather() {
        return father;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", father=" + father +
                '}';
    }
}
