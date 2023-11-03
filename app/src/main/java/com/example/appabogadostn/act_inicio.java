package com.example.appabogadostn;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.appabogadostn.R;
import com.example.appabogadostn.crontroller.Database;
import com.example.appabogadostn.modelo.Appointment;
import com.example.appabogadostn.modelo.Lawyer;

import java.util.ArrayList;

public class act_inicio extends AppCompatActivity {
    ListView ListaInicio;
    ArrayAdapter adapter;
    Database db;
    Button btnAgregar;
    Appointment appointment;
    Lawyer logUser;
    TextView txtHello;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lyt_inicio);
        ListaInicio = findViewById(R.id.ListaInicio);
        btnAgregar = findViewById(R.id.btnAgragar);
        txtHello = findViewById(R.id.txtHello);

        Intent intent = getIntent();
        String lawyerID = intent.getStringExtra("lawyer_identification");

        db = new Database(this);
        // Obtén la lista de abogados
        ArrayList<Appointment> lawyers = db.getAppointmentsForLawyer(lawyerID);

        adapter= new ArrayAdapter(act_inicio.this, android.R.layout.simple_list_item_1, lawyers);
        ListaInicio.setAdapter(adapter);

        if (lawyerID != null) {
            logUser = db.getLawyerInfo(lawyerID);
            if (logUser != null) {
                String lawyerName = logUser.getUsername();
                txtHello.setText("Hello, " + lawyerName);
            } else {
                txtHello.setText("Hello, Unknown Lawyer");
            }
        } else {
            txtHello.setText("Hello, Anonymous User");
        }

        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(act_inicio.this, act_Start.class);
                startActivity(intent1);
                finish();

            }
        });

        ListaInicio.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            appointment = db.getAppointmentPhoneNumber()



            }
        });

    }


    //btnLlamar.setOnClickListener(new View.OnClickListener() {
    //    @Override
    //    public void onClick(View view) {
    //        if(txtTelefono.getText().toString().isEmpty()){
    //            Toast.makeText(getApplicationContext(),"Por favor ingrese un numero de telefono",
    //                    Toast.LENGTH_LONG).show();
    //        }else{
    //            int telefono= Integer.parseInt(txtTelefono.getText().toString());
    //            Intent llamar = new Intent(Intent.ACTION_CALL,Uri.parse("tel:"+telefono));
    //            startActivity(llamar);
    //        }
    //    }
    //});

}
