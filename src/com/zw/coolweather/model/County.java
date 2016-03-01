package com.zw.coolweather.model;

/**
 * 包名：com.zw.coolweather.model
 * 描述：县 实体类
 * User 张伟
 * QQ:326093926
 * Date 2016/3/1
 * Time 11:16
 * 修改日期：
 * 修改内容：
 */
public class County {
    private int id;
    private String countyName;
    private String countyCode;
    private int cityId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountyName() {
        return countyName;
    }

    public void setCountyName(String countyName) {
        this.countyName = countyName;
    }

    public String getCountyCode() {
        return countyCode;
    }

    public void setCountyCode(String countyCode) {
        this.countyCode = countyCode;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }
}
