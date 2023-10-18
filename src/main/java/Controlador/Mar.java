package Controlador;

import Modelo.Alumno;
import Modelo.Curso;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Mar {
    public static void marshall(Curso primero,Curso segundo){
        try {
            JAXBContext context=JAXBContext.newInstance(Curso.class);
            Marshaller marshaller= context.createMarshaller();
            Path path1= Paths.get("PrimerCurso.xml");
            Path path2= Paths.get("SegundoCurso.xml");
            marshaller.marshal(primero, Files.newOutputStream(path1));
            marshaller.marshal(segundo, Files.newOutputStream(path2));
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
