package Modelo;


import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@XmlRootElement
public class Curso {

   private List<Alumno> alumno;

   public Curso(){}
    public Curso(List<Alumno> alumno) {
        this.alumno = alumno;
    }
    @XmlElementWrapper(name = "Alumnos")
    public List<Alumno> getAlumno() {
        return alumno;
    }

    public void setAlumno(List<Alumno> alumno) {
        this.alumno = alumno;
    }
    public static List<Alumno> pasarCursoSegundo(List<Alumno>alumnos){
        List<Alumno> alumnos2=new ArrayList<>();
        for (Alumno alumno:alumnos) {
            Iterator<Asignatura> itr=alumno.getAsignaturas().iterator();
            while (itr.hasNext()){
                Asignatura asignatura=itr.next();
                if (asignatura.getNota()<5){
                    itr.remove();
                }
            }
            if (){

            }

        }
        return alumnos2;
    }
    @Override
    public String toString() {
        return "Curso{" + alumno +
                '}';
    }
}
