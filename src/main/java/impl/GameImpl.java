package impl;

import api.Game;
import api.User;

import java.util.Random;
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
        Random random = new Random();
        int objectOne = 1+random.nextInt(2); // генерация первого объекта комнаты
        int objectTwo = 1+random.nextInt(2); // генерация второго объекта комнаты
        System.out.print("Сделайте выбор (введите номер выбора), при условии, что 1 приведет к выигрошу, а 2 к поражению:" +
                "\n [1] "+objectOne+" \n [2] " +objectTwo+" \n [3] Пропуск \n [4] Выход \n");
        Scanner scanner = new Scanner(System.in); // взаимодействие с пользователем
        int temp = scanner.nextInt();
        if (temp==1) { if (objectOne==1) {  // если игрок выбирает 1 сюжетную ветку
            user.increaseScore(1);}
            else if (objectOne==2) {
            user.reduceScore(1);}
        } else if (temp==2){ // если игрок выбирает 2 сюжетную ветку
            if (objectTwo==1) {
                user.increaseScore(1);}
            else if (objectTwo==2) {
                user.reduceScore(1);}
        } else if (temp==3){ // если игрок выбирает пропуск хода
            System.out.println("Пропуск");
        } else if (temp==4){ // если игрок выбирает выйти
            System.out.println("Выход");
        }
    }
}
