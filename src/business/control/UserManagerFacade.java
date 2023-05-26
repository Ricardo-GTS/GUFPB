package business.control;

import infra.InfraException;
import util.BirthDateInvalidException;
import util.LoginInvalidException;
import util.PasswordInvalidException;
import java.util.Set;

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

	public void registerUser() throws LoginInvalidException, PasswordInvalidException, BirthDateInvalidException {
		userManager.registerUser();
	}

	public void removeUser() throws InfraException {
		userManager.removeUser();
	}

	public void listUsers() throws InfraException {
		userManager.listUsers();
	}

	public Set<User> getAllClients() throws InfraException {
		return userManager.getAllClients();
	}

}
