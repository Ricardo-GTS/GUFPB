package business.model.Questionario;

public class Pergunta {
    private String texto;
    private Resposta resposta;

    public Pergunta(String texto, Resposta resposta) {
        this.texto = texto;
        this.resposta = resposta;
    }

    public String getTexto() {
        return texto;
    }

    public Resposta getResposta() {
        return resposta;
    }
}
