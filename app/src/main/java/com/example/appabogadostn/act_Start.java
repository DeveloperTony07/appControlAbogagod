package com.example.appabogadostn;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

public class act_Start extends AppCompatActivity {

    //TextView txtUsername;
    Fragment frmStart;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lyt_start);


        Intent intent = getIntent();
        String layerIdentification = intent.getStringExtra("lawyer_identification");

         frmStart = frm_Register_Appointment.newInstance(layerIdentification);
         getSupportFragmentManager().beginTransaction().add(R.id.frmStart, frmStart).commit();

    }

}