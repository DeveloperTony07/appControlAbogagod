package com.example.appabogadostn;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.appabogadostn.crontroller.Database;
import com.example.appabogadostn.modelo.Lawyer;

import java.util.ArrayList;

public class act_UserList extends AppCompatActivity {

    Button btnBack;
    ListView  userList;
    ArrayAdapter adapter;
    Database db;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lyt_user_list);
        btnBack = findViewById(R.id.btnBackUserList);
        userList = findViewById(R.id.lawyersList);

        // Inicializa la instancia de Database con el contexto
        db = new Database(this);

        // Obtén la lista de abogados
        ArrayList<Lawyer> lawyers = db.getLawyers();


        adapter= new ArrayAdapter(act_UserList.this, android.R.layout.simple_list_item_1, lawyers);
        userList.setAdapter(adapter);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(act_UserList.this, act_Welcome.class);
                startActivity(intent);
            }
        });
    }
}