
package business.model;

import java.io.Serializable;

import business.model.Cursos.Data;

public class User implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = -3409171233621036055L;

    private String login, senha;
    private Data data_nascimento;

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

    public String toString() {
        return login + "\n" + senha;
    }

}
