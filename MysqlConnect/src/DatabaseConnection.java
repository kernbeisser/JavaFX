import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    public Connection databaseLink;

    public Connection getConnection() {
        String databaseName = "mysql";
        String databaseUser = "...";
        String databasePassword = "...";
        
        String url = "jdbc:mysql://localhost:3306/" + databaseName;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            databaseLink = DriverManager.getConnection(url, databaseUser, databasePassword);
        } catch (ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException e) {     
            e.getMessage();
        }

        return databaseLink;
    }
}
