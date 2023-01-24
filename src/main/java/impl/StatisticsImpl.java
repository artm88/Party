package impl;

import api.Statistics;
import api.User;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class StatisticsImpl implements Statistics {

    private User user;
    public StatisticsImpl(User user) throws FileNotFoundException {
        this.user = user;
    }

    @Override
    public void statToFile() {
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
    }

    @Override
    // результат и статистика игрока
    public void statToUser() {
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
    }
}
