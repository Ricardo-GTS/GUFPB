package business.control;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import business.model.Curso;
import business.model.Cursos.ArquiteUrban;
import business.model.Cursos.Computacao;
import business.model.Cursos.fisica;

public class CursoManager {
    private static Map<String, Curso> cursosListadosMap;
    private static Map<Integer, String> numeroParaNomeCursoMap;
    private static Scanner scanner = new Scanner(System.in);

    public CursoManager() {
        inicializarCursos();
        inicializarNumeroParaNomeCursoMap();
    }

    public static void inicializarCursos() {
        cursosListadosMap = new HashMap<>();

        ArquiteUrban arquiteUrban = new ArquiteUrban("Arquitetura e Urbanismo", 5, "Ciências Sociais");     //Aqui tambem o primeiro campo do Map tem que ser o nome da classe do Curso.
        cursosListadosMap.put("ArquiteUrban", arquiteUrban);

        fisica fisica = new fisica("Física (licenciatura)", 4, "Exatas");
        cursosListadosMap.put("fisica", fisica);

        Computacao computacao = new Computacao("Ciência da Computação", 4, "Tecnologia da Informação");
        cursosListadosMap.put("Computacao", computacao);
        // Adicionar outros cursos aqui

    }

    public static void inicializarNumeroParaNomeCursoMap() {
        numeroParaNomeCursoMap = new HashMap<>();
        
        numeroParaNomeCursoMap.put(1, "ArquiteUrban");      // esse valor tem que ser o nome da classe do Curso, para que sejá possivel bustar o curso pelo nome.
        numeroParaNomeCursoMap.put(2, "fisica");
        numeroParaNomeCursoMap.put(3, "Computacao");

        // Adicionar outros cursos aqui

    }

    public Curso buscarCurso(String nomeCurso) {
        return cursosListadosMap.get(nomeCurso);
    }

    public void listarCursos() {
        System.out.println("Cursos Listados:");
        System.out.println("---------------------");
        for (Map.Entry<Integer, String> entry : numeroParaNomeCursoMap.entrySet()) {
            int numeroCurso = entry.getKey();
            String nomeCurso = entry.getValue();
            Curso curso = cursosListadosMap.get(nomeCurso);
            System.out.println("Curso Número: " + numeroCurso);
            curso.imprimirInformacoesCurso();
        }

        exibirGradeCurricular();
    }

    private static void exibirGradeCurricular() {
        System.out.print("Deseja ver a grade curricular de algum curso? (S/N): ");
        String resposta = scanner.nextLine().trim().toUpperCase();

        if (resposta.equals("S")) {
            System.out.print("Digite o número do curso: ");
            int numeroCurso = scanner.nextInt();
            scanner.nextLine();

            String nomeCurso = numeroParaNomeCursoMap.get(numeroCurso);
            if (nomeCurso != null) {
                Curso curso = cursosListadosMap.get(nomeCurso);
                if (curso != null) {
                    curso.exibirGradeCurricular();
                } else {
                    System.out.println("Curso não encontrado.");
                }
            } else {
                System.out.println("Curso não encontrado.");
            }
        }

    }
}
