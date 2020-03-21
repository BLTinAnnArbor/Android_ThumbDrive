package com.ebookfrenzy.recycleviewwithintent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ActivityB extends AppCompatActivity {

    public static final String TAG = "ActivityB";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);

        Bundle extras = getIntent().getExtras();
        if(extras == null) { return; }

        String qTitle = extras.getString("qTitle");
        TextView  titleView = findViewById(R.id.titleTextView);
        titleView.setText(qTitle);

        String qDetails = extras.getString("qDetails");
        TextView  detailsView = findViewById(R.id.detailsTextView);
        detailsView.setText(qDetails);

    }
}
