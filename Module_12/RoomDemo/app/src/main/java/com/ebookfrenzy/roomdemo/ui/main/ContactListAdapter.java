package com.ebookfrenzy.roomdemo.ui.main;

import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ebookfrenzy.roomdemo.Contact;
import com.ebookfrenzy.roomdemo.MainActivity;
import com.ebookfrenzy.roomdemo.R;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Comment;

import java.util.Collections;
import java.util.List;

public class ContactListAdapter extends RecyclerView.Adapter<ContactListAdapter.ViewHolder> {

    private static final String TAG = "ContactListAdapter";

    private int contactItemLayout;
    private List<Contact> contactList;

    Context context;
    //ContactClickListener contactClickListener;

    public ContactListAdapter(int layoutId) { // Constructor
        contactItemLayout = layoutId;  // an int
    }


 /*       // see Chrome bookmark
    public ContactListAdapter(Context context,   // Constructor
                              int layoutId, ContactClickListener contactClickListener) {
    this.context = context;
    contactItemLayout = layoutId;  // an int
    this.contactClickListener = contactClickListener;
    }

    public interface ContactClickListener {
        void onItemClicked(Contact itemClicked);
    }

  */


    public void setContactList(List<Contact> contacts) {
        contactList = contacts;
        notifyDataSetChanged();
    }

    public List<Contact> getContactList(){
        return contactList;
    }

    public void sortContactList(){
        Collections.sort(getContactList(), Contact.NameComparator);
        notifyDataSetChanged();
    }

    public void sortContactListDes(){
        Collections.sort(getContactList(), Contact.NameComparatorReverse);
        notifyDataSetChanged();
    }
//***************************
    @Override
    public int getItemCount() {
        return contactList == null ? 0 : contactList.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(
                 parent.getContext()).inflate(R.layout.card_layout, parent, false);
        ViewHolder myViewHolder = new ViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int listPosition) {

        Contact contact = contactList.get(listPosition);

        holder.can.setImageResource(R.drawable.dark_red_can);
        holder.name.setText(contact.getName());
        holder.phone.setText((contact.getPhone()));
    }

     //class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    class ViewHolder extends RecyclerView.ViewHolder{
        TextView name;
        TextView phone;
        ImageView can;
        MainViewModel mainViewModel;

        ViewHolder(View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name);
            phone = itemView.findViewById(R.id.phone);
            can = (ImageView)itemView.findViewById(R.id.can_image);

            can.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.i(TAG, "onClick: name = "+ name.getText().toString());
                    mainViewModel.deleteContact(name.getText().toString());
                }
            });
        }
        /*
        @Override
         public void onClick(View v){
            if(contactList != null){
                contactClickListener.onItemClicked(contactList.get(getLayoutPosition()));
            }
            if(v.getId() == R.id.can_image){
                Log.i(TAG, "v.getId() ="+ v.getId());

            }
        }

         */

    } // class ViewHolder

} // class ContactListAdapter
