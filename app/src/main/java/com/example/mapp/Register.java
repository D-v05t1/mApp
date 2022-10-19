package com.example.mapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Register extends AppCompatActivity {

    private TextInputEditText email, password, confirmnpasssword;
    private Button register;
    private FirebaseDatabase firebaseDatabase;
    private FirebaseAuth mAuth;
    private TextView lv;
    private DatabaseReference databaseReference;
    private ProgressBar pb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        //pb = findViewById(R.id.pbar);
        Toolbar toolbar = findViewById(R.id.topbar);
        setSupportActionBar(toolbar);
        mAuth=FirebaseAuth.getInstance();
        email = findViewById(R.id.username);
        password = findViewById(R.id.password);
        confirmnpasssword = findViewById(R.id.confirm);
        //personalno = findViewById(R.id.regpersonalno);
        register = findViewById(R.id.regokay);
        lv= findViewById(R.id.login);

        firebaseDatabase = FirebaseDatabase.getInstance();
        getSupportActionBar().setDisplayShowTitleEnabled(false);



        lv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent p = new Intent(Register.this, Login.class);
                startActivity(p);
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usrmail = email.getText().toString();
                //String usrname = username.getText().toString();
                String pass = password.getText().toString();
                String confirm = confirmnpasssword.getText().toString();
                // String no = personalno.getText().toString();


                if (TextUtils.isEmpty(usrmail) || TextUtils.isEmpty(pass) || TextUtils.isEmpty(confirm)){
                    //  || TextUtils.isEmpty(no) || TextUtils.isEmpty(usrname)) {
                    Toast.makeText(Register.this, "Hello, check all fields please", Toast.LENGTH_SHORT).show();
                }

                else if (!pass.equals(confirm)){
                    Toast.makeText(Register.this, "Password provided are not matching", Toast.LENGTH_SHORT).show();
                }

                else {
                    mAuth.createUserWithEmailAndPassword(usrmail, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            // on below line we are checking if the task is success or not.
                            if (task.isSuccessful()) {

                                // in on success method we are hiding our progress bar and opening a login activity.
                                //loadingPB.setVisibility(View.GONE);
                                Toast.makeText(Register.this, "User Registered..", Toast.LENGTH_SHORT).show();
                                Intent i = new Intent(Register.this, Login.class);
                                startActivity(i);

                            }

                            else {

                                // in else condition we are displaying a failure toast message.
                                //loadingPB.setVisibility(View.GONE);
                                Toast.makeText(Register.this, "Fail to register user..", Toast.LENGTH_SHORT).show();
                            }

                        }
                    });}

            }});
    }
}