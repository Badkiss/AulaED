package Modelo;


import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Asignatura {
    String nombre;
    @XmlAttribute
    Integer nota;
    public Asignatura(){}

    public Asignatura(String nombre){
        this.nombre=nombre;
        nota=(int)(Math.random()*11);
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

    public void setNota(Integer nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "Asignatura{" +
                "nombre='" + nombre + '\'' +
                ", nota=" + nota +
                '}';
    }
}
