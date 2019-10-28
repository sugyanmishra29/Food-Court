package com.example.foodcourt;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    SharedPreferences sp; //sp-the name of shared preferences has to be the same in both the files
    SharedPreferences.Editor editor;//editor-the name of the editor can be different in both the files

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sp = getSharedPreferences("login",MODE_PRIVATE);
        editor = sp.edit();

        /*if(sp.getBoolean("logged",false)){
            Intent i = new Intent(this,authpage.class);    //useless code....always takes back to authpage even after login
            startActivity(i);
        }*/
        boolean loginState = sp.getBoolean("logged",false);
        if (loginState == false){
            Intent intent = new Intent(MainActivity.this,authpage.class);
            startActivity(intent);
            finishAffinity();
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.mainmenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id =item.getItemId();
        switch (id){
            case R.id.signout:
                AlertDialog.Builder abuilder = new AlertDialog.Builder(MainActivity.this);
                abuilder.setTitle("Signing out");
                abuilder.setMessage("Do you want to sign out from Food Court?");
                abuilder.setPositiveButton("SIGN OUT", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        editor.clear();
                        editor.commit();
                        Intent i = new Intent(MainActivity.this,authpage.class);
                        startActivity(i);
                        finishAffinity();
                        Toast.makeText(MainActivity.this,"Signed out successfully",Toast.LENGTH_SHORT).show();
                    }
                });
                abuilder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                abuilder.show();
                break;
            case R.id.help:
                Intent j = new Intent(MainActivity.this,help.class);
                startActivity(j);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void onBackPressed() {
        AlertDialog.Builder ab=new AlertDialog.Builder(MainActivity.this);
        ab.setTitle("Exit");
        ab.setMessage("Do you want to close the app?");
        ab.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finishAffinity();
            }
        });
        ab.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        ab.show();
    }
}