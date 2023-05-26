package view;

import infra.InfraException;
import util.BirthDateInvalidException;
import util.LoginInvalidException;
import util.PasswordInvalidException;
import java.util.Scanner;

import business.control.CursoManagerFacade;
import business.control.QuestionarioManagerFacade;
import business.control.UserManagerFacade;

import business.model.Curso;
import business.model.Questionario.Pergunta;

public class MainScreenDesktop {

    private static UserManagerFacade userManager;
    private static CursoManagerFacade CursoManager= CursoManagerFacade.getInstance();
    
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws InfraException {
        userManager = UserManagerFacade.getInstance();
        showMenu();
    }

    private static void showMenu() {
        System.out.println("Bem vindo ao sistema GUFPB !");
        System.out.println("Escolha a opcao desejada:");
        System.out.println("1-Cadastrar Usuario");
        System.out.println("2-Listar Usuarios");
        System.out.println("3-Excluir Usuario");
        System.out.println("4-Ver Cursos Disponiveis");
        System.out.println("6-Responder Questionario");
        System.out.println("5-Sair");

        int option = readIntInput();

        switch (option) {
            case 1:
                try {
                    userManager.registerUser();
                } catch (LoginInvalidException e) {
                    System.out.println(e.getMessage());
                } catch (PasswordInvalidException e) {
                    System.out.println(e.getMessage());
                } catch (BirthDateInvalidException e) {
                    System.out.println(e.getMessage());
                }
                showMenu();
                break;
            case 2:
                try {
                    userManager.listUsers();
                } catch (InfraException e) {
                    System.out.println(e.getMessage());
                }
                showMenu();
                break;
            case 3:
                try {
                    userManager.removeUser();
                } catch (InfraException e) {
                    System.out.println(e.getMessage());
                }
                showMenu();
                break;
            case 4:
                CursoManager = CursoManagerFacade.getInstance();
                CursoManager.listarCursos();
                showMenu();
                break;
            case 5:
                System.exit(0);
            case 6:
                QuestionarioManagerFacade questionario = QuestionarioManagerFacade.getInstance();
                questionario.executarQuestionario();
                showMenu();
                break;    
            default:
                System.out.println("Opcao invalida!");
                showMenu();
                break;
        }
    }

    private static int readIntInput() {
        while (true) {
            System.out.print("Digite sua opcao: ");
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Opcao invalida! Digite novamente.");
            }
        }
    }

}
