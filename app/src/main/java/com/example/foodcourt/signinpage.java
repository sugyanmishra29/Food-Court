package com.example.foodcourt;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class signinpage extends AppCompatActivity {

    private EditText siUsername;
    private EditText siPassword;
    private Button btnSignIn;
    private Button btnResetSi;

    private void checkLogin(){
        final String email_txt = siUsername.getText().toString().trim();
        final String password_txt = siPassword.getText().toString().trim();

        DatabaseReference ref = FirebaseDatabase.getInstance().getReference();

        ref.child("Users").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()){
                    if (dataSnapshot.child(email_txt).exists()){
                        if (dataSnapshot.child(email_txt).getValue().toString().equals(password_txt)){
                            Intent i = new Intent(signinpage.this,MainActivity.class);
                            startActivity(i);
                        }

                        else{
                            Toast.makeText(signinpage.this, "Invalid password", Toast.LENGTH_SHORT).show();
                        }
                    }

                    else{
                        Toast.makeText(signinpage.this, "Invalid Email", Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(signinpage.this, "Error. Try again", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signinpage);

        siUsername=(EditText)findViewById(R.id.siUsername);
        siPassword=(EditText)findViewById(R.id.siPassword);

        btnSignIn=(Button)findViewById(R.id.btnSignin);
        btnResetSi=(Button)findViewById(R.id.btnResetsi);

        btnResetSi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                siUsername.setText("");
                siPassword.setText("");
            }
        });

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkLogin();
            }
        });

    }
}
