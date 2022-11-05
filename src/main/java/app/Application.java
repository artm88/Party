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
        System.out.println("Вы приходите на коктейльную пати в честь вашего устройства на работу.\n" +
                "Вы в комнате, перед Вами выбор куда подойти. Так же Вы можете пройти мимо или отдохнуть.\n"); // главное меню
        do {
            game.play();
            //System.out.println(user.getName() + ", твой счет игры " + user.scoreOfGame()+
                  //  " из максимально возможных "+user.maxScore()); // отображение счета игры (временная опция)
            System.out.println("Нажмите цифру 5 для выхода или любую другую цифру для продолжения"); // развилка на выход
            Scanner scannerOfExit = new Scanner(System.in); // взаимодействие с пользователем
            exit=scannerOfExit.nextInt();
        } while (exit!=5);
        if (user.scoreOfGame()>user.maxScore()/2)   {
        System.out.println(user.getName() + ", Вы социально адаптирован." );}
        else {System.out.println(user.getName() + ", Вы стараетесь избегать людей." );}
    }

}
