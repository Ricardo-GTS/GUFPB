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
import business.control.Observer.UserObserver;
import business.control.Observer.UserObserverImpl;
import business.model.Curso;
import business.model.User;

public class MainScreenDesktop {

    private static UserManagerFacade userManager;
    private static CursoManagerFacade CursoManager = CursoManagerFacade.getInstance();
    private static LoginManager loginManager;
    private static Scanner scanner = new Scanner(System.in);
    private static QuestionarioManagerFacade questionario = QuestionarioManagerFacade.getInstance();
    private static User loggedInUser;
    private static Curso CursoRecomendado;
    private static UserObserver observer = new UserObserverImpl();

    public static void main(String[] args) throws InfraException {
        System.out.println("Bem vindo ao sistema GUFPB !");
        userManager = UserManagerFacade.getInstance();
        userManager.addObserver(observer);
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
            System.out.println("6-Restaurar Login Anterior");
            System.out.println("7-Sair");
            System.out.println("Obs. Faça o Login para Responder o Questionário e Ver o Curso Recomendado\n");

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
                    if(loginManager.restoreState()){
                        loggedInUser = loginManager.getLoggedInUser();
                        System.out.println("Login restaurado com sucesso! Bem vindo de volta " + loggedInUser.getLogin() + "!");
                        showLoggedInMenu();
                    } else {
                        showMenu();
                    }
                    break;                    
                case 7:
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
        String resposta;

        switch (option) {
            case 1:
                CursoManager.listarCursos();
                showLoggedInMenu();
                break;
            case 2:
                questionario.executarQuestionario();
                System.out.println("Calculando Curso Recomendado...");
                questionario.calcularCursoRecomendado();
                loggedInUser.setCurso_Recomendado(questionario.getCursoRecomendado());
                
                CursoRecomendado = CursoManager.buscarCurso(loggedInUser.getCurso_Recomendado());
                if (CursoRecomendado != null) {
                    System.out.println("Esse é o Curso Recomendado para você:\n");
                    CursoRecomendado.imprimirInformacoesCurso();
                    System.out.println("Deseja ver a Grade Curricular? (S/N)");
                    resposta = scanner.nextLine();
                    if (resposta.equalsIgnoreCase("S"))
                    CursoRecomendado.exibirGradeCurricular();
                } else {
                    System.out.println("Nenhum curso recomendado encontrado.");
                }
                showLoggedInMenu();
                break;
            case 3:
                if(CursoRecomendado != null){
                    System.out.println("Esse é o Curso Recomendado para você : ");
                    CursoRecomendado.imprimirInformacoesCurso();
                    System.out.println("Quer Ver a Grade Curricular ? (S/N)");
                    resposta = scanner.nextLine();
                    if (resposta.equals("S") || resposta.equals("s"))
                    CursoRecomendado.exibirGradeCurricular();
                    CursoManager.buscarCurso(loggedInUser.getCurso_Recomendado());
                }else{
                    System.out.println("Você ainda não respondeu o questionário");
                }
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
                questionario.CleanRespostaQuestionario();
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
