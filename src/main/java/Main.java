import Controlador.*;
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

        Sax.mostrar(Paths.get("PrimerCurso.xml"));

        primeroJ=UnMar.unMarshall(Paths.get("PrimerCurso.xml"));
        segundoJ=UnMar.unMarshall(Paths.get("SegundoCurso.xml"));

        primeroJ.setAlumno(Curso.pasarCursoPrimero(primeroJ.getAlumno()));
        segundoJ.setAlumno(Curso.pasarCursoSegundo(segundoJ.getAlumno()));

        segundoJ.getAlumno().addAll(primeroJ.getAlumno().stream().filter(alumno -> alumno.getAsignaturas().size()<3).collect(Collectors.toList()));
        primeroJ.setAlumno(Curso.nuevoAño(primeroJ.getAlumno()));
        primeroJ.setAlumno(Curso.rellenarFaltantesPrimero(primeroJ.getAlumno()));
        segundoJ.setAlumno(Curso.nuevoAñoSegundo(segundoJ.getAlumno()));
        Mar.marshall(primeroJ,segundoJ);





        primeroD=Dom.domRecoger(Paths.get("DomPrimero.xml"));
        segundoD=Dom.domRecoger(Paths.get("DomSegundo.xml"));
        primeroD.setAlumno(Curso.pasarCursoPrimero(primeroD.getAlumno()));
        segundoD.setAlumno(Curso.pasarCursoSegundo(segundoD.getAlumno()));

        segundoD.getAlumno().addAll(primeroD.getAlumno().stream().filter(alumno -> alumno.getAsignaturas().size()<3).collect(Collectors.toList()));
        primeroD.setAlumno(Curso.nuevoAño(primeroD.getAlumno()));
        primeroD.setAlumno(Curso.rellenarFaltantesPrimero(primeroD.getAlumno()));
        segundoD.setAlumno(Curso.nuevoAñoSegundo(segundoD.getAlumno()));

        Dom.domCrear(primeroD,segundoD);
    }
}
