package com.ebookfrenzy.serviceexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Intent hoolyHoot = new Intent(this, MyIntentService.class);
        //startService(hoolyHoot);
    }

    public void buttonClick(View view){

        Intent hoolyHoot = new Intent(this, MyService.class);
        startService(hoolyHoot);
    }
}
