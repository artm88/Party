package impl;

import api.Game;
import api.User;

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

    }
}
