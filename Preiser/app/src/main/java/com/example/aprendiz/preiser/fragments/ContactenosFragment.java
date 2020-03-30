package com.example.aprendiz.preiser.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.aprendiz.preiser.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ContactenosFragment extends Fragment {

    private EditText nombre;

    private EditText mensaje;
    private Button enviar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_contactenos, container, false);
    }



    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        nombre = view.findViewById(R.id.TextInputNombre);
        mensaje = view.findViewById(R.id.TextInputMensaje);
        enviar = view.findViewById(R.id.btnEnviar);

        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(nombre.getText().toString().isEmpty()||mensaje.getText().toString().isEmpty())
                {
                    Toast.makeText(getContext(), "Los Campos deben estar Diligenciados", Toast.LENGTH_SHORT).show();
                }else{
                    enviaremail();
                }
                nombre.setText("");
                mensaje.setText("");
            }
        });
    }

    private void enviaremail() {

        String recipienteList = nombre.getText().toString();
        String[] recipientes= recipienteList.split(",");

        String nombres = nombre.getText().toString();
        String mensajes = mensaje.getText().toString();

        Intent intent = new Intent(Intent.ACTION_SEND);
        // va el correo de preiser

        String correo[]={"preiserapp@gmail.com"};
       // intent.putExtra(Intent.EXTRA_EMAIL,correo);
        intent.putExtra(Intent.EXTRA_SUBJECT,nombres);
        intent.putExtra(Intent.EXTRA_TEXT,mensajes);

        intent.setType("massage/rfc822");
        startActivity(Intent.createChooser(intent,"Choose an email client"));


    }
}


