package pe.edu.upc.t_sis_app_estudiante.viewcontrollers.fragments;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import pe.edu.upc.t_sis_app_estudiante.R;
import pe.edu.upc.t_sis_app_estudiante.viewcontrollers.activities.MainActivity;
import pe.edu.upc.t_sis_app_estudiante.viewcontrollers.activities.UpdateActivity;

public class PerfilFragment extends Fragment  implements View.OnClickListener {
    private SharedPreferences pref_Session;
    TextView txtCerrarSesionTextView, txtNameTextView, txtemailTextView, txtPhoneTextView, txtdirectionTextView;
    Button button_editar;
    private ImageView pictureImageView;
    private String strImage;

    public PerfilFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_perfil, container, false);
        pref_Session = this.getActivity().getSharedPreferences("SessionStudent", Context.MODE_PRIVATE);

        pictureImageView = (ImageView) view.findViewById(R.id.pictureImageView);
        button_editar = (Button) view.findViewById(R.id.button_editar);
        txtCerrarSesionTextView = (TextView) view.findViewById(R.id.txtCerrarSesionTextView);
        txtNameTextView = (TextView) view.findViewById(R.id.txtNameTextView);
        txtemailTextView = (TextView) view.findViewById(R.id.txtemailTextView);
        txtPhoneTextView = (TextView) view.findViewById(R.id.txtPhoneTextView);
        txtdirectionTextView = (TextView) view.findViewById(R.id.txtdirectionTextView);
        strImage = pref_Session.getString("picture", "");

        CargarImage(strImage);
        txtCerrarSesionTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CerrarSesion();
                RegresarLogin();
            }
        });

        button_editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), UpdateActivity.class);
                startActivity(intent);
            }
        });

        CargarDatosStudent();
        return view;
    }


    private void CargarImage(String strImage){
        //decode base64 string to image====================================================================================
        byte[]  imageBytes = Base64.decode(strImage, Base64.DEFAULT);
        Bitmap decodedImage = BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.length);
        pictureImageView.setImageBitmap(decodedImage);
    }


    private void RegresarLogin(){
        Intent myLogin = new Intent(getActivity().getApplicationContext(), MainActivity.class);
        myLogin.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(myLogin);
    }

    private void CerrarSesion(){
        pref_Session.edit().clear().apply();
    }

    private void CargarDatosStudent(){
        txtNameTextView.setText(pref_Session.getString("name", "") + " " + pref_Session.getString("lastName", ""));
        txtemailTextView.setText(pref_Session.getString("email", "") );
        txtPhoneTextView.setText(pref_Session.getString("phone", "") );
        txtdirectionTextView.setText(pref_Session.getString("direction", "") );
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onClick(View v) {
        getActivity().onBackPressed();
    }
}
