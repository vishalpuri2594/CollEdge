package com.mycollege.mait;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.view.View;
import android.widget.Button;

/**
 * Created by Akshay on 1/8/2015.
 */
public class NotificationBar extends Activity implements View.OnClickListener {
    Button stat, down;
    NotificationManager nm;
    final static int uniqueID1 = 100, uniqueID2 = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notification_extra);
        stat = (Button) findViewById(R.id.bStatusBar);
        down = (Button) findViewById(R.id.bDownBar);
        down.setOnClickListener(this);
        stat.setOnClickListener(this);
        nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        nm.cancel(uniqueID1);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bStatusBar:

                Intent act = new Intent(this, NotificationBar.class);
                String body = "New Notification Recieved";
                String title = "MAIT";


                TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
                stackBuilder.addParentStack(NotificationBar.class);
                stackBuilder.addNextIntent(act);

                PendingIntent pi = stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);


                final NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this)
                        .setSmallIcon(R.drawable.ic_action_icon).setContentText(body)
                        .setContentTitle(title).setContentIntent(pi);
                NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();
                String[] events = {"College closed on 20th", "Review Forms submission", "Fest Details"};
                // Sets a title for the Inbox in expanded layout
                inboxStyle.setBigContentTitle("Newsfeed");

                // Moves events into the expanded layout
                for (int i = 0; i < events.length; i++) {

                    inboxStyle.addLine(events[i]);
                }
                // Moves the expanded layout object into the notification object.
                mBuilder.setStyle(inboxStyle);

                nm.notify(uniqueID1, mBuilder.build());

                break;

            case R.id.bDownBar:

                final NotificationCompat.Builder dBuilder = new NotificationCompat.Builder(this);
                dBuilder.setContentText("Please wait").setContentTitle("Downloading")
                        .setSmallIcon(R.drawable.ic_action_icon);

                new Thread(
                        new Runnable() {
                            @Override
                            public void run() {

                                int incr;
                                for(incr = 0;incr<101;incr+=1){
                                    dBuilder.setProgress(100,incr,false);
                                    dBuilder.setContentText(incr + " % Downloaded");
                                    nm.notify(uniqueID2,dBuilder.build());
                                    try{
                                        Thread.sleep(100);
                                    }catch(Exception e){
                                        e.printStackTrace();
                                    }
                                }
                                dBuilder.setContentTitle("Download Completed");
                                dBuilder.setContentText("Finished");
                                nm.notify(uniqueID2,dBuilder.build());
                            }
                        }
                ).start();
                break;
        }
    }
}
