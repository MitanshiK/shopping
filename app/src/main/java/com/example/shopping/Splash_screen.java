package com.example.shopping;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ProgressBar;

public class Splash_screen extends AppCompatActivity {
    String user_Name,user_Password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fetch();
        setContentView(R.layout.activity_splash_screen);
        getSupportActionBar().hide();
        ProgressBar progress = findViewById(R.id.prog);
        progress.setVisibility(View.VISIBLE);


//        ProgressDialog progDialog = new ProgressDialog(this);
//        progDialog.setMessage("Loading");
//        progDialog.setTitle("shop");
//        progDialog.create();
//        progDialog.show();


        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if(user_Name.isEmpty() && user_Password.isEmpty())
                {
                    Intent i1 = new Intent(Splash_screen.this,  SignIn.class);
                    startActivity(i1);
                    finish();
                }
                else {
                    Intent i1 = new Intent(Splash_screen.this, LoginTo.class);
                    startActivity(i1);
                    finish();
                }

//                Intent intent = new Intent(Splash_screen.this, SignIn.class);
//                startActivity(intent);
//                Intent i1 = new Intent(Splash_screen.this,  SignIn.class);
//                   startActivity(i1);
               progress.setVisibility(View.GONE);
//                progDialog.dismiss();
                finish();
            }
        }, 3000);


    }
    private void fetch() {
        SharedPreferences sh = getSharedPreferences("pref", Context.MODE_PRIVATE);
        user_Name = sh.getString("username", "");
        user_Password = sh.getString("userpass", "");

    }
}