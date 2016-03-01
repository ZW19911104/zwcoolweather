package com.zw.coolweather.sys;

import android.app.AlarmManager;
import android.app.Application;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.SystemClock;
import com.zw.coolweather.receiver.AutoUpdateReceiver;

/**
 * 包名：com.zw.coolweather.sys
 * 描述：
 * User 张伟
 * QQ:326093926
 * Date 2016/3/1
 * Time 16:31
 * 修改日期：
 * 修改内容：
 */
public class WeatherApplication extends Application {
    private static WeatherApplication application;
    private AlarmManager manager;

    public static WeatherApplication getInstance(){
        return application;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
    }

    /**
     * 启动定时器 8小时启动一次
     */
    public void startWeather(){
        manager = (AlarmManager) getSystemService(ALARM_SERVICE);
        //8小时
        int anHour = 8*60*60*1000;
        long triggerAtTime = SystemClock.elapsedRealtime();
        Intent intent = new Intent(this,AutoUpdateReceiver.class);
        PendingIntent pi = PendingIntent.getBroadcast(this,0,intent,0);
        manager.setRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP,triggerAtTime,anHour,pi);

    }

    /**
     * 停止定时器
     */
    public void stopWeather(){
        Intent intent = new Intent(this,AutoUpdateReceiver.class);
        PendingIntent pi = PendingIntent.getBroadcast(this,0,intent,0);
        manager.cancel(pi);
    }




}
