package com.zw.coolweather.util;

import android.text.TextUtils;
import com.zw.coolweather.db.CoolWeatherDB;
import com.zw.coolweather.model.City;
import com.zw.coolweather.model.County;
import com.zw.coolweather.model.Province;

/**
 * 包名：com.zw.coolweather.util
 * 描述：为解析返回的省市县数据而封装的工具类
 * User 张伟
 * QQ:326093926
 * Date 2016/3/1
 * Time 12:29
 * 修改日期：
 * 修改内容：
 */
public class Utility {

    /**
     * 解析和处理服务器返回的省级数据
     * @param coolWeatherDB 数据库操作类
     * @param response      待处理数据
     * @return
     */
    public synchronized static boolean handleProvincesResponse(CoolWeatherDB coolWeatherDB,String response){
        if(!TextUtils.isEmpty(response)){
            String[] allProvinces = response.split(",");
            if(allProvinces!=null&&allProvinces.length>0){
                for(String p:allProvinces){
                    String[] array = p.split("\\|");
                    Province province = new Province();
                    province.setProvinceCode(array[0]);
                    province.setProvinceName(array[1]);
                    //将解析出来的数据存储到Province表
                    coolWeatherDB.saveProvince(province);
                }
                return true;
            }
        }
        return false;
    }

    /**
     * 解析和处理服务器返回的市级数据
     * @param coolWeatherDB
     * @param response
     * @param provinceId
     * @return
     */
    public synchronized static boolean handleCitiesResponse(CoolWeatherDB coolWeatherDB,String response,int provinceId){
        if(!TextUtils.isEmpty(response)){
            String[] allCities = response.split(",");
            if(allCities!=null&&allCities.length>0){
                for(String p:allCities){
                    String[] array = p.split("\\|");
                    City city = new City();
                    city.setCityCode(array[0]);
                    city.setCityName(array[1]);
                    city.setProvinceId(provinceId);
                    //将解析出来的数据存储到Province表
                    coolWeatherDB.saveCity(city);
                }
                return true;
            }
        }
        return false;
    }

    /**
     * 解析和处理服务器返回的县级数据
     * @param coolWeatherDB
     * @param response
     * @param cityId
     * @return
     */
    public synchronized static boolean handleCountiesResponse(CoolWeatherDB coolWeatherDB,String response,int cityId){
        if(!TextUtils.isEmpty(response)){
            String[] allCounties = response.split(",");
            if(allCounties!=null&&allCounties.length>0){
                for(String p:allCounties){
                    String[] array = p.split("\\|");
                    County county = new County();
                    county.setCountyCode(array[0]);
                    county.setCountyName(array[1]);
                    county.setCityId(cityId);
                    //将解析出来的数据存储到Province表
                    coolWeatherDB.saveCounty(county);
                }
                return true;
            }
        }
        return false;
    }
}
