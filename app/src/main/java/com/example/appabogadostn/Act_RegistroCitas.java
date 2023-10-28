package com.example.appabogadostn;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

public class Act_RegistroCitas extends AppCompatActivity {

    Fragment frmRegisterCita;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lyt_registro_citas);

        frmRegisterCita = new frm_register_appointment();

        getSupportFragmentManager().beginTransaction().add(R.id.frmContainerRegister, frmRegisterCita).commit();
    }


}