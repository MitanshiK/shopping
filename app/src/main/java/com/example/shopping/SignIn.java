package com.example.shopping;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ShareActionProvider;
import android.widget.TextView;
import android.widget.Toast;

public class SignIn extends AppCompatActivity {
    EditText sUser, sEmail, sPass, sPassCon;
    TextView link2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        sUser = (EditText) findViewById(R.id.user2);
        sEmail = (EditText) findViewById(R.id.email);
        sPass = (EditText) findViewById(R.id.pass2);
        sPassCon = (EditText) findViewById(R.id.re_pass);
        Button reg = (Button) findViewById(R.id.register);
        link2=findViewById(R.id.log);

        link2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent lo=new Intent(SignIn.this,LoginTo.class);
                startActivity(lo);
            }
        });


        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                if (sUser.getText().toString().equals("")) {
//                    Toast.makeText(SignIn.this, "Please select a username", Toast.LENGTH_SHORT).show();
//                } else if (sEmail.getText().toString().equals("")) {
//                    Toast.makeText(SignIn.this, "Please fill your email", Toast.LENGTH_SHORT).show();
//                } else if (sPass.getText().toString().equals(sPassCon.getText().toString()) && !sPass.getText().toString().equals("")) {
//                    Toast.makeText(SignIn.this, "registered Successfully", Toast.LENGTH_SHORT).show();
//                    Intent i3 = new Intent(SignIn.this, homepage.class);
//                    startActivity(i3);
//                } else {
//                    Toast.makeText(SignIn.this, "Passwords don't Match !", Toast.LENGTH_SHORT).show();
//                }
                if (sUser.getText().toString().isEmpty() || sEmail.getText().toString().isEmpty()
                        || sPass.getText().toString().isEmpty() || sPassCon.getText().toString().isEmpty()) {
                    Toast.makeText(SignIn.this, "Field is empty", Toast.LENGTH_SHORT).show();
                } else if(sPass.getText().toString().equals(sPassCon.getText().toString())) {
                    saveDataLocally();
                    Intent i3 = new Intent(SignIn.this, LoginTo.class);
                  startActivity(i3);
                }
            }

        });


    }


    /* SAVE- Using Sharedpreferences */
    private void saveDataLocally() {
        SharedPreferences sharedPreferences = getSharedPreferences("pref", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("username", sUser.getText().toString());
        editor.putString("Email", sEmail.getText().toString());
        editor.putString("userpass", sPass.getText().toString());
        editor.putString("Con_Password", sPassCon.getText().toString());
        editor.apply();

        Toast.makeText(this, "Data is saved", Toast.LENGTH_SHORT).show();


    }


//    /*FETCH-  Using SharedPreferences */
//    private void fetch_Data() {
//        SharedPreferences sharedPreferences = getSharedPreferences("pref", Context.MODE_PRIVATE);
//        String user_Name = sharedPreferences.getString("UserName", "");
//        String user_Email = sharedPreferences.getString("Email", "");
//        String user_Password = sharedPreferences.getString("Password", "");
//        String user_ConPassword = sharedPreferences.getString("Con_Password", "");
//
//        Log.d("TAG", "fetch_Data: "+user_Name
//        +"\n"+user_Email+"\n"+user_Password+"\n"+user_ConPassword);
//
//    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
       finishAffinity();
    }
}