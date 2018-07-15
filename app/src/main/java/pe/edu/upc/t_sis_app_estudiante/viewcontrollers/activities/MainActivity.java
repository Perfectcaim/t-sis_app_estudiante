package pe.edu.upc.t_sis_app_estudiante.viewcontrollers.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;
import pe.edu.upc.t_sis_app_estudiante.R;
import pe.edu.upc.t_sis_app_estudiante.models.Student;
import pe.edu.upc.t_sis_app_estudiante.viewcontrollers.Interface.StudentInterface;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView correoTextView;
    TextView passwordTextView;
    TextView texto2TextView, textErrorTextView;
    Button button_inicio;
    CheckBox chkGuardarCredenciales;
    private SharedPreferences prefs;
    private SharedPreferences SessionStudent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        prefs = getSharedPreferences("PreferencesStudent", Context.MODE_PRIVATE);
        SessionStudent = getSharedPreferences("SessionStudent", Context.MODE_PRIVATE);

        if (ValidarUsuarioLogueado()) {
            Intent myMenu = new Intent(this, MenuActivity.class);
            startActivity(myMenu);
            finish();
        } else {
            correoTextView = (TextView) findViewById(R.id.correoTextView);
            passwordTextView = (TextView) findViewById(R.id.passwordTextView);
            texto2TextView = (TextView) findViewById(R.id.texto2TextView);
            textErrorTextView = (TextView) findViewById(R.id.textErrorTextView);
            button_inicio = (Button) findViewById(R.id.button_inicio);
            chkGuardarCredenciales = (CheckBox) findViewById(R.id.chkGuardarCredenciales);

            button_inicio.setOnClickListener(this);

            texto2TextView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View viewIn) {
                    try {
                        Intent myRegister = new Intent(MainActivity.this, RegisterActivity.class);
                        startActivity(myRegister);
                    } catch (Exception except) {
                        Toast.makeText(MainActivity.this, except.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void GuardarCredenciales(String email, String Password){
        if(chkGuardarCredenciales.isChecked()){
            SharedPreferences.Editor edit = prefs.edit();
            edit.putString("email", email);
            edit.putString("password", Password);
            edit.apply();
        }
    }

    private void GuardarDatosSession(Student oStudent) {
        SharedPreferences.Editor edit = SessionStudent.edit();
        edit.putString("dni", oStudent.getDni());
        edit.putString("name", oStudent.getName());
        edit.putString("lastName", oStudent.getLastname());
        edit.putString("email", oStudent.getEmail());
        edit.putString("direction", oStudent.getAddress());
        edit.putString("password", oStudent.getPassword());
        edit.putString("phone", oStudent.getPhone());
        edit.putString("token", oStudent.getToken());
        edit.putInt("status", oStudent.getStatus());
        edit.putString("picture", oStudent.getPicture());
        edit.apply();
    }

    private void LoginUser(){
        RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint("http://t-sys-kennygonzales.c9users.io").build();
        StudentInterface servicio = restAdapter.create(StudentInterface.class);
        Student student = new Student(
                correoTextView.getText().toString(),
                passwordTextView.getText().toString());
        servicio.LoginUser(student, new Callback<Student>() {

            @Override
            public void success(Student student2, Response response) {
                GuardarDatosSession(student2);
                GuardarCredenciales(correoTextView.getText().toString(), passwordTextView.getText().toString());
                Intent myLogin = new Intent(MainActivity.this, MenuActivity.class);
                myLogin.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(myLogin);
            }
            @Override
            public void failure(RetrofitError error) {
                textErrorTextView.setText("El email o el password ingresads son incorrectos.");
            }
        });
    }

    private boolean ValidarUsuarioLogueado(){
        if (SessionStudent.getString("token", "").isEmpty()){
            return false;
        }else{
            return true;
        }
    }

    private boolean ValidarCamposLogin(){
        if (correoTextView.getText().toString().isEmpty()){
            textErrorTextView.setText("El email o el password ingresads son incorrectos.");
            return false;
        }else if (passwordTextView.getText().toString().isEmpty()){
            textErrorTextView.setText("El email o el password ingresads son incorrectos.");
            return false;
        }else{
            return true;
        }
    }

    @Override
    public void onClick(View viewIn) {
        try {
            if(ValidarCamposLogin()) {
                LoginUser();
            }
        } catch (Exception except) {
            Toast.makeText(MainActivity.this, except.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
