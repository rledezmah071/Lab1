package com.example.ricar.myhiface;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;



    public class Ventana2 extends Activity implements View.OnClickListener{

        TextView usuario;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_ventana2);

            usuario = (TextView) findViewById(R.id.usuarioText);

            Intent intent = getIntent();
            Bundle extras = intent.getExtras();

            if (extras != null) {
                String dato = extras.getString("usuario");
                usuario.setText(dato);

            }


        }

        @Override
        public void onClick(View v) {

        }
    }
