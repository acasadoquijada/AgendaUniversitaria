package es.com.blogspot.httpagenda_universitaria_etsiit.agendauniversitaria;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


/**
 * Created by alejandro on 5/03/16.
 */


public class BD_asignaturas extends BD {

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


    public BD_asignaturas(Context context) {
        super(context);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREAR);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    @Override
    public Asignatura get(String n) {

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.query(TABLA_ASIGNATURAS, new String[]{COLUMNA_ID,
                        COLUMNA_NOMBRE, COLUMNA_ABR, COLUMNA_AULA}, COLUMNA_NOMBRE + "=?",
                new String[]{String.valueOf(n)}, null, null, null, null);

        if (cursor != null)
            cursor.moveToFirst();

        Asignatura as = new Asignatura(cursor.getString(1), cursor.getString(2), cursor.getString(3));

        db.close();

        as.to_string();

        return as;

    }

    @Override
    public int set(Object o) {

        long newRowId;

        Asignatura as=(Asignatura)o;

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(COLUMNA_AULA, as.get_aula());
        values.put(COLUMNA_ABR, as.get_abreviatura());
        values.put(COLUMNA_NOMBRE, as.get_nombre());

        newRowId = db.insert(TABLA_ASIGNATURAS, null, values);

        db.close();

        return (int) newRowId;
    }

}