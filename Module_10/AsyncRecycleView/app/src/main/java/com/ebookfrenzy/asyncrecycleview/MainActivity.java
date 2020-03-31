package com.ebookfrenzy.asyncrecycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    public static final String TAG ="MainActivity";

    String name;

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.i(TAG, "inside  onCreate()");

        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new RecyclerAdapter();
        recyclerView.setAdapter(adapter);

    } // onCreate()

    public void addName(View view){

        Log.i(TAG, "inside MainAct. addName()");

        EditText n;

        n = findViewById(R.id.nameEditText);
        name = n.getText().toString();

        AsyncTask task = new MyTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, name);
    }

    public void clearNames(View view){
        Log.i(TAG, "inside MainAct. clearName()");

        Data.nameList.clear();
        Data.timeList.clear();

        adapter.notifyDataSetChanged();
    }

    class MyTask extends  AsyncTask<String, String, String> {

        @Override
        protected void onPreExecute() {

            // a good place to update the user interface
        }

        @Override
        protected String doInBackground(String... names) {

            Random rand = new Random();
            int pause = rand.nextInt(10);

            try {
                Thread.sleep(pause*1000);
            }
            catch (Exception e) {
                return(e.getLocalizedMessage());
            }
            Data.addName(name);
            Data.addTime(pause);

            // Sending names to onProgressUpdate()
            publishProgress(names);

        return "On post execute was now called";
        }

        @Override
        protected void onProgressUpdate(String... values) {

        }

        @Override
        protected void onPostExecute(String result) {

            adapter.notifyDataSetChanged();
        }

    } // class MyTask extends AsyncTask

} // class MainActivity
