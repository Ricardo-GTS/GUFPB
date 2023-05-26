package business.control;

import infra.InfraException;
import util.BirthDateInvalidException;
import util.LoginInvalidException;
import util.PasswordInvalidException;
import util.UserValidador;

import java.util.Comparator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import business.model.Data;
import business.model.User;

public class UserManager {

    private Set<User> users;

    private static Scanner scanner = new Scanner(System.in);

    public UserManager() throws InfraException {
        users = new TreeSet<>(new ComparadorData());
    }

    public void registerUser() throws LoginInvalidException, PasswordInvalidException, BirthDateInvalidException {
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
                addUser(args, data2);
                System.out.println("Usuario adicionado com sucesso!");
                break;
            } catch (LoginInvalidException e) {
                System.out.println(e.getMessage());
                System.out.print("Nome do usuario: ");
                name = scanner.nextLine();
            } catch (PasswordInvalidException e) {
                System.out.println(e.getMessage());
                System.out.print("Senha do usuario: ");
                pass = scanner.nextLine();
            } catch (BirthDateInvalidException e) {
                System.out.println(e.getMessage());
                System.out.println("Data de nascimento");
                System.out.print("Dia: ");
                dia = scanner.nextInt();
                scanner.nextLine();

                System.out.print("Mes: ");
                mes = scanner.nextInt();
                scanner.nextLine();

                System.out.print("Ano: ");
                ano = scanner.nextInt();
                scanner.nextLine();

                data2 = new Data(dia, mes, ano);
                System.out.println(data2);
            }
        }
    }

    public void listUsers() throws InfraException {
        try {
            Set<User> users = getAllClients();
            System.out.println("Usuários cadastrados:");
            for (User user : users) {
                System.out.println("[ Login: " + user.getLogin() + " || Senha: " + user.getSenha()
                        + " || Data de Nascimento: " + user.getData_nascimento() + " ]");
            }
        } catch (InfraException e) {
            System.out.println(e.getMessage());
        }
    }

    public void removeUser() throws InfraException {
        System.out.print("Digite o login do usuário que deseja excluir: ");
        String login = scanner.nextLine();
        try {
            DeleteUser(login);
            System.out.println("Usuário removido com sucesso!");
        } catch (InfraException e) {
            System.out.println(e.getMessage());
        }
    }

    public void DeleteUser(String login) throws InfraException {
        User userToRemove = null;
        for (User user : users) {
            if (user.getLogin().equals(login)) {
                userToRemove = user;
                break;
            }
        }
        if (userToRemove == null) {
            throw new InfraException("Usuário não encontrado.");
        }
        users.remove(userToRemove);
    }

    private void addUser(String[] args, Data data2)
            throws LoginInvalidException, PasswordInvalidException, BirthDateInvalidException {
        UserValidador.validateName(args[0]);
        UserValidador.validatePassword(args[1]);
        UserValidador.validateBirthDate(data2);
        users.add(createUser(args[0], args[1], data2));
    }

    private User createUser(String username, String password, Data data) {
        return new User(username, password, data);
    }

    public Set<User> getAllClients() throws InfraException {
        if (users.isEmpty()) {
            throw new InfraException("Não há usuários cadastrados.");
        } else {
            return users;
        }
    }

    private static class ComparadorData implements Comparator<User> {
        @Override
        public int compare(User user1, User user2) {
            return user2.getData_nascimento().compareTo(user1.getData_nascimento());
        }
    }
}
