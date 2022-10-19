package com.example.mapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.RelativeLayout;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements SendRvAdapter.Dataviewclick{

    private RecyclerView Rview;
    private FirebaseDatabase frDatabase;
    private DatabaseReference drDatabase;
    private ArrayList<SendAppraisalModal> sendAppModalist;

    private RelativeLayout Rlayout;
    private SendRvAdapter sendRvAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Rview=findViewById(R.id.Recyvw);
        frDatabase=FirebaseDatabase.getInstance();
        drDatabase=frDatabase.getReference("userdata");
        sendAppModalist=new ArrayList<>();
        Rlayout=findViewById(R.id.rl);
        sendRvAdapter=new SendRvAdapter(sendAppModalist,this,this);

        Rview.setLayoutManager(new LinearLayoutManager(this));
        Rview.setAdapter(sendRvAdapter);
        loadData();
    }
    private void loadData(){
      sendAppModalist.clear();
      drDatabase.addChildEventListener(new ChildEventListener() {
          @Override
          public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
              sendAppModalist.add(snapshot.getValue(SendAppraisalModal.class));
              sendRvAdapter.notifyDataSetChanged();

          }

          @Override
          public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
              sendRvAdapter.notifyDataSetChanged();

          }

          @Override
          public void onChildRemoved(@NonNull DataSnapshot snapshot) {
              sendRvAdapter.notifyDataSetChanged();

          }

          @Override
          public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
              sendRvAdapter.notifyDataSetChanged();

          }

          @Override
          public void onCancelled(@NonNull DatabaseError error) {

          }
      });

    }
    @Override
    public void onclickdata(int position) {

    }
}