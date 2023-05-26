package business.model.Questionario;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Questionario {
    private List<Pergunta> perguntas;
    private Scanner scanner;

    public Questionario() {
        perguntas = new ArrayList<>();
        scanner = new Scanner(System.in);
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

    private boolean lerResposta() {
        System.out.print("Digite 'Sim' ou 'Não': ");
        String resposta = scanner.nextLine().toLowerCase();
        return resposta.equals("sim");
    }
}