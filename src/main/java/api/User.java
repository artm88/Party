package api;

public interface User {
    String getName();
    int getLose();
    int getWin();
    void reduceLose(int amount);
    void increaseLose(int amount);
    void reduceWin(int amount);
    void increaseWin(int amount);
}
