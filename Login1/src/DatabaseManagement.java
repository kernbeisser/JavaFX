import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManagement {

    public Connection databaseLink;

    public Connection getConnection(String dbUser, String dbPassword) {
        String databaseName = "accounts";
        String databaseUser = dbUser;
        String databasePassword = dbPassword;

        String url = "jdbc:mysql://localhost:3306/" + databaseName;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            databaseLink = DriverManager.getConnection(url, databaseUser, databasePassword);
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
                | NoSuchMethodException | ClassNotFoundException | SQLException e) {
            e.getMessage();
        }
        return databaseLink;
    }
}
