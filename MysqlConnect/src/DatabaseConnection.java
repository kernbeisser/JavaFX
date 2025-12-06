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
        // String url = "jdbc:mysql://localhost:3306/" + databaseName;
        String url = "jdbc:mysql://localhost:3306/" + databaseName;

        try {
            // Class.forName("com.mysql.jdbc.Driver");
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            databaseLink = DriverManager.getConnection(url, databaseUser, databasePassword);
            IO.println("bin drin...");
        } catch (ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException e) {     
            IO.println("Argh...");       
            e.getMessage();
        }

        return databaseLink;
    }
}
