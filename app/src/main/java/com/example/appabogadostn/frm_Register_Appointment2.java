package com.example.appabogadostn;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.appabogadostn.crontroller.Database;
import com.example.appabogadostn.modelo.Lawyer;
import com.google.android.material.textfield.TextInputLayout;

public class frm_Register_Appointment2 extends Fragment {

    private TextInputLayout etTime, etPay;

    public frm_Register_Appointment2() {
        // Required empty public constructor
    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frm_register_appointment2, container, false);

        etTime = view.findViewById(R.id.txtRegisterAppointmentTime);
        etPay = view.findViewById(R.id.txtRegisterAppointmentPay);

        Button btnRegisterAppointment = view.findViewById(R.id.btnRegisterAppointment);

        btnRegisterAppointment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String lawyerID = getArguments().getString("lawyerID");
                String clientName = getArguments().getString("clientName");
                String clientID = getArguments().getString("clientID");
                String clientPhone = getArguments().getString("clientPhone");
                String appointmentName = getArguments().getString("appointmentName");
                String appointmentType = getArguments().getString("appointmentType");
                String time = etTime.getEditText().getText().toString();
                String stringPay = etPay.getEditText().getText().toString();
                int pay = Integer.parseInt(stringPay);

                Database db = new Database(requireContext());

                if(db.addAppointment(lawyerID, clientName, clientID, clientPhone, appointmentName, appointmentType, time, pay)){
                    showMessage("added successfully");
                    Intent intent = new Intent(getActivity(), act_AppointmentList.class);

                    // get lawyer information
                    Lawyer loggedLawyer = db.getLawyerInfo(lawyerID);
                    //pass the identification and the username in the act_Start
                    intent.putExtra("lawyer_identification", loggedLawyer.getIdentification());

                    startActivity(intent);
                    getActivity().finish();
                }else{
                    showMessage("add appointment error");
                }



            }
        });

        return view;
    }//Fin on create

    private void showMessage(String mensaje) {
        // Puedes mostrar el mensaje de diferentes maneras. Por ejemplo, usando un Toast.
        Toast.makeText(getActivity(), mensaje, Toast.LENGTH_SHORT).show();
    }
}