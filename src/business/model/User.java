
package business.model;


public class User {

    private String login;
    private String senha;
    private Data data_nascimento;
    private String Curso_Recomendado;

    private User(BuilderUser builder) {
        this.login = builder.login;
        this.senha = builder.senha;
        this.data_nascimento = builder.data_nascimento;
        this.Curso_Recomendado = builder.Curso_Recomendado;
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

    public Data getData_nascimento() {
        return data_nascimento;
    }

    public String getCurso_Recomendado() {
        return Curso_Recomendado;
    }

    public void setCurso_Recomendado(String curso_Recomendado) {
        Curso_Recomendado = curso_Recomendado;
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", senha='" + senha + '\'' +
                ", data_nascimento=" + data_nascimento +
                ", Curso_Recomendado='" + Curso_Recomendado + '\'' +
                '}';
    }

    public static class BuilderUser {                       // Metodo Builder
        private String login;
        private String senha;
        private Data data_nascimento;
        private String Curso_Recomendado;

        public BuilderUser(String login, String senha, Data data_nascimento){
            this.login = login;
            this.senha = senha;
            this.data_nascimento = data_nascimento;
        }

        public BuilderUser dataNascimento(Data data_nascimento) {
            this.data_nascimento = data_nascimento;
            return this;
        }

        public BuilderUser cursoRecomendado(String Curso_Recomendado) {
            this.Curso_Recomendado = Curso_Recomendado;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }

}
