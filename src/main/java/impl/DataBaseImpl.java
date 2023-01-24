package impl;

import api.DataBase;
import api.User;

import java.io.FileNotFoundException;
import java.sql.*;

public class DataBaseImpl implements DataBase{

    // запись имени и счета  игрока в базу данных

    String url = "jdbc:postgresql://localhost:5432/userscore";
    String userBD="postgres";
    String passwordDb="artem";

   // @Override
    //public void createOfTable() {

        // запаска для создание базы
        //try (Connection connectionForCreateTable= DriverManager.getConnection(url, userBD, passwordDb);
        // Statement statement = connectionForCreateTable.createStatement()) {
        //   statement.execute("DROP TABLE IF EXISTS accounts");
        //  statement.execute("CREATE TABLE accounts (" +
        //         " user_id serial PRIMARY KEY," +
        //        " username VARCHAR (50) UNIQUE NOT NULL,"+
        //          " score serial,"+
        //        " scoreMax serial"+
        //       ");");
        //}
        //catch (SQLException excpt){
        // throw new RuntimeException(excpt);
        //}

  //  }


    private User user;
    public DataBaseImpl(User user) throws FileNotFoundException {
        this.user = user;
    }

    @Override
    public void addUser() {
        // подгрузка последнего id для увеличение его значение на 1
        int userid=0;
        String queryForId="select user_id from accountsUserScore";
        try (Connection connectionForId= DriverManager.getConnection(url, userBD, passwordDb);
             PreparedStatement StatementForId = connectionForId.prepareStatement(queryForId)) {
            //preparedStatement.setInt(1,2);
            ResultSet resultSet=StatementForId.executeQuery();
            while (resultSet.next()){
                userid = resultSet.getInt("user_id");
            }
        }
        catch (SQLException excpt){
            throw new RuntimeException(excpt);
        }

        // запись новой строки - данных нового пользователя
        String query="INSERT INTO accountsUserScore(user_id, username, score, scoreMax) VALUES (?, ?, ?, ?)";
        try (Connection connectionForCreateData= DriverManager.getConnection(url, userBD, passwordDb);
             PreparedStatement preparedStatement = connectionForCreateData.prepareStatement(query))
        {
            preparedStatement.setInt(1, userid+1);
            preparedStatement.setString(2, user.getName());
            preparedStatement.setInt(3, user.scoreOfGame());
            preparedStatement.setInt(4, user.maxScore());
            preparedStatement.execute();
        }
        catch (SQLException excpt){
            throw new RuntimeException(excpt);
        }
    }

    @Override
    public void printDB() {
        // отображение базы данных
        String queryForTest="select * from accountsUserScore";
        try (Connection connectionForTest= DriverManager.getConnection(url, userBD, passwordDb);
             PreparedStatement StatementForTest = connectionForTest.prepareStatement(queryForTest)) {
            //preparedStatement.setInt(1,2);
            ResultSet resultSet=StatementForTest.executeQuery();
            while (resultSet.next()){
                int user_id = resultSet.getInt("user_id");
                String username=resultSet.getString("username");
                int score = resultSet.getInt("score");
                int scoreMax = resultSet.getInt("scoreMax");
                System.out.println("Пациент № " + user_id +". "+ username +" имеет "+ score +
                        " баллов из "+ scoreMax+" социальной адаптации.");
            }
        } catch (SQLException excpt){
            throw new RuntimeException(excpt);
        }
    }
}

