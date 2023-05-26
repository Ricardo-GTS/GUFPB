
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
        Pergunta pergunta1 = new Pergunta("Pergunta 1: Você gosta de programação?", new Resposta(false));
        Pergunta pergunta2 = new Pergunta("Pergunta 2: Você prefere trabalhar em equipe?", new Resposta(false));
        Pergunta pergunta3 = new Pergunta("Pergunta 3: Você se considera uma pessoa organizada?", new Resposta(false));

        questionario.adicionarPergunta(pergunta1);
        questionario.adicionarPergunta(pergunta2);
        questionario.adicionarPergunta(pergunta3);
    }

    public List<Pergunta>  executarQuestionario() {
        return  questionario.responderQuestionario();
    }

    
}
