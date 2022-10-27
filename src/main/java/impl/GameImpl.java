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
        System.out.println("Сделайте выбор (введите номер выбора): " +
                "/n 1. Выишрать /n 2. Проиграть /n 3. Пропуск /n 4. Выход /n");
        Scanner scanner = new Scanner(System.in); // взаимодействие с пользователем
        if (scanner.equals("1")) {
            user.reduceScore(1);
        } else if (scanner.equals("2")){
            user.increaseScore(1);
        } else if (scanner.equals("3")){
            System.out.println("Пропуск");
        } else if (scanner.equals("4")){
            System.out.println("Выход");
        }
    }
}
