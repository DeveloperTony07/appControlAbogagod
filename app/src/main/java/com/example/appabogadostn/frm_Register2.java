package com.example.appabogadostn;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class frm_Register2 extends Fragment {

    public frm_Register2() {
        // Constructor vacío requerido por Fragment
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflar el diseño del fragmento
        View view = inflater.inflate(R.layout.frm_register2, container, false);

        // Obtener una referencia al botón btnBackRegister
        Button btnBackRegister = view.findViewById(R.id.btnBackRegister);

        // Obtener una referencia al botón btnNextRegister2
        Button btnNextRegister2 = view.findViewById(R.id.btnNextRegister2);

        // Establecer un OnClickListener para el botón
        btnBackRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Realizar la transacción para regresar a frm_Register1
                FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
                transaction.replace(R.id.frmContainerRegister, new frm_Register1()).addToBackStack(null).commit();
            }
        });

        // Establecer un OnClickListener para el botón btnNextRegister2
        btnNextRegister2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Realizar la transacción para ir a frm_Register3
                FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
                transaction.replace(R.id.frmContainerRegister, new frm_Register3()).addToBackStack(null).commit();
            }
        });

        return view;
    }
}
