package business.model;

public abstract class Curso {
    protected String nome;
    protected int anosDuração;
    protected StringBuilder gradeCurricular;
    protected String area;

    // Construtor
    public Curso(String nome, int anosDuração, String area) {
        this.nome = nome;
        this.anosDuração = anosDuração;
        this.area = area;
    }

    // Método Template
    public void imprimirInformacoesCurso() {
        System.out.println("Informações do Curso:");
        System.out.println("Nome: " + getNome());
        System.out.println("Duração: " + getDuracaoCurso() + " anos");
        System.out.println("Área: " + getArea());
        imprimirGradeCurricular();
        System.out.println("---------------------");
    }

    // Métodos abstratos para serem implementados pelas subclasses
    protected abstract void imprimirGradeCurricular();
    protected abstract void setGradeCurricular(String grade);


    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDuracaoCurso(int anosDuração) {
        this.anosDuração = anosDuração;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getNome() {
        return this.nome;
    }

    public int getDuracaoCurso() {
        return this.anosDuração;
    }

    public String getArea() {
        return this.area;
    }

    public StringBuilder getGradeCurricular() {
        return this.gradeCurricular;
    }
}