package api;

public interface User {
    String getName();
    int getLose();
    int getWin();
    void reduce(int amount);
    void increase(int amount);
}
