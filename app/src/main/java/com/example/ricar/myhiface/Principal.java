package com.example.ricar.myhiface;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Principal extends Activity implements View.OnClickListener {
    Button inicio;
    EditText usuario;
    EditText Contrasena;
    Preferencias Preferencias; //Instancia de la clase

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        Preferencias = new Preferencias(getApplicationContext()); //Iniciamos la instancia

        inicio = (Button) findViewById(R.id.Inicio);
        inicio.setOnClickListener(this);
        usuario = (EditText) findViewById(R.id.usuarioText);
        Contrasena=(EditText)findViewById(R.id.contrasenaText);
        Contrasena.setOnClickListener(this);
    }

    @Override
    public void  onClick(View v){
        switch (v.getId()){
            case R.id.Inicio:
                String datos = usuario.getText().toString();
                Preferencias.Guardar("Datos guardados");

                Intent intent = new Intent(getApplicationContext(),Ventana1.class);
                intent.putExtra("usuario", datos);
                startActivity(intent);
                break;
        }
    }
}
