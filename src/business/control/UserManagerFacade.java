package business.control;

import infra.InfraException;
import util.BirthDateInvalidException;
import util.LoginInvalidException;
import util.PasswordInvalidException;
import java.util.Map;
import java.util.Set;

import business.model.Data;
import business.model.User;

public class UserManagerFacade {			// Padrão Facade

	private static UserManagerFacade instance;
	private UserManager userManager;

	private UserManagerFacade() throws InfraException {
		userManager = new UserManager();
	}

	public static synchronized UserManagerFacade getInstance() throws InfraException {		// Padrão Singleton
		if (instance == null) {
			instance = new UserManagerFacade();
		}
		return instance;
	}

	public void addUser(String[] args, Data data) throws LoginInvalidException, PasswordInvalidException, BirthDateInvalidException {
		userManager.addUser(args, data);
	}

	public void removeUser(String login) throws InfraException {
		userManager.removeUser(login);
	}

	public Set<User> getAllClients() throws InfraException {
		return userManager.getAllClients();
	}

}
