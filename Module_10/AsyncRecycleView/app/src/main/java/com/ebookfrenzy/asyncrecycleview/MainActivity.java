package com.ebookfrenzy.asyncrecycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String TAG ="MainActivity";

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.i(TAG, "inside  onCreate()");
        Data.nameList.clear();
        Log.i(TAG, "just did Data.nameList.clear() inside onCreate()");
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
        String name;

        n = view.findViewById(R.id.nameEditText);  // This blows things up
                                    // n is a null object reference?
        if(!n.getText().toString().equals("")) {
            name = n.getText().toString();
        }else{
            name = "Hi";
        }

        Data.addName(name);
    }

    public void clearNames(View view){
        Log.i(TAG, "inside MainAct. clearName()");
        Data.nameList.clear();
    }

} // class MainActivity
