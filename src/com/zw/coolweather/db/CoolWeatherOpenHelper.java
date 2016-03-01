package com.zw.coolweather.db;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * 包名：com.zw.coolweather.db
 * 描述：数据库帮助类
 * User 张伟
 * QQ:326093926
 * Date 2016/3/1
 * Time 10:53
 * 修改日期：
 * 修改内容：
 */
public class CoolWeatherOpenHelper extends SQLiteOpenHelper {

    /**
     * 创建省
     * id:自主增长id
     * province_name:省名
     * province_code:省级代号
     *
     */
    public static final String CREATE_PROVINCE = "create table Province(" +
                    "id integer primary key autoincrement, " +
                    "province_name text,province_code text)";

    /**
     * 创建城市
     * id:自主增长
     * city_name:城市名
     * city_code:城市级代号
     * province_id:是City表关联Province表的外键
     *
     */
    public static final String CREATE_CITY = "create table City(" +
                    "id integer primary key autoincrement," +
                    "city_name text," +
                    "city_code text," +
                    "province_id integer)";

    /**
     * 创建区县
     * id:自主增长
     * county_name:区县名
     * county_code:县级代号
     * city_id:是County表关联City表的外键
     */
    public static final String CREATE_COUNTY = "create table County(" +
            "id integer primary key autoincrement," +
            "county_name text," +
            "county_code text," +
            "city_id integer)";


    public CoolWeatherOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public CoolWeatherOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_PROVINCE);//创建省
        db.execSQL(CREATE_CITY);//创建市
        db.execSQL(CREATE_COUNTY);//创建县
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
