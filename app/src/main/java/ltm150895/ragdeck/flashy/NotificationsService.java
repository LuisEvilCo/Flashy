package ltm150895.ragdeck.flashy;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;
import android.util.Log;
import android.support.v4.content.LocalBroadcastManager;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;

public class NotificationsService extends NotificationListenerService {

    private Context context;

    @Override public void onCreate()
    {
        super.onCreate();
        context = getApplicationContext();
    }
    int j=0;
    @Override public void onNotificationPosted(StatusBarNotification sbn) {
        j+=1;
       // Toast.makeText(getBaseContext(), "onNotificationPosted " + String.valueOf(j), Toast.LENGTH_LONG).show();
        String LogTag = "onNotificationPosted";

        Log.d(LogTag, "notificacion recibida " + String.valueOf(j));
        Intent msgrcv = new Intent("Msg");

        msgrcv.putExtra("package", "pack");
        msgrcv.putExtra("ticker", "ticker");
        msgrcv.putExtra("title", "title");
        msgrcv.putExtra("text", "text");

        LocalBroadcastManager.getInstance(context).sendBroadcast(msgrcv);
    }

    @Override public void onNotificationRemoved(StatusBarNotification sbn) {
        Log.i("Msg","Notification Removed");
    }
}