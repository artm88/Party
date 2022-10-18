package impl;

import api.User;

public class UserImpl implements User {

    private String name;
    private int lose;
    private int win;

    public UserImpl (String name){
        this.name=name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getLose() {
        return this.lose;
    }

    @Override
    public int getWin() {
        return this.win;
    }

    @Override
    public void reduceLose(int amount) {
        this.lose-=amount;
    }

    @Override
    public void increaseLose(int amount) {
        this.lose+=amount;
    }

    @Override
    public void reduceWin(int amount) {
        this.win-=amount;
    }

    @Override
    public void increaseWin(int amount) {
        this.win+=amount;
    }
}
