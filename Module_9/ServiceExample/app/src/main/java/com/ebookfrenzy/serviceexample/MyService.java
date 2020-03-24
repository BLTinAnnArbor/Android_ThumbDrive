package com.ebookfrenzy.serviceexample;

import android.app.Service;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {

    private static final String TAG = "ServiceExample";

    public MyService() {
    }

    @Override
    public void onCreate(){
        Log.i(TAG, "Service onCreate()");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId){

       // delay loop code was initially here

        AsyncTask task = new SrvTask().executeOnExecutor(
                AsyncTask.THREAD_POOL_EXECUTOR, startId);

        return Service.START_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.i(TAG, "Service onBind()");
        return null;
    }

    private class SrvTask extends AsyncTask<Integer, Integer, String>{

        @Override
        protected String doInBackground(Integer... params){

            int startId = params[0];
            int i=0;
            while (i <= 3){

                publishProgress(params[0]);
                try{
                    Thread.sleep(10000);
                    i++;
                } catch(Exception e){
                }
                Log.i(TAG, "Service running i = "+ i);
            }
            return ("Service complete "+ startId);

        } // doInBackground()

        @Override
        protected void onPostExecute(String result){
            Log.i(TAG, result);
        }

        @Override
        protected void onPreExecute(){
        }

        @Override
        protected  void onProgressUpdate(Integer... values){
            Log.i(TAG, "Service Running "+ values[0]);
        }

    } // class SrvTask extends AsyncTask

} // class MyService
