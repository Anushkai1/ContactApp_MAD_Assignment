package com.example.contactapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder> {

    Context ct;
    MainActivity.Contact[] contacts;
    private SelectListenr selectListenr;

    public ContactAdapter(Context ct2, MainActivity.Contact[] contacts2, SelectListenr selectListenr2) {
        ct = ct2;
        contacts = contacts2;
        selectListenr = selectListenr2;
    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(ct);
        View view = inflater.inflate(R.layout.contact_card, parent, false);
        return new ContactViewHolder(view,selectListenr);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {
        holder.name.setText(contacts[position].name);
        holder.phone.setText(contacts[position].phone);
        holder.address.setText(contacts[position].address);
        holder.email.setText(contacts[position].email);
    }

    @Override
    public int getItemCount() {
        return contacts.length;
    }

    public class ContactViewHolder extends RecyclerView.ViewHolder {

        TextView name, phone, email, address;

        public ContactViewHolder(@NonNull View itemView, SelectListenr selectListenr2) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            phone = itemView.findViewById(R.id.phone);
            email = itemView.findViewById(R.id.email);
            address = itemView.findViewById(R.id.address);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (selectListenr2 != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            selectListenr2.onItemCLicked(position);
                        }
                    }
                }
            });
        }
    }
}

