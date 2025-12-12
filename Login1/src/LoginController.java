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

public class LoginController {

    @FXML
    private Button btnCancel;

    @FXML
    private Button btnLogin;

    @FXML
    private Label lblStatus;

    @FXML
    private PasswordField pwPassword;

    @FXML
    private TextField txtUserName;

    @FXML
    void onCancel(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void onLogin(ActionEvent event) {
        if (txtUserName.getText().isBlank() && pwPassword.getText().isBlank()) {
            lblStatus.setText("Argh...");
            return;
        }

        lblStatus.setText("You're in'!");

        DatabaseManagement dbConnect = new DatabaseManagement();

        String dbUserName = txtUserName.getText();
        String dbPassword = pwPassword.getText();

        Connection connection = dbConnect.getConnection(dbUserName, dbPassword);

        String query = "select first_name, last_name, user_name from UserAccounts;";

        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String userName = rs.getString("user_name");

                String result = "User: " + userName + ", First Name: " + firstName + ", Last Name: " + lastName;

                IO.println(result);

                // lblStatus.setText(result);
            }

        } catch (SQLException e) {
            e.getMessage();
        }
        
    }

}
