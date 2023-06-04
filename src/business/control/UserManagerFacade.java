package business.control;

import infra.InfraException;
import util.BirthDateInvalidException;
import util.LoginInvalidException;
import util.PasswordInvalidException;
import java.util.Set;
import java.util.HashSet;

import business.control.Observer.UserObserver;
import business.model.User;



public class UserManagerFacade {							// Padrão Facade
    private static UserManagerFacade instance;
    private UserManager userManager;
    private Set<UserObserver> observers;

    private UserManagerFacade() throws InfraException {
        userManager = new UserManager();
        observers = new HashSet<>();
    }

    public static synchronized UserManagerFacade getInstance() throws InfraException { 	// Padrão Singleton
        if (instance == null) {
            instance = new UserManagerFacade();
        }
        return instance;
    }

    public void registerUser() throws LoginInvalidException, PasswordInvalidException, BirthDateInvalidException {
        String user = userManager.registerUser();
        notifyUserRegistered(user);
    }

    public void removeUser() throws InfraException {
        String user = userManager.removeUser();
        notifyUserRemoved(user);
    }

    public void listUsers() throws InfraException {
        userManager.listUsers();
    }

    public User getUser(String login) throws InfraException {
        return userManager.getUser(login);
    }

    public Set<User> getAllClients() throws InfraException {
        return userManager.getAllClients();
    }

    public void addObserver(UserObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(UserObserver observer) {
        observers.remove(observer);
    }

    private void notifyUserRegistered(String user) {
        for (UserObserver observer : observers) {
            observer.onUserRegistered(user);
        }
    }

    private void notifyUserRemoved(String user) {
        for (UserObserver observer : observers) {
            observer.onUserRemoved(user);
        }
    }

}