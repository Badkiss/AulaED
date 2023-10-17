package Modelo;

import Controlador.CustomDateAdapter;


import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@XmlRootElement
public class Alumno {
  private  String nombre;
  private  String apellido;
  private int año;
  @XmlTransient
  private Date fechaNac;

  private List<Asignatura> asignaturas;

  public Alumno(){}
    public Alumno(String nombre, String apellido, int año, Date fechaNac) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.año = año;
        this.fechaNac = fechaNac;
        asignaturas=crearAsignatura(año);
    }
    private List<Asignatura> rellenarPrimero(){
      List<Asignatura> asignaturas=new ArrayList<>();
      asignaturas.add(new Asignatura("Base_Datos"));
      asignaturas.add(new Asignatura("Programacion"));
      return asignaturas;
    }
    private List<Asignatura> crearAsignatura(int año) {
      List<Asignatura> asignaturas1=new ArrayList<>();
       asignaturas1.addAll(rellenarPrimero());
       return asignaturas1;
    }
    @XmlElement
    public String getNombre() {
        return nombre;
    }
    @XmlElement
    public String getApellido() {
        return apellido;
    }

    @XmlElement
    public int getAño() {
        return año;
    }
    @XmlJavaTypeAdapter(CustomDateAdapter.class)
    public Date getFechaNac() {
        return fechaNac;
    }
    @XmlElementWrapper(name = "Asignaturas")
    public List<Asignatura> getAsignatura() {
        return asignaturas;
    }

    public void setAsignaturas(List<Asignatura> asignaturas) {
        this.asignaturas = asignaturas;
    }
}
