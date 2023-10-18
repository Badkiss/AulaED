package Modelo;


import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
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

    @Override
    public String toString() {
        return "Curso{" + alumno +
                '}';
    }
}
