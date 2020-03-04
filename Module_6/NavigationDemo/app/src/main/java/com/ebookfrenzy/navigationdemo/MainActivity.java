package com.ebookfrenzy.navigationdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;

import com.ebookfrenzy.navigationdemo.ui.main.MainFragment;

public class MainActivity extends AppCompatActivity
        implements SecondFragment.OnFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        // Deleted the loading of main_fragment.xml
    }

    @Override // Necessary for above implementation
    public void onFragmentInteraction(Uri uri){

    }
}
