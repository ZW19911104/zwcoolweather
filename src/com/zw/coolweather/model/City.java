package com.zw.coolweather.model;

/**
 * 包名：com.zw.coolweather.model
 * 描述：市 实体类
 * User 张伟
 * QQ:326093926
 * Date 2016/3/1
 * Time 11:14
 * 修改日期：
 * 修改内容：
 */
public class City {
    private int id;
    private String cityName;
    private String cityCode;
    private int provinceId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public int getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(int provinceId) {
        this.provinceId = provinceId;
    }
}
