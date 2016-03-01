package com.zw.coolweather.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.zw.coolweather.service.AutoUpdateService;

/**
 * 包名：com.zw.coolweather.receiver
 * 描述：自动更新天气的广播接收类
 * User 张伟
 * QQ:326093926
 * Date 2016/3/1
 * Time 16:35
 * 修改日期：
 * 修改内容：
 */
public class AutoUpdateReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Intent weatherIntent = new Intent(context, AutoUpdateService.class);
        context.startService(weatherIntent);
    }
}
