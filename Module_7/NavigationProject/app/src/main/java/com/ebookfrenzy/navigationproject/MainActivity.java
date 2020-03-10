package com.ebookfrenzy.navigationproject;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;

import com.ebookfrenzy.navigationproject.ui.main.MainFragment;

import static com.ebookfrenzy.navigationproject.FragmentA.*;

public class MainActivity extends AppCompatActivity implements
        FragmentA.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
    }
    @Override
    public void onFragmentInteraction(Uri uri){
    }
}
