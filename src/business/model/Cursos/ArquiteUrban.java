package business.model.Cursos;

import business.model.Curso;

public class ArquiteUrban extends Curso {

    public ArquiteUrban(String nome, int anosDuração, String area) {
        super(nome, anosDuração, area);
        // TODO Auto-generated constructor stub
    }

    int anosDuração = 4;

    @Override
    public int getAnosDuração() {
        // TODO Auto-generated method stub
        return anosDuração;
    }

    @Override
    public String getArea() {
        // TODO Auto-generated method stub
        return super.getArea();
    }

    @Override
    public StringBuilder getGradeCurrular() {
        // TODO Auto-generated method stub
        return super.getGradeCurrular();
    }

    @Override
    public String getNome() {
        // TODO Auto-generated method stub
        return super.getNome();
    }

    @Override
    public void setAnosDuração(int anosDuração) {
        // TODO Auto-generated method stub
        super.setAnosDuração(anosDuração);
    }

    @Override
    public void setArea(String area) {
        // TODO Auto-generated method stub
        super.setArea(area);
    }

    @Override
    public void setGradeCurrular(String grade) {
        // TODO Auto-generated method stub
        super.setGradeCurrular(grade);
    }

    @Override
    public void setNome(String nome) {
        // TODO Auto-generated method stub
        super.setNome(nome);
    }

}
