import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class ConnectionController {

    @FXML
    private Button btnConnect;

    @FXML
    private Label lblbUserName;

    @FXML
    private PasswordField pwPassword;

    @FXML
    private TextField txtUserName;

     @FXML
    private Label lblResult;


    @FXML
    void onConnect(ActionEvent event) {
        DatabaseConnection dbConnect = new DatabaseConnection();

        String dbUserName = txtUserName.getText();
        String dbPassword = pwPassword.getText();


        Connection connection = dbConnect.getConnection(dbUserName, dbPassword);

        String query = "select user,host,password from mysql.user;";

        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            
            while (rs.next()) {
                String userName = rs.getString("User");
                String hostName = rs.getString("Host");
                String password = rs.getString("Password");
                
                String result = "User: " + userName + ", Host: " + hostName + ", Password: " + password;

                IO.println(result);

                lblResult.setText(result);
            }
            
        } catch (SQLException e) {
            e.getMessage();
        }
    }

}
