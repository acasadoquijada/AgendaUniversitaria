package es.com.blogspot.httpagenda_universitaria_etsiit.agendauniversitaria;

import android.app.ExpandableListActivity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


/**
 * Created by alejandro on 5/03/16.
 */


public class Prueba_BD extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "agendas.db";
    public static final String TABLA_ASIGNATURAS = "asignaturas";
    public static final String COLUMNA_ID = "_id";
    public static final String COLUMNA_NOMBRE = "nombre";
    public static final String COLUMNA_ABR = "abreviatura";
    public static final String COLUMNA_AULA = "aula";


    public static final String SQL_CREAR = "create table "
            + TABLA_ASIGNATURAS + "("
            + COLUMNA_ID + " integer primary key autoincrement, "
            + COLUMNA_NOMBRE + " text not null, "
            + COLUMNA_ABR + " text not null, "
            + COLUMNA_AULA + " text not null);";


    public Prueba_BD(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);


    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREAR);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    public int agregar(String nombre) {

        long newRowId;

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        String a = "abr";
        String b = "1.2";

        values.put(COLUMNA_AULA, "0.2");
        values.put(COLUMNA_ABR, "AC");
        values.put(COLUMNA_NOMBRE, "Arquitectura de computadores");

        newRowId = db.insert(TABLA_ASIGNATURAS, null, values);

        db.close();

        return (int) newRowId;
    }

    public void obtener(String nombre ) {

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.query(TABLA_ASIGNATURAS, new String[]{COLUMNA_ID,
                        COLUMNA_NOMBRE, COLUMNA_ABR, COLUMNA_AULA}, COLUMNA_NOMBRE + "=?",
                new String[]{String.valueOf(nombre)}, null, null, null, null);

        if (cursor != null)
            cursor.moveToFirst();

        Asignatura as = new Asignatura(cursor.getString(1), cursor.getString(2), cursor.getString(3));

        db.close();

        as.to_string();

    }
}