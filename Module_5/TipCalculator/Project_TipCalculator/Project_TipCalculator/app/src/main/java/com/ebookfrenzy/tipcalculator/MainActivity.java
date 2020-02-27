package com.ebookfrenzy.tipcalculator;
//THIS IS FOR STUDY PURPOSES ONLY AND NOT TO BE DISTRIBUTED. IF IT IS FOUND THAT THIS SCRIPT WAS
//USED PARTIALLY OR WHOLLY AS A HOMEWORK ASSIGNMENT THE OFFENDING STUDENT WILL FAIL THE COURSE.
//THIS FILE IS PROTECTED IN OTHER WAYS SO IT WILL BE DISCOVERED.
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import android.util.Log;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    TextView amount;
    TextView result;

    private static final String TAG = "MyActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        amount = findViewById(R.id.amount);
        result = findViewById(R.id.result);

        calculateTip();
    }

    private void calculateTip(){
        Button btn = findViewById(R.id.calculateBtn);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG,"does this work Scott Shaper wrote this");
                if(amount==null || amount.length() == 0){
                    result.setText(R.string.error);

                }
                else {
                    String output;
                    double ten;
                    double fifteen;
                    double twenty;
                    double value = Double.parseDouble(amount.getText().toString());

                    ten = value - (value * .90);
                    fifteen = value - (value * .85);
                    twenty = value - (value * .80);

                    output = "The tip value are as follows:\n\nTen percent = " + String.format(Locale.US,"%.2f",ten) + "\nFifteen percent = " + String.format(Locale.US,"%.2f", fifteen) + "\nTwenty percent = " + String.format(Locale.US,"%.2f",twenty);

                    result.setText(output);
                }
            }
        });

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        CharSequence userText = result.getText();
        outState.putCharSequence("savedText", userText);
    }
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        CharSequence userText = savedInstanceState.getCharSequence("savedText");
        result.setText(userText);
    }
}
