package es.com.blogspot.httpagenda_universitaria_etsiit.agendauniversitaria;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


/**
 * Created by alejandro on 5/03/16.
 */


public class Asignatura{


    private String nombre;
    private String abreviatura;
    private String aula;


    public Asignatura(String nombre, String abreviatura, String aula){
        this.nombre = nombre;
        this.abreviatura = abreviatura;
        this.aula = aula;
    }

    public String get_nombre(){
        return this.nombre;
    }

    public String get_abreviatura(){
        return this.abreviatura;
    }

    public String get_aula(){
        return this.aula;
    }

    public void to_string(){
        System.out.println("Nombre: " + this.nombre + " Abreviatura: " + this.abreviatura + " Aula: " + this.aula );
    }

}
