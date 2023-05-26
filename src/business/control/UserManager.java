package business.control;

import infra.InfraException;
import util.BirthDateInvalidException;
import util.LoginInvalidException;
import util.PasswordInvalidException;
import util.UserValidador;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

import business.model.Data;
import business.model.User;

public class UserManager {

    private Set<User> users;

    public UserManager() throws InfraException {
        users = new TreeSet<>(new ComparadorData());
    }

    public void addUser(String[] args, Data data2)
            throws LoginInvalidException, PasswordInvalidException, BirthDateInvalidException {
        UserValidador.validateName(args[0]);
        UserValidador.validatePassword(args[1]);
		UserValidador.validateBirthDate(data2);
        users.add(createUser(args[0], args[1], data2));
    }

    private User createUser(String username, String password, Data data) {        // Padrão Factory
        // Lógica de criação de um objeto User
        return new User(username, password, data);
    }

    public void removeUser(String login) throws InfraException {
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

    public Set<User> getAllClients() throws InfraException {
        if (users.isEmpty()) {
            throw new InfraException("Não há usuários cadastrados.");
        } else {
            return users;
        }
    }

	public void displayUsersByDescendingBirthdate() {
		if (users.isEmpty()) {
			System.out.println("Não há usuários cadastrados.");
		} else {
			System.out.println("Usuários ordenados por data de nascimento decrescente:");
			for (User user : users) {
				System.out.println(user);
			}
		}
	}

	private static class ComparadorData implements Comparator<User> {
        @Override
        public int compare(User user1, User user2) {
            // Comparação da data de nascimento em ordem decrescente
            return user2.getData_nascimento().compareTo(user1.getData_nascimento());
        }
    }
}
