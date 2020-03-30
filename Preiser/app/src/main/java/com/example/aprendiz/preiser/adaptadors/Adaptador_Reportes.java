package com.example.aprendiz.preiser.adaptadors;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.aprendiz.preiser.R;
import com.example.aprendiz.preiser.clases.Prestamo;

import java.util.ArrayList;
import java.util.List;

public class Adaptador_Reportes extends RecyclerView.Adapter<Adaptador_Reportes.Holder> {
    List<Prestamo> list = new ArrayList<>();
    Context context;


    public Adaptador_Reportes(List<Prestamo> list, Context context) {
        this.list = list;
        this.context = context;
    }


    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        Holder holder = new Holder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.fijaDatos(list.get(position));

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        public Holder(View itemView) {
            super(itemView);
        }

        public void fijaDatos(Prestamo prestamo) {
            TextView id,nombre_Aprendiz, elemento, ficha, estado;

            nombre_Aprendiz = itemView.findViewById(R.id.nombre_aprendiz);
            elemento = itemView.findViewById(R.id.txtelementoE);
            ficha = itemView.findViewById(R.id.txtFicha);
            id = itemView.findViewById(R.id.txtID);
            estado = itemView.findViewById(R.id.txtestado);

            nombre_Aprendiz.setText("Nombre: "+prestamo.getAprendiz().getNombre());
            elemento.setText("Elemento: "+prestamo.getDetalles().get(0).getMaterial().getNombre().getNombre());
            ficha.setText("Ficha: "+prestamo.getAprendiz().getFicha().get(0).getNumero_ficha());
            id.setText("Id: "+prestamo.getId());
            estado.setText("Estado: "+prestamo.getEstado());

        }
    }
}
