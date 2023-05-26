package business.model.Cursos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import business.model.Curso;

public class fisica extends Curso {

    public fisica(String nome, int anosDuração, String area) {
        super(nome, anosDuração, area);
        carregarGradeCurricular();

    }

    @Override
    protected void setGradeCurricular(String grade) {
        gradeCurricular = new StringBuilder();
        gradeCurricular.append(grade);
    }

    @Override
    protected void imprimirGradeCurricular() {
        System.out.println("Grade Curricular do curso de Física:");
        System.out.println(gradeCurricular);
    }

    private void carregarGradeCurricular() {
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("resources/GradeFisica.txt");
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
