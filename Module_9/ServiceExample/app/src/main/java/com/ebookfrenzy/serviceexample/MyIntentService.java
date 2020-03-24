package com.ebookfrenzy.serviceexample;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

public class MyIntentService extends IntentService {

    private static final String TAG = "ServiceExample";

    public MyIntentService(){
        super("MyIntentService");
    }

    @Override
    protected void onHandleIntent(Intent arg0){
        Log.i(TAG, "Intent Service started");
    }
}
