package Controlador;


import Modelo.Alumno;
import Modelo.Asignatura;
import Modelo.Curso;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
           Element eNombre=doc.createElement("nombre");
           eNombre.appendChild(doc.createTextNode(alumno.getNombre()));
           eAlumno.appendChild(eNombre);
           Element eApellido=doc.createElement("apellido");
           eApellido.appendChild(doc.createTextNode(alumno.getApellido()));
           eAlumno.appendChild(eApellido);
           Element eAño=doc.createElement("año");
           eAño.appendChild(doc.createTextNode(alumno.getAño()+""));
           eAlumno.appendChild(eAño);
           Element eFechaNac=doc.createElement("fechaNac");
           eFechaNac.appendChild(doc.createTextNode(simpleDateFormat.format(alumno.getFechaNac())));
           eAlumno.appendChild(eFechaNac);
           Element eAsignaturas=doc.createElement("Asignaturas");
           eAlumno.appendChild(eAsignaturas);
           for (Asignatura asignatura: alumno.getAsignaturas()){
               Element eAsignatura=doc.createElement("asignatura");
               Attr attr=doc.createAttribute("nota");
               attr.setValue(asignatura.getNota()+"");
               eAsignatura.setAttributeNode(attr);
               eAsignatura.appendChild(doc.createTextNode(asignatura.getNombre()));
               eAsignaturas.appendChild(eAsignatura);
           }


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
                Element eNombre=doc2.createElement("nombre");
                eNombre.appendChild(doc2.createTextNode(alumno.getNombre()));
                eAlumno.appendChild(eNombre);
                Element eApellido=doc2.createElement("apellido");
                eApellido.appendChild(doc2.createTextNode(alumno.getApellido()));
                eAlumno.appendChild(eApellido);
                Element eAño=doc2.createElement("año");
                eAño.appendChild(doc2.createTextNode(alumno.getAño()+""));
                eAlumno.appendChild(eAño);
                Element eFechaNac=doc2.createElement("fechaNac");
                eFechaNac.appendChild(doc2.createTextNode(simpleDateFormat.format(alumno.getFechaNac())));
                eAlumno.appendChild(eFechaNac);
                Element eAsignaturas=doc2.createElement("Asignaturas");
                eAlumno.appendChild(eAsignaturas);
                for (Asignatura asignatura: alumno.getAsignaturas()){
                    Element eAsignatura=doc2.createElement("asignatura");
                    Attr attr=doc2.createAttribute("nota");
                    attr.setValue(asignatura.getNota()+"");
                    eAsignatura.setAttributeNode(attr);
                    eAsignatura.appendChild(doc2.createTextNode(asignatura.getNombre()));
                    eAsignaturas.appendChild(eAsignatura);
                }

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

    public static Curso domRecoger(Path path) {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd/MM/yyyy");
        Curso curso=new Curso();
        List<Alumno> alumnosList=new ArrayList<>();
        List<Asignatura> asignaturasList =new ArrayList<>();
        try {
            InputStream inputStream= Files.newInputStream(path);
            DocumentBuilderFactory documentBuilderFactory=DocumentBuilderFactory.newDefaultInstance();
            DocumentBuilder documentBuilder= documentBuilderFactory.newDocumentBuilder();
            Document doc=documentBuilder.parse(inputStream);

            doc.getDocumentElement().normalize();
            NodeList alumnos=doc.getElementsByTagName("Alumnos");
            Element alumno= (Element)(alumnos.item(0));
           NodeList alumnosBien =alumno.getElementsByTagName("alumno");
            for (int i = 0; i < alumnosBien.getLength(); i++) {
                Node alumnoB=alumnosBien.item(i);
                Element alumnoMuyBien=(Element) alumnoB;
                NodeList Asignaturas= alumnoMuyBien.getElementsByTagName("Asignaturas");
                Element asignaturas=(Element) (Asignaturas.item(0));
                NodeList asignaturasBien=asignaturas.getElementsByTagName("asignatura");
                for (int j = 0; j < asignaturasBien.getLength(); j++) {
                    Node asignatura=asignaturasBien.item(j);
                    if (asignatura.getNodeType()==Node.ELEMENT_NODE){
                        asignaturasList.add(new Asignatura(asignatura.getTextContent(),Integer.parseInt(asignatura.getAttributes().item(0).getTextContent())));
                    }

                }
                alumnosList.add(new Alumno
                        (alumnoMuyBien.getElementsByTagName("nombre").item(0).getTextContent(),
                                alumnoMuyBien.getElementsByTagName("apellido").item(0).getTextContent(),
                                Integer.parseInt(alumnoMuyBien.getElementsByTagName("año").item(0).getTextContent()),
                                simpleDateFormat.parse(alumnoMuyBien.getElementsByTagName("fechaNac").item(0).getTextContent()),
                                asignaturasList));
                asignaturasList=new ArrayList<>();
            }
            curso.setAlumno(alumnosList);
            return curso;

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
