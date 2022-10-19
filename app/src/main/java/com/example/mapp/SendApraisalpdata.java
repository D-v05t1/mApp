package com.example.mapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SendApraisalpdata extends AppCompatActivity {

    private TextInputEditText Objective,Indicator_agreed,Proof_result,Agreed_p_targets,Self_appraisal_mark,
            Treainingduration,Comments, Agreedtraining,Professionalism,Technicalcompetency,Teamwork;;
    private FirebaseDatabase firedb;
    private DatabaseReference datadb;
    private Button Send_Data;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_apraisalpdata);
        Objective=findViewById(R.id.objective);
        Indicator_agreed=findViewById(R.id.indicator);
        Proof_result=findViewById(R.id.proof1);
        Agreed_p_targets=findViewById(R.id.agreedperformance);
        Self_appraisal_mark=findViewById(R.id.selfmark);

        Treainingduration=findViewById(R.id.trainingagreed);
        Comments=findViewById(R.id.traininduration);
        Agreedtraining=findViewById(R.id.trainingcomments);

        Professionalism=findViewById(R.id.prof);
        Technicalcompetency=findViewById(R.id.technical);
        Teamwork=findViewById(R.id.teamwork);

        Send_Data=findViewById(R.id.senddata);
        firedb=FirebaseDatabase.getInstance();
        datadb=firedb.getReference("userdata");


        Send_Data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String my_objective=Objective.getText().toString();
                String my_indicator=Indicator_agreed.getText().toString();
                String my_proof=Proof_result.getText().toString();
                String my_target=Agreed_p_targets.getText().toString();
                String my_mark=Self_appraisal_mark.getText().toString();

                String my_treainingduration=Treainingduration.getText().toString();
                String my_comments=Comments.getText().toString();
                String my_agreedtraining=Agreedtraining.getText().toString();

                String my_professionalism=Professionalism.getText().toString();
                String my_technicalcompetency=Technicalcompetency.getText().toString();
                String my_teamwork=Teamwork.getText().toString();


                SendAppraisalModal sendAmodal=new SendAppraisalModal(my_objective,my_indicator,my_proof,my_target,my_mark,my_treainingduration
                ,my_comments,my_agreedtraining,my_professionalism,my_technicalcompetency,my_teamwork);

                datadb.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        datadb.child("objectives").setValue(sendAmodal);
                        Toast.makeText(SendApraisalpdata.this, "successfully added", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(SendApraisalpdata.this,MainActivity.class));
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Toast.makeText(SendApraisalpdata.this, "error is"+error.toString(), Toast.LENGTH_SHORT).show();
                    }
                });



            }
        });


    }
}