package Controlador;

import Modelo.Curso;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

public class UnMar {
    public static Curso unMarshall(Path path){
        try {

            JAXBContext context =JAXBContext.newInstance(Curso.class);
            Unmarshaller unmarshaller= context.createUnmarshaller();
            Curso primero= (Curso) (unmarshaller.unmarshal(path.toFile()));
            return primero;

        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }

    }
}
