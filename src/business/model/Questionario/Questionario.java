package business.model.Questionario;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class Questionario {
    private List<Pergunta> perguntas;
    private static Scanner scanner = new Scanner(System.in);


    public Questionario() {
        perguntas = new ArrayList<>();
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

    public List<Pergunta> responderQuestionario() {
        for (Pergunta pergunta : perguntas) {
            System.out.println(pergunta.getTexto());
            boolean resposta = lerResposta();
            pergunta.getResposta().setValor(resposta);
            System.out.println();
        }
            System.out.println("Questionário concluído!");
        return perguntas;
    }

    public void CleanRespostaQuestionario() {
        for (Pergunta pergunta : perguntas) {
            pergunta.getResposta().setValor(false);
        }
    }   

    private boolean lerResposta() {
        System.out.print("Digite 'Sim' ou 'Não': ");
        String resposta = scanner.nextLine().toLowerCase();
        return resposta.equals("sim");
    }

    public String calcularCursoRecomendado(List<Pergunta> respostas) {
        Map<String, Integer> contagemCursos = new HashMap<>();
    
        for (Pergunta pergunta : respostas) {
            if (pergunta.getResposta().getValor()) {
                String curso = pergunta.getCursoRelacionado();
                contagemCursos.put(curso, contagemCursos.getOrDefault(curso, 0) + 1);
            }
        }
    
        // Encontrar o curso com o maior número de ocorrências
        String cursoRecomendado = null;
        int maxOcorrencias = 0;
        for (Map.Entry<String, Integer> entry : contagemCursos.entrySet()) {
            String curso = entry.getKey();
            int ocorrencias = entry.getValue();
            if (ocorrencias > maxOcorrencias) {
                cursoRecomendado = curso;
                maxOcorrencias = ocorrencias;
            }
        }
    
        return cursoRecomendado;
    }


}

//porque as peguntas do questionario está se repetindo quando é executado ?
//porque o metodo exibirQuestionario() está sendo chamado duas vezes, uma no metodo responderQuestionario() e outra no metodo listarCursos()
//não está

