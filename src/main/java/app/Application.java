package app;

import api.Game;
import api.Registrator;
import api.User;
import impl.GameImpl;
import impl.RegistratorImpl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.sql.*;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) throws FileNotFoundException {
        Registrator registrator = new RegistratorImpl();
        //String LOGS = "C:\\Users\\artem\\IdeaProjects\\Party\\src\\main\\resources\\log.txt";
        //PrintWriter printWriterLOGS = new PrintWriter(new FileOutputStream(LOGS));
        //printWriterLOGS.printf("Регистратция пройдена.\n");
        User user = registrator.registerUser();
        String LOGS = "C:\\Users\\artem\\IdeaProjects\\Party\\src\\main\\resources\\"+user.getName()+"_log.txt";
        PrintWriter printWriterLOGS = new PrintWriter(new FileOutputStream(LOGS));
        printWriterLOGS.printf("Регистратция пройдена. Добавлено имя пользователя: "+ user.getName()+". Введен счет пользователя: "+
                user.scoreOfGame()+". Введен максимальный счет теста: "+user.maxScore());
        Game game = new GameImpl(user);
        printWriterLOGS.printf("\nЗагружена игра.\n");
        int exit=0;
        System.out.println("Добро пожаловать на коктейльную пати в честь вашего устройства на работу.\n" +
                "Вы в комнате, перед Вами выбор куда подойти. Так же Вы можете пройти мимо или отдохнуть.\n"); // главное меню
        String ENVIRONMENT = "C:\\Users\\artem\\IdeaProjects\\Party\\src\\main\\resources\\ENVIRONMENT.txt";
        String[] ENVIRONMENTS={};
        try (Scanner scannerENVIRONMENT = new Scanner(new FileInputStream(ENVIRONMENT))) {
            int iE = 0;
            while (scannerENVIRONMENT.hasNextLine()){
                //ENVIRONMENTS[iE]=scannerENVIRONMENT.nextLine();
                //System.out.println(ENVIRONMENTS[iE]);
                System.out.println(scannerENVIRONMENT.nextLine());
                iE++;
            }
        } catch (FileNotFoundException e){
            System.out.println("Не найден Файл!");
        }
        do {
            game.play();
            printWriterLOGS.printf("Пройден уровень игры.\n");
            //System.out.println(user.getName() + ", твой счет игры " + user.scoreOfGame()+
                  //  " из максимально возможных "+user.maxScore()); // отображение счета игры (временная опция)
            System.out.println("Нажмите цифру 5 для выхода или любую другую цифру для продолжения"); // развилка на выход
            Scanner scannerOfExit = new Scanner(System.in); // взаимодействие с пользователем
            exit=scannerOfExit.nextInt();
        } while (exit!=5);
        if (user.scoreOfGame()>user.maxScore()/2)   {
        System.out.println(user.getName() + ", Вы социально адаптированы." );}
        else {System.out.println(user.getName() + ", Вы стараетесь избегать людей." );}
        System.out.println("Нажмите цифру 6 для вывода статистики"); // развилка на статистику
        Scanner scannerOfStat = new Scanner(System.in);
        int stat=0;
        stat=scannerOfStat.nextInt();
        if (stat==6) {
            System.out.println(user.getName() + ", Вы имеете " + user.scoreOfGame() +
                    " баллов выбора людей из максимально возможных " + user.maxScore());
            System.out.println("Баллов социальной адаптации " + Math.round(10*user.scoreOfGame()/ user.maxScore()) +
                    " по 10-бальной шкале.");
        }
        String STATISTIC = "C:\\Users\\artem\\IdeaProjects\\Party\\src\\main\\resources\\"+user.getName()+"_statistic.txt";
        try (PrintWriter printWriterSTATISTIC = new PrintWriter(new FileOutputStream(STATISTIC))) {
            printWriterSTATISTIC.printf(user.getName() + " имеет " + user.scoreOfGame() +
                    " баллов выбора людей из максимально возможных " + user.maxScore()+
                    ".\nБаллов социальной адаптации " + Math.round(10*user.scoreOfGame()/ user.maxScore()) +
                    " по 10-бальной шкале.\n");
        } catch (FileNotFoundException ex){
            System.out.println("Не найден Файл!");
        }
        printWriterLOGS.printf("Игра закончена.\n");
        printWriterLOGS.close();
        /*String url = "jdbc:postgresql://localhost:5432/postgres";
        String userBD="postgres";
        String passwordDb="artem";
        String query="insert into public.accounts (user_id, username, score) VALUES(?, ?, ?)";
        try (Connection connectionFinal= DriverManager.getConnection(url, userBD, passwordDb);
             PreparedStatement preparedStatementFinal = connectionFinal.prepareStatement(query)) {
            preparedStatementFinal.setInt(1,2);
            ResultSet resultSetFinal=preparedStatementFinal.executeQuery();
            while (resultSetFinal.next()){
                int user_id = resultSetFinal.getInt("user_id");
                String username=resultSetFinal.getString("username");
                int score = resultSetFinal.getInt("score");
            }
        } catch (SQLException excpt){
            throw new RuntimeException(excpt);
        }*/
    }

}
