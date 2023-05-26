
package business.model;
import java.util.List;
import business.model.Questionario.Pergunta;


import java.io.Serializable;

public class User implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = -3409171233621036055L;

    private String login, senha;
    private Data data_nascimento;
    private List<Pergunta> respostasQuestionario;

    public Data getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(Data data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public User(String login, String senha, Data data_nascimento) {
        super();
        this.login = login;
        this.senha = senha;
        this.data_nascimento = data_nascimento;

    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<Pergunta> getRespostasQuestionario() {
        return respostasQuestionario;
    }

    public void SetRespostasQuestionario(List<Pergunta> respostasQuestionario) {
        this.respostasQuestionario = respostasQuestionario;
    }

    public String toString() {
        return login + "\n" + senha;
    }

}
