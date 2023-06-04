package business.control.Commands;

import business.model.Questionario.Questionario;

public class CalcularCursoRecomendadoCommand implements Command {
    private Questionario questionario;

    public CalcularCursoRecomendadoCommand(Questionario questionario) {
        this.questionario = questionario;
    }

    @Override
    public void execute() {
        questionario.calcularCursoRecomendado();
    }
}