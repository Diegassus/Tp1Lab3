package com.example.trabajopractico1login.request;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.trabajopractico1login.model.Usuario;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ApiClient {
    private static File archivo;

    private static File conectar (File dir){
        if(archivo == null){
            archivo=new File(dir,"personal.dat");
        }
        return archivo;
    }

    public static void guardar(Context context, Usuario usuario){
        File archivo=conectar(context.getFilesDir());
        try {
            FileOutputStream fos = new FileOutputStream(archivo);
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(usuario);
            bos.flush();
            oos.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Usuario leer(Context context){
        File archivo = conectar(context.getFilesDir());
        try{
            FileInputStream fis=new FileInputStream(archivo);
            BufferedInputStream bis=new BufferedInputStream(fis);
            ObjectInputStream ois=new ObjectInputStream(bis);
            Usuario miUsuario=(Usuario)ois.readObject();
            ois.close();

            return miUsuario;
        }catch (FileNotFoundException e){
            return null;
        }catch (IOException e){
            return null;
        }catch (ClassNotFoundException e){
            return null;
        }
    }

    public static Usuario login(Context context, String mail, String pass){
        File archivo = conectar(context.getFilesDir());
        try{
            FileInputStream fis=new FileInputStream(archivo);
            BufferedInputStream bis=new BufferedInputStream(fis);
            ObjectInputStream ois=new ObjectInputStream(bis);
            Usuario miUsuario=(Usuario)ois.readObject();
            ois.close();

            if(miUsuario.getEmail().equals(mail) && miUsuario.getPassword().equals(pass)){
                return miUsuario;
            }
            return null;
        }catch (FileNotFoundException e){
            return null;
        }catch (IOException e){
            return null;
        }catch (ClassNotFoundException e){
            return null;
        }
    }

}
