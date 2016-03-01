package com.zw.coolweather.util;

/**
 * 包名：com.zw.coolweather.util
 * 描述：网络请求回调类
 * User 张伟
 * QQ:326093926
 * Date 2016/3/1
 * Time 12:18
 * 修改日期：
 * 修改内容：
 */
public interface HttpCallbackListener {
    void onFinish(String response);
    void onError(Exception e);
}
