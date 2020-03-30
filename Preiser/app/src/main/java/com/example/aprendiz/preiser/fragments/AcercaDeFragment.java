package com.example.aprendiz.preiser.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.aprendiz.preiser.adaptadors.AdaptadorAcercaDe;
import com.example.aprendiz.preiser.clases.InfoAcercaDe;
import com.example.aprendiz.preiser.R;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class AcercaDeFragment extends Fragment {
    List<InfoAcercaDe> infoAcercaDes;

    public AcercaDeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_acerca_de, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        infoAcercaDes = new ArrayList<>();
        infoAcercaDes.add(new InfoAcercaDe("Nombre: Alejandro","Equipo: Web","Telefono: 3216784536",R.drawable.alejadro));
        infoAcercaDes.add(new InfoAcercaDe("Nombre: Jhon","Equipo: Web","Telefono: 3117896534",R.drawable.hon));
        infoAcercaDes.add(new InfoAcercaDe("Nombre: Esteban","Equipo: Web","Telefono: 3116742290",R.drawable.toreto));
        infoAcercaDes.add(new InfoAcercaDe("Nombre: Maria","Equipo: Web","Telefono: 3173458970",R.drawable.maria));
        infoAcercaDes.add(new InfoAcercaDe("Nombre: Manuel","Equipo: Web","Telefono: 3148643982",R.drawable.manuel));
        infoAcercaDes.add(new InfoAcercaDe("Nombre: Carlos","Equipo: Web","Telefono: 320786394",R.drawable.carlos));
        infoAcercaDes.add(new InfoAcercaDe("Nombre: Johana","Equipo: Base de Datos","Telefono: 3137680123",R.drawable.q));
        infoAcercaDes.add(new InfoAcercaDe("Nombre: Darwin","Equipo: Base de ","Telefono: 3142895067",R.drawable.darwin));
        infoAcercaDes.add(new InfoAcercaDe("Nombre: Edwin","Equipo: Base de Datos","Telefono: 3152186753",R.drawable.edwin));
        infoAcercaDes.add(new InfoAcercaDe("Nombre: Victor","Equipo: Movil","Telefono: 3102895069",R.drawable.victor));
        infoAcercaDes.add(new InfoAcercaDe("Nombre: Cristian","Equipo: Movil","Telefono: 3218470947",R.drawable.cristian));
        infoAcercaDes.add(new InfoAcercaDe("Nombre: Harol","Equipo: Movil","Telefono: 3162895629",R.drawable.harol));
        infoAcercaDes.add(new InfoAcercaDe("Nombre: Yamid","Equipo: Diseño","Telefono: 3157894590",R.drawable.yamid));
        infoAcercaDes.add(new InfoAcercaDe("Nombre: Alexis","Equipo: Diseño","Telefono: 3205638921",R.drawable.alexis));
        infoAcercaDes.add(new InfoAcercaDe("Nombre: Sebastian","Equipo: Diseño","Telefono: 3168923167",R.drawable.carvajal));
        infoAcercaDes.add(new InfoAcercaDe("Nombre: Duvan","Equipo: Diseño","Telefono: 3184985027",R.drawable.duvan));
        infoAcercaDes.add(new InfoAcercaDe("Nombre: Maikol","Equipo: Diseño","Telefono: 3195296592",R.drawable.maikol));
        infoAcercaDes.add(new InfoAcercaDe("Nombre: Esteban","Equipo: Diseño","Telefono: 3206723472",R.drawable.millos));

        AdaptadorAcercaDe adaptadorAcercaDe= new AdaptadorAcercaDe(infoAcercaDes,getContext());
        RecyclerView recyclerView = view.findViewById(R.id.recyclerViewAcercaDe);
        recyclerView.setAdapter(adaptadorAcercaDe);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));

    }
}
