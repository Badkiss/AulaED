package Modelo;


import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
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
        for (Alumno alumno:alumnos){
            for (int i = 0; i <alumno.getAsignaturas().size() ; i++) {
                if (alumno.getAsignaturas().get(i).getNota()>4){
                    alumno.getAsignaturas().remove(i);
                }

            }
            if (alumno.getAsignaturas().size()>0){
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
}
