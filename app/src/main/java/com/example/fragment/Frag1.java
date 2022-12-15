package com.example.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class Frag1 extends Fragment {
    EnvoyerData envoyerData;

    public interface EnvoyerData{
        public Void envoyerMessage(String message);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        envoyerData = (EnvoyerData) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_frag1, container, false);
        Button b = view.findViewById(R.id.btn_envoyer);
        EditText z = view.findViewById(R.id.z_msg);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                envoyerData.envoyerMessage(z.getText().toString());
            }
        });
        return view;
    }
}