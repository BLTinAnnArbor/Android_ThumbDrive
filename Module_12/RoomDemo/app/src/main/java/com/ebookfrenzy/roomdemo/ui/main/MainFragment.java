package com.ebookfrenzy.roomdemo.ui.main;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ebookfrenzy.roomdemo.R;
import android.widget.EditText;

import com.ebookfrenzy.roomdemo.Contact;
import android.widget.Button;
import androidx.lifecycle.Observer;
import java.util.List;

public class MainFragment extends Fragment {

    private MainViewModel mViewModel;
    private ContactListAdapter adapter;  // an int

    private EditText name;
    private EditText phone;

    public static MainFragment newInstance() {
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

    }

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
                mViewModel.deleteProduct(name.getText().toString());
                clearFields();
            }
        });
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

}
