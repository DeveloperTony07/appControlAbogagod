package com.example.appabogadostn;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.appabogadostn.crontroller.Database;
import com.google.android.material.textfield.TextInputLayout;

public class frm_Register3 extends Fragment {

    private TextInputLayout etPassword;

    private TextInputLayout etConfirmPassword;

    public frm_Register3() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflar el diseño del fragmento
        View view = inflater.inflate(R.layout.frm_register3, container, false);

        //Referencia a los TextInputLayout
        etPassword = view.findViewById(R.id.txtRegisterPassword);
        etConfirmPassword = view.findViewById(R.id.txtConfirmPassword);

        // Obtener una referencia a los Botones
        Button btnBackRegister2 = view.findViewById(R.id.btnBackRegister2);
        Button btnRegister = view.findViewById(R.id.btnRegisterLawyer);

        // Establecer un OnClickListener para el botón
        btnBackRegister2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Obtener los datos de frm_Register2
                String identification = getArguments().getString("identification");
                String username = getArguments().getString("username");
                String phone = getArguments().getString("phone");
                String email = getArguments().getString("email");

                // Crear una nueva instancia de frm_Register2
                frm_Register2 previousFragment = new frm_Register2();

                // Pasar los datos a frm_Register2 usando un Bundle
                Bundle bundle = new Bundle();
                bundle.putString("identification", identification);
                bundle.putString("username", username);
                bundle.putString("phone", phone);
                bundle.putString("email", email);
                previousFragment.setArguments(bundle);

                // Realizar la transacción para regresar a frm_Register2
                FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
                transaction.replace(R.id.frmContainerRegister, previousFragment).addToBackStack(null).commit();
            }
        });

        // Establecer un OnClickListener para el botón de registro
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(verifyPasswords()){
                    String identification = getArguments().getString("identification");
                    String username = getArguments().getString("username");
                    String phone = getArguments().getString("phone");
                    String email = getArguments().getString("email");
                    String password = etPassword.getEditText().getText().toString();

                    Database database = new Database(requireContext());
                    if(database.addLawyer(identification, username, phone, email, password)){
                        showMessage("Se registro Con exito");
                        Intent intent = new Intent(getActivity(), act_Welcome.class);
                        startActivity(intent);
                        getActivity().finish(); // Esto cierra la actividad actual después de iniciar la nueva
                    }else{
                        showMessage("Error al agregar usuario");
                    }


                }else{
                    showMessage("Contrasenas incorrectas");
                }
            }
        });

        return view;
    }//Fin del onCreate



    private boolean verifyPasswords() {
        String contrasena = etPassword.getEditText().getText().toString();
        String confirmarContrasena = etConfirmPassword.getEditText().getText().toString();

        if (contrasena.equals(confirmarContrasena)) {
            // Las contraseñas son iguales
            return true;
        } else {
            // Las contraseñas no son iguales
            return false;
        }
    }
    private void showMessage(String mensaje) {
        // Puedes mostrar el mensaje de diferentes maneras. Por ejemplo, usando un Toast.
        Toast.makeText(getActivity(), mensaje, Toast.LENGTH_SHORT).show();
    }
}