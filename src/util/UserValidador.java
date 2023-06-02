package util;

import business.model.Data;

public class UserValidador {

    public static void validateName(String name) throws LoginInvalidException {
        if (name.length() > 20) {
            throw new LoginInvalidException("Login com mais de 20 caracteres!\n");
        } else if (name.length() == 0) {
            throw new LoginInvalidException("Login vazio!\n");
        } else if (name.matches(".*\\d.*")) {
            throw new LoginInvalidException("Login não pode conter números!\n");
        }
    }

    public static void validatePassword(String pass) throws PasswordInvalidException {
        if (pass.length() > 12) {
            throw new PasswordInvalidException("Senha não pode possuir mais de 12 caracteres!\n");
        } else if (pass.length() < 8) {
            throw new PasswordInvalidException("Senha não pode possuir menos de 8 caracteres!\n");
        } else if (!pass.matches(".*\\d.*") || !pass.matches(".*\\c.*")) {
            throw new PasswordInvalidException("Senha deve possuir caracteres e números!\n");
        } else if (countNumbers(pass) < 2) {
            throw new PasswordInvalidException("Senha deve ter pelo menos 2 números!\n");
        }
    }

    public static void validateBirthDate(Data data) throws BirthDateInvalidException {
        int dia = data.getDia();
        int mes = data.getMes();
        int ano = data.getAno();

        if (dia < 1 || dia > 31 || mes < 1 || mes > 12 || ano <= 1900 || ano >= 2023) {
            throw new BirthDateInvalidException("Data de nascimento inválida!\n");
        }
    }

    private static int countNumbers(String s) {
        int count = 0;
        for (int i = 0, len = s.length(); i < len; i++) {
            if (Character.isDigit(s.charAt(i))) {
                count++;
            }
        }
        return count;
    }
}
