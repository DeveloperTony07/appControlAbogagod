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
 * Use the {@link frm_Register3#newInstance} factory method to
 * create an instance of this fragment.
 */
public class frm_Register3 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public frm_Register3() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment frm_Register3.
     */
    // TODO: Rename and change types and number of parameters
    public static frm_Register3 newInstance(String param1, String param2) {
        frm_Register3 fragment = new frm_Register3();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflar el diseño del fragmento
        View view = inflater.inflate(R.layout.frm_register3, container, false);

        // Obtener una referencia al botón btnBackRegister
        Button btnBackRegister2 = view.findViewById(R.id.btnBackRegister2);

        // Establecer un OnClickListener para el botón
        btnBackRegister2.setOnClickListener(new View.OnClickListener() {
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