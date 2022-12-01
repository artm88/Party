package impl;

import api.Game;
import api.User;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class GameImpl implements Game {
    //private   COUNT_OF_LOSE   int
    //private   COUNT_OF_WIN   int
    //private   LIST_OF_PEOPLE   коллекция или БД
    //private   LIST_OF_OBJECT    коллекция или БД

    List<String> L_O_ENVIRONMENTS=getArrayOfString(); // вызов метода подгрузки файла с окружением
    //private String[] LIST_OF_ENVIRONMENT={"Человеку", "Человеку с книгой", "Людям", "креслу", "шкафу", "углу"};
    private final User user;
    public GameImpl(User user) throws FileNotFoundException {
        this.user = user;
    }

    @Override
    public void play() {

        // генерация окружения
        Random random = new Random();
        int objectOne = random.nextInt(6); // генерация первого объекта комнаты, 6 - число объектов
        int objectTwo = random.nextInt(6); // генерация второго объекта комнаты
        String StringOne = L_O_ENVIRONMENTS.get(objectOne); // cвязь сюжетного выбора и типа объекта
        String StringTwo = L_O_ENVIRONMENTS.get(objectTwo);
        System.out.print("Сделайте выбор (введите номер выбора):" +
                "\n [1] Подойти к "+StringOne+" \n [2] Подойти к " +
                StringTwo+" \n [3] Пройти дальше \n [4] Отдохнуть \n");

        //основная часть игры
        Scanner scanner = new Scanner(System.in); // взаимодействие с пользователем
        int temp = scanner.nextInt();
        if (objectOne<3||objectTwo<3){user.increaseMaxScore(1);}
        if (temp==1) {
            if (objectOne<3) {  // если игрок выбирает 1 сюжетную ветку
                user.increaseScore(1);}
            else if (objectOne>=3) {
            user.reduceScore(1);}
        }
        else if (temp==2){ // если игрок выбирает 2 сюжетную ветку
            if (objectTwo<3) {
                user.increaseScore(1);}
            else if (objectTwo>=3) {
                user.reduceScore(1);}
        }
        else if (temp==3){ //если игрок выбирает пропуск хода, считается за проигрыш в случае наличия человек в выборе
            System.out.println("Проходите дальше...");
        }
        else if (temp==4){ // если игрок выбирает отдых, то ход не пишется в общий счёт
            System.out.println("Отдыхаете...");
            if (objectOne<3||objectTwo<3){user.reduceMaxScore(1);}
        }
        if (user.maxScore()<11){
            int count=10-user.maxScore();
            System.out.println(user.getName() + ", сделан ход номер " + user.maxScore()+
                    " для точного результата осталось "+count+ " ходов.");} // отображение хода игры
        else {System.out.println(user.getName() + ", сделан ход номер " + user.maxScore());}
    }

    private List<String> getArrayOfString(){ // подгрузка файла с окружением
        String ENVIRONMENT = "C:\\Users\\artem\\IdeaProjects\\Party\\src\\main\\resources\\ENVIRONMENT.txt";
        List<String> ENVIRONMENTS= new ArrayList<>();
        try (Scanner scannerENVIRONMENT = new Scanner(new FileInputStream(ENVIRONMENT))) {
            //int iE = 0;
            while (scannerENVIRONMENT.hasNextLine()){
                ENVIRONMENTS.add(scannerENVIRONMENT.nextLine());
                //System.out.println(ENVIRONMENTS.get(iE));
                //System.out.println(scannerENVIRONMENT.nextLine());
                //iE++;
            }
        } catch (FileNotFoundException e){
            System.out.println("Не найден Файл!");
        }
        return ENVIRONMENTS;
    }
}
