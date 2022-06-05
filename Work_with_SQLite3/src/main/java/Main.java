import java.sql.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws SQLException {
        String dbPath = "jdbc:sqlite:C:/Users/A12/Desktop/SQL/Programs/hotel.db";
        Connection connection = DriverManager.getConnection(dbPath);
        Statement statement = connection.createStatement();


        ArrayList<dbRecord> dbRecordArrayList = new ArrayList<>();
        String sqlQuery = "SELECT * FROM guests3";
        ResultSet resultSet = statement.executeQuery(sqlQuery);
        // Из ResultSet данные получаются по одному элементу каждого типа, последовательно
        while(resultSet.next()) {
            dbRecordArrayList.add(new dbRecord(
                    resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getString("city"),
                    resultSet.getInt("gender"),
                    resultSet.getInt("age")));
        }
        dbRecordArrayList.forEach(System.out::println);

        connection.close();
    }
}

class dbRecord {
    int id;
    String name;
    String city;
    int gender;
    int age;

    public dbRecord(int id, String name, String city, int gender, int age) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.gender = gender;
        this.age = age;
    }
    @Override
    public String toString() {
        return id + " " + name + " " + city + " " + gender + " " + age;
    }
}
