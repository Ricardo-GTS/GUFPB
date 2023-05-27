package business.model.Questionario;

public class Pergunta {
    private String texto;
    private Resposta resposta;
    private String CursoRelacionado;

    public Pergunta(String texto, Resposta resposta, String CursoRelacionado) {
        this.texto = texto;
        this.resposta = resposta;
        this.CursoRelacionado = CursoRelacionado;
    }

    public String getTexto() {
        return texto;
    }

    public Resposta getResposta() {
        return resposta;
    }

    public String getCursoRelacionado() {
        return CursoRelacionado;
    }   
}
