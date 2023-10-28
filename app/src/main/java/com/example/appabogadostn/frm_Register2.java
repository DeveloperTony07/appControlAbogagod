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

public class frm_Register2 extends Fragment {

    private TextInputLayout etPhone;
    private TextInputLayout etEmail;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflar el diseño del fragmento
        View view = inflater.inflate(R.layout.frm_register2, container, false);

        etPhone = view.findViewById(R.id.txtRegisterPhone);
        etEmail = view.findViewById(R.id.txtRegisterEmail);

        String identification = getArguments().getString("identification");
        String username = getArguments().getString("username");

        // Obtener una referencia al botón btnBackRegister
        Button btnBackRegister = view.findViewById(R.id.btnBackRegister);
        // Obtener una referencia al botón btnNextRegister2
        Button btnNextRegister2 = view.findViewById(R.id.btnNextRegister2);

        // Establecer un OnClickListener para el botón btnNextRegister2
        btnNextRegister2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtener los datos de los EditText
                String phone = etPhone.getEditText().getText().toString();
                String email = etEmail.getEditText().getText().toString();

                if (validateFields(phone,email)) {

                    frm_Register3 nextFragment = new frm_Register3();

                    Bundle bundle = new Bundle();
                    bundle.putString("identification", identification);
                    bundle.putString("username", username);
                    bundle.putString("phone", phone);
                    bundle.putString("email", email);
                    nextFragment.setArguments(bundle);

                    FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
                    transaction.replace(R.id.frmContainerRegister, nextFragment).addToBackStack(null).commit();

                } else {
                    // Mostrar un mensaje de error
                    showMessage("El usuario debe ingresar todos los datos.");
                }
            }
        });

        btnBackRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Realizar la transacción para regresar a frm_Register1
                FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
                transaction.replace(R.id.frmContainerRegister, new frm_Register1()).addToBackStack(null).commit();
            }
        });

        return view;
    } //Fin del onCreate

    private boolean validateFields(String phone, String email) {
        return !phone.isEmpty() && !email.isEmpty();
    }

    private void showMessage(String mensaje) {
        // Puedes mostrar el mensaje de diferentes maneras. Por ejemplo, usando un Toast.
        Toast.makeText(getActivity(), mensaje, Toast.LENGTH_SHORT).show();
    }
}
