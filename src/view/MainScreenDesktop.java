package view;

import infra.InfraException;
import util.LoginInvalidException;
import util.PasswordInvalidException;

import java.util.Iterator;
import java.util.Scanner;

import business.control.UserManager;
import business.model.User;

public class MainScreenDesktop {

    UserManager userManager;

    public static void main(String[] args) {
        showMenu();
    }

    public static void showMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bem vindo ao sistema GUFPB !");
        System.out.println("Escolha a opcao desejada:");
        System.out.println("1-Cadastrar Usuario");
        System.out.println("2-Listar Usuarios");
        System.out.println("3-Excluir Usuario");
        System.out.println("4-Sair");

        String option = scanner.nextLine();

        MainScreenDesktop main = new MainScreenDesktop();

        main.readUserInput(option);
    }

    public void readUserInput(String option) {
        try {
            userManager = new UserManager();
        } catch (InfraException e) {
            System.out.println(e.getMessage());
        }
        int choice = Integer.parseInt(option);
        boolean checkedLogin = false;
        boolean checkedPassword = false;
        switch (choice) {

            case 1:

                while (true) {
                    String name = "";
                    String pass = "";

                    if (!checkedLogin) {
                        System.out.println("Nome do usuario:");
                        name = new Scanner(System.in).nextLine();

                    }
                    if (!checkedPassword) {
                        System.out.println("Senha do usuario:");
                        pass = new Scanner(System.in).nextLine();

                    }

                    try {
                        String[] args = {name, pass};
                        this.userManager.addUser(args);
                        System.out.println("Usuario adicionado com sucesso!");
                        break;
                    } catch (LoginInvalidException e) {
                        System.out.println(e.getMessage());
                        checkedLogin = false;
                        checkedPassword = true;
                    } catch (PasswordInvalidException e) {
                        System.out.println(e.getMessage());
                        checkedLogin = true;
                        checkedPassword = false;
                    }

                }
                showMenu();
                break;

            case 2:
                String usuarios = "";
                Iterator<User> users;
                try {
                    users = this.userManager.getAllClients().values().iterator();
                    while (users.hasNext()) {
                        User user = users.next();
                        usuarios = usuarios + "[ Login: " + user.getLogin() + " || Senha: " + user.getSenha() + " ]" + "\n";
                    }
                    System.out.println(usuarios);
                } catch (InfraException e) {
                    System.out.println(e.getMessage());
                }


                showMenu();
                break;
            case 3:
                break;

        }
    }
}