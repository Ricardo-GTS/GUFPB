
package business.control;

import java.util.List;

import business.model.Questionario.Pergunta;
import business.model.Questionario.Questionario;
import business.model.Questionario.Resposta;

public class QuestionarioManager {
    private Questionario questionario;


    public QuestionarioManager() {
        questionario = new Questionario();
    }

    public void criarQuestionario() {
        Pergunta pergunta1 = new Pergunta("Pergunta 1: Você gosta de estudar matemática?", new Resposta(false), "Computacao");
        Pergunta pergunta2 = new Pergunta("Pergunta 2: Você tem interesse em projetar e construir edifícios?", new Resposta(false), "ArquiteUrban");
        Pergunta pergunta3 = new Pergunta("Pergunta 3: Você gosta de programar e resolver problemas com computadores?", new Resposta(false), "Computacao");
        Pergunta pergunta4 = new Pergunta("Pergunta 4: Você tem interesse em aprender sobre fenômenos físicos e leis da natureza?", new Resposta(false), "fisica");
        Pergunta pergunta5 = new Pergunta("Pergunta 5: Você se interessa por urbanismo e planejamento urbano?", new Resposta(false), "ArquiteUrban");
        Pergunta pergunta6 = new Pergunta("Pergunta 6: Você gosta de fazer experimentos científicos?", new Resposta(false), "fisica");
        
        questionario.adicionarPergunta(pergunta1);
        questionario.adicionarPergunta(pergunta2);
        questionario.adicionarPergunta(pergunta3);
        questionario.adicionarPergunta(pergunta4);
        questionario.adicionarPergunta(pergunta5);
        questionario.adicionarPergunta(pergunta6);
    }

    public List<Pergunta>  executarQuestionario() {
        return  questionario.responderQuestionario();
    }

    public void CleanRespostaQuestionario() {
        questionario.CleanRespostaQuestionario();
    }

    public String calcularCursoRecomendado(List<Pergunta> respostas) {
        return questionario.calcularCursoRecomendado(respostas);
    }

    
}
