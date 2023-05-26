package business.model.Cursos;

import business.model.Curso;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ArquiteUrban extends Curso {

    public ArquiteUrban(String nome, int anosDuração, String area) {
        super(nome, anosDuração, area);
        carregarGradeCurricular();
    }

    @Override
    public void setGradeCurricular(String grade) {
        gradeCurricular = new StringBuilder();
        gradeCurricular.append(grade);
    }

    @Override
    public void imprimirGradeCurricular() {
        System.out.println("Grade Curricular do curso Arquitetura e Urbanismo:");
        System.out.println(gradeCurricular);
    }

    private void carregarGradeCurricular() {
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("resources/GradeArquiteUrban.txt");
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
