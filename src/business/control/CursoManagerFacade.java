package business.control;

import business.model.Curso;

public class CursoManagerFacade {
    private static CursoManagerFacade instance;
    private CursoManager cursoManager;

    private CursoManagerFacade() {
        cursoManager = new CursoManager();
    }

    public static CursoManagerFacade getInstance() {
        if (instance == null) {
            instance = new CursoManagerFacade();
        }
        return instance;
    }

    public void listarCursos() {
        cursoManager.listarCursos();
    }

    // Outros métodos da fachada, se necessário

    public Curso buscarCurso(String nomeCurso) {
        return cursoManager.buscarCurso(nomeCurso);
    }
}
