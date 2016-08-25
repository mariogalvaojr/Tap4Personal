package com.example.mriogalvojnior.tap4personal;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.mriogalvojnior.tap4personal.gen.dao.DaoMaster;
import com.example.mriogalvojnior.tap4personal.gen.dao.DaoSession;

/**
 * Created by Mário Galvão Júnior on 17/06/2016.
 */
public class Tap4PersonalApplication extends Application {

    private DaoMaster.DevOpenHelper devOpenHelper;

    @Override
    public void onCreate() {
        super.onCreate();
        devOpenHelper = new DaoMaster.DevOpenHelper(this, "smart_academy", null);
    }

    private SQLiteDatabase getDB() {
        if (devOpenHelper != null) {
            return devOpenHelper.getWritableDatabase();
        }
        Log.e("smart","DevOpenHelper == null");
        return null;
    }

    public DaoSession getNewDBSession() {
        DaoMaster daoMaster = new DaoMaster(getDB());
        return daoMaster.newSession();
    }
}
