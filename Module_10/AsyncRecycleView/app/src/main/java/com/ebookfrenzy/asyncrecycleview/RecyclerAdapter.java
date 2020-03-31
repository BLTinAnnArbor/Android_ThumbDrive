package com.ebookfrenzy.asyncrecycleview;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerAdapter extends RecyclerView.
        Adapter<RecyclerAdapter.ViewHolder> {

    public static final String TAG ="RecyclerAdapter";

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.card_layout, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);

        return viewHolder;
    }

    @Override                            // i is an index into the data arrays
    public void onBindViewHolder(ViewHolder viewHolder, int i) {

        Log.i(TAG, "inside onBindViewHolder()");

        //viewHolder.nameAndTime.setText(Data.nameList.get(i));
        viewHolder.nameAndTime.setText("The name is "+ Data.nameList.get(i) +
                ". The time it took was "+ Data.timeList.get(i) +" seconds.");
    }

    @Override
    public int getItemCount() {

        Log.i(TAG, " inside  getItemCount()");

        return Data.nameList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView nameAndTime;

        ViewHolder(View itemView){   // constructor
            super(itemView);
            nameAndTime = itemView.findViewById(R.id.myTextView);
        }
    } // class ViewHolder

} // class RecycleAdapter
