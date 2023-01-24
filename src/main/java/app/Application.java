package app;

import api.DataBase;
import api.Game;
import api.Registrator;
import api.User;
import impl.DataBaseImpl;
import impl.GameImpl;
import impl.RegistratorImpl;


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
        System.out.println("Добро пожаловать на коктейльную пати в честь вашего устройства на работу.\n" +
                "Вы в комнате, перед Вами выбор куда подойти. " +
                "Так же Вы можете пройти мимо или отдохнуть.\n"); // главное меню

        //

        //  сама игра
        do {
            game.play();

            printWriterLOGS.printf("Пройден уровень игры.\n");//логи

            //System.out.println(user.getName() + ", твой счет игры " + user.scoreOfGame()+
                  //  " из максимально возможных "+user.maxScore()); // отображение счета игры (временная опция)
            System.out.println("Нажмите цифру 5 для выхода или любую другую цифру для продолжения"); //развилка на выход
            Scanner scannerOfExit = new Scanner(System.in); // взаимодействие с пользователем
            exit=scannerOfExit.nextInt();
        } while (exit!=5);

        // запись статистики игрока
        String STATISTIC = "C:\\Users\\artem\\IdeaProjects\\Party\\src\\main\\resources\\"+user.getName()+
                "_statistic.txt";
        try (PrintWriter printWriterSTATISTIC = new PrintWriter(new FileOutputStream(STATISTIC))) {
            if (user.maxScore()!=0) {
                printWriterSTATISTIC.printf(user.getName() + " имеет " + user.scoreOfGame() +
                        " баллов выбора людей из максимально возможных " + user.maxScore() +
                        ".\nБаллов социальной адаптации " + Math.round(10 * user.scoreOfGame() / user.maxScore()) +
                        " по 10-бальной шкале.\n");
            }
            else {
                printWriterSTATISTIC.printf(user.getName() + " имеет " + user.scoreOfGame() +
                        " баллов выбора людей из максимально возможных " + user.maxScore() +
                        ".\nБаллов социальной адаптации " +  user.maxScore() +
                        " по 10-бальной шкале.\n");
            }
        } catch (FileNotFoundException ex){
            System.out.println("Не найден Файл!");
        }

        printWriterLOGS.printf("Игра закончена.\n"); //логи
        printWriterLOGS.close();

        // результат и статистика игрока
        if (user.scoreOfGame()>user.maxScore()/2)   {
        System.out.println(user.getName() + ", Вы социально адаптированы." );}
        else {System.out.println(user.getName() + ", Вы стараетесь избегать людей." );}
        System.out.println("Нажмите цифру 6 для вывода статистики " +
                "или любую другую цифру для выхода"); // развилка на статистику
        Scanner scannerOfStat = new Scanner(System.in);
        int stat=0;
        stat=scannerOfStat.nextInt();
        if (stat!=6) {
        }
        else {
            System.out.println(user.getName() + ", Вы имеете " + user.scoreOfGame() +
                    " баллов выбора людей из максимально возможных " + user.maxScore());
            if (user.maxScore()!=0) {
                System.out.println("Баллов социальной адаптации " +
                        Math.round(10 * user.scoreOfGame() / user.maxScore()) +
                        " по 10-бальной шкале.");
            }
            else{
                System.out.println("Баллов социальной адаптации " +
                        user.maxScore() + " по 10-бальной шкале.");
            }
        }
        System.out.println("Спасибо! \nИгру делал Корюкин Артём.");

        // запись имени и счета  игрока в базу данных
        DataBase dataBase = new DataBaseImpl(user);
        dataBase.addUser();
        dataBase.printDB();
    }

}
