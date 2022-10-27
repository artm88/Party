package impl;

import api.Registrator;
import api.User;

import java.util.Scanner;

public class RegistratorImpl implements Registrator { // регистратция пользователя
    @Override
    public User registerUser() {
        System.out.print("Добро пожаловать, введите имя: ");
        Scanner scanner=new Scanner(System.in);
        String name = scanner.nextLine();
        return new UserImpl(name);
    }
}
