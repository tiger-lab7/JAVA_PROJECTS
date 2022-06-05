import java.sql.*;

public class Main {

    public static void main(String... args) throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/MyDataBase";
        String username ="postgres";
        String password = "password";

        Connection connection = null;
        Statement statement = null;

        connection = DriverManager.getConnection(url, username, password);
        connection.setSchema("MyDataBase");
        System.out.println(connection.getSchema());

        statement = connection.createStatement();

        String SQLrequest = "CREATE TABLE IF NOT EXISTS myTable(" +
                "id SERIAL PRIMARY KEY," +
                "name VARCHAR(200));";
        statement.execute(SQLrequest);

        String name = "'Igor'";
        String SQLrequest1 = "INSERT INTO myTable(name) VALUES(" + name + ");";
        statement.execute(SQLrequest1);

        String name2 = "'Vasia'";
        String SQLrequest2 = "INSERT INTO myTable(name) VALUES(" + name2 + ");";
        statement.execute(SQLrequest2);

        String SQLquerry = "SELECT * FROM myTable;";
        ResultSet resultSet = statement.executeQuery(SQLquerry);
        while(resultSet.next()) {
            System.out.println(resultSet.getString("name"));
        }

        String SQLrequest3 = "UPDATE myTable SET name='Васисуалий' WHERE id=2;";
        statement.execute(SQLrequest3);

        String SQLrequest4 = "DELETE FROM myTable WHERE id=1";
        statement.execute(SQLrequest4);

        //String SQLrequest3 = "DROP TABLE myTable;";

        connection.close();


    }
}
