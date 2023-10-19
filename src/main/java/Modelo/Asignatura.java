package Modelo;


import javax.xml.bind.annotation.*;
import java.util.Objects;

@XmlRootElement
public class Asignatura {

    String nombre;

    Integer nota;
    public Asignatura(){}

    public Asignatura(String nombre){
        this.nombre=nombre;
        nota=(int)(Math.random()*11);
    }
    public Asignatura(String nombre,Integer nota){
        this.nombre=nombre;
        this.nota=nota;
    }

    @XmlElement

    public String getNombre() {
        return nombre;
    }

    @XmlAttribute
    public Integer getNota() {
        return nota;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNota(Integer nota) {
        this.nota = nota;
    }
    public void setNotaAleatoria(){
        this.nota=(int)(Math.random()*11);
    }
    @Override
    public String toString() {
        return "Asignatura{" +
                "nombre='" + nombre + '\'' +
                ", nota=" + nota +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if(o instanceof Asignatura){
            Asignatura asignatura=(Asignatura) (o);
            return asignatura.getNombre().equals(this.getNombre());
        }else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, nota);
    }
}
