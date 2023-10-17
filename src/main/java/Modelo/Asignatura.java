package Modelo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Asignatura {
    String nombre;
    Integer nota;
    public Asignatura(){}

    public Asignatura(String nombre){
        this.nombre=nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getNota() {
        return nota;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNota() {
        nota=(int)(Math.random()*11);
    }
}
