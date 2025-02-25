package com.ebookfrenzy.roomdemo;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ContactDao {

    @Insert
    void insertContact(Contact contact);

    @Query("SELECT * FROM contacts WHERE contactName = :name")
    List<Contact> findContact(String name);

    @Query("SELECT * FROM contacts WHERE contactName LIKE '%' || :name || '%' ")
    List<Contact> searchContact(String name);

    @Query("DELETE FROM contacts WHERE contactName = :name")
    void deleteContact(String name);

    @Query("SELECT * FROM contacts")
    LiveData<List<Contact>> getAllContacts();

}
