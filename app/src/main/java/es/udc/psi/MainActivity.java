package es.udc.psi;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.net.URL;


public class MainActivity extends AppCompatActivity implements TopFragment.OnTopFragmlistener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        Bundle bundle = new Bundle();

        TopFragment topFragment = new TopFragment();
        DownFragment downFragment = new DownFragment();
        downFragment.setArguments(bundle);

        fragmentTransaction.replace(R.id.cm_content_frame_top, topFragment);
        fragmentTransaction.replace(R.id.cm_content_frame_bottom, downFragment);
        fragmentTransaction.commit();
    }

    @Override
    public void onTextSelected(String text) {
        //Log.d("_TAG",text);
        DownFragment downFragment = (DownFragment) getSupportFragmentManager().findFragmentById(R.id.cm_content_frame_bottom);
        if (downFragment != null) {
            downFragment.setText(text);
        }
    }

    @Override
    public void onUriSelected(URL url) {
        //Log.d("_TAG",text);
        DownFragment downFragment = (DownFragment) getSupportFragmentManager().findFragmentById(R.id.cm_content_frame_bottom);
        if (downFragment != null) {
            downFragment.loadUrl(url.toString());
        }
    }

    @Override
    public void onClearSelected() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        DownFragment downFragment = (DownFragment) fragmentManager.findFragmentById(R.id.cm_content_frame_bottom);

        if (downFragment != null) {
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.remove(downFragment).commit();
        }
    }

    @Override
    public void onBackPressed() {
        // Crea un AlertDialog.Builder
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("¿Desea salir de la aplicación?");

        builder.setMessage("¿Está seguro de que desea salir de la aplicación?");

        // Añade los botones "OK" y "Cancel"
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                Log.d("MainActivity", "Se ha pulsado el botón OK");
                Toast.makeText(MainActivity.this, "Se ha pulsado el botón OK", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                Log.d("MainActivity", "Se ha pulsado el botón Cancel");
                Toast.makeText(MainActivity.this, "Se ha pulsado el botón Cancel", Toast.LENGTH_SHORT).show();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

}