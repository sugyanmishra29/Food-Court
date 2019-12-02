package com.example.foodcourt;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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

import static android.widget.Toast.LENGTH_SHORT;

public class signuppage extends AppCompatActivity {

    private EditText suUsername;
    private EditText suPassword;
    private Button btnSignUp;
    private Button btnResetSu;

    private void addData()
    {
        final String email_txt = suUsername.getText().toString().trim();
        final String password_txt = suPassword.getText().toString().trim();
        final DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
        Log.v("Sign up",email_txt);
        Log.v("Sign up",password_txt);
        if(!email_txt.equals(""))
        {
            if(!password_txt.equals("")) {

                ref.child("Users").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if(dataSnapshot.exists())
                        {
                            if(dataSnapshot.child(email_txt).exists())
                            {
                                Toast.makeText(signuppage.this, "Email id already in use", LENGTH_SHORT).show();
                            }
                            else
                            {
                                ref.child("Users").child(email_txt).setValue(password_txt);
                                Log.v("sign up ","Before intent");
                                Intent i = new Intent(signuppage.this,authpage.class);
                                startActivity(i);
                                Log.v("sign up ","After intent");
                                Toast.makeText(signuppage.this, "Account created successfully", LENGTH_SHORT).show();
                            }
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
            else
            {
                Toast.makeText(this,"Please Fill Password.", LENGTH_SHORT).show();
            }
        }
        else
        {
            Toast.makeText(this,"Please Fill Email.", LENGTH_SHORT).show();
        }


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
