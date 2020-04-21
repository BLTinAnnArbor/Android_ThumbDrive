package com.ebookfrenzy.roomdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.ebookfrenzy.roomdemo.ui.main.MainFragment;

public class MainActivity extends AppCompatActivity {

    // With mf below, you now have access to all the methods in MainFragment.
    MainFragment mf = MainFragment.newInstance(); // a static method call

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, mf)
                    .commitNow();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){

        switch (item.getItemId()){

            case R.id.show_contacts:
                mf.showAllContacts();
                return true;

            case R.id.add_contact:
                mf.addContact();
                return true;

            case R.id.find_contact:
                mf.findContact();
                return true;

            case R.id.sort_az:
                mf.sortContactsAsc();
                return true;

            case R.id.sort_za:
                mf.sortContactsDes();
                return true;

            case R.id.delete_contact:
                mf.deleteContact();
                return true;

            default: return super.onOptionsItemSelected(item);
        }
    }

    public void showToast(String message){

        LayoutInflater inflater = getLayoutInflater();     // Below, a required cast to ViewGroup.
        View layout = inflater.inflate(R.layout.toast_layout, (ViewGroup)findViewById(R.id.toast_root));

        TextView toastText = layout.findViewById(R.id.toast_text);
        ImageView toastImage = layout.findViewById(R.id.toast_image);

        toastText.setText(message);
        toastImage.setImageResource(R.drawable.ic_very_dissatisfied_white);

        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, -350);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();
    }

} // class MainActivity
