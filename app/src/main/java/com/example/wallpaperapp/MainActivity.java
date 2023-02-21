package com.example.wallpaperapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private final static String TAG = "MainActivity";
    private RecyclerView recyclerView;
    private List<WallPaperModel> wallPaperModelList;
    private WallPaperAdapter wallPaperAdapter;
    private DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        
        
        wallPaperModelList = new ArrayList<>();
        wallPaperAdapter = new WallPaperAdapter(wallPaperModelList);
        recyclerView.setAdapter(wallPaperAdapter);

        databaseReference = FirebaseDatabase.getInstance().getReference().child("WallPapers");

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot: snapshot.getChildren()) {
                    WallPaperModel model = dataSnapshot.getValue(WallPaperModel.class);
                    wallPaperModelList.add(model);
                }
                wallPaperAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.e(TAG, error.getMessage());
            }
        });


    }


    private void init() {
        Toolbar toolbar = findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);

        recyclerView = findViewById(R.id.recyclerView);
    }

    private void setSupportActionBar(Toolbar toolbar) {
    }

}