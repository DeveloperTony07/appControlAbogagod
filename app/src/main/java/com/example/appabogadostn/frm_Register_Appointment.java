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

public class frm_Register_Appointment extends Fragment {

    private TextInputLayout etClientName, etClientID, etClientPhone, etAppointmentName, etAppointmentType;


    public frm_Register_Appointment() {
        // Required empty public constructor
    }

    public static frm_Register_Appointment newInstance(String layerIdentification) {
        frm_Register_Appointment fragment = new frm_Register_Appointment();
        Bundle args = new Bundle();
        args.putString("lawyer_identification", layerIdentification);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.frm_register_appointment, container, false);

        Bundle args = getArguments();

        String lawyerIdentification = args.getString("lawyerID");


        etClientName = view.findViewById(R.id.txtRegisterClientName);
        etClientID = view.findViewById(R.id.txtRegisterClientID);
        etClientPhone = view.findViewById(R.id.txtRegisterClientPhone);
        etAppointmentName = view.findViewById(R.id.txtRegisterAppointmentName);
        etAppointmentType = view.findViewById(R.id.txtRegisterAppointmentType);

        Button btnNext = view.findViewById(R.id.btnRegisterAppointmentNext);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String clientName = etClientName.getEditText().getText().toString();
                String clientID = etClientID.getEditText().getText().toString();
                String clientPhone = etClientPhone.getEditText().getText().toString();
                String appointmentName = etAppointmentName.getEditText().getText().toString();
                String appointmentType = etAppointmentType.getEditText().getText().toString();

                if (validateFields(clientName, clientID, clientPhone, appointmentName, appointmentType)) {

                    Bundle bundle = new Bundle();
                    bundle.putString("clientName", clientName);
                    bundle.putString("clientID", clientID);
                    bundle.putString("clientPhone", clientPhone);
                    bundle.putString("appointmentName", appointmentName);
                    bundle.putString("appointmentType", appointmentType);
                    bundle.putString("lawyerID", lawyerIdentification );

                    frm_Register_Appointment2 nextFragment = new frm_Register_Appointment2();
                    nextFragment.setArguments(bundle);

                    FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
                    transaction.replace(R.id.frmStart, nextFragment).addToBackStack(null).commit();
                } else {
                    showMessage("El usuario debe ingresar todos los datos.");
                }
            }
        });

        return view;
    }

    private boolean validateFields(String clientName, String clientId, String clientPhone, String appointmentName, String appointmentType){
        return !clientName.isEmpty() && !clientId.isEmpty() && !clientPhone.isEmpty() && !appointmentName.isEmpty() && !appointmentType.isEmpty();
    }

    private void showMessage(String message){
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }

}