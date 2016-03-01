package com.zw.coolweather.model;

/**
 * 包名：com.zw.coolweather.model
 * 描述：省 实体类
 * User 张伟
 * QQ:326093926
 * Date 2016/3/1
 * Time 11:13
 * 修改日期：
 * 修改内容：
 */
public class Province {
    private int id;
    private String provinceName;
    private String provinceCode;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }
}
