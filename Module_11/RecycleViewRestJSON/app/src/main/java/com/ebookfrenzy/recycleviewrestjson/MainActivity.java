package com.ebookfrenzy.recycleviewrestjson;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        final Gson gson = new Gson();

        RequestQueue queue = Volley.newRequestQueue(this);

        String url = "http://198.199.80.235/cps276/cps276_examples/datasources/names_json_251v2.json";

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(

                Request.Method.GET,
                url,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.i(TAG, "  I'm right before gson.fromJson() call!");

                        Employees employees = gson.fromJson(response.toString(), Employees.class);

                        Log.i(TAG, " I'm right after gson.fromJson() call!");

                        ArrayList<Employees> empList = employees.getEmployees();

                        //RecyclerViewAdapter adapter = new RecyclerViewAdapter(empList);
                        adapter = new RecyclerViewAdapter(empList);

                        recyclerView.setAdapter(adapter);

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.i(TAG, " error in Response.Listener");
                    }
                }
        );

        Log.i(TAG, " I'm right before queue.add() call!");

        queue.add(jsonObjectRequest);

    } // onCreate()

} // class MainActivity
