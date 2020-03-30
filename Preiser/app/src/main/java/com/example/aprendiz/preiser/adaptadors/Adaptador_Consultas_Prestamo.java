package com.example.aprendiz.preiser.adaptadors;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.aprendiz.preiser.R;
import com.example.aprendiz.preiser.clases.Prestamo;

import java.util.ArrayList;
import java.util.List;

public class Adaptador_Consultas_Prestamo extends RecyclerView.Adapter<Adaptador_Consultas_Prestamo.Holder> {
    List<Prestamo> lista = new ArrayList<>();
    Context context;
    private OnClickItem mlistener;
    public interface OnClickItem{
        void ItemClick(int position);
    }

    public void setMlistener(OnClickItem mlistener) {
        this.mlistener = mlistener;
    }

    public Adaptador_Consultas_Prestamo(List<Prestamo> lista, Context context) {
        this.lista = lista;
        this.context = context;
    }







    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_consultar_prestamo,parent,false);
        Holder holder = new Holder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        holder.fijarDatos(lista.get(position));

    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        public Holder(View itemView) {
            super(itemView);
        }

        public void fijarDatos(Prestamo prestamo) {
            TextView nombre_A,ficha;
            Button detalles;

            nombre_A = itemView.findViewById(R.id.txtnombre_A);
            ficha = itemView.findViewById(R.id.txtficha);
            detalles = itemView.findViewById(R.id.btndetalles);

            detalles.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(Adaptador_Consultas_Prestamo.this.mlistener != null){
                        int position = getLayoutPosition();
                        if(position != RecyclerView.NO_POSITION){
                            Adaptador_Consultas_Prestamo.this.mlistener.ItemClick(position);
                        }
                    }
                }
            });
            nombre_A.setText("Nombre: "+prestamo.getAprendiz().getNombre());
            ficha.setText("Ficha: "+prestamo.getAprendiz().getFicha().get(0).getNumero_ficha());
        }
    }
}
