package Modelo;

import Controlador.CustomDateAdapter;


import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@XmlRootElement
@XmlType(propOrder = {"nombre","apellido","año","fechaNac","asignaturas"})
public class Alumno {
  private  String nombre;
  private  String apellido;
  private int año;
  @XmlTransient
  private Date fechaNac;

  private List<Asignatura> asignaturas;

  public Alumno(){}

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    public Alumno(String nombre, String apellido, int año, Date fechaNac) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.año = año;
        this.fechaNac = fechaNac;
        asignaturas =crearAsignatura(año);
    }
    private List<Asignatura> rellenarPrimero(){
      List<Asignatura> asignaturas;
        int suspensosMaximos=3;
        int contador=0;
        do {
            contador=0;
            asignaturas=new ArrayList<>();
      asignaturas.add(new Asignatura("Base_Datos"));
      asignaturas.add(new Asignatura("Programacion"));
      asignaturas.add(new Asignatura("FOL"));
      asignaturas.add(new Asignatura("Entornos_Desarrollo"));
      asignaturas.add(new Asignatura("Lenguaje de marcas"));
      asignaturas.add(new Asignatura("Sistemas"));
            for (Asignatura asignatura:asignaturas) {
                if(asignatura.getNota()<5){
                    contador++;
                }
            }
        }while (suspensosMaximos<contador);

      return asignaturas;
    }
    public List<Asignatura> rellenarSegundo(){
        List<Asignatura> asignaturas;
        int suspensosMaximos=3;
        int contador=0;
        do {
            contador=0;
            asignaturas=new ArrayList<>();
        asignaturas.add(new Asignatura("Acceso_datos"));
        asignaturas.add(new Asignatura("Programacion_Multimedia"));
        asignaturas.add(new Asignatura("Programacion_Servicios"));
        asignaturas.add(new Asignatura("Diseño_Interfaces"));
        asignaturas.add(new Asignatura("Sistemas_Empresariales"));
        asignaturas.add(new Asignatura("EIE"));
        for (Asignatura asignatura:asignaturas) {
            if(asignatura.getNota()<5){
                contador++;
            }
        }
        }while (suspensosMaximos<contador);

        return asignaturas;
    }

    private int totalSuspendidas(){
      int cont=0;
      for (Asignatura asignatura:this.getAsignaturas()){
          if (asignatura.getNota()<5){
              cont++;
          }
      }
      return cont;
    }
    private List<Asignatura> crearAsignatura(int año) {
      List<Asignatura> asignaturas1=new ArrayList<>();
      if (año==1) {
          asignaturas1.addAll(rellenarPrimero());
      }else {
          asignaturas1.addAll(rellenarSegundo());
      }
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
    @XmlElement(name = "asignatura")
    public List<Asignatura> getAsignaturas() {
        return asignaturas;
    }

    public void setAsignaturas(List<Asignatura> asignaturas) {
        this.asignaturas = asignaturas;
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", año=" + año +
                ", fechaNac=" + fechaNac +
                ", asignaturas=" + asignaturas +
                '}';
    }
}
