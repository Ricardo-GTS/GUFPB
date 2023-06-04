package business.control;

import business.control.Commands.Command;
import business.control.Commands.CalcularCursoRecomendadoCommand;
import business.control.Commands.ExecutarQuestionarioCommand;
import business.control.Commands.CleanRespostaQuestionario;

import business.model.Questionario.Pergunta;
import business.model.Questionario.Questionario;
import business.model.Questionario.Resposta;
import infra.InfraException;




public class QuestionarioManager {
    private Questionario questionario;
    private Command executarQuestionarioCommand;
    private Command calcularCursoRecomendadoCommand;
    private Command CleanRespostaQuestionario;

    public QuestionarioManager() {
        questionario = new Questionario();
        executarQuestionarioCommand = new ExecutarQuestionarioCommand(questionario);
        CleanRespostaQuestionario = null; // Será definido posteriormente
        calcularCursoRecomendadoCommand = null; // Será definido posteriormente
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

    public void executarQuestionario() {
        executarQuestionarioCommand.execute();
    }

    public void calcularCursoRecomendado() {
        calcularCursoRecomendadoCommand = new CalcularCursoRecomendadoCommand(questionario);
        calcularCursoRecomendadoCommand.execute();
    }

    public String getCursoRecomendado() throws InfraException {
        return questionario.getCursoRecomendado();
    }

    public void CleanRespostaQuestionario() {
        CleanRespostaQuestionario = new CleanRespostaQuestionario(questionario);
        CleanRespostaQuestionario.execute();
    }

}
