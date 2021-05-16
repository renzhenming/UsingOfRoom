package com.rzm.usingofroom;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;

import com.rzm.usingofroom.db.PersonBean;
import com.rzm.usingofroom.db.PersonInfoDao;
import com.rzm.usingofroom.db.PersonInfoDb;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new DbThread().start();
    }

    public class DbThread extends Thread {
        @Override
        public void run() {
            PersonInfoDb personInfoDb = Room.databaseBuilder(getApplicationContext(), PersonInfoDb.class, "renzhenming").build();
            PersonInfoDao personDao = personInfoDb.getPersonDao();
            for (int i = 0; i < 100; i++) {
                PersonBean p = new PersonBean();
                p.setAddress("上海陆家嘴" + i + "号");
                p.setName("张三  " + i);
                p.setVersion("" + i);
                personDao.insert(p);
            }

            List<PersonBean> all = personDao.findAll();
            System.out.println("renzhenming: " + all);
        }
    }
}