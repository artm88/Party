package api;

public interface User {
    String getName();
    int getLose();
    int getWin();
    int scoreOfGame();
    void reduceScore(int amount);
    void increaseScore(int amount);
    void reduceLose(int amount);
    void increaseLose(int amount);
    void reduceWin(int amount);
    void increaseWin(int amount);
}
