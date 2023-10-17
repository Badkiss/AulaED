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
    public static void marshall(){
        try {
            Curso primero =new Curso();
            Curso segundo =new Curso();
            SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd/MM/yyyy");
            Date date= simpleDateFormat.parse("23/08/1999");
            List<Alumno> alumnos=new ArrayList<>();
            for (int i = 0; i < 24; i++) {
                alumnos.add(new Alumno("Alx","grux",1,date));
            }
            primero.setAlumnos(alumnos);
            JAXBContext context=JAXBContext.newInstance(Curso.class);
            Marshaller marshaller= context.createMarshaller();
            Path path= Paths.get("PrimerCurso.xml");
            marshaller.marshal(primero, Files.newOutputStream(path));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
