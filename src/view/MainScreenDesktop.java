package view;

import infra.InfraException;
import util.LoginInvalidException;
import util.PasswordInvalidException;

import java.util.Iterator;
import java.util.Scanner;

import business.control.UserManager;
import business.model.User;
import business.model.Cursos.ArquiteUrban;

public class MainScreenDesktop {

    private static UserManager userManager;
    private static Scanner scanner = new Scanner(System.in);
    private static ArquiteUrban arquiteUrban;

    public static void main(String[] args) throws InfraException {
        InicializarCursos();
        userManager = new UserManager();
        showMenu();
    }

    private static void showMenu() {
        System.out.println("Bem vindo ao sistema GUFPB !");
        System.out.println("Escolha a opcao desejada:");
        System.out.println("1-Cadastrar Usuario");
        System.out.println("2-Listar Usuarios");
        System.out.println("3-Excluir Usuario");
        System.out.println("4-Ver Cursos Disponiveis");
        System.out.println("5-Sair");

        int option = readIntInput();

        switch (option) {
            case 1:
                registerUser();
                break;
            case 2:
                listUsers();
                break;
            case 3:
                removeUser();
                break;
            case 4:
                ListarCursos();
                break;
            case 5:
                System.exit(0);
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

    private static void registerUser() {
        String name = readStringInput("Nome do usuario:");
        String pass = readStringInput("Senha do usuario:");

        while (true) {
            try {
                String[] args = {name, pass};
                userManager.addUser(args);
                System.out.println("Usuario adicionado com sucesso!");
                break;
            } catch (LoginInvalidException e) {
                System.out.println(e.getMessage());
                name = readStringInput("Nome do usuario:");
            } catch (PasswordInvalidException e) {
                System.out.println(e.getMessage());
                pass = readStringInput("Senha do usuario:");
            } 
        }

        showMenu();
    }

    private static void listUsers() {
        String usuarios = "";
        Iterator<User> users;
        try {
            users = userManager.getAllClients().values().iterator();
            while (users.hasNext()) {
                User user = users.next();
                usuarios = usuarios + "[ Login: " + user.getLogin() + " || Senha: " + user.getSenha() + " ]" + "\n";
            }
            System.out.println(usuarios);
        } catch (InfraException e) {
            System.out.println(e.getMessage());
        }

        showMenu();
    }

    private static void removeUser() {
        String login = readStringInput("Digite o login do usuario que deseja excluir:");
        try {
            if (userManager.getAllClients().containsKey(login)) {
                userManager.getAllClients().remove(login);
                System.out.println("Usuario removido com sucesso!");
            } else {
                System.out.println("Usuario nao encontrado!");
            }
        } catch (InfraException e) {
            System.out.println(e.getMessage());
        }

        showMenu();
    }

    private static void InicializarCursos() {
        arquiteUrban = new ArquiteUrban("Aquitetura e Urbanismo", 4, "Ciências Sociais");
        arquiteUrban.setGradeCurrular("Aqui a gente coloca toda a grade curricular");
    }

    private static void ListarCursos() {
        System.out.println(arquiteUrban);
    }

    private static String readStringInput(String prompt) {
        System.out.print(prompt + " ");
        return scanner.nextLine();
    }
}
