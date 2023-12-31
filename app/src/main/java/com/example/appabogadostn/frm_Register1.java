package com.example.appabogadostn;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class frm_Register1 extends Fragment {

    private TextInputLayout etIdentification;
    private TextInputLayout etUsername;

    //private OnRegisterDataListener dataListener;

    /* Ver si funciona sin el metodo */
    public frm_Register1() {
        // Constructor vacío requerido por Fragment
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.frm_register1, container, false);

        //Referencia a los ID de los TextInputLayout
        etIdentification = view.findViewById(R.id.txtRegisterClientName);
        etUsername = view.findViewById(R.id.txtRegisterClientID);

        //Referencia al boton
        Button btnNextRegister = view.findViewById(R.id.btnNextRegister1);

        btnNextRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtener los datos de los EditText
                String identification = etIdentification.getEditText().getText().toString();
                String username = etUsername.getEditText().getText().toString();

                if (validateFields(identification, username)) {

                    Bundle bundle = new Bundle();
                    bundle.putString("identification", identification);
                    bundle.putString("username", username);

                    frm_Register2 nextFragment = new frm_Register2();
                    nextFragment.setArguments(bundle);

                    FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
                    transaction.replace(R.id.frmContainerRegister, nextFragment).addToBackStack(null).commit();
                } else {
                    showMessage("El usuario debe ingresar todos los datos.");
                }

            }
        });

        return view;
    }

    private boolean validateFields(String identification, String username) {
        return !identification.isEmpty() && !username.isEmpty();
    }

    private void showMessage(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }
}
