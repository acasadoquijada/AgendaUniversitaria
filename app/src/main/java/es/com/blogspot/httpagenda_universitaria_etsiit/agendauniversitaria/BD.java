package es.com.blogspot.httpagenda_universitaria_etsiit.agendauniversitaria;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by alejandro on 10/03/16.
 */
public abstract class BD <T> extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "agenda.db";

    public BD(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    @Override
    abstract public void onCreate(SQLiteDatabase db);

    @Override
    abstract public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion);

    // T es un tipo genérico.
    abstract public T get(String n);

    abstract public int set(T o);
}
