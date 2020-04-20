package com.ebookfrenzy.roomdemo;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Comparator;

@Entity(tableName = "contacts")
public class Contact  {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "contactId")
    private int id;

    @ColumnInfo(name = "contactName")
    private String name;

    // No column necessary
    private String phone;

    public Contact(String name, String phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
    }

    public int getId() {
        return this.id;
    }
    public String getName() {
        return this.name;
    }
    public String getPhone() {
        return this.phone;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public static Comparator<Contact> NameComparator = new Comparator<Contact>() {

        @Override
        public int compare(Contact c1, Contact c2) {
            return c1.getName().compareTo(c2.getName());
        }
    };
    public static Comparator<Contact> NameComparatorReverse = new Comparator<Contact>() {

        @Override
        public int compare(Contact c1, Contact c2) {
            return -1*c1.getName().compareTo(c2.getName());
        }
    };

}
