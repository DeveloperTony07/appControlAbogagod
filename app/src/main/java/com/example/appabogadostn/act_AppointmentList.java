package com.example.appabogadostn;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.appabogadostn.crontroller.Database;
import com.example.appabogadostn.modelo.Appointment;
import com.example.appabogadostn.modelo.Lawyer;

import java.util.ArrayList;

public class act_AppointmentList extends AppCompatActivity {

    ListView appointmentList;
    ArrayAdapter adapter1;
    Database db1;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lyt_appointment_list);
        appointmentList = findViewById(R.id.listViewAppointments);

        Intent intent = getIntent();
        String lawyerID = intent.getStringExtra("lawyer_identification");

        db1 = new Database(this);
        // Obtén la lista de abogados
        ArrayList<Appointment> lawyers = db1.getAppointmentsForLawyer(lawyerID);

        adapter1= new ArrayAdapter(act_AppointmentList.this, android.R.layout.simple_list_item_1, lawyers);
        appointmentList.setAdapter(adapter1);
    }

}