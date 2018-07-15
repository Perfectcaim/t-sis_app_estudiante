package pe.edu.upc.t_sis_app_estudiante.viewcontrollers.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import pe.edu.upc.t_sis_app_estudiante.R;

public class BuscarAsesorFragment extends Fragment {
    public BuscarAsesorFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_buscar_asesor, container, false);

        return view;
    }

}
