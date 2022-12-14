package impl;

import api.User;

public class UserImpl implements User { // создание профиля пользователя

    private String name;
    private int score;
    private int maxScore;
    /*private int lose;
    private int win;*/

    public UserImpl (String name){
        this.name=name;
    }

    @Override
    public String getName() {
        return this.name;
    }  // возвращение имени пользователя

    @Override
    public int scoreOfGame() {  // возвращение количества поражений пользователя
        return this.score;
    } // возвращение счета игры

    @Override
    public void reduceScore(int amount) { // уменьшение количества поражений пользователя
        this.score-=amount;
    } // уменьшение счета игры

    @Override
    public void increaseScore(int amount) { // увеличение количества поражений пользователя
        this.score+=amount;
    } // увеличение счета игры

    @Override
    public int maxScore() {  // возвращение количества поражений пользователя
        return this.maxScore;
    } // возвращение максимального возможных очков игры

    @Override
    public void increaseMaxScore(int amount) { // увеличение количества поражений пользователя
        this.maxScore+=amount;
    } // подсчет максимального возможных очков игры

    @Override
    public void reduceMaxScore(int amount) { // увеличение количества поражений пользователя
        this.maxScore-=amount;
    } // подсчет максимального возможных очков игры


    // часть для шаблона проектирования Состояние
   /* @Override
    public int getLose() {  // возвращение количества поражений пользователя
        return this.lose;
    }

    @Override
    public int getWin() {
        return this.win;
    } // возвращение количества побед пользователя

    @Override
    public void reduceLose(int amount) { // уменьшение количества поражений пользователя
        this.lose-=amount;
    }

    @Override
    public void increaseLose(int amount) { // увеличение количества поражений пользователя
        this.lose+=amount;
    }

    @Override
    public void reduceWin(int amount) { // уменьшение количества побед пользователя
        this.win-=amount;
    }

    @Override
    public void increaseWin(int amount) {
        this.win+=amount;
    } // увеличение количества побед пользователя*/
}
