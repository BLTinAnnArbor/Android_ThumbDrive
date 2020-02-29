package com.ebookfrenzy.projectaddnames.ui.main;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;

import com.ebookfrenzy.projectaddnames.R;

public class MainFragment extends Fragment {

    private static final String TAG = "MyFragment";

    private MainViewModel mViewModel;
    private ListView myListView;
    private TextView badInput;
    private EditText nom;
    private Button addBtn;

    ArrayList<String> listItems = new ArrayList<String>();
    ArrayAdapter<String> adapter;

    public static MainFragment newInstance() { // returns a new MainFragment instance
        Log.i(TAG, "MainFragment newInstance()");
        return new MainFragment();
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        Log.i(TAG, "onCreateView");

        View view = inflater.inflate(R.layout.main_fragment, container, false);

        mViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        myListView = view.findViewById(R.id.listView);
        badInput = view.findViewById(R.id.badInput);
        nom = view.findViewById(R.id.name_edit_text);
        addBtn = view.findViewById(R.id.addNameBtn);

        adapter = new ArrayAdapter<String>(view.getContext(),
                android.R.layout.simple_list_item_1, listItems);

        myListView.setAdapter(adapter);

        if(mViewModel.nameList.size() > 0){  // If there is something in the view model
            for(String n : mViewModel.nameList){ // nameList, then loop thru and add the
                listItems.add(n);                // items to the ListView (current screen).
            }
            adapter.notifyDataSetChanged();
        }

        addBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v){
                Log.i(TAG, "onClick()");
                if(!nom.getText().toString().equals("")){
                    Log.i(TAG, "name isn't blank");
                    mViewModel.setName(nom.getText().toString());
                    badInput.setText(""); // Clears if a valid name is entered.
                    addListItem();
                    adapter.notifyDataSetChanged();
                }else{
                    badInput.setText("You must enter a name.");
                    Log.i(TAG, "must enter a name");
                }
            }
        });
        return view;

    } // onCreateView()

    private void addListItem(){
        Log.i(TAG, "in mfrag addListItem()");
        mViewModel.addListItem();
        listItems.add(mViewModel.getName());
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Log.i(TAG, "in onActivityCreated()");
    }

} // MainFragment()
