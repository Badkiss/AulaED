import Controlador.Dom;
import Controlador.Iniciador;
import Controlador.Mar;
import Controlador.UnMar;
import Modelo.Curso;

public class Main {
    public static void main(String[] args) {
        Curso primero=Iniciador.iniciarPrimero();
        Curso segundo=Iniciador.iniciarSegundo();
        Mar.marshall(primero,segundo);
        Dom.domCrear(primero,segundo);
        segundo=UnMar.unMarshall();
        segundo.setAlumno(Curso.pasarCursoSegundo(segundo.getAlumno()));
        Mar.marshall(primero,segundo);

    }
}
