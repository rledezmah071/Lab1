package com.example.ricar.myhiface;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class Ventana1 extends Activity implements View.OnClickListener {

    Button finalizar;

    ListView ListaZonas;

    ArrayAdapter<String> opciones;

    String[] ArrayZonas = new String[]{"Tangamandapio", "Ciudad Gótica", "Asgard"};

    String mensaje = "";

    Preferencias Preferencias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ventana1);

        finalizar = (Button) findViewById(R.id.finaliza);
        finalizar.setOnClickListener(this);


        ListaZonas = (ListView) findViewById(R.id.listView);

        ListaZonas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int laPosicion = position + 1;
                String elementoSeleccionado =
                        (String) ListaZonas.getItemAtPosition(position);
                Toast.makeText(getApplicationContext(), "Selecciono la zona geográfica: " +
                        laPosicion + ") " + elementoSeleccionado, Toast.LENGTH_LONG).show();
            }
        });
        opciones = new ArrayAdapter(this, android.R.layout.simple_list_item_1,
                ArrayZonas);
        ListaZonas.setAdapter(opciones);

        Preferencias = new Preferencias((getApplicationContext()));

        mensaje = Preferencias.CargarConfig();

        Toast Revision = Toast.makeText(getApplicationContext(),
                "usuario Guardado", Toast.LENGTH_LONG);
        Revision.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        Revision.show();

        Bundle losExtras = getIntent().getExtras();
        if (losExtras != null) {
            Toast.makeText(Ventana1.this, mensaje, Toast.LENGTH_LONG).show();
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.finaliza:
                Intent Final = new Intent(getApplicationContext(),Ventana2.class);
                startActivity(Final);
                break;
        }
    }//Fin onClick

}

