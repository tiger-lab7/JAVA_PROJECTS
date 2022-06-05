import java.sql.DriverManager

fun main() {
    val dbPath = "jdbc:sqlite:C:/Users/A12/Desktop/SQL/Programs/hotel.db";
    val connection = DriverManager.getConnection(dbPath)
    val statement = connection.createStatement()
    val resultSet = statement.executeQuery("SELECT * FROM guests3")
    val dbRecordsList = ArrayList<KtDbRecord>()
    while(resultSet.next()) {
        dbRecordsList.add(KtDbRecord(
            resultSet.getInt("id"),
            resultSet.getString("name"),
            resultSet.getString("city"),
            resultSet.getInt("gender"),
            resultSet.getInt("age")));
    }
    dbRecordsList.forEach { println(it) }
}




class KtDbRecord(var id: Int, var name: String, var city: String,
                 var gender: Int, var age: Int) {

    override fun toString(): String {
        return "$id $name $city $gender $age"
    }
}