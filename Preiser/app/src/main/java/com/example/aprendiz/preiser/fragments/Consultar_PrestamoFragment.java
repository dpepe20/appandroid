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
import com.example.aprendiz.preiser.adaptadors.Adaptador_Consultas_Prestamo;
import com.example.aprendiz.preiser.clases.Detalles;
import com.example.aprendiz.preiser.clases.Prestamo;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class Consultar_PrestamoFragment extends Fragment {
    RecyclerView recyclerView;
    List<Prestamo> prestamoList;
    View view;
    EditText edtbuscar;
    Button buscar;
    int count = 0;


    public Consultar_PrestamoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =  inflater.inflate(R.layout.fragment_consultar_prestamo, container, false);
        recyclerView = view.findViewById(R.id.recyclerV2);
        edtbuscar = view.findViewById(R.id.edtBuscar);
        buscar = view.findViewById(R.id.btnBuscar);

        buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<Prestamo> listaBusqueda = new ArrayList<>();
                String busqueda = edtbuscar.getText().toString();
                    int count=0;
                    if(edtbuscar.getText().toString().isEmpty()){
                        Toast.makeText(getContext(), "Campo Vacio", Toast.LENGTH_SHORT).show();
                    }else {
                        for (Prestamo prestamo : prestamoList) {
                            if (prestamo.getAprendiz().getNombre().toLowerCase().contains(busqueda.toLowerCase())) {
                                listaBusqueda.add(prestamo);
                                count = 1;
                            }
                        }
                        inputAdapter(listaBusqueda);
                        edtbuscar.setText("");
                        if (count==0){
                            Toast.makeText(getContext(), "No Existe Registro", Toast.LENGTH_SHORT).show();
                        }
                    }

                }
        });
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        String url = "https://preiser-app.herokuapp.com/api/Prestamo/";
        RequestQueue colaSolicitudes = Volley.newRequestQueue(getContext());
        StringRequest solicitud = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                //<<<Para recibir muchos objetos en una lista>>>------------------------------------------------------------
                Gson gson = new Gson();
                Type mainactivity = new TypeToken<Collection<Prestamo>>(){}.getType();
                prestamoList =gson.fromJson(response,mainactivity);
                if(prestamoList.size()>0) {
                    inputAdapter(prestamoList);
                }else{
                    Toast.makeText(getContext(), "PRESTAMO DEL APRENDIZ NO REGISTRADO", Toast.LENGTH_SHORT).show();
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

    private void inputAdapter(final List<Prestamo> list) {
        Adaptador_Consultas_Prestamo adaptador_consultas = new Adaptador_Consultas_Prestamo(list,getContext());
        recyclerView.setAdapter(adaptador_consultas);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));

        adaptador_consultas.setMlistener(new Adaptador_Consultas_Prestamo.OnClickItem() {
            @Override
            public void ItemClick(int position) {
                DetallesActivity.prestamolist = list.get(position);
                Intent intent = new Intent(getContext(),DetallesActivity.class);
                startActivity(intent);
            }
        });
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
            if(prestamoList.size()==prestamoList.size()) {
                Toast.makeText(getContext(), "NO SE HAN AGREGADO PRESTAMOS", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(getContext(), "LISTA ACTUALIZADA", Toast.LENGTH_SHORT).show();
            }
        }
        return super.onOptionsItemSelected(item);
    }
}
