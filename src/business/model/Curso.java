package business.model;

//Classe pai para criar os metodos e fazer as classes filhas herdarem.

public abstract class Curso {
    protected String nome;
    protected int anosDuração;
    protected StringBuilder gradeCurrular;
    protected String area;

    // Construtor
    public Curso(String nome, int anosDuração, String area) {
        this.nome = nome;
        this.anosDuração = anosDuração;
        this.area = area;
    }

    // Gets e Sets
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAnosDuração() {
        return anosDuração;
    }

    public void setAnosDuração(int anosDuração) {
        this.anosDuração = anosDuração;
    }

    public StringBuilder getGradeCurrular() {
        return gradeCurrular;
    }

    public void setGradeCurrular(String grade) {
        gradeCurrular = new StringBuilder();
        gradeCurrular.append(grade);
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String toString() {
        return "Curso: " + nome + "\n" +
                "Duração: " + anosDuração + " anos" + "\n" +
                "Área: " + area + "\n" +
                "Grade curricular: " + gradeCurrular;
    }

}
