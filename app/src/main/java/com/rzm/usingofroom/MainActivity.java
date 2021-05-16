package com.rzm.usingofroom;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;

import com.rzm.usingofroom.db.Father;
import com.rzm.usingofroom.db.PersonBean;
import com.rzm.usingofroom.db.PersonInfoDao;
import com.rzm.usingofroom.db.PersonInfoDb;
import com.rzm.usingofroom.db.Teacher;
import com.rzm.usingofroom.db.TeacherDao;

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
                p.setName("张三" + i);
                p.setVersion("" + i);

                personDao.insert(p);
            }

            TeacherDao teacherDao = personInfoDb.getTeacherDao();
            for (int i = 0; i < 100; i++) {
                Teacher p = new Teacher();
                p.setAge(i);
                p.setName("老师" + i);
                p.setFather(new Father("老师" + i + "的父亲", 20 + i));
                teacherDao.insert(p);
            }

            System.out.println("删除张三2前---------------");
            print(personDao, teacherDao);


            PersonBean p2 = personDao.findByName("张三2");
            System.out.println("找到p2 = ---------------" + p2.getName());
            personDao.delete(p2);
            System.out.println("删除p2 = ---------------" + p2.getName());

            System.out.println("删除张三2后----------------");
            print(personDao, teacherDao);
        }
    }

    /**
     * 2021-05-16 10:53:35.397 31997-31997/com.rzm.usingofroom W/InputMethodManager: startInputReason = 1
     * 2021-05-16 10:53:35.432 31997-32160/com.rzm.usingofroom I/System.out: 删除张三2前---------------
     * 2021-05-16 10:53:35.441 31997-32160/com.rzm.usingofroom I/System.out: renzhenming: [MyRoomTable{id=1, version='0', name='张三0', address='上海陆家嘴0号'}, MyRoomTable{id=2, version='1', name='张三1', address='上海陆家嘴1号'}, MyRoomTable{id=3, version='2', name='张三2', address='上海陆家嘴2号'}, MyRoomTable{id=4, version='3', name='张三3', address='上海陆家嘴3号'}, MyRoomTable{id=5, version='4', name='张三4', address='上海陆家嘴4号'}, MyRoomTable{id=6, version='5', name='张三5', address='上海陆家嘴5号'}, MyRoomTable{id=7, version='6', name='张三6', address='上海陆家嘴6号'}, MyRoomTable{id=8, version='7', name='张三7', address='上海陆家嘴7号'}, MyRoomTable{id=9, version='8', name='张三8', address='上海陆家嘴8号'}, MyRoomTable{id=10, version='9', name='张三9', address='上海陆家嘴9号'}, MyRoomTable{id=11, version='10', name='张三10', address='上海陆家嘴10号'}, MyRoomTable{id=12, version='11', name='张三11', address='上海陆家嘴11号'}, MyRoomTable{id=13, version='12', name='张三12', address='上海陆家嘴12号'}, MyRoomTable{id=14, version='13', name='张三13', address='上海陆家嘴13号'}, MyRoomTable{id=15, version='14', name='张三14', address='上海陆家嘴14号'}, MyRoomTable{id=16, version='15', name='张三15', address='上海陆家嘴15号'}, MyRoomTable{id=17, version='16', name='张三16', address='上海陆家嘴16号'}, MyRoomTable{id=18, version='17', name='张三17', address='上海陆家嘴17号'}, MyRoomTable{id=19, version='18', name='张三18', address='上海陆家嘴18号'}, MyRoomTable{id=20, version='19', name='张三19', address='上海陆家嘴19号'}, MyRoomTable{id=21, version='20', name='张三20', address='上海陆家嘴20号'}, MyRoomTable{id=22, version='21', name='张三21', address='上海陆家嘴21号'}, MyRoomTable{id=23, version='22', name='张三22', address='上海陆家嘴22号'}, MyRoomTable{id=24, version='23', name='张三23', address='上海陆家嘴23号'}, MyRoomTable{id=25, version='24', name='张三24', address='上海陆家嘴24号'}, MyRoomTable{id=26, version='25', name='张三25', address='上海陆家嘴25号'}, MyRoomTable{id=27, version='26', name='张三26', address='上海陆家嘴26号'}, MyRoomTable{id=28, version='27', name='张三27', address='上海陆家嘴27号'}, MyRoomTable{id=29, version='28', name='张三28', address='上海陆家嘴28号'}, MyRoomTable{id=30, version='29', name='张三29', address='上海陆家嘴29号'}, MyRoomTable{id=31, version='30', name='张三30', address='上海陆家嘴30号'}, MyRoomTable{id=32, version='31', name='张三31', address='上海陆家嘴31号'}, MyRoomTable{id=33, version='32', name='张三32', address='上海陆家嘴32号'}, MyRoomTable{id=34, version='33', name='张三33', address='上海陆家嘴33号'}, MyRoomTable{id=35, version='34', name='张三34', address='上海陆家嘴34号'}, MyRoomTable{id=36, version='35', name='张三35', address='上海陆家嘴35号'}, MyRoomTable{id=37, version='36', name='张三36', address='上海陆家嘴36号'}, MyRoomTable{id=38, version='37', name='张三37', address='上海陆家嘴37号'}, MyRoomTable{id=39, version='38', name='张三38', address='上海陆家嘴38号'}, MyRoomTable{id=40, version='39', name='张三39', address='上海陆家嘴39号'}, MyRoomTable{id=41, version='40', name='张三40', address='上海陆家嘴40号'}, MyRoomTable{id=42, version='41', name='张三41', address='上海陆家嘴41号'}, MyRoomTable{id=43, version='42', name='张三42', address='上海陆家嘴42号'}, MyRoomTable{id=44, version='43', name='张三43', address='上海陆家嘴43号'}, MyRoomTable{id=45, version='44', name='张三44', address='上海陆家嘴44号'}, MyRoomTable{id=46, version='45', name='张三45', address='上海陆家嘴45号'}, MyRoomTable{id=47, version='46', name='张三46', address='上海陆家嘴46号'}, MyRoomTable{id=48, version='47', name='张三47', address='上海陆家嘴47号'}, MyRoomTable{id=49, version='48', name='张三48', address='上海陆家嘴48号'}, MyRoomTable{i
     * 2021-05-16 10:53:35.447 31997-32160/com.rzm.usingofroom I/System.out: renzhenming: [Teacher{name='老师0', age=0}, Teacher{name='老师1', age=1}, Teacher{name='老师2', age=2}, Teacher{name='老师3', age=3}, Teacher{name='老师4', age=4}, Teacher{name='老师5', age=5}, Teacher{name='老师6', age=6}, Teacher{name='老师7', age=7}, Teacher{name='老师8', age=8}, Teacher{name='老师9', age=9}, Teacher{name='老师10', age=10}, Teacher{name='老师11', age=11}, Teacher{name='老师12', age=12}, Teacher{name='老师13', age=13}, Teacher{name='老师14', age=14}, Teacher{name='老师15', age=15}, Teacher{name='老师16', age=16}, Teacher{name='老师17', age=17}, Teacher{name='老师18', age=18}, Teacher{name='老师19', age=19}, Teacher{name='老师20', age=20}, Teacher{name='老师21', age=21}, Teacher{name='老师22', age=22}, Teacher{name='老师23', age=23}, Teacher{name='老师24', age=24}, Teacher{name='老师25', age=25}, Teacher{name='老师26', age=26}, Teacher{name='老师27', age=27}, Teacher{name='老师28', age=28}, Teacher{name='老师29', age=29}, Teacher{name='老师30', age=30}, Teacher{name='老师31', age=31}, Teacher{name='老师32', age=32}, Teacher{name='老师33', age=33}, Teacher{name='老师34', age=34}, Teacher{name='老师35', age=35}, Teacher{name='老师36', age=36}, Teacher{name='老师37', age=37}, Teacher{name='老师38', age=38}, Teacher{name='老师39', age=39}, Teacher{name='老师40', age=40}, Teacher{name='老师41', age=41}, Teacher{name='老师42', age=42}, Teacher{name='老师43', age=43}, Teacher{name='老师44', age=44}, Teacher{name='老师45', age=45}, Teacher{name='老师46', age=46}, Teacher{name='老师47', age=47}, Teacher{name='老师48', age=48}, Teacher{name='老师49', age=49}, Teacher{name='老师50', age=50}, Teacher{name='老师51', age=51}, Teacher{name='老师52', age=52}, Teacher{name='老师53', age=53}, Teacher{name='老师54', age=54}, Teacher{name='老师55', age=55}, Teacher{name='老师56', age=56}, Teacher{name='老师57', age=57}, Teacher{name='老师58', age=58}, Teacher{name='老师59', age=59}, Teacher{name='老师60', age=60}, Teacher{name='老师61', age=61}, Teacher{name='老师62', age=62}, Teacher{name='老师63', age=63}, Teacher{name='老师64', age=64}, Teacher{name='老师65', age=65}, Teacher{name='老师66', age=66}, Teacher{name='老师67', age=67}, Teacher{name='老师68', age=68}, Teacher{name='老师69', age=69}, Teacher{name='老师70', age=70}, Teacher{name='老师71', age=71}, Teacher{name='老师72', age=72}, Teacher{name='老师73', age=73}, Teacher{name='老师74', age=74}, Teacher{name='老师75', age=75}, Teacher{name='老师76', age=76}, Teacher{name='老师77', age=77}, Teacher{name='老师78', age=78}, Teacher{name='老师79', age=79}, Teacher{name='老师80', age=80}, Teacher{name='老师81', age=81}, Teacher{name='老师82', age=82}, Teacher{name='老师83', age=83}, Teacher{name='老师84', age=84}, Teacher{name='老师85', age=85}, Teacher{name='老师86', age=86}, Teacher{name='老师87', age=87}, Teacher{name='老师88', age=88}, Teacher{name='老师89', age=89}, Teacher{name='老师90', age=90}, Teacher{name='老师91', age=91}, Teacher{name='老师92', age=92}, Teacher{name='老师93', age=93}, Teacher{name='老师94', age=94}, Teacher{name='老师95', age=95}, Teacher{name='老师96', age=96}, Teacher{name='老师97', age=97}, Teacher{name='老师98', age=98}, Teacher{name='老师99', age=99}]
     * 2021-05-16 10:53:35.448 31997-32160/com.rzm.usingofroom I/System.out: 找到p2 = ---------------张三2
     * 2021-05-16 10:53:35.450 31997-32160/com.rzm.usingofroom I/System.out: 删除p2 = ---------------张三2
     * 2021-05-16 10:53:35.450 31997-32160/com.rzm.usingofroom I/System.out: 删除张三2后----------------
     * 2021-05-16 10:53:35.455 31997-32160/com.rzm.usingofroom I/System.out: renzhenming: [MyRoomTable{id=1, version='0', name='张三0', address='上海陆家嘴0号'}, MyRoomTable{id=2, version='1', name='张三1', address='上海陆家嘴1号'}, MyRoomTable{id=4, version='3', name='张三3', address='上海陆家嘴3号'}, MyRoomTable{id=5, version='4', name='张三4', address='上海陆家嘴4号'}, MyRoomTable{id=6, version='5', name='张三5', address='上海陆家嘴5号'}, MyRoomTable{id=7, version='6', name='张三6', address='上海陆家嘴6号'}, MyRoomTable{id=8, version='7', name='张三7', address='上海陆家嘴7号'}, MyRoomTable{id=9, version='8', name='张三8', address='上海陆家嘴8号'}, MyRoomTable{id=10, version='9', name='张三9', address='上海陆家嘴9号'}, MyRoomTable{id=11, version='10', name='张三10', address='上海陆家嘴10号'}, MyRoomTable{id=12, version='11', name='张三11', address='上海陆家嘴11号'}, MyRoomTable{id=13, version='12', name='张三12', address='上海陆家嘴12号'}, MyRoomTable{id=14, version='13', name='张三13', address='上海陆家嘴13号'}, MyRoomTable{id=15, version='14', name='张三14', address='上海陆家嘴14号'}, MyRoomTable{id=16, version='15', name='张三15', address='上海陆家嘴15号'}, MyRoomTable{id=17, version='16', name='张三16', address='上海陆家嘴16号'}, MyRoomTable{id=18, version='17', name='张三17', address='上海陆家嘴17号'}, MyRoomTable{id=19, version='18', name='张三18', address='上海陆家嘴18号'}, MyRoomTable{id=20, version='19', name='张三19', address='上海陆家嘴19号'}, MyRoomTable{id=21, version='20', name='张三20', address='上海陆家嘴20号'}, MyRoomTable{id=22, version='21', name='张三21', address='上海陆家嘴21号'}, MyRoomTable{id=23, version='22', name='张三22', address='上海陆家嘴22号'}, MyRoomTable{id=24, version='23', name='张三23', address='上海陆家嘴23号'}, MyRoomTable{id=25, version='24', name='张三24', address='上海陆家嘴24号'}, MyRoomTable{id=26, version='25', name='张三25', address='上海陆家嘴25号'}, MyRoomTable{id=27, version='26', name='张三26', address='上海陆家嘴26号'}, MyRoomTable{id=28, version='27', name='张三27', address='上海陆家嘴27号'}, MyRoomTable{id=29, version='28', name='张三28', address='上海陆家嘴28号'}, MyRoomTable{id=30, version='29', name='张三29', address='上海陆家嘴29号'}, MyRoomTable{id=31, version='30', name='张三30', address='上海陆家嘴30号'}, MyRoomTable{id=32, version='31', name='张三31', address='上海陆家嘴31号'}, MyRoomTable{id=33, version='32', name='张三32', address='上海陆家嘴32号'}, MyRoomTable{id=34, version='33', name='张三33', address='上海陆家嘴33号'}, MyRoomTable{id=35, version='34', name='张三34', address='上海陆家嘴34号'}, MyRoomTable{id=36, version='35', name='张三35', address='上海陆家嘴35号'}, MyRoomTable{id=37, version='36', name='张三36', address='上海陆家嘴36号'}, MyRoomTable{id=38, version='37', name='张三37', address='上海陆家嘴37号'}, MyRoomTable{id=39, version='38', name='张三38', address='上海陆家嘴38号'}, MyRoomTable{id=40, version='39', name='张三39', address='上海陆家嘴39号'}, MyRoomTable{id=41, version='40', name='张三40', address='上海陆家嘴40号'}, MyRoomTable{id=42, version='41', name='张三41', address='上海陆家嘴41号'}, MyRoomTable{id=43, version='42', name='张三42', address='上海陆家嘴42号'}, MyRoomTable{id=44, version='43', name='张三43', address='上海陆家嘴43号'}, MyRoomTable{id=45, version='44', name='张三44', address='上海陆家嘴44号'}, MyRoomTable{id=46, version='45', name='张三45', address='上海陆家嘴45号'}, MyRoomTable{id=47, version='46', name='张三46', address='上海陆家嘴46号'}, MyRoomTable{id=48, version='47', name='张三47', address='上海陆家嘴47号'}, MyRoomTable{id=49, version='48', name='张三48', address='上海陆家嘴48号'}, MyRoomTable{id=50, version='49', name='张三49', address='上海陆家嘴49号'}, MyRoomTab
     * 2021-05-16 10:53:35.460 31997-32160/com.rzm.usingofroom I/System.out: renzhenming: [Teacher{name='老师0', age=0}, Teacher{name='老师1', age=1}, Teacher{name='老师3', age=3}, Teacher{name='老师4', age=4}, Teacher{name='老师5', age=5}, Teacher{name='老师6', age=6}, Teacher{name='老师7', age=7}, Teacher{name='老师8', age=8}, Teacher{name='老师9', age=9}, Teacher{name='老师10', age=10}, Teacher{name='老师11', age=11}, Teacher{name='老师12', age=12}, Teacher{name='老师13', age=13}, Teacher{name='老师14', age=14}, Teacher{name='老师15', age=15}, Teacher{name='老师16', age=16}, Teacher{name='老师17', age=17}, Teacher{name='老师18', age=18}, Teacher{name='老师19', age=19}, Teacher{name='老师20', age=20}, Teacher{name='老师21', age=21}, Teacher{name='老师22', age=22}, Teacher{name='老师23', age=23}, Teacher{name='老师24', age=24}, Teacher{name='老师25', age=25}, Teacher{name='老师26', age=26}, Teacher{name='老师27', age=27}, Teacher{name='老师28', age=28}, Teacher{name='老师29', age=29}, Teacher{name='老师30', age=30}, Teacher{name='老师31', age=31}, Teacher{name='老师32', age=32}, Teacher{name='老师33', age=33}, Teacher{name='老师34', age=34}, Teacher{name='老师35', age=35}, Teacher{name='老师36', age=36}, Teacher{name='老师37', age=37}, Teacher{name='老师38', age=38}, Teacher{name='老师39', age=39}, Teacher{name='老师40', age=40}, Teacher{name='老师41', age=41}, Teacher{name='老师42', age=42}, Teacher{name='老师43', age=43}, Teacher{name='老师44', age=44}, Teacher{name='老师45', age=45}, Teacher{name='老师46', age=46}, Teacher{name='老师47', age=47}, Teacher{name='老师48', age=48}, Teacher{name='老师49', age=49}, Teacher{name='老师50', age=50}, Teacher{name='老师51', age=51}, Teacher{name='老师52', age=52}, Teacher{name='老师53', age=53}, Teacher{name='老师54', age=54}, Teacher{name='老师55', age=55}, Teacher{name='老师56', age=56}, Teacher{name='老师57', age=57}, Teacher{name='老师58', age=58}, Teacher{name='老师59', age=59}, Teacher{name='老师60', age=60}, Teacher{name='老师61', age=61}, Teacher{name='老师62', age=62}, Teacher{name='老师63', age=63}, Teacher{name='老师64', age=64}, Teacher{name='老师65', age=65}, Teacher{name='老师66', age=66}, Teacher{name='老师67', age=67}, Teacher{name='老师68', age=68}, Teacher{name='老师69', age=69}, Teacher{name='老师70', age=70}, Teacher{name='老师71', age=71}, Teacher{name='老师72', age=72}, Teacher{name='老师73', age=73}, Teacher{name='老师74', age=74}, Teacher{name='老师75', age=75}, Teacher{name='老师76', age=76}, Teacher{name='老师77', age=77}, Teacher{name='老师78', age=78}, Teacher{name='老师79', age=79}, Teacher{name='老师80', age=80}, Teacher{name='老师81', age=81}, Teacher{name='老师82', age=82}, Teacher{name='老师83', age=83}, Teacher{name='老师84', age=84}, Teacher{name='老师85', age=85}, Teacher{name='老师86', age=86}, Teacher{name='老师87', age=87}, Teacher{name='老师88', age=88}, Teacher{name='老师89', age=89}, Teacher{name='老师90', age=90}, Teacher{name='老师91', age=91}, Teacher{name='老师92', age=92}, Teacher{name='老师93', age=93}, Teacher{name='老师94', age=94}, Teacher{name='老师95', age=95}, Teacher{name='老师96', age=96}, Teacher{name='老师97', age=97}, Teacher{name='老师98', age=98}, Teacher{name='老师99', age=99}]
     * 2021-05-16 10:53:35.819 31997-31997/com.rzm.usingofroom W/InputMethodManager: startInputReason = 5
     *
     * @param personDao
     * @param teacherDao
     */
    private void print(PersonInfoDao personDao, TeacherDao teacherDao) {
        List<PersonBean> p = personDao.findAll();
        System.out.println("renzhenming: " + p);

        List<Teacher> t = teacherDao.findAll();
        System.out.println("renzhenming: " + t);
    }
}