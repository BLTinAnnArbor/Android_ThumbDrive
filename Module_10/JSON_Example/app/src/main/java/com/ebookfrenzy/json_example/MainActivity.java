package com.ebookfrenzy.json_example;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void loadGrades(View view){

        Resources res = getResources();
        InputStream is = res.openRawResource(R.raw.student_grades);

        Scanner scanner = new Scanner(is);  // okay for smaller files (buffered input stream for larger)
        StringBuilder builder = new StringBuilder();

        while(scanner.hasNextLine()){
            builder.append(scanner.nextLine());
        }

        parseJson(builder.toString());

    }

    private void parseJson(String s) {
        TextView txtDisplay = findViewById(R.id.myTextView);

        StringBuilder builder = new StringBuilder();

        try {
            JSONObject root = new JSONObject(s);

            JSONObject student = root.getJSONObject("student-grades");

            builder.append("Name: ")
                    .append(student.getString("name")).append("\n");

            builder.append("Full Time: ")
                    .append(student.getBoolean("full-time")).append("\n\n");

            JSONArray courses = student.getJSONArray("courses");

            for(int i=0; i < courses.length(); i++){
                JSONObject course = courses.getJSONObject(i);
                builder.append(course.getString("name"))
                        .append(": ")
                        .append(course.getString("grade"))
                        .append("\n");

            }



        } catch (JSONException e) {
            e.printStackTrace();
        }

        txtDisplay.setText(builder.toString());
    }
}
