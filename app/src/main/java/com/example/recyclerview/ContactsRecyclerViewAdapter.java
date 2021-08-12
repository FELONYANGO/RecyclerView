package com.example.recyclerview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.contentcapture.ContentCaptureCondition;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class ContactsRecyclerViewAdapter  extends RecyclerView.Adapter <ContactsRecyclerViewAdapter.ViewHolder>{
    private ArrayList<Contacts> contacts=new ArrayList<Contacts>();
    private Context context;
    public ContactsRecyclerViewAdapter(Context context) {
           this.context=context;

    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_list_item,parent,false);
       ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.textname.setText(contacts.get(position).getName());
        holder.textmail.setText(contacts.get(position).getEmail());
    holder.parent.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(context, contacts.get(position).getName()+" selected", Toast.LENGTH_SHORT).show();
        }
    });
    Glide.with(context)
            .asBitmap()
            .load(contacts.get(position).getImageurl())
            .into(holder.image);
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    public void setContacts(ArrayList<Contacts> contacts) {
        this.contacts = contacts;
        notifyDataSetChanged();
    }

    public  class ViewHolder extends RecyclerView.ViewHolder{
        private TextView textname ;
        private CardView parent;
        private TextView textmail;
        private ImageView image;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textname= itemView.findViewById(R.id.textname);
            parent=itemView.findViewById(R.id.parent);
            textmail=itemView.findViewById(R.id.textmail);
            image=itemView.findViewById(R.id.image);
        }

    }
}
