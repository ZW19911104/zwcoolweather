package com.zw.coolweather.service;

import android.app.Service;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.IBinder;
import android.preference.PreferenceManager;
import com.zw.coolweather.util.HttpCallbackListener;
import com.zw.coolweather.util.HttpUtil;
import com.zw.coolweather.util.Utility;

/**
 * 包名：com.zw.coolweather.service
 * 描述：自动更新天气服务
 * User 张伟
 * QQ:326093926
 * Date 2016/3/1
 * Time 16:28
 * 修改日期：
 * 修改内容：
 */
public class AutoUpdateService extends Service {

    @Override
    public void onCreate() {
        super.onCreate();

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                updateWeather();
            }
        }).start();

        return super.onStartCommand(intent, flags, startId);
    }

    /**
     * 更新天气信息
     */
    private void updateWeather() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String weatherCode = prefs.getString("weather_code","");
        String address = "http://www.weather.com.cn/data/cityinfo/"+weatherCode+".html";
        HttpUtil.sendHttpRequest(address, new HttpCallbackListener() {
            @Override
            public void onFinish(String response) {
                Utility.handleWeatherResponse(AutoUpdateService.this,response);
            }

            @Override
            public void onError(Exception e) {
                if(e!=null){
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

    }
}
