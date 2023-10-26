package com.example.appabogadostn;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class act_Register extends AppCompatActivity  {

    Button btnBack;
    Fragment fragmentRegister1;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lyt_register);
        btnBack = findViewById(R.id.btnBackTwo);

        fragmentRegister1 = new frm_Register1();

        getSupportFragmentManager().beginTransaction().add(R.id.frmContainerRegister, fragmentRegister1).commit();

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(act_Register.this, act_Welcome.class);
                startActivity(intent);
                finish();
            }
        });
    } // Fin del onCreate

}
