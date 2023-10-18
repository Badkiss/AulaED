package Controlador;

import Modelo.Alumno;
import Modelo.Curso;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Iniciador {
    public  static Curso iniciarPrimero(){
        try {
            Curso primero =new Curso();

            SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd/MM/yyyy");
            Date date= simpleDateFormat.parse("23/08/1999");
            List<Alumno> alumnosPrimero=new ArrayList<>();

            for (int i = 0; i < 24; i++) {
                alumnosPrimero.add(new Alumno("Alx","grux",1,date));
            }

            primero.setAlumno(alumnosPrimero);
            return primero;
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
    public static Curso iniciarSegundo(){
        try {
            Curso segundo = new Curso();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date date = simpleDateFormat.parse("23/08/1999");
            List<Alumno> alumnosSegundo = new ArrayList<>();
            for (int i = 0; i < 8; i++) {
                alumnosSegundo.add(new Alumno("Alx", "grux", 2, date));
            }
            segundo.setAlumno(alumnosSegundo);
            return segundo;
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
