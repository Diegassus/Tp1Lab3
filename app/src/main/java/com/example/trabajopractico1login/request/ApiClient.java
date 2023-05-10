package com.example.trabajopractico1login.request;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.trabajopractico1login.model.Usuario;

public class ApiClient {
    private static SharedPreferences sp;

    private static SharedPreferences conectar (Context context){
        if(sp == null){
            sp = context.getSharedPreferences("datos", Context.MODE_PRIVATE);
        }
        return sp;
    }

    public static void guardar(Context context, Usuario usuario){
        SharedPreferences sp = conectar(context);
        SharedPreferences.Editor editor = sp.edit();
        editor.putLong("dni", usuario.getDni());
        editor.putString("nombre", usuario.getNombre());
        editor.putString("apellido", usuario.getApellido());
        editor.putString("email", usuario.getEmail());
        editor.putString("password", usuario.getPassword());
        editor.commit();
    }

    public static Usuario leer(Context context){
        SharedPreferences sp = conectar(context);
        Long dni = sp.getLong("dni", -1);
        String nombre = sp.getString("nombre", "nn");
        String apellido = sp.getString("apellido", "nn");
        String email = sp.getString("email", "nn");
        String password = sp.getString("password", "nn");
        return new Usuario(dni, nombre, apellido, email, password);
    }

    public static Usuario login(Context context, String mail, String pass){
        SharedPreferences sp = conectar(context);
        Long dni = sp.getLong("dni", -1);
        String nombre = sp.getString("nombre", "nn");
        String apellido = sp.getString("apellido", "nn");
        String email = sp.getString("email", "nn");
        String password = sp.getString("password", "nn");

        if(email.equals(mail) && password.equals(pass)){
            return new Usuario(dni, nombre, apellido, email, password);
        }
        return null;
    }
}
