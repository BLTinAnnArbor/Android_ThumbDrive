package com.ebookfrenzy.recycleviewrestjson;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private static final String TAG = "RecyclerViewAdapter";

    private ArrayList<Employees> employeeList;

    public RecyclerViewAdapter(ArrayList<Employees> empList){    // Constructor

        Log.i(TAG, "  I'm in the constructor");
        employeeList = empList;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.card_view,parent,false);

        RecyclerViewAdapter.ViewHolder viewHolder = new RecyclerViewAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder holder, int position) {

        Employees employee = employeeList.get(position);

        holder.age.setText(employee.getAge());
        holder.eyeColor.setText(employee.getEyeColor());
        holder.name.setText(employee.getName());
        holder.company.setText(employee.getCompany());
        holder.email.setText(employee.getEmail());
        holder.phone.setText(employee.getPhone());
        holder.address.setText(employee.getAddress());
                    // Below, position needs to be a String for setText()
        holder.countNumber.setText(String.valueOf(position + 1));

        String sex = employee.getGender();
        if(sex.equals("male")){
            holder.gender.setImageResource(R.drawable.male);
        }else{
            holder.gender.setImageResource(R.drawable.female);
        }

    } // onBindViewHolder()

    @Override
    public int getItemCount() {
        return employeeList.size();
    }

    public class ViewHolder extends  RecyclerView.ViewHolder{

        public ImageView gender;

        public TextView age;
        public TextView eyeColor;
        public TextView name;
        public TextView company;

        public TextView email;
        public TextView phone;
        public TextView address;
        public TextView countNumber;

        public  ViewHolder(View view){
            super(view);

            gender = view.findViewById(R.id.gender_image);

            age = view.findViewById(R.id.age);
            eyeColor = view.findViewById(R.id.eye_color);
            name = view.findViewById(R.id.name);
            company = view.findViewById(R.id.company);

            email = view.findViewById(R.id.email);
            phone = view.findViewById(R.id.phone);
            address = view.findViewById(R.id.address);
            countNumber = view.findViewById(R.id.count_number);
        }

    } // class ViewHolder

} // class RecyclerViewAdapter
