package Controlador;

import Modelo.Curso;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

public class UnMar {
    public static void unMarshall(){
        try {
            Path path= Paths.get("PrimerCurso.xml");
            JAXBContext context =JAXBContext.newInstance(Curso.class);
            Unmarshaller unmarshaller= context.createUnmarshaller();
            Curso primero= (Curso) (unmarshaller.unmarshal(path.toFile()));
            primero.getAlumno().stream().forEach(p->System.out.println(p));

        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }

    }
}
