package Controlador;


import Modelo.Alumno;
import Modelo.Asignatura;
import Modelo.Curso;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.events.EndElement;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Dom {
    public static void domCrear(Curso primero ,Curso segundo){
        try {
            SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd/MM/yyyy");
       DocumentBuilderFactory documentBuilderFactory=DocumentBuilderFactory.newDefaultInstance();
       DocumentBuilder documentBuilder= documentBuilderFactory.newDocumentBuilder();
       Document doc=documentBuilder.newDocument();
       Element raiz=doc.createElement("curso");
       doc.appendChild(raiz);
       Element alumnos=doc.createElement("Alumnos");
       raiz.appendChild(alumnos);
       for (Alumno alumno: primero.getAlumno()){
           Element eAlumno=doc.createElement("alumno");
           alumnos.appendChild(eAlumno);
           Element eApellido=doc.createElement("apellido");
           eApellido.appendChild(doc.createTextNode(alumno.getApellido()));
           eAlumno.appendChild(eApellido);
           Element eAsignaturas=doc.createElement("Asignaturas");
           eAlumno.appendChild(eAsignaturas);
           for (Asignatura asignatura: alumno.getAsignatura()){
               Element eAsignatura=doc.createElement("asignatura");
               Attr attr=doc.createAttribute("nota");
               attr.setValue(asignatura.getNota()+"");
               eAsignatura.setAttributeNode(attr);
               eAsignatura.appendChild(doc.createTextNode(asignatura.getNombre()));
               eAsignaturas.appendChild(eAsignatura);
           }
           Element eAño=doc.createElement("año");
           eAño.appendChild(doc.createTextNode(alumno.getAño()+""));
           eAlumno.appendChild(eAño);
           Element eFechaNac=doc.createElement("fechaNac");
           eFechaNac.appendChild(doc.createTextNode(simpleDateFormat.format(alumno.getFechaNac())));
           eAlumno.appendChild(eFechaNac);
           Element eNombre=doc.createElement("nombre");
           eNombre.appendChild(doc.createTextNode(alumno.getNombre()));
           eAlumno.appendChild(eNombre);
       }

            TransformerFactory transformerFactory=TransformerFactory.newInstance();
            Transformer transformer= transformerFactory.newTransformer();
            DOMSource source=new DOMSource(doc);
            StreamResult result=new StreamResult(new File("DomPrimero.xml"));
            transformer.transform(source,result);

            DocumentBuilderFactory documentBuilderFactory2=DocumentBuilderFactory.newDefaultInstance();
            DocumentBuilder documentBuilder2= documentBuilderFactory2.newDocumentBuilder();
            Document doc2=documentBuilder.newDocument();
            Element raiz2=doc2.createElement("curso");
            doc2.appendChild(raiz2);
            Element eAlumnos2=doc2.createElement("Alumnos");
            raiz2.appendChild(eAlumnos2);
            for (Alumno alumno: segundo.getAlumno()){
                Element eAlumno=doc2.createElement("alumno");
                eAlumnos2.appendChild(eAlumno);
                Element eApellido=doc2.createElement("apellido");
                eApellido.appendChild(doc2.createTextNode(alumno.getApellido()));
                eAlumno.appendChild(eApellido);
                Element eAsignaturas=doc2.createElement("Asignaturas");
                eAlumno.appendChild(eAsignaturas);
                for (Asignatura asignatura: alumno.getAsignatura()){
                    Element eAsignatura=doc2.createElement("asignatura");
                    Attr attr=doc2.createAttribute("nota");
                    attr.setValue(asignatura.getNota()+"");
                    eAsignatura.setAttributeNode(attr);
                    eAsignatura.appendChild(doc2.createTextNode(asignatura.getNombre()));
                    eAsignaturas.appendChild(eAsignatura);
                }
                Element eAño=doc2.createElement("año");
                eAño.appendChild(doc2.createTextNode(alumno.getAño()+""));
                eAlumno.appendChild(eAño);
                Element eFechaNac=doc2.createElement("fechaNac");
                eFechaNac.appendChild(doc2.createTextNode(simpleDateFormat.format(alumno.getFechaNac())));
                eAlumno.appendChild(eFechaNac);
                Element eNombre=doc2.createElement("nombre");
                eNombre.appendChild(doc2.createTextNode(alumno.getNombre()));
                eAlumno.appendChild(eNombre);
            }
            TransformerFactory transformerFactory2=TransformerFactory.newInstance();
            Transformer transformer2= transformerFactory2.newTransformer();
            DOMSource source2=new DOMSource(doc2);
            StreamResult result2=new StreamResult(new File("DomSegundo.xml"));
            transformer.transform(source2,result2);

   } catch (ParserConfigurationException e) {
       throw new RuntimeException(e);
   } catch (TransformerConfigurationException e) {
            throw new RuntimeException(e);
        } catch (TransformerException e) {
            throw new RuntimeException(e);
        }
    }

}
