package com.ebookfrenzy.localbound;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class BoundService extends Service {

    private final IBinder myBinder = new MyLocalBinder();

    public BoundService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return myBinder;
    }

    public class MyLocalBinder extends Binder {

        BoundService getService(){
            return BoundService.this;
        }
    }

    public String getCurrentTime(){
        SimpleDateFormat dateFormat =
                new SimpleDateFormat("HH:mm:SS MM/dd/yyyy", Locale.US);
        return  (dateFormat.format(new Date()));
    }

} // class BoundService
