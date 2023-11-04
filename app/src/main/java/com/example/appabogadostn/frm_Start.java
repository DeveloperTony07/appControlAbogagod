package com.example.appabogadostn;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.appabogadostn.crontroller.Database;
import com.example.appabogadostn.modelo.Lawyer;

public class frm_Start extends Fragment {

   TextView username;
   Button btnRegisterAppointment, btnAppointmentList;

    public frm_Start() {
        // Required empty public constructor
    }

    public static frm_Start newInstance(String lawyerIdentification, String lawyerUsername) {
        frm_Start fragment = new frm_Start();
        Bundle args = new Bundle();
        args.putString("lawyer_identification", lawyerIdentification);
        args.putString("lawyer_username", lawyerUsername);
        fragment.setArguments(args);
        return fragment;
    }


    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.frm_start, container, false);
        username = view.findViewById(R.id.textUsernameLawyer);
        btnAppointmentList = view.findViewById(R.id.btn_Appointment_List);
        btnRegisterAppointment = view.findViewById(R.id.btn_Register_Appointment);

        Bundle args = getArguments();

        String lawyerID = args.getString("lawyer_identification");
        String lawyerUsername = args.getString("lawyer_username");

        username.setText(lawyerUsername);

        btnRegisterAppointment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("lawyerID", lawyerID );

                frm_Register_Appointment nextFragment = new frm_Register_Appointment();
                nextFragment.setArguments(bundle);

                FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
                transaction.replace(R.id.frmStart, nextFragment).addToBackStack(null).commit();

            }
        });

        btnAppointmentList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Database db = new Database(requireContext());
                Intent intent = new Intent(getActivity(), act_AppointmentList.class);
                // get lawyer information
                Lawyer loggedLawyer = db.getLawyerInfo(lawyerID);
                //pass the identification and the username in the act_Start
                intent.putExtra("lawyer_identification", loggedLawyer.getIdentification());

                startActivity(intent);
            }
        });


        return view;
    }
}