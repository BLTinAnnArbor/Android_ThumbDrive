package com.ebookfrenzy.recycleviewwithintent;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import java.util.Random;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private static final String TAG = "RecyclerAdapter";

    Data d = new Data();

    List<String> titles = d.titleList;
    List<String> details = d.detailList;
    List<Integer> images = d.imageList;

    // Imbedded Class
    class ViewHolder extends RecyclerView.ViewHolder {

        ImageView itemImage;
        TextView itemTitle;
        TextView itemDetail;
        TextView itemHiddenImageNum;

        ViewHolder(View itemView) {  // Constructor
            super(itemView);

            itemImage = itemView.findViewById(R.id.item_image);
            itemTitle = itemView.findViewById(R.id.item_title);
            itemDetail = itemView.findViewById(R.id.item_detail);
            itemHiddenImageNum = itemView.findViewById(R.id.item_hidden_image_num);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent i = new Intent(v.getContext(), ActivityB.class);

                    TextView titleView = v.findViewById(R.id.item_title);
                    String titleStr = titleView.getText().toString();
                    i.putExtra("qTitle", titleStr);

                    TextView detailsView = v.findViewById(R.id.item_detail);
                    String detailsStr = detailsView.getText().toString();
                    i.putExtra("qDetails", detailsStr);

                    TextView imageNumView = v.findViewById(R.id.item_hidden_image_num);
                    String imageNumStr = imageNumView.getText().toString();
                    i.putExtra("qImageNum", imageNumStr);

                    v.getContext().startActivity(i);

                }

            });

        } // end Constructor
    } // end Class ViewHolder


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {

        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.card_layout, viewGroup, false);

        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {

        Random rand = new Random();
        int bound = getItemCount();

        int imageNum = rand.nextInt(bound);

        viewHolder.itemTitle.setText(titles.get(rand.nextInt(bound)));
        viewHolder.itemDetail.setText(details.get(rand.nextInt(bound)));
        viewHolder.itemImage.setImageResource(images.get(imageNum));
        viewHolder.itemHiddenImageNum.setText(String.valueOf(imageNum));
    }

    @Override
    public int getItemCount() {
        return titles.size();
    }

}