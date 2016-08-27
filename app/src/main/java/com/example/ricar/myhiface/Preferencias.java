package com.example.ricar.myhiface;

import android.content.Context;
import android.content.SharedPreferences;

public class Preferencias {


        Context NewContext;
        private SharedPreferences Configuracion;
        private SharedPreferences.Editor editConfiguracion;

        public Preferencias(Context ElContext) {
            NewContext = ElContext;
            Configuracion = NewContext.getSharedPreferences("Configuracion", NewContext.MODE_PRIVATE);
            editConfiguracion = Configuracion.edit();
        }

        public Preferencias() {
        }

        public void Guardar(String Informacion) {
            editConfiguracion.putString("Informacion", Informacion);
            editConfiguracion.commit();
        }

        public String CargarConfig() {
            String Informacion = "Bienvenidos";

            SharedPreferences cargar = NewContext.getSharedPreferences("Configuracion", NewContext.MODE_PRIVATE);
            Informacion = cargar.getString("Informacion", " ");

            return Informacion;
        }
    }
