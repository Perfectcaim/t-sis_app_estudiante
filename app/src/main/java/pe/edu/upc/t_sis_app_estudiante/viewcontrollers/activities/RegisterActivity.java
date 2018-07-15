package pe.edu.upc.t_sis_app_estudiante.viewcontrollers.activities;

import android.app.PendingIntent;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Base64;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.content.Intent;
import android.view.View;
import android.net.Uri;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.Map;

import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.util.Log;
import android.widget.Toast;

import pe.edu.upc.t_sis_app_estudiante.R;
import pe.edu.upc.t_sis_app_estudiante.models.Advisor;
import pe.edu.upc.t_sis_app_estudiante.models.Student;
import pe.edu.upc.t_sis_app_estudiante.viewcontrollers.Interface.StudentInterface;
import pe.edu.upc.t_sis_app_estudiante.viewcontrollers.clases.PhotoUtils;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class RegisterActivity extends AppCompatActivity  implements View.OnClickListener {
    private AlertDialog _photoDialog;
    private Uri mImageUri;
    private static final int ACTIVITY_SELECT_IMAGE = 1020, ACTIVITY_SELECT_FROM_CAMERA = 1040, ACTIVITY_SHARE = 1030;
    private PhotoUtils photoUtils;
    private ImageView pictureImageView;
    private boolean fromShare = false;
    private Button button_registrar;
    private TextInputLayout impdni, impphone, impname, implastname, impemail, imppassword, imppassword2, impadress;
    private EditText txtdni, txtphone, txtname, txtlastname, txtemail, txtpassword, txtpassword2, txtadress;
    AlertDialog alert = null;
    private SharedPreferences pref_maps;
    private String strImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        pictureImageView = (ImageView) findViewById(R.id.pictureImageView);
        button_registrar = (Button) findViewById(R.id.button_registrar);

        button_registrar.setOnClickListener(this);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RegisterActivity.this.onBackPressed();
            }
        });

        photoUtils = new PhotoUtils(this);
        // Get intent, action and MIME type
        Intent intent = getIntent();
        String action = intent.getAction();
        String type = intent.getType();
        if (Intent.ACTION_SEND.equals(action) && type != null) {
            if ("text/plain".equals(type)) {
                fromShare = true;
            } else if (type.startsWith("image/")) {
                fromShare = true;
                mImageUri = (Uri) intent
                        .getParcelableExtra(Intent.EXTRA_STREAM);
                getImage(mImageUri);
            }
        }
        pictureImageView = (ImageView) findViewById(R.id.pictureImageView);
        getPhotoDialog();
        setPhotoButton();
    }

    private void setPhotoButton() {
        pictureImageView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (!getPhotoDialog().isShowing() && !isFinishing())
                    getPhotoDialog().show();
            }
        });
    }

    private AlertDialog getPhotoDialog() {
        if (_photoDialog == null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
            builder.setTitle(R.string.photo_source);
            builder.setPositiveButton(R.string.camera, new DialogInterface.OnClickListener() {
                //CAMARA
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent intent = new Intent(
                            "android.media.action.IMAGE_CAPTURE");
                    File photo = null;
                    try {
                        // place where to store camera taken picture
                        photo = PhotoUtils.createTemporaryFile("picture", ".jpg", RegisterActivity.this);
                        photo.delete();
                    } catch (Exception e) {
                        Log.v(getClass().getSimpleName(),
                                "Can't create file to take picture!");
                    }
                    mImageUri = Uri.fromFile(photo);
                    intent.putExtra(MediaStore.EXTRA_OUTPUT, mImageUri);
                    startActivityForResult(intent, ACTIVITY_SELECT_FROM_CAMERA);
                }
            });
            builder.setNegativeButton(R.string.gallery, new DialogInterface.OnClickListener() {
                //GALERIA
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent galleryIntent = new Intent(Intent.ACTION_GET_CONTENT);
                    galleryIntent.setType("image/*");
                    startActivityForResult(galleryIntent, ACTIVITY_SELECT_IMAGE);
                }
            });
            _photoDialog = builder.create();
        }
        return _photoDialog;
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (mImageUri != null)
            outState.putString("Uri", mImageUri.toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState.containsKey("Uri")) {
            mImageUri = Uri.parse(savedInstanceState.getString("Uri"));
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == ACTIVITY_SELECT_IMAGE && resultCode == RESULT_OK) {
            mImageUri = data.getData();
            getImage(mImageUri);
        } else if (requestCode == ACTIVITY_SELECT_FROM_CAMERA && resultCode == RESULT_OK) {
            getImage(mImageUri);
        }
    }

    private void setImageBitmap(Bitmap bitmap) {
        pictureImageView.setImageBitmap(bitmap);
    }

    public static String convert(Bitmap bitmap)
    {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStream);
        return Base64.encodeToString(outputStream.toByteArray(), Base64.DEFAULT);
    }

    public void getImage(Uri uri) {
        Bitmap bounds = photoUtils.getImage(uri);
        if (bounds != null) {
            strImage = convert(bounds);
            setImageBitmap(bounds);
        }
    }

    public String ConvertImageToString(){
        pictureImageView.buildDrawingCache();
        Bitmap bitmap = pictureImageView.getDrawingCache();

        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 90, stream);
        byte[] image = stream.toByteArray();
        String strIma = Base64.encodeToString(image, 0);
        return strIma;
    }

    public boolean ValidarCamposRegistroUsuario(){
        txtdni = (EditText) findViewById(R.id.dniTextView);
        txtphone = (EditText) findViewById(R.id.phoneTextView);
        txtname = (EditText) findViewById(R.id.nameTextView);
        txtlastname = (EditText) findViewById(R.id.lastnameTextView);
        txtemail = (EditText) findViewById(R.id.correoTextView);
        txtpassword = (EditText) findViewById(R.id.passwordTextView);
        txtadress = (EditText) findViewById(R.id.directionTextView);
        txtpassword2 = (EditText) findViewById(R.id.password2TextView);

        impdni = (TextInputLayout) findViewById(R.id.impDni);
        impphone = (TextInputLayout) findViewById(R.id.impPhone);
        impname = (TextInputLayout) findViewById(R.id.impName);
        implastname = (TextInputLayout) findViewById(R.id.impLastName);
        impemail = (TextInputLayout) findViewById(R.id.impCorreo);
        imppassword = (TextInputLayout) findViewById(R.id.impPassword);
        imppassword2 = (TextInputLayout) findViewById(R.id.impPassword2);
        impadress = (TextInputLayout) findViewById(R.id.impdirection);

        if (txtdni.getText().toString().isEmpty() || txtdni.length() < 8){
            impdni.setError("DNI invalido");
            return false;
        }else if (txtphone.getText().toString().isEmpty() || txtphone.length() < 9){
            impphone.setError("Telefono invalido");
            return false;
        }else if (txtname.getText().toString().isEmpty()){
            impname.setError("Nombre invalido");
            return false;
        }else if (txtlastname.getText().toString().isEmpty()){
            implastname.setError("Apellidos invalido");
            return false;
        }else if(Patterns.EMAIL_ADDRESS.matcher(txtemail.getText().toString()).matches()==false){
            impemail.setError("Correo invalido");
            return false;
        }else if(txtpassword.getText().toString().isEmpty()){
            imppassword.setError("Contraseña invalido");
            return false;
        }else if(txtpassword2.getText().toString().isEmpty()){
            imppassword2.setError("Confirmar contraseña invalido");
            return false;
        }else if(!txtpassword.getText().toString().equals(txtpassword2.getText().toString())){
            imppassword2.setError("La contraseña deben coincidir");
            return false;
        }else if (txtadress.getText().toString().isEmpty()){
            impadress.setError("Dirección invalido");
            return false;
        }else{
            return true;
        }
    }

    private void registerUser(){
        RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint("http://t-sys-kennygonzales.c9users.io").build();
        StudentInterface servicio = restAdapter.create(StudentInterface.class);
        Student student = new Student(
                txtdni.getText().toString(),
                txtemail.getText().toString(),
                txtpassword.getText().toString(),
                txtname.getText().toString(),
                txtlastname.getText().toString(),
                txtadress.getText().toString(),
                txtphone.getText().toString(),
                0,
                "",
                strImage);

        servicio.RegisterStudent(student, new Callback<Student>() {
            @Override
            public void success(Student student2, Response response) {
                new AlertDialog.Builder(RegisterActivity.this)
                        .setTitle("Alerta: Registro Asesor")
                        .setMessage("El asesor fue registrado correctamente.")
                        .setNegativeButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        })
                        .show();
            }
            @Override
            public void failure(RetrofitError error) {
                new AlertDialog.Builder(RegisterActivity.this)
                        .setTitle("Alerta: Registro Asesor")
                        .setMessage("El correo o dni que ha ingresado ya se encuentra registrado, por favor valide los campos.")
                        .setNegativeButton("OK", null)
                        .show();
            }
        });
    }


    @Override
    public void onClick(View v) {
        if (ValidarCamposRegistroUsuario() == true) {
            registerUser();
        }
    }
}
