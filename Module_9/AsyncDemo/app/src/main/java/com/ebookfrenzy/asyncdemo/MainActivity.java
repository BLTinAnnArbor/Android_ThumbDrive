package com.ebookfrenzy.asyncdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{

    private TextView hoolyHoot;

    // Imbedded class
    private class MyTask extends AsyncTask<String, Integer, String>
    {
        @Override
        protected void onPreExecute(){  // runs on the main thread
        }

        @Override
        protected String doInBackground(String... params)
        {
            int i = 0;
            while(i <= 20){
                publishProgress(i);
                try{
                    Thread.sleep(1000);
                    i++;
                }catch(Exception e){
                    return(e.getLocalizedMessage());
                }
            }
            return "Button Pressed";
        }

        @Override
        protected void onProgressUpdate(Integer... values){
            hoolyHoot.setText("Counter = "+ values[0]);
        }

        @Override
        protected void onPostExecute(String result){
            hoolyHoot.setText("Button Pressed");
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hoolyHoot = findViewById(R.id.myTextView);
    }

    public void buttonClick(View view){
        AsyncTask task = new MyTask().execute();
    }

} // MainActivity
