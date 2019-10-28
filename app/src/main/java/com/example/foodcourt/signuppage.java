package com.example.foodcourt;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class signuppage extends AppCompatActivity {

    private EditText suUsername;
    private EditText suPassword;
    private Button btnSignUp;
    private Button btnResetSu;

    private void addData()
    {
        final String email_txt = suUsername.getText().toString().trim();
        final String password_txt = suPassword.getText().toString().trim();

        DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
        ref.child("Users").child(email_txt).setValue(password_txt);

        Intent i = new Intent(signuppage.this,authpage.class);
        startActivity(i);
        Toast.makeText(this, "Account created successfully", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signuppage);

        suUsername=(EditText)findViewById(R.id.suUsername);
        suPassword=(EditText)findViewById(R.id.suPassword);

        btnSignUp=(Button)findViewById(R.id.btnSignup);
        btnResetSu=(Button)findViewById(R.id.btnResetsu);

        btnResetSu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                suUsername.setText("");
                suPassword.setText("");
            }
        });

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addData();
            }
        });




    }
}
