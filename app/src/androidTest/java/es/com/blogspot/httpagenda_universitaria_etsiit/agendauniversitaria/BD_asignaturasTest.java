package es.com.blogspot.httpagenda_universitaria_etsiit.agendauniversitaria;

import org.junit.Test;

import android.test.AndroidTestCase;
import android.test.RenamingDelegatingContext;

/**
 * Created by alejandro on 10/03/16.
 */

public class BD_asignaturasTest extends AndroidTestCase {

    private BD_asignaturas db;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        RenamingDelegatingContext context = new RenamingDelegatingContext(getContext(), "test_");
        db = new BD_asignaturas(context);
    }

    @Test
    public void crear_asignatura() throws Exception{

        Asignatura a = new Asignatura("Prueba","PR","1.2");

        db.set(a);

        Asignatura b;

        b = db.get("Prueba");

        assertEquals(b.get_nombre(), "Prueba");

    }

}