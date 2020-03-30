package com.example.aprendiz.preiser.adaptadors;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.aprendiz.preiser.clases.InfoAcercaDe;
import com.example.aprendiz.preiser.R;

import java.util.List;

/**
 * Created by APRENDIZ on 16/11/2018.
 */

public class AdaptadorAcercaDe extends RecyclerView.Adapter<AdaptadorAcercaDe.Holder> {

    private List<InfoAcercaDe>infoAcercaDeList;
    Context context;

    public AdaptadorAcercaDe(List<InfoAcercaDe> infoAcercaDeList, Context context) {
        this.infoAcercaDeList = infoAcercaDeList;
        this.context = context;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_acercade,parent,false);
        Holder myholder = new Holder (view);
        return myholder;
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
    holder.filarcontenido(infoAcercaDeList.get(position));
    }

    @Override
    public int getItemCount() {
        return infoAcercaDeList.size();
    }

    public class Holder extends RecyclerView.ViewHolder {

        private TextView nombre;
        private TextView equipo;
        private TextView telefono;
        private ImageView imagen;

        public Holder(View itemView) {
            super(itemView);
            nombre=itemView.findViewById(R.id.TextNombre);
            equipo=itemView.findViewById(R.id.TextEquipo);
            telefono=itemView.findViewById(R.id.TextTelefono);
            imagen=itemView.findViewById(R.id.imageView);

        }

        public void filarcontenido(InfoAcercaDe infoAcercaDe) {
            nombre.setText(infoAcercaDe.getNombre());
            equipo.setText(infoAcercaDe.getEquipo());
            telefono.setText(infoAcercaDe.getTelefono());

            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inSampleSize=20;
            Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(),infoAcercaDe.getImg(),options);
            imagen.setImageBitmap(bitmap);

        }
    }
}
