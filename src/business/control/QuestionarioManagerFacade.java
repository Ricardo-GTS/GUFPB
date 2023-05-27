package business.control;
import java.util.List;
import business.model.Questionario.Pergunta;

public class QuestionarioManagerFacade {
    private static QuestionarioManagerFacade instance;
    private QuestionarioManager questionarioManager;

    private QuestionarioManagerFacade() {
        questionarioManager = new QuestionarioManager();
        questionarioManager.criarQuestionario();
    }

    public static QuestionarioManagerFacade getInstance() {
        if (instance == null) {
            instance = new QuestionarioManagerFacade();
        }
        return instance;
    }

    public List<Pergunta>  executarQuestionario() {
        return questionarioManager.executarQuestionario();
    }

    public String calcularCursoRecomendado(List<Pergunta> respostasQuestionario) {
        return questionarioManager.calcularCursoRecomendado(respostasQuestionario);
    }
}

