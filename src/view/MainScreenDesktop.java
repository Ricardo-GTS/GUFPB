package view;

import infra.InfraException;
import util.LoginInvalidException;
import util.PasswordInvalidException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

import business.control.UserManagerFacade;
import business.model.Curso;
import business.model.User;
import business.model.Cursos.ArquiteUrban;
import business.model.Cursos.Data;

public class MainScreenDesktop {

    private static UserManagerFacade userManager;
    private static Scanner scanner = new Scanner(System.in);
    private static ArquiteUrban arquiteUrban;
    private static List<Curso> CursosListados = new ArrayList<>();
    private static Map<String, Curso> CursosListadosMap = new HashMap<>();

    public static void main(String[] args) throws InfraException {
        InicializarCursos();
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
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nome do usuario: ");
        String name = scanner.nextLine();

        System.out.print("Senha do usuario:");
        String pass = scanner.nextLine();

        System.out.println("Data de nascimento");
        System.out.print("Dia: ");
        int dia = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Mes: ");
        int mes = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Ano: ");
        int ano = scanner.nextInt();
        scanner.nextLine();

        Data data2 = new Data(dia, mes, ano);
        System.out.println(data2);

        while (true) {
            try {
                String[] args = { name, pass, data2.toString() };
                userManager.addUser(args, data2);
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
        scanner.close();

    }

    private static void listUsers() {

        String usuarios = "";
        Iterator<User> users;
        try {
            users = userManager.getAllClients().values().iterator();
            while (users.hasNext()) {
                User user = users.next();
                usuarios = usuarios + "[ Login: " + user.getLogin() + " || Senha: " + user.getSenha()
                        + " ||" + " Data de Nascimento: " + user.getData_nascimento() + " ]" + "\n";
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
                userManager.removeUser(login);
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
        arquiteUrban.setGradeCurricular("Aqui a gente coloca toda a grade curricular");
        CursosListadosMap.put("ArquiteUrban", arquiteUrban);

        // Adicionar outros cursos aqui

    }

    private static void ListarCursos() {

        System.out.println("Cursos Listados:");
        for (Map.Entry<String, Curso> entry : CursosListadosMap.entrySet()) {
            String nome = entry.getKey();
            Curso curso = entry.getValue();
            System.out.println("Curso: " + nome);
            curso.imprimirInformacoesCurso();
        }
        
        showMenu();
    }

    private static String readStringInput(String prompt) {
        System.out.print(prompt + " ");
        return scanner.nextLine();
    }
}
