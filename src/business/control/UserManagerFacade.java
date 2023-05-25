package business.control;

import infra.InfraException;
import util.LoginInvalidException;
import util.PasswordInvalidException;
import java.util.Map;

import business.model.User;
import business.model.Cursos.Data;

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

	public void addUser(String[] args, Data data) throws LoginInvalidException, PasswordInvalidException {
		userManager.addUser(args, data);
	}

	public void removeUser(String login) throws InfraException {
		userManager.removeUser(login);
	}

	public Map<String, User> getAllClients() throws InfraException {
		return userManager.getAllClients();
	}

}
