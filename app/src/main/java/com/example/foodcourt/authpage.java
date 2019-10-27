package com.example.foodcourt;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class authpage extends AppCompatActivity {
    private Button btnAuthpgSignIn;
    private Button btnAuthpgSignUp;
    private Button btnAuthpgGuest;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.authpage);

        btnAuthpgSignIn=(Button)findViewById(R.id.btn1);
        btnAuthpgSignUp=(Button)findViewById(R.id.btn2);
        btnAuthpgGuest=(Button)findViewById(R.id.btn3);

        btnAuthpgSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(authpage.this, signinpage.class);
                startActivity(i);
            }
        });

        btnAuthpgSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(authpage.this, signuppage.class);
                startActivity(i);
            }
        });

        btnAuthpgGuest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(authpage.this, MainActivity.class);
                startActivity(i);
            }
        });
    }
}
