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
    private String[] LIST_OF_ENVIRONMENT={"Человек", "Человек с книгой", "Люди", "кресло", "шкаф", "угол"};
    private final User user;
    public GameImpl(User user) {
        this.user = user;
    }
    @Override
    public void play() {
        Random random = new Random();
        int objectOne = random.nextInt(6); // генерация первого объекта комнаты, 6 - число объектов
        int objectTwo = random.nextInt(6); // генерация второго объекта комнаты
        String StringOne = LIST_OF_ENVIRONMENT[objectOne]; // cвязь сюжетного выбора и типа объекта
        String StringTwo = LIST_OF_ENVIRONMENT[objectTwo];
        System.out.print("Сделайте выбор (введите номер выбора):" +
                "\n [1] "+StringOne+" \n [2] " +StringTwo+" \n [3] Не хочу решать \n [4] Отдохнуть \n");
        Scanner scanner = new Scanner(System.in); // взаимодействие с пользователем
        int temp = scanner.nextInt();
        if (objectOne<3||objectTwo<3){user.increaseMaxScore(1);}
        if (temp==1) { if (objectOne<3) {  // если игрок выбирает 1 сюжетную ветку
            user.increaseScore(1);}
            else if (objectOne>=3) {
            user.reduceScore(1);}
        } else if (temp==2){ // если игрок выбирает 2 сюжетную ветку
            if (objectTwo<3) {
                user.increaseScore(1);}
            else if (objectTwo>=3) {
                user.reduceScore(1);}
        } else if (temp==3){ // если игрок выбирает пропуск хода, считается за проигрыш
            System.out.println("Пропуск");
        } else if (temp==4){ // если игрок устал, ход не пишется в общий счёт
            System.out.println("Устал");
            if (objectOne<3||objectTwo<3){user.reduceMaxScore(1);}
        }
    }
}
