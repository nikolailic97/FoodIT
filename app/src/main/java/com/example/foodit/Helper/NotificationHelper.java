package com.example.foodit.Helper;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.ContextWrapper;
import android.net.Uri;
import android.os.Build;

import com.example.foodit.R;


public class NotificationHelper extends ContextWrapper {
    private static final String FOOD_CHANEL_ID = "com.example.foodit.FOODIT";
    private static final String FOOD_CHANEL_NAME = "Food It";

    private NotificationManager manager;

    public NotificationHelper(Context base) {
        super(base);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O); // only working if API is 26 or higher
            createChannel();
    }

    @TargetApi(Build.VERSION_CODES.O)
    private void createChannel() {
        NotificationChannel foodChannel = new NotificationChannel(FOOD_CHANEL_ID,
                FOOD_CHANEL_NAME,
                NotificationManager.IMPORTANCE_DEFAULT);
        foodChannel.enableLights(false);
        foodChannel.enableVibration(true);
        foodChannel.setLockscreenVisibility(Notification.VISIBILITY_PRIVATE);
        
        getManager().createNotificationChannel(foodChannel);
    }

    public NotificationManager getManager() {
        if(manager == null)
            manager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        return manager;
    }

    @TargetApi(Build.VERSION_CODES.O)
    public Notification.Builder getFoodItChannelNotification(String title, String body,
                                                             PendingIntent contentIntent, Uri soundUri) {


        return new Notification.Builder(getApplicationContext(), FOOD_CHANEL_ID)
                .setContentIntent(contentIntent)
                .setContentTitle(title)
                .setContentText(body)
                .setSmallIcon(R.mipmap.ic_launcher_round)
                .setSound(soundUri)
                .setAutoCancel(false);
    }
}
