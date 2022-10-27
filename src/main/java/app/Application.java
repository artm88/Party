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
        do {
            game.play();
            System.out.println(user.getName() + ", твой счет игры " + user.scoreOfGame());
            System.out.println("Нажми цифру 4 для выхода");
            Scanner scannerOfExit = new Scanner(System.in); // взаимодействие с пользователем
            if (scannerOfExit.equals("4")) { return true;}
        } while (false );
    }

}
