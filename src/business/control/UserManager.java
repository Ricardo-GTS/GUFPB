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

    public String registerUser() throws LoginInvalidException, PasswordInvalidException, BirthDateInvalidException {
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
                User temp = addUser(args, data2);
                return temp.getLogin(); 
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
            System.out.println("\nUsuários cadastrados:");
            for (User user : users) {
                System.out.println("[ Login: " + user.getLogin() + " || Senha: " + user.getSenha()
                        + " || Data de Nascimento: " + user.getData_nascimento() + " ]");
            }
        } catch (InfraException e) {
            System.out.println(e.getMessage());
        }
    }

    public String removeUser() throws InfraException {
        System.out.print("Digite o login do usuário que deseja excluir: ");
        String login = scanner.nextLine();
        String Removed = null;
        try {
            Removed = DeleteUser(login);
        } catch (InfraException e) {
            System.out.println(e.getMessage());
        }
        return Removed;
    }

    public String DeleteUser(String login) throws InfraException {
        User userToRemove = null;
        for (User user : users) {
            if (user.getLogin().equals(login)) {
                userToRemove = user;
                break;
            }
        }
        if (userToRemove == null) {
            throw new InfraException("\nUsuário não encontrado.");
        }
        users.remove(userToRemove);
        return userToRemove.getLogin();
    }

    private User addUser(String[] args, Data data2)
            throws LoginInvalidException, PasswordInvalidException, BirthDateInvalidException {
        UserValidador.validateName(args[0]);
        UserValidador.validatePassword(args[1]);
        UserValidador.validateBirthDate(data2);
        User temp = createUser(args[0], args[1], data2);
        users.add(temp);
        return temp;
    }

    private User createUser(String username, String password, Data data) {      // Padrão Factory
        // Lógica de criação de um objeto User
        return new User.BuilderUser(username, password, data).build();          // Padrão Builder
    }

    public Set<User> getAllClients() throws InfraException {
        if (users.isEmpty()) {
            throw new InfraException("\nNão há usuários cadastrados.");
        } else {
            return users;
        }
    }

    public User getUser(String login) throws InfraException {
        for (User user : users) {
            if (user.getLogin().equals(login)) {
                return user;
            }
        }
        throw new InfraException("\nUsuário não encontrado.");
    }

   // public void Calculate_Curso_Recomendado(User user)

    private static class ComparadorData implements Comparator<User> {
        @Override
        public int compare(User user1, User user2) {
            return user2.getData_nascimento().compareTo(user1.getData_nascimento());
        }
    }


}
