package business.control;

import infra.InfraException;

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

    public void executarQuestionario() {
        questionarioManager.executarQuestionario();
    }

    public void calcularCursoRecomendado() {
        questionarioManager.calcularCursoRecomendado();
    }

    public String getCursoRecomendado() throws InfraException {
        return questionarioManager.getCursoRecomendado();
    }

    public void CleanRespostaQuestionario() {
        questionarioManager.CleanRespostaQuestionario();
    }
}

