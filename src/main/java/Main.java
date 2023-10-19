import Controlador.Dom;
import Controlador.Iniciador;
import Controlador.Mar;
import Controlador.UnMar;
import Modelo.Curso;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Curso primeroJ=Iniciador.iniciarPrimero();
        Curso segundoJ=Iniciador.iniciarSegundo();
        Curso primeroD=Iniciador.iniciarPrimero();
        Curso segundoD=Iniciador.iniciarSegundo();

        Mar.marshall(primeroJ,segundoJ);
        Dom.domCrear(primeroD,segundoD);

        primeroJ=UnMar.unMarshall(Paths.get("PrimerCurso.xml"));
        segundoJ=UnMar.unMarshall(Paths.get("SegundoCurso.xml"));

        primeroD=Dom.domRecoger(Paths.get("DomPrimero.xml"));
        segundoD=Dom.domRecoger(Paths.get("DomSegundo.xml"));


        primeroJ.setAlumno(Curso.pasarCursoPrimero(primeroJ.getAlumno()));


        segundoJ.setAlumno(Curso.pasarCursoSegundo(segundoJ.getAlumno()));
        segundoJ.getAlumno().addAll(primeroJ.getAlumno().stream().filter(alumno -> alumno.getAsignaturas().size()<3).collect(Collectors.toList()));
        primeroJ.setAlumno(Curso.nuevoAño(primeroJ.getAlumno()));
        primeroJ.setAlumno(Curso.rellenarFaltantesPrimero(primeroJ.getAlumno()));
        segundoJ.setAlumno(Curso.nuevoAñoSegundo(segundoJ.getAlumno()));
        Mar.marshall(primeroJ,segundoJ);

    }
}
