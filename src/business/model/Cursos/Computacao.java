package business.model.Cursos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import business.model.Curso;

public class Computacao extends Curso {

    public Computacao(String nome, int anosDuração, String area) {
        super(nome, anosDuração, area);
        carregarGradeCurricular();
        // TODO Auto-generated constructor stub
    }

    @Override
    protected void setGradeCurricular(String grade) {
        // TODO Auto-generated method stub
        gradeCurricular = new StringBuilder();
        gradeCurricular.append(grade);
    }

    @Override
    protected void imprimirGradeCurricular() {
        // TODO Auto-generated method stub
        System.out.println("Grade Curricular do curso de Ciência da Computação:");
        System.out.println(gradeCurricular);
    }

    private void carregarGradeCurricular() {
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("resources/GradeCC.txt");
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            StringBuilder grade = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                grade.append(line).append("\n");
            }
            setGradeCurricular(grade.toString());
        } catch (IOException e) {
            System.out.println("Erro ao carregar a grade curricular: " + e.getMessage());
        }
    }

}
