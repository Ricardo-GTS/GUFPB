package business.control;
import java.util.List;
import business.model.Questionario.Pergunta;

public class QuestionarioManagerFacade {
    private static QuestionarioManagerFacade instance;
    private QuestionarioManager questionarioManager;

    private QuestionarioManagerFacade() {
        questionarioManager = new QuestionarioManager();
    }

    public static QuestionarioManagerFacade getInstance() {
        if (instance == null) {
            instance = new QuestionarioManagerFacade();
        }
        return instance;
    }

    public List<Pergunta>  executarQuestionario() {
        questionarioManager.criarQuestionario();
        return questionarioManager.executarQuestionario();
    }
}
