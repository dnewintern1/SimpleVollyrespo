package com.base.vollyandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MakingJsonArrayReq extends AppCompatActivity {

    private RecyclerView recyclerView;
    RecyclerView.Adapter mAdapter;
    RecyclerView.LayoutManager layoutManager;

    ArrayList<Contact> arraylist = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_making_json_array_req);

        recyclerView = findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setHasFixedSize(true);

        BackgroundTask backgroundTask = new BackgroundTask(MakingJsonArrayReq.this);

        arraylist = backgroundTask.getList();

        mAdapter = new RecyclerAdapter(arraylist);
        recyclerView.setAdapter(mAdapter);

    }
}