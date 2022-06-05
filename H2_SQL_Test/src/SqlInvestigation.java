import java.sql.*;

public class SqlInvestigation {

    public static final String DB_URL = "jdbc:h2:/c:/JavaPrj/SQLDemo/db/SQL_INVESTIGATION2";
    // драйвер джавы JDBC : производитель базы данных : адрес в интернете или на диске с названием БД

    public static void main(String[] args) {

        String sql = "CREATE TABLE IF NOT EXISTS investigation(id BIGINT PRIMARY KEY, number INTEGER)";

        try {
            Connection connection = DriverManager.getConnection(DB_URL);
            // Получаем новое соединение с БД SQL_INVESTIGATION1 от Java Driver Manager'а

            Statement statement = connection.createStatement();
            // Создаем statement для выполнения sql-команд

            statement.execute(sql);
            // Выполняем команду СОЗДАТЬ ТАБЛИЦУ

            statement.execute("INSERT INTO investigation VALUES (0, 111)");
            // Выполняем команду ВНЕСТИ В ТАБЛИЦУ ЗНАЧЕНИЯ ()

            statement.execute("UPDATE investigation SET number = number + 5 WHERE id = 0");
            // Выполняем команду ОБНОВИТЬ ТАБЛИЦУ УСТАНОВИТЬ значение ГДЕ id = 0

            ResultSet resultSet = statement.executeQuery("SELECT * FROM investigation WHERE id = 0");
            // Создаём переменную объекта resultSet и получаем в него данные из запроса к БД

            while (resultSet.next()) {
                System.out.println(resultSet.getInt("number")); //Читаем resultSet, пока в нем есть сл. элемент
            }

            statement.execute("DELETE investigation WHERE id = 0");
            // Выполянем команду УДАЛИТЬ строку
            statement.execute("DELETE investigation");
            // Выполянем команду УДАЛИТЬ таблицу

            statement.close();
            // Закрываем соединение с БД

        } catch (SQLException e) {
            System.out.println("ОШИБКА SQL! " + e);
        }

    }


    // Инициализация
    public static void sqlInvestigation() throws SQLException, ClassNotFoundException {

        String DB_Driver = "org.h2.Driver";
        Class.forName(DB_Driver);
        //Такая команда создает класс драйвера и позволяет в дальнейшем сразу вызывать Connection
        // Инициализируем таблицы
        //data1 = new Data1();

    }

}

