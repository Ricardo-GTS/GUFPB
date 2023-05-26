package business.control;
import business.model.User;
import infra.InfraException;

import java.util.Scanner;

public class LoginManager {
    private static LoginManager instance;
    private UserManagerFacade userManager;
    private boolean loggedIn;
    
    private static Scanner scanner = new Scanner(System.in);

    private LoginManager() throws InfraException {
        userManager = UserManagerFacade.getInstance();
        loggedIn = false;
    }

    public static LoginManager getInstance() throws InfraException {
        if (instance == null) {
            instance = new LoginManager();
        }
        return instance;
    }

    public User performLogin() throws InfraException {
        System.out.print("Digite o nome de usuário: ");
        String username = scanner.nextLine();
        System.out.print("Digite a senha: ");
        String password = scanner.nextLine();

        try {
            User user = userManager.getUser(username);
            if (user != null && validateCredentials(username, password, user)) {
                System.out.println("Login bem-sucedido. Bem-vindo, " + user.getLogin() + "!");
                loggedIn = true;
                return user;
            } else {
                System.out.println("Nome de usuário ou senha inválidos.");
            }
        } catch (InfraException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    private boolean validateCredentials(String username, String password, User user) {
        return user.getLogin().equals(username) && user.getSenha().equals(password);
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void logout() {
        loggedIn = false;
        System.out.println("Logout realizado com sucesso.");
    }
}
