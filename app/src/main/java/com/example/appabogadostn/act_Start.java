package com.example.appabogadostn;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class act_Start extends AppCompatActivity {

    TextView txtUsername, txtIdentification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_start);
        txtUsername = findViewById(R.id.textLawyerUsername);
        txtIdentification = findViewById(R.id.textLawyerIdentification);


    }

}