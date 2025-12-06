import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class ConnectionController {

    @FXML
    private Button btnConnect;

    @FXML
    private Label lblbUserName;

    @FXML
    void onConnect(ActionEvent event) {
        DatabaseConnection dbConnect = new DatabaseConnection();

        Connection connection = dbConnect.getConnection();

        String query = "select user,host,password from mysql.user;";

        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);

            
            while (rs.next()) {
                String userName = rs.getString("User");
                String hostName = rs.getString("Host");
                String password = rs.getString("Password");
                
                System.out.println("User: " + userName + ", Host: " + hostName + ", Password: " + password);
            }
            
        } catch (SQLException e) {
            e.getMessage();
        }
    }

}
