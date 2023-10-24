package com.example.appabogadostn;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link frm_Register1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class frm_Register1 extends Fragment {


    public frm_Register1() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflar el diseño del fragmento
        View view = inflater.inflate(R.layout.frm_register1, container, false);

        // Obtener una referencia al botón btnBackRegister
        Button btnNextRegister = view.findViewById(R.id.btnNextRegister1);

        // Establecer un OnClickListener para el botón
        btnNextRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Realizar la transacción para regresar a frm_Register1
                FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
                transaction.replace(R.id.frmContainerRegister, new frm_Register2()).addToBackStack(null).commit();
            }
        });

        return view;
    }
}