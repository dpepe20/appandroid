package com.example.aprendiz.preiser.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.aprendiz.preiser.DetallesActivity;
import com.example.aprendiz.preiser.Detalles_Elemento;
import com.example.aprendiz.preiser.R;
import com.example.aprendiz.preiser.adaptadors.Adaptador_Reportes;
import com.example.aprendiz.preiser.clases.Prestamo;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ReportesFragment extends Fragment {
    Button buscar;
    EditText edtbuscar;
    List<Prestamo> prestamos;
    RecyclerView recyclerView;
    View view;
    int count=0;


    public ReportesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_reportes, container, false);
        recyclerView = view.findViewById(R.id.recyclerV);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

            String url = "http://preiser-app.herokuapp.com/api/Prestamo/";
            RequestQueue colaSolicitudes = Volley.newRequestQueue(getContext());
            StringRequest solicitud = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    //<<<Para recibir muchos objetos en una lista>>>------------------------------------------------------------
                    Gson gson = new Gson();
                    Type mainactivity = new TypeToken<Collection<Prestamo>>(){}.getType();
                     prestamos =gson.fromJson(response,mainactivity);
                     if(prestamos.size()>0) {
                         inputAdapter(prestamos);
                     }else{
                         Toast.makeText(getContext(), "NO HAY REPORTES", Toast.LENGTH_SHORT).show();
                     }

                    //<<<Para recir a un objeto en especifico>>>-----------------------------------------------------------------
                    //prestamos = new ArrayList<>();
                    //prestamos.add(gson.fromJson(response,Prestamo.class));
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(getActivity(), "ERROR: "+error.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
            colaSolicitudes.add(solicitud);


    }

    private void inputAdapter(final List<Prestamo> lis) {
        Adaptador_Reportes adaptador = new Adaptador_Reportes(lis,getContext());
        recyclerView.setAdapter(adaptador);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.actualizar, menu);


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if(id == R.id.actualizar){
            onViewCreated(view,null);
            if(prestamos.size()==prestamos.size()) {
                Toast.makeText(getContext(), "NO SE HAN AGREGADO PRESTAMOS", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(getContext(), "LISTA ACTUALIZADA", Toast.LENGTH_SHORT).show();
            }
        }
        return super.onOptionsItemSelected(item);
    }
}
