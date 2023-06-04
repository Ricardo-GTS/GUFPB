package business.model.Questionario;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import infra.InfraException;


public class Questionario {
    private List<Pergunta> perguntas;
    private static Scanner scanner = new Scanner(System.in);
    private String cursoRecomendado;


    public Questionario() {
        perguntas = new ArrayList<>();
        cursoRecomendado = null;
    }

    public void adicionarPergunta(Pergunta pergunta) {
        perguntas.add(pergunta);
    }

    public void exibirQuestionario() {
        for (Pergunta pergunta : perguntas) {
            System.out.println(pergunta.getTexto());
            System.out.println();
        }
    }

    public void responderQuestionario() {
        for (Pergunta pergunta : perguntas) {
            System.out.println(pergunta.getTexto());
            boolean resposta = lerResposta();
            pergunta.getResposta().setValor(resposta);
            System.out.println();
        }
            System.out.println("Questionário concluído!");
    }

    public void CleanRespostaQuestionario() {
        for (Pergunta pergunta : perguntas) {
            pergunta.getResposta().setValor(false);
        }
        cursoRecomendado = null;
    }   

    private boolean lerResposta() {
        System.out.print("Digite 'S' ou 'N': ");
        String resposta = scanner.nextLine().toLowerCase();
        return resposta.equals("s");
    }

    public void calcularCursoRecomendado() {
        Map<String, Integer> contagemCursos = new HashMap<>();
    
        for (Pergunta pergunta : perguntas) {
            if (pergunta.getResposta().getValor()) {
                String curso = pergunta.getCursoRelacionado();
                contagemCursos.put(curso, contagemCursos.getOrDefault(curso, 0) + 1);
            }
        }
    
        // Encontrar o curso com o maior número de ocorrências
        String cursoRec = null;
        int maxOcorrencias = 0;
        for (Map.Entry<String, Integer> entry : contagemCursos.entrySet()) {
            String curso = entry.getKey();
            int ocorrencias = entry.getValue();
            if (ocorrencias > maxOcorrencias) {
                cursoRec = curso;
                maxOcorrencias = ocorrencias;
            }
        }
    
        cursoRecomendado = cursoRec;
    }

    public String getCursoRecomendado() throws InfraException {
        if (cursoRecomendado == null) {
            throw new InfraException("O curso recomendado ainda não foi calculado!");
        }
        else
            return cursoRecomendado;
    }


}
