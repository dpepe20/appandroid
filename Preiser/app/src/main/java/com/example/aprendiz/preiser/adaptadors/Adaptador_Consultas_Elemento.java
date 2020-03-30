package com.example.aprendiz.preiser.adaptadors;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.aprendiz.preiser.Detalles_Elemento;
import com.example.aprendiz.preiser.R;
import com.example.aprendiz.preiser.clases.Bodega_Material;
import com.example.aprendiz.preiser.clases.Prestamo;

import java.util.ArrayList;
import java.util.List;


public class Adaptador_Consultas_Elemento extends RecyclerView.Adapter<Adaptador_Consultas_Elemento.Holder> {
    List<Bodega_Material> bodega_materialList = new ArrayList<>();
    Context context;
    private OnClickItem2 mlistener2;
    public interface OnClickItem2{
        void ItemClick(int position);
    }

    public void setMlistener2(OnClickItem2 mlistener2) {
        this.mlistener2 = mlistener2;
    }

    public Adaptador_Consultas_Elemento(List<Bodega_Material> bodega_materialList, Context context) {
        this.bodega_materialList = bodega_materialList;
        this.context = context;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_consultar_elemento,parent,false);
        Holder holder = new Holder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        holder.fiijaDatos(bodega_materialList.get(position));

    }

    @Override
    public int getItemCount() {
        return bodega_materialList.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        public Holder(View itemView) {
            super(itemView);
        }

        public void fiijaDatos(Bodega_Material bodega_material) {
            TextView elemento;
            Button detalles;

            elemento=itemView.findViewById(R.id.txtelementoE);
            detalles=itemView.findViewById(R.id.btndetalles_elemento);

            elemento.setText(bodega_material.getMaterial().getNombre().getNombre());

            detalles.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(Adaptador_Consultas_Elemento.this.mlistener2 != null){
                        int position = getLayoutPosition();
                        if(position != RecyclerView.NO_POSITION){
                            Adaptador_Consultas_Elemento.this.mlistener2.ItemClick(position);
                        }
                    }
                }
            });
        }
    }
}
