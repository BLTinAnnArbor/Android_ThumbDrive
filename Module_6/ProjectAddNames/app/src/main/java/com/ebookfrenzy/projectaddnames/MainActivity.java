package com.ebookfrenzy.projectaddnames;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.ebookfrenzy.projectaddnames.ui.main.MainFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        if (savedInstanceState == null) {  // These lines put the MainFragment in
            getSupportFragmentManager().beginTransaction()  // the container area.
                    .replace(R.id.container, MainFragment.newInstance())
                    .commitNow();
        }
    }
}
