package com.zw.coolweather.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.zw.coolweather.model.City;
import com.zw.coolweather.model.County;
import com.zw.coolweather.model.Province;

import java.util.ArrayList;
import java.util.List;

/**
 * 包名：com.zw.coolweather.db
 * 描述：数据库操作封装类
 * User 张伟
 * QQ:326093926
 * Date 2016/3/1
 * Time 11:17
 * 修改日期：
 * 修改内容：
 */
public class CoolWeatherDB {
    /**
     * 数据库名称
     */
    public static final String DB_NAME = "cool_weather";

    /**
     * 数据库版本
     */
    public static final int VERSION = 1;

    private static CoolWeatherDB coolWeatherDB;

    private SQLiteDatabase db;

    /**
     * 将构造方法私有化
     */
    private CoolWeatherDB(Context context) {
        CoolWeatherOpenHelper dbHelper = new CoolWeatherOpenHelper(context, DB_NAME, null, VERSION);
        db = dbHelper.getWritableDatabase();
    }

    /**
     * 获取CoolWeatherDB的实例
     *
     * @param context
     * @return
     */
    public synchronized static CoolWeatherDB getInstance(Context context) {
        if (coolWeatherDB == null) {
            coolWeatherDB = new CoolWeatherDB(context);
        }
        return coolWeatherDB;
    }

    /**
     * 将Province实例存储到数据库
     *
     * @param province
     */
    public void saveProvince(Province province) {
        if (province != null) {
            ContentValues values = new ContentValues();
            values.put("province_name", province.getProvinceName());
            values.put("province_code", province.getProvinceCode());
            db.insert("Province", null, values);
        }
    }

    /**
     * 从数据库读取全国所有省份信息
     *
     * @return
     */
    public List<Province> loadProvinces() {
        List<Province> list = new ArrayList<Province>();
        Cursor cursor = db.query("Province", null, null, null, null, null, null);
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    Province province = new Province();
                    province.setId(cursor.getInt(cursor.getColumnIndex("id")));
                    province.setProvinceName(cursor.getString(cursor.getColumnIndex("province_name")));
                    province.setProvinceCode(cursor.getString(cursor.getColumnIndex("province_code")));
                    list.add(province);
                } while (cursor.moveToNext());
            }
            cursor.close();
        }
        return list;
    }

    /**
     * 将城市存储到数据库
     * @param city
     */
    public void saveCity(City city){
        if(city!=null){
            ContentValues values = new ContentValues();
            values.put("city_name",city.getCityName());
            values.put("city_code",city.getCityCode());
            values.put("province_id",city.getProvinceId());
            db.insert("City",null,values);
        }
    }

    /**
     * 从数据库读取全国所有城市信息
     *
     * @return
     */
    public List<City> loadCitys() {
        List<City> list = new ArrayList<City>();
        Cursor cursor = db.query("City", null, null, null, null, null, null);
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    City city = new City();
                    city.setId(cursor.getInt(cursor.getColumnIndex("id")));
                    city.setCityName(cursor.getString(cursor.getColumnIndex("city_name")));
                    city.setCityCode(cursor.getString(cursor.getColumnIndex("city_code")));
                    city.setProvinceId(cursor.getInt(cursor.getColumnIndex("province_id")));
                    list.add(city);
                } while (cursor.moveToNext());
            }
            cursor.close();
        }
        return list;
    }

    /**
     * 将County实例存储到数据库
     * @param county
     */
    public void saveCounty(County county){
        if(county!=null){
            ContentValues values = new ContentValues();
            values.put("county_name",county.getCountyName());
            values.put("county_code",county.getCountyCode());
            values.put("city_id",county.getCityId());
            db.insert("County",null,values);
        }
    }

    /**
     * 从数据库读取全国所有城市信息
     *
     * @return
     */
    public List<County> loadCountys() {
        List<County> list = new ArrayList<County>();
        Cursor cursor = db.query("County", null, null, null, null, null, null);
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    County county = new County();
                    county.setId(cursor.getInt(cursor.getColumnIndex("id")));
                    county.setCountyName(cursor.getString(cursor.getColumnIndex("county_name")));
                    county.setCountyCode(cursor.getString(cursor.getColumnIndex("county_code")));
                    county.setCityId(cursor.getInt(cursor.getColumnIndex("city_id")));
                    list.add(county);
                } while (cursor.moveToNext());
            }
            cursor.close();
        }
        return list;
    }

}
