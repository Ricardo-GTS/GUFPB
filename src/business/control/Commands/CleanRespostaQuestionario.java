

package business.control.Commands;

import business.model.Questionario.Questionario;

public class CleanRespostaQuestionario implements Command {
    private Questionario questionario;

    public CleanRespostaQuestionario(Questionario questionario) {
        this.questionario = questionario;
    }

    @Override
    public void execute() {
        questionario.CleanRespostaQuestionario();
    }
}
