package app;

import api.Game;
import api.Registrator;
import api.User;
import impl.GameImpl;
import impl.RegistratorImpl;
import impl.UserImpl;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Registrator registrator = new RegistratorImpl();
        User user = registrator.registerUser();
        Game game = new GameImpl(user);
        int exit=0;
        do {
            game.play();
            System.out.println(user.getName() + ", твой счет игры " + user.scoreOfGame());
            System.out.println("Нажми цифру 4 для выхода или любую другую цифру для продолжения");
            Scanner scannerOfExit = new Scanner(System.in); // взаимодействие с пользователем
            exit=scannerOfExit.nextInt();
        } while (exit!=4);
    }

}
