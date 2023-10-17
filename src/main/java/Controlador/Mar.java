package Controlador;

import Modelo.Alumno;
import Modelo.Curso;

import java.util.ArrayList;
import java.util.List;

public class Mar {
    public static void marshall(){
        try {
            Curso primero =new Curso();
            Curso segundo =new Curso();
            List<Alumno> alumnos=new ArrayList<>();
            for (int i = 0; i < 24; i++) {
                alumnos.add(new Alumno());
            }
        }
    }
}
