package com.example.mapp;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
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
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;
import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {
    private TextInputEditText Email, Password;
    private Button bttn;
    private TextView navigate;
    private FirebaseAuth mAuth;
    private ProgressBar pb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = findViewById(R.id.topbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        Email = findViewById(R.id.lemail);
        Password = findViewById(R.id.lpassword);
        mAuth = FirebaseAuth.getInstance();

        bttn = findViewById(R.id.slogin);
        navigate = findViewById(R.id.reg);

        getSupportActionBar().setDisplayShowTitleEnabled(false);

        navigate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent p = new Intent(Login.this, Register.class);
                startActivity(p);
            }
        });


        bttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user_mail = Email.getText().toString();
                String pass = Password.getText().toString();
                if (TextUtils.isEmpty(user_mail) || TextUtils.isEmpty(pass)) {
                    Toast.makeText(Login.this, "please fill all the fields", Toast.LENGTH_SHORT).show();
                } else {
                    mAuth.signInWithEmailAndPassword(user_mail, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            // on below line we are checking if the task is success or not.
                            if (task.isSuccessful()) {
                                // on below line we are hiding our progress bar.
                                //loadingPB.setVisibility(View.GONE);
                                Toast.makeText(Login.this, "Login Successful..", Toast.LENGTH_SHORT).show();
                                // on below line we are opening our mainactivity.
                                Intent i = new Intent(Login.this, SendApraisalpdata.class);
                                startActivity(i);
                               // finish();
                            } else {
                                //loadingPB.setVisibility(View.GONE);
                                Toast.makeText(Login.this, "Please enter valid user particulars..", Toast.LENGTH_SHORT).show();
                            }
                        }

                    });}
            }
        });
    }

/*
        @Override
        public void onStart() {
            super.onStart();
            // in on start method checking if
            // the user is already sign in.
            FirebaseUser user = mAuth.getCurrentUser();
            if (user != null) {
                // if the user is not null then we are
                // opening a main activity on below line.
                Intent i = new Intent(Login.this, MainActivity.class);
                startActivity(i);
                this.finish();
          }
            }*/

}
