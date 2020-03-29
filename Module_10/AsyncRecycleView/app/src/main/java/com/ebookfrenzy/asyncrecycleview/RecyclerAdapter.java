package com.ebookfrenzy.asyncrecycleview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.
        Adapter<RecyclerAdapter.ViewHolder> {

    Data d;
    ArrayList<String> names = d.nameList;

    private String[] titles = {"Chapter One",
            "Chapter Two",
            "Chapter Three"};

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.card_layout, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override                            // i is an index into the data arrays
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.nameAndTime.setText(names.get(i));
    }

    @Override
    public int getItemCount() {
        return names.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder{
        TextView nameAndTime;

        ViewHolder(View itemView){   // constructor
            super(itemView);
            nameAndTime = itemView.findViewById(R.id.myTextView);
        }
    } // class ViewHolder
}
