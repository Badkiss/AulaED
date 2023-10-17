package Modelo;

import Controlador.CustomDateAdapter;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;
import java.util.List;
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Alumno {
  private  Nombre nombre;
  private  Apellido apellido;
  private int año;
  @XmlTransient
  private Date fechaNac;

  private List<Asignatura> asignaturas;

  public Alumno(){}
    public Alumno(Nombre nombre, Apellido apellido, int año, Date fechaNac) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.año = año;
        this.fechaNac = fechaNac;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Apellido getApellido() {
        return apellido;
    }

    public int getAño() {
        return año;
    }
    @XmlJavaTypeAdapter(CustomDateAdapter.class)
    public Date getFechaNac() {
        return fechaNac;
    }
    @XmlElementWrapper
    public List<Asignatura> getAsignaturas() {
        return asignaturas;
    }

    public void setAsignaturas(List<Asignatura> asignaturas) {
        this.asignaturas = asignaturas;
    }
}
