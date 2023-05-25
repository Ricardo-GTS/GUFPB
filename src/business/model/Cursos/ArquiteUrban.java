package business.model.Cursos;

import business.model.Curso;

public class ArquiteUrban extends Curso {


    public ArquiteUrban(String nome, int anosDuração, String area) {
        super(nome, anosDuração, area);
    }
    
    @Override
    public void setGradeCurricular(String grade) {
        gradeCurricular = new StringBuilder();
        gradeCurricular.append(grade);
    }

    @Override
    public void imprimirGradeCurricular() {     //Método Template
        // Implementação específica para o curso ArquiteUrban
        System.out.println("Grade Curricular do curso Aquitetura e Urbanismo:");
        System.out.println(gradeCurricular);
    }




}
