package business.control;

import business.control.MementoLogin.LoginMemento;
import business.control.MementoLogin.LoginMementoCareTaker;
import business.model.User;
import infra.InfraException;

import java.util.Scanner;

public class LoginManager {
    private static LoginManager instance;
    private User loggedInUser;
    private UserManagerFacade userManager;
    private boolean loggedIn;
    private LoginMementoCareTaker mementoCareTaker; // Memento caretaker
    
    private static Scanner scanner = new Scanner(System.in);

    private LoginManager() throws InfraException {      
        userManager = UserManagerFacade.getInstance();
        loggedIn = false;
        mementoCareTaker = new LoginMementoCareTaker(); // Inicializar o memento caretaker
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
            loggedInUser = userManager.getUser(username);
            if (loggedInUser != null && validateCredentials(username, password, loggedInUser)) {
                System.out.println("\nLogin bem-sucedido. Bem-vindo, " + loggedInUser.getLogin() + "!");
                loggedIn = true;
                return loggedInUser;
            } else {
                System.out.println("\nNome de usuário ou senha inválidos.");
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
        saveState();        // Salvar o estado do memento
        loggedIn = false;
        loggedInUser = null;
        System.out.println("\nLogout realizado com sucesso.");
    }
    
    public void saveState() {                               // Salvar o estado do memento
        LoginMemento memento = new LoginMemento(loggedInUser, loggedIn);
        mementoCareTaker.saveMemento(memento);
    }
    
    public boolean restoreState() {                          // Restaurar o estado do memento
        LoginMemento memento = mementoCareTaker.retrieveMemento();
        if (memento != null) {
            loggedInUser = memento.getLoggedInUser();
            loggedIn = memento.isLoggedIn();
            return true;
        } else {
            System.out.println("Não há estados salvos.");
            return false;
        }
    }

    public User getLoggedInUser() {
        return loggedInUser;
    }
    
}