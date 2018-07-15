package pe.edu.upc.t_sis_app_estudiante.viewcontrollers.activities;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import pe.edu.upc.t_sis_app_estudiante.R;
import pe.edu.upc.t_sis_app_estudiante.viewcontrollers.fragments.BuscarAsesorFragment;
import pe.edu.upc.t_sis_app_estudiante.viewcontrollers.fragments.HistorialFragment;
import pe.edu.upc.t_sis_app_estudiante.viewcontrollers.fragments.PerfilFragment;
import pe.edu.upc.t_sis_app_estudiante.viewcontrollers.fragments.ReservarAsesorFragment;

public class MenuActivity extends AppCompatActivity {

    private TextView mTextMessage;
    private SharedPreferences pref_Session;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            return navigateTo(item);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navigateTo(navigation.getMenu().findItem(R.id.navigation_perfil));

        pref_Session = getSharedPreferences("SessionUser", Context.MODE_PRIVATE);
    }

    private Fragment getFragmentFor(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.navigation_perfil:
                return new PerfilFragment();
            case R.id.navigation_buscar:
                return new BuscarAsesorFragment();
            case R.id.navigation_reservar:
                return new ReservarAsesorFragment();
            case R.id.navigation_historial:
                return new HistorialFragment();
        }
        return null;
    }

    private boolean navigateTo(MenuItem item) {
        item.setChecked(true);
        return getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.contentFrameLayout, getFragmentFor(item))
                .commit() > 0;
    }

}

