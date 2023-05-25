package business.control;

import infra.InfraException;
import util.LoginInvalidException;
import util.PasswordInvalidException;
import java.util.Map;

import business.model.User;

public class UserManagerFacade {
    private static UserManagerFacade instance;
    private UserManager userManager;

    private UserManagerFacade() throws InfraException {
        userManager = new UserManager();
    }

    public static synchronized UserManagerFacade getInstance() throws InfraException {
        if (instance == null) {
            instance = new UserManagerFacade();
        }
        return instance;
    }

    public void addUser(String[] args) throws LoginInvalidException, PasswordInvalidException {
        userManager.addUser(args);
    }

    public void removeUser(String login) throws InfraException {
        userManager.removeUser(login);
    }

    public Map<String, User> getAllClients() throws InfraException {
        return userManager.getAllClients();
    }

    public UserManager createUserManager() throws InfraException {
        return new UserManager();
    }
}
