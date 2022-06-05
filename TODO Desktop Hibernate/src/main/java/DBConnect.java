import org.sqlite.JDBC;

import java.sql.*;
import java.util.*;

public class DBConnect {

    //private static final String DB_PATH = "jdbc:sqlite:C:/Users/A12/Desktop/SQL/Programs/work.db";
    private static final String DB_PATH = "jdbc:sqlite:work.db";

    private static DBConnect instance = null;
    public static synchronized DBConnect getInstance() throws SQLException {
        if(instance == null) instance = new DBConnect();
        return instance;
    }

    private final Connection connection;
    private DBConnect() throws SQLException {
        connection = DriverManager.getConnection(DB_PATH);
        //connection.createStatement().execute("DROP TABLE works");
        connection.createStatement().execute("CREATE TABLE IF NOT EXISTS works" +
                "(n INTEGER PRIMARY KEY, task TEXT NOT NULL, isDone BOOLEAN NOT NULL DEFAULT FALSE)");
    }

    public List<Task> getAllTasks() {
        try (Statement statement = connection.createStatement();) {
            List<Task> taskList = new ArrayList<>();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM works");
            while (resultSet.next()) {
                taskList.add(new Task(
                        resultSet.getInt("n"),
                        resultSet.getString("task"),
                        resultSet.getBoolean("isDone")));
            }
            return taskList;
        } catch (SQLException ex) {ex.printStackTrace();}

        return Collections.emptyList();
    }

    public void executeSql(String sql) {
        if(sql.equals("")) return;

        try (Statement statement = connection.createStatement();) {
            statement.execute(sql);
        } catch (SQLException ex) {ex.printStackTrace();}
    }

    public void closeConnection() {
        try {
            connection.close();
        } catch (SQLException ex) {ex.printStackTrace();}
        //System.out.println("Connection closed!");
    }
}
