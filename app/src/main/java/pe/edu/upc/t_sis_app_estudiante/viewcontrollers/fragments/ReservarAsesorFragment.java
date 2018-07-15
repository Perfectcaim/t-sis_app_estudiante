package pe.edu.upc.t_sis_app_estudiante.viewcontrollers.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import pe.edu.upc.t_sis_app_estudiante.R;
import pe.edu.upc.t_sis_app_estudiante.models.Student;

public class ReservarAsesorFragment extends Fragment  implements View.OnClickListener {
    private SharedPreferences pre_session;
    private EditText dniTextView;
    private Button btnFecha, btnRegistrar;

    public ReservarAsesorFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_reservar_asesor, container, false);

        pre_session=this.getActivity().getSharedPreferences("SessionStudent",Context.MODE_PRIVATE);
        dniTextView = view.findViewById(R.id.dniTextView);
        dniTextView.setText(pre_session.getString("dni", "") + " - " + pre_session.getString("name", "") + " " + pre_session.getString("lastName", ""));
        Student oStudent= new Student(pre_session.getString("dni", ""));
        dniTextView.setEnabled(false);
        dniTextView.setFocusable(false);
        dniTextView.setTextColor(Color.GRAY);
        btnRegistrar= view.findViewById(R.id.button_registrar);

        btnRegistrar.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {

    }
}
