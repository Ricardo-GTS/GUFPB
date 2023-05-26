package business.model.Questionario.Adapter;

import business.model.Questionario.Pergunta;
import business.model.Questionario.Resposta;

//QuestionAdapter atua como um adaptador entre a classe Pergunta e a interface Question

public class QuestionAdapter implements Question {
    private Pergunta pergunta;

    public QuestionAdapter(Pergunta pergunta) {
        this.pergunta = pergunta;
    }

    @Override
    public String getText() {
        return pergunta.getTexto();
    }

    @Override
    public Resposta getResposta() {
        Resposta resposta = pergunta.getResposta();

        return resposta;
    }
}