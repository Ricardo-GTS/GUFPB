package business.control.Commands;

import business.model.Questionario.Questionario;

public class ExecutarQuestionarioCommand implements Command {
    private Questionario questionario;

    public ExecutarQuestionarioCommand(Questionario questionario) {
        this.questionario = questionario;
    }

    @Override
    public void execute() {
        questionario.responderQuestionario();
    }
}
