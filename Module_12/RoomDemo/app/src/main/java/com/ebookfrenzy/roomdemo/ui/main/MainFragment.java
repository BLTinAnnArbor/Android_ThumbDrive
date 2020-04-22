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

import android.widget.Adapter;
import android.widget.EditText;

import com.ebookfrenzy.roomdemo.Contact;
import android.widget.Button;
import android.widget.ImageView;

import androidx.lifecycle.Observer;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainFragment extends Fragment {
//public class MainFragment extends Fragment implements ContactListAdapter.ContactClickListener{
    
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

        observerSetup();
        recyclerSetup();

    } // onActivityCreated()


    public void findContact(){
        String nm = name.getText().toString();

        if (!nm.equals("")) {
            mViewModel.searchContact(nm);
            clearFields();
        } else {
            ((MainActivity) getActivity()).showToast("You must enter a name " +
                    " or partial name if you want to search for a contact.");
            name.requestFocus();
        }
    }

    public void showAllContacts(){

        mViewModel.getAllContacts().observe(this, new Observer<List<Contact>>() {
            @Override
            public void onChanged(@Nullable final List<Contact> contacts) {
                adapter.setContactList(contacts);
            }
        });
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

        if (!nm.equals("")) {
            mViewModel.deleteContact(nm);
            clearFields();
        } else {
            ((MainActivity) getActivity()).showToast("You must enter at least a name " +
                    "if you want to delete a contact.");
            name.requestFocus();
        }
    }

    private void clearFields() {
        name.setText("");
        phone.setText("");
        name.requestFocus();
    }

//*************************************
    private void recyclerSetup() {

        RecyclerView recyclerView;

        //adapter = new ContactListAdapter(R.layout.card_layout); // (R.layout.card_layout) is an int.

        adapter = new ContactListAdapter(R.layout.card_layout, new ContactListAdapter.MyAdapterListener() {
            @Override
            public void onContainerClick(View v, int position) {

                Log.i(TAG, "iconTextViewOnClick at position "+ position);

                //mViewModel.deleteContact();  I have the position, now I need the name here
            }
        });

        recyclerView = getView().findViewById(R.id.contact_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
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
                            adapter.setContactList(contacts);
                        }
                        else{
                            ((MainActivity) getActivity()).showToast("Nothing found in the database.");
                            name.requestFocus();
                        }
                    }
                });

    } // observerSetup()

} // class MainFragment
