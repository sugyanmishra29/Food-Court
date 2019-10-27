package com.example.foodcourt;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class signuppage extends AppCompatActivity {


    private EditText suUsername;
    private EditText suPassword;
    private Button btnSignUp;
    private Button btnResetSu;

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

            }
        });



    }
}
