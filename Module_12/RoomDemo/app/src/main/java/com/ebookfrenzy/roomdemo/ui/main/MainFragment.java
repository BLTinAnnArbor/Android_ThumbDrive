package com.ebookfrenzy.roomdemo.ui.main;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProviders;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ebookfrenzy.roomdemo.MainActivity;
import com.ebookfrenzy.roomdemo.R;
import android.widget.EditText;

import com.ebookfrenzy.roomdemo.Contact;
import android.widget.Button;
import android.widget.ImageView;

import androidx.lifecycle.Observer;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainFragment extends Fragment {
    
    private static String TAG = "MainFragment";

    private MainViewModel mViewModel;
    private ContactListAdapter adapter;

    private EditText name;
    private EditText phone;
    private ImageView trashCan;  // Probably not necessary



    // Line below is called to replace container of main activity or something similar.
    // It also enables the instance mf in MainActivity to access methods in this fragment.
    public static MainFragment newInstance() {
        // to keep method from collapsing
        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.main_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(MainViewModel.class);

        name = getView().findViewById(R.id.name);
        phone = getView().findViewById(R.id.phone);

        listenerSetup();
        observerSetup();
        recyclerSetup();

    } // onActivityCreated()


    public void showAllContacts(){
        adapter.getContactList();
    }

    public void sortContactsAsc(){
        adapter.sortContactList();
    }

    public void sortContactsDes(){
        adapter.sortContactListDes();
    }

    public void addContact(){

        String nm = name.getText().toString();
        String ph = phone.getText().toString();

        if (!nm.equals("") && !ph.equals("")) {
            Contact contact = new Contact(nm, ph);
            mViewModel.insertContact(contact);
            clearFields();
            name.requestFocus();
        } else {
            ((MainActivity) getActivity()).showToast("You must enter both a name and a phone number" +
                    " if you'd like to add a contact.");
            name.requestFocus();
        }
    }

    public void deleteContact(){

        String nm = name.getText().toString();
        String ph = phone.getText().toString();

        if (!nm.equals("")) { // If nm is not a record, nothing bad happens.
            mViewModel.deleteContact(nm);
            clearFields();
        } else {
            ((MainActivity) getActivity()).showToast("You must enter at least a name " +
                    "if you want to delete a contact.");
            name.requestFocus();
        }
    }

    public void findContact(){
       // ???
    }

//*************************************8
    private void recyclerSetup() {

        RecyclerView recyclerView;

        //adapter = new ContactListAdapter(R.layout.contact_list_item);  // book example
        adapter = new ContactListAdapter(R.layout.card_layout); // (R.layout.card_layout) is an int.
        recyclerView = getView().findViewById(R.id.contact_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
    }

    private void clearFields() {
        name.setText("");
        phone.setText("");
    }

    private void observerSetup() {

        mViewModel.getAllContacts().observe(this, new Observer<List<Contact>>() {
            @Override
            public void onChanged(@Nullable final List<Contact> contacts) {
                adapter.setContactList(contacts);
            }
        });

        mViewModel.getSearchResults().observe(this,
                new Observer<List<Contact>>() {
                    @Override
                    public void onChanged(@Nullable final List<Contact> contacts) {

                        if (contacts.size() > 0) {
                            name.setText(contacts.get(0).getName());
                            phone.setText(contacts.get(0).getPhone());
                        } else {
                            name.setText("No Match");
                        }
                    }
                });
    }
//******************************************************************************
    private void listenerSetup() {

        Button addButton = getView().findViewById(R.id.addButton);
        Button findButton = getView().findViewById(R.id.findButton);
        Button deleteButton = getView().findViewById(R.id.deleteButton);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String nm = name.getText().toString();
                String ph = phone.getText().toString();

                if (!nm.equals("") && !ph.equals("")) {
                    Contact contact = new Contact(nm, ph);
                    mViewModel.insertContact(contact);
                    clearFields();
                } else {
                    name.setText("Incomplete information");
                }
            }
        });

        findButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mViewModel.findContact(name.getText().toString());
            }
        });

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mViewModel.deleteContact(name.getText().toString());
                clearFields();
            }
        });
    }

} // class MainFragment
