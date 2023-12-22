package com.example.shopping;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button signn = (Button) findViewById(R.id.signupp);
        signn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(login.this, SignIn.class);
                startActivity(intent2);
            }
        });

        Button log = (Button) findViewById(R.id.loginn);

        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(login.this, LoginTo.class);
                startActivity(intent1);
            }
        });

    }
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.main_menu, menu);
//        return true;
//    }

//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//
//        switch (item.getItemId()) {
//            case R.id.settingg:
//                // code
//                Toast.makeText(this, "Settingd", Toast.LENGTH_SHORT).show();
//                break;
//            case R.id.helpp:
//                Toast.makeText(this, "Help", Toast.LENGTH_SHORT).show();
//                break;
//            case R.id.linked:
//                Toast.makeText(this, "Linked devices", Toast.LENGTH_SHORT).show();
//                break;
//            case R.id.pay:
//                Toast.makeText(this, "Payments", Toast.LENGTH_SHORT).show();
//                break;
//            default:
//                return super.onOptionsItemSelected(item);
//        }
//        return super.onOptionsItemSelected(item);
//    }

}