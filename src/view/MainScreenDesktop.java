package view;

import infra.InfraException;
import util.BirthDateInvalidException;
import util.LoginInvalidException;
import util.PasswordInvalidException;
import java.util.Scanner;

import business.control.CursoManagerFacade;
import business.control.LoginManager;
import business.control.QuestionarioManagerFacade;
import business.control.UserManagerFacade;
import business.model.Curso;
import business.model.User;
import business.model.Questionario.Pergunta;

public class MainScreenDesktop {

    private static UserManagerFacade userManager;
    private static CursoManagerFacade CursoManager = CursoManagerFacade.getInstance();
    private static LoginManager loginManager;
    private static Scanner scanner = new Scanner(System.in);
    private static User loggedInUser;

    public static void main(String[] args) throws InfraException {
        System.out.println("Bem vindo ao sistema GUFPB !");
        userManager = UserManagerFacade.getInstance();
        loginManager = LoginManager.getInstance();
        showMenu();
    }

    private static void showMenu() throws InfraException {

        if (!loginManager.isLoggedIn()) {
            System.out.println("\nEscolha a opção desejada:");
            System.out.println("1-Login");
            System.out.println("2-Cadastrar Usuário");
            System.out.println("3-Listar Usuários");
            System.out.println("4-Excluir Usuário");
            System.out.println("5-Ver Cursos Disponíveis");
            System.out.println("6-Sair\n");

            int option = readIntInput();

            switch (option) {
                case 1:
                    loggedInUser = loginManager.performLogin();
                    if (loggedInUser != null) {
                        showLoggedInMenu();
                    } else {
                        showMenu();
                    }
                    break;
                case 2:
                    try {
                        userManager.registerUser();
                    } catch (LoginInvalidException | PasswordInvalidException | BirthDateInvalidException e) {
                        System.out.println(e.getMessage());
                    }
                    showMenu();
                    break;
                case 3:
                    try {
                        userManager.listUsers();
                    } catch (InfraException e) {
                        System.out.println(e.getMessage());
                    }
                    showMenu();
                    break;
                case 4:
                    try {
                        userManager.removeUser();
                    } catch (InfraException e) {
                        System.out.println(e.getMessage());
                    }
                    showMenu();
                    break;
                case 5:
                    CursoManager.listarCursos();
                    showMenu();
                    break;
                case 6:
                    System.exit(0);
                default:
                    System.out.println("Opção inválida!");
                    showMenu();
                    break;
            }
        } else {
            showLoggedInMenu();
        }
    }

    private static void showLoggedInMenu() throws InfraException {
        System.out.println("\nEscolha a opção desejada:");
        System.out.println("1-Ver Cursos Disponíveis");
        System.out.println("2-Responder Questionário");
        System.out.println("3-Ver Curso Recomendado");
        System.out.println("4-Listar Usuários");
        System.out.println("5-Excluir Usuário");
        System.out.println("6-Logout\n");

        int option = readIntInput();

        switch (option) {
            case 1:
                CursoManager.listarCursos();
                showLoggedInMenu();
                break;
            case 2:
                QuestionarioManagerFacade questionario = QuestionarioManagerFacade.getInstance();
                loggedInUser.SetRespostasQuestionario(questionario.executarQuestionario());
                showLoggedInMenu();
                break;
            case 3:
                // Implementar a funcionalidade de ver curso recomendado
                showLoggedInMenu();
                break;
            case 4:
                userManager.listUsers();
                showLoggedInMenu();
                break;
            case 5:
                userManager.removeUser();
                showLoggedInMenu();
                break;
            case 6:
                LoginManager.getInstance().logout();
                loggedInUser = null;
                showMenu();
                break;
            default:
                System.out.println("Opção inválida!");
                showLoggedInMenu();
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
