package com.ebookfrenzy.asyncproject;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private String myStr = "Hi there- from onBindViewHolder()";

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.card_layout, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.itemTitle.setText(myStr);

    }

    @Override
    public int getItemCount() {

    }

    class ViewHolder extends RecyclerView.ViewHolder{

        TextView itemTitle;

        ViewHolder (View itemView){
            super(itemView);
            itemTitle = itemView.findViewById(R.id.item_title);
        }
    } // class ViewHolder

} // class RecycleAdapter
