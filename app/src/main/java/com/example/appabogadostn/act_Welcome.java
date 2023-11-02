package com.example.appabogadostn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.appabogadostn.crontroller.Database;

public class act_Welcome extends AppCompatActivity {

    private Button btnLogin, btnSingUp, btnUserList;
    private Database db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lyt_welcome);

        db = new Database(this);
        db.openDatabase();

        btnLogin = findViewById(R.id.btnLogin);
        btnSingUp = findViewById(R.id.btnSingUp);
        //btnUserList = findViewById(R.id.btnUserList);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(act_Welcome.this, act_Login.class);
                startActivity(intent);
            }
        });

        btnSingUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(act_Welcome.this,act_Register.class);
                startActivity(intent);
            }
        });

        /*btnUserList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(act_Welcome.this, act_UserList.class);
                startActivity(intent);
            }
        });*/
    }
}