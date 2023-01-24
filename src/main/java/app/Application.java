package app;

import api.*;
import impl.DataBaseImpl;
import impl.GameImpl;
import impl.RegistratorImpl;
import impl.StatisticsImpl;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.sql.*;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) throws FileNotFoundException {

        Registrator registrator = new RegistratorImpl();
        User user = registrator.registerUser();

        String LOGS = "C:\\Users\\artem\\IdeaProjects\\Party\\src\\main\\resources\\"+user.getName()+"_log.txt";//логи
        PrintWriter printWriterLOGS = new PrintWriter(new FileOutputStream(LOGS));
        printWriterLOGS.printf("Регистратция пройдена. Добавлено имя пользователя: "+ user.getName()+
                ". Введен счет пользователя: "+user.scoreOfGame()+". Введен максимальный счет теста: "+user.maxScore());

        Game game = new GameImpl(user);

        printWriterLOGS.printf("\nЗагружена игра.\n");//логи

        int exit=0;
        int numOfLevel=1;
        //  сама игра
        do {
            game.play();

            printWriterLOGS.printf("Пройден "+numOfLevel+" уровень игры.\n");//логи
            numOfLevel++;

            //System.out.println(user.getName() + ", твой счет игры " + user.scoreOfGame()+
                  //  " из максимально возможных "+user.maxScore()); // отображение счета игры (временная опция)

            System.out.println("Нажмите цифру 5 для выхода или любую другую цифру для продолжения"); //развилка на выход

            Scanner scannerOfExit = new Scanner(System.in); // взаимодействие с пользователем
            exit=scannerOfExit.nextInt();
        } while (exit!=5);

        printWriterLOGS.printf("Игра закончена.\n"); //логи
        printWriterLOGS.close();

        Statistics statistics = new StatisticsImpl(user);
        statistics.statToFile(); // запись статистики игрока в файл
        statistics.statToUser(); // результаты и вывод статистики игрока

        // запись имени и счета  игрока в базу данных
        DataBase dataBase = new DataBaseImpl(user);
        //dataBase.createOfTable(); //создание таблицы
        dataBase.addUser(); // добавление пользователя
        dataBase.printDB(); //вывод Базы Данных
    }

}
