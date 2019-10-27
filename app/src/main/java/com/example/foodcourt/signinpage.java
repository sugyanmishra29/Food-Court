package com.example.foodcourt;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class signinpage extends AppCompatActivity {

    private EditText siUsername;
    private EditText siPassword;
    private Button btnSignIn;
    private Button btnResetSi;

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

            }
        });

    }
}
