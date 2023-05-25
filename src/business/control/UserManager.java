package business.control;

import infra.InfraException;
import util.LoginInvalidException;
import util.PasswordInvalidException;
import util.UserValidador;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;
import business.model.Cursos.Data;
import business.model.User;

public class UserManager {

	private Map<String, User> users;

	public UserManager() throws InfraException {
		users = new TreeMap<>(Comparator.naturalOrder());
	}

	public void addUser(String[] args, Data data2)
			throws LoginInvalidException, PasswordInvalidException {
		UserValidador.validateName(args[0]);
		UserValidador.validatePassword(args[1]);
		users.put(args[0], new User(args[0], args[1], data2));
	}

	public void removeUser(String login) throws InfraException {
		if (!users.containsKey(login)) {
			throw new InfraException("Usuário não encontrado.");
		}
		users.remove(login);
	}

	public Map<String, User> getAllClients() throws InfraException {
		if (users.isEmpty()) {
			throw new InfraException("Não há usuários cadastrados.");
		} else {
			return users;
		}
	}

}


