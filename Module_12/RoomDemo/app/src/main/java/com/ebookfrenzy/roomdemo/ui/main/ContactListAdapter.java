package com.ebookfrenzy.roomdemo.ui.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ebookfrenzy.roomdemo.Contact;
import com.ebookfrenzy.roomdemo.R;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Collections;
import java.util.List;

public class ContactListAdapter extends RecyclerView.Adapter<ContactListAdapter.ViewHolder> {

    private int contactItemLayout;
    private List<Contact> contactList;

    public ContactListAdapter(int layoutId) { // Constructor
        contactItemLayout = layoutId;  // an int
    }

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
    
    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView can;
        TextView name;
        TextView phone;

        ViewHolder(View itemView) {
            super(itemView);

            can = itemView.findViewById(R.id.can_image);
            name = itemView.findViewById(R.id.name);
            phone = itemView.findViewById(R.id.phone);
        }
    }

} // class ContactListAdapter
