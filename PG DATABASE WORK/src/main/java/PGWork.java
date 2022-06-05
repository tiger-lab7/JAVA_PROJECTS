import lombok.SneakyThrows;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class PGWork {

    @SneakyThrows
    public static void main(String[] args) {

        String appConfigPath =
                Thread.currentThread()
                        .getContextClassLoader().getResource("pgConnection.properties").getPath();

        //System.out.println(rootPath);
        //String appConfigPath = rootPath + "pgConnection.properties";
       // String appConfigPath = "C:\\Users\\A12\\IdeaProjects\\PG DATABASE WORK\\src\\main\\resources\\pgConnection.properties";

        Properties connectionPG = new Properties();
        connectionPG.load(new FileInputStream(appConfigPath));

        String postgresURI = connectionPG.getProperty("postgresURI");
        String userName = connectionPG.getProperty("userName");
        String password = connectionPG.getProperty("password");

        Connection connection = DriverManager.getConnection(postgresURI, userName, password);
        //Statement statement = connection.createStatement();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM cats WHERE name=?");
        preparedStatement.setString(1, "БАРСИК");
        ResultSet resultSet = preparedStatement.executeQuery();


        while(resultSet.next()) {
            System.out.printf("%d %s %d ", resultSet.getInt("id"),
                    resultSet.getString("name"), resultSet.getInt("type"));
        }

        preparedStatement.close();
        connection.close();
    }
}
