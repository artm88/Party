package impl;

import api.Registrator;
import api.User;

import java.util.Scanner;

public class RegistratorImpl implements Registrator { // регистратция пользователя
    @Override
    public User registerUser() {
        System.out.print("Добро пожаловать, введите имя: ");
        Scanner scannerName=new Scanner(System.in);
        String name = scannerName.nextLine();
        System.out.println("Добро пожаловать на коктейльную пати в честь вашего устройства на работу.\n" +
                "Вы в комнате, перед Вами выбор куда подойти. " +
                "Так же Вы можете пройти мимо или отдохнуть.\n"); // главное меню
        return new UserImpl(name);
    }
}
