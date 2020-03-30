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
import com.example.aprendiz.preiser.adaptadors.Adaptador_Consultas_Elemento;
import com.example.aprendiz.preiser.clases.Bodega_Material;
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
public class Consultar_ElementoFragment extends Fragment {
    View view;
    List<Prestamo> prestamoLista;
    List<Bodega_Material> list;
    RecyclerView recyclerViewElementos;
    EditText edtbuscarElemento;
    Button btnbuscarelemento;
    int count=0;


    public Consultar_ElementoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_consultar__elemento, container, false);

        edtbuscarElemento = view.findViewById(R.id.edtbuscarelemento);
        btnbuscarelemento = view.findViewById(R.id.btnbuscarelemento);
        recyclerViewElementos = view.findViewById(R.id.recyclerElementos);

        btnbuscarelemento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<Bodega_Material> listaBusqueda = new ArrayList<>();
                String busqueda = edtbuscarElemento.getText().toString();
                    int count=0;
                    if(edtbuscarElemento.getText().toString().isEmpty()){
                        Toast.makeText(getContext(), "Campo Vacio", Toast.LENGTH_SHORT).show();
                    }else {
                        for (Bodega_Material bodega_material : list) {
                            if (bodega_material.getMaterial().getNombre().getNombre().toLowerCase().contains(busqueda.toLowerCase())) {
                                listaBusqueda.add(bodega_material);
                                count = 1;
                            }
                        }
                        inputAdapter(listaBusqueda);
                        edtbuscarElemento.setText("");
                        if(count == 0){
                            Toast.makeText(getContext(), "No Existe Elemento", Toast.LENGTH_SHORT).show();
                        }
                    }

                }
        });
        return view;

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        consumirElemento();
        consumirPrestamo();

    }

    private void consumirPrestamo() {
        String url = "http://preiser-app.herokuapp.com/api/Prestamo/";
        RequestQueue colaSolicitudes = Volley.newRequestQueue(getContext());
        StringRequest solicitud = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                //<<<Para recibir muchos objetos en una lista>>>------------------------------------------------------------
                Gson gson = new Gson();
                Type mainactivity = new TypeToken<Collection<Prestamo>>(){}.getType();
                prestamoLista =gson.fromJson(response,mainactivity);

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

    private void consumirElemento() {
        String url = "https://preiser-app.herokuapp.com/api/Bodega_Material/";
        RequestQueue colaSolicitudes = Volley.newRequestQueue(getContext());
        StringRequest solicitud = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                Type mainactivity = new TypeToken<Collection<Bodega_Material>>(){}.getType();
                list =gson.fromJson(response,mainactivity);
                if(list.size()>0) {
                    inputAdapter(list);
                }else{
                    Toast.makeText(getContext(), "NO HAY REGISTRO DE ELEMENTOS", Toast.LENGTH_SHORT).show();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getActivity(), "ERROR", Toast.LENGTH_SHORT).show();

            }
        });
        colaSolicitudes.add(solicitud);
    }

    private void inputAdapter(final List<Bodega_Material> bodega_materialList){
        Adaptador_Consultas_Elemento adaptador_consultas_elemento = new Adaptador_Consultas_Elemento(bodega_materialList,getContext());
        recyclerViewElementos.setAdapter(adaptador_consultas_elemento);

        recyclerViewElementos.setHasFixedSize(true);
        recyclerViewElementos.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));

        adaptador_consultas_elemento.setMlistener2(new Adaptador_Consultas_Elemento.OnClickItem2() {
            @Override
            public void ItemClick(int position) {
                Detalles_Elemento.prestamolista = prestamoLista.get(0);
                Detalles_Elemento.bodega_materialList = bodega_materialList.get(position);
                Intent intent = new Intent(getContext(),Detalles_Elemento.class);
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
            if(list.size()==list.size()) {
                Toast.makeText(getContext(), "NO SE HAN AGREGADO ELEMENTOS", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(getContext(), "LISTA ACTUALIZADA", Toast.LENGTH_SHORT).show();
            }
        }
        return super.onOptionsItemSelected(item);
    }
}
