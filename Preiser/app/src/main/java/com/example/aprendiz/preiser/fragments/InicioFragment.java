package com.example.aprendiz.preiser.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.aprendiz.preiser.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class InicioFragment extends Fragment {
    View view;


    public InicioFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_inicio, container, false);

        return view;
    }

}
