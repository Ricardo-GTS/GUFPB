package business.model.Questionario.Adapter;

import business.model.Questionario.Resposta;

// Classe Resposta adaptada para a interface Answer
public class AnswerAdapter implements Answer {
    private Resposta resposta;

    public AnswerAdapter(Resposta resposta) {
        this.resposta = resposta;
    }

    @Override
    public boolean getValor() {
        return resposta.getValor();
    }
}