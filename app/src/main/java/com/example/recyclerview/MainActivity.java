package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
 private RecyclerView recyclerView;
 private ContactsRecyclerViewAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Contacts> contacts=new ArrayList<Contacts>();
        contacts.add(new Contacts("Dwaine jones","dwainejones@gmail.com","https://cdn.imgbin.com/7/3/11/imgbin-snake-eyes-general-joseph-colton-g-i-joe-action-film-gi-joe-eL86VXbAEMnvYVes0aS9pLcfA.jpg"));
        contacts.add(new Contacts("John wick","johnwick@gmail.com","https://png.pngitem.com/pimgs/s/125-1259682_john-wick-png-john-wick-transparent-background-png.png"));
        contacts.add(new Contacts("Vin diesel","vindiesel@gmail.com","https://freepngimg.com/thumb/vin_diesel/21416-6-vin-diesel-free-download.png"));

        ContactsRecyclerViewAdapter adapter;
        adapter = new ContactsRecyclerViewAdapter();
        adapter.setContacts(contacts);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        
        
 
    }
}