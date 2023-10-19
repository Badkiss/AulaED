package Modelo;


import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

@XmlRootElement
public class Curso {

   private List<Alumno> alumno;

   public Curso(){}
    public Curso(List<Alumno> alumno) {
        this.alumno = alumno;
    }

    public static List<Alumno> nuevoAñoSegundo(List<Alumno> alumnos) {
       int contador=0;
       for (Alumno alumno:alumnos){
           if (alumno.getAño()==1){
               alumno.getAsignaturas().addAll(alumno.rellenarSegundo());
               alumno.setAño(2);
           }
           do {
               contador=0;
               for (Asignatura asignatura: alumno.getAsignaturas()){
                   asignatura.setNotaAleatoria();
                   if (asignatura.getNota()<5){
                       contador++;
                   }
               }
           }while (contador>3);
        }
       return  alumnos;
    }


    @XmlElementWrapper(name = "Alumnos")
    public List<Alumno> getAlumno() {
        return alumno;
    }

    public void setAlumno(List<Alumno> alumno) {
        this.alumno = alumno;
    }
    public static List<Alumno> pasarCursoPrimero(List<Alumno> alumnos) {
        for (Alumno alumno:alumnos) {
            Iterator<Asignatura> itr=alumno.getAsignaturas().iterator();
            while (itr.hasNext()){
                Asignatura asignatura=itr.next();
                if (asignatura.getNota()>4){
                    itr.remove();
                }
            }
        }
        return alumnos;
    }
    public static List<Alumno> pasarCursoSegundo(List<Alumno>alumnos){
        List<Alumno> alumnos2=new ArrayList<>();
        for (Alumno alumno:alumnos) {
            Iterator<Asignatura> itr=alumno.getAsignaturas().iterator();
            while (itr.hasNext()){
                Asignatura asignatura=itr.next();
                if (asignatura.getNota()>4){
                    itr.remove();
                }
            }

            if (alumno.getAsignaturas().size()!=0){
                alumnos2.add(alumno);
            }
        }
        return alumnos2;
    }
    @Override
    public String toString() {
        return "Curso{" + alumno +
                '}';
    }

    public static List<Alumno> nuevoAño(List<Alumno> alumnos) {
       alumnos.stream().filter(alumno -> alumno.getAsignaturas().size()>=3).collect(Collectors.toList());
        for (Alumno alumno:alumnos){
            for(Asignatura asignatura:alumno.getAsignaturas()){
                asignatura.setNotaAleatoria();
            }
        }
        return alumnos;
   }
    public static List<Alumno> rellenarFaltantesPrimero(List<Alumno> alumnos){
       try {
           SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd/MM/yyyy");
           for (int i = alumnos.size(); i < 24; i++) {
               alumnos.add(new Alumno("Alx","gri",1,simpleDateFormat.parse("23/08/1999")));
           }
           return alumnos;
       } catch (ParseException e) {
           throw new RuntimeException(e);
       }

    }
}
