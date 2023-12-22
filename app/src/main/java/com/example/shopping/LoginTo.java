package com.example.shopping;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginTo extends AppCompatActivity {
    EditText user, pass;
    Button sub;
    TextView link;
    CheckBox rem;
    String user_Name, user_Password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_to);
        fetch();
        user = (EditText) findViewById(R.id.user1);
        pass = (EditText) findViewById(R.id.pass1);
        sub = (Button) findViewById(R.id.loginInf);
        link = findViewById(R.id.Sign);
        rem = findViewById(R.id.check1);

        link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent si = new Intent(LoginTo.this, SignIn.class);
                startActivity(si);
            }
        });

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (user.getText().toString().isEmpty() || pass.getText().toString().isEmpty()) {
                    Toast.makeText(LoginTo.this, "Empty Fields", Toast.LENGTH_SHORT).show();
                } else if (user.getText().toString().equals(user_Name) && pass.getText().toString().equals(user_Password)) {
                    Toast.makeText(LoginTo.this, "Login Successfull >^< ", Toast.LENGTH_SHORT).show();
                    Intent i2 = new Intent(LoginTo.this, homepage.class);
                    startActivity(i2);
                } else {
                    Toast.makeText(LoginTo.this, "Incorrect Username Or password", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void fetch() {
        SharedPreferences sh = getSharedPreferences("pref", Context.MODE_PRIVATE);
        user_Name = sh.getString("username", "");
        user_Password = sh.getString("userpass", "");
        Log.d("TAG", "fetch: " + user_Name + user_Password);
        //Toast.makeText(this, "user>"+user_Name+"pass>"+user_Password, Toast.LENGTH_SHORT).show();
    }
}