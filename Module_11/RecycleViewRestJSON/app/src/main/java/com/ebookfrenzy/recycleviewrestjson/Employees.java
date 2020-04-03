package com.ebookfrenzy.recycleviewrestjson;

import java.util.ArrayList;

public class Employees {

    private static final String TAG = "Employees";

    private String age;
    private String eyeColor;
    private String name;
    private String gender;
    private String company;
    private String email;
    private String phone;
    private String address;

    private ArrayList<Employees> employees;

    public ArrayList<Employees> getEmployees(){

        return employees;
    }


    public String getAge() {
        return age;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getCompany() {
        return company;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

} // class Employees
