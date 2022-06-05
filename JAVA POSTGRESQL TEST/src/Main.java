import java.sql.*;

public class Main {

    public static void main(String[] args) throws SQLException {

        String URL = "jdbc:postgres://localhost:127.0.0.1:5000/";
        Connection connection = DriverManager.getConnection(URL); // Просим соединения у DriverManager'a Java SQL!
        Statement statement = connection.createStatement(); // Создаем состояние в соединении
        statement.execute("CREATE TABLE IF NOT EXISTS testTable(BIGINT AUTO_INCREMENT id, STRING name)");
        statement.execute("INSERT testTable id 1 VALUE STRING(ВАСЯ) ");
        ResultSet resultSet = statement.execute("SELECT id 1").getResultSet;
        System.out.println(resultSet.getString());

    }
}
