package impl;

import api.Game;
import api.User;

import java.util.Scanner;

public class GameImpl implements Game {
    //private   COUNT_OF_LOSE   int
    //private   COUNT_OF_WIN   int
    //private   LIST_OF_PEOPLE   коллекция или БД
    //private   LIST_OF_OBJECT    коллекция или БД
    private final User user;
    public GameImpl(User user) {
        this.user = user;
    }
    @Override
    public void play() {
        System.out.print("Сделайте выбор (введите номер выбора): " +
                "\n 1. Выишрать \n 2. Проиграть \n 3. Пропуск \n 4. Выход \n");
        Scanner scanner = new Scanner(System.in); // взаимодействие с пользователем
        int temp = scanner.nextInt();
        if (temp==1) {
            user.increaseScore(1);
        } else if (temp==2){
            user.reduceScore(1);
        } else if (temp==3){
            System.out.println("Пропуск");
        } else if (temp==4){
            System.out.println("Выход");
        }
    }
}
