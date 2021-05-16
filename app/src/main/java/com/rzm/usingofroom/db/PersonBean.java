package com.rzm.usingofroom.db;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class PersonBean {

    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "version")
    private String version;
    @ColumnInfo(name = "name")
    private String name;
    @ColumnInfo(name = "myadress")
    private String address;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "MyRoomTable{" +
                "id=" + id +
                ", version='" + version + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
