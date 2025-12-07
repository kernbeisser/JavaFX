import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class ListController {

    @FXML
    private ListView<String> lstWizzards;

       @FXML
    private Button btnConnect;

    @FXML
    private PasswordField pwPassword;

    @FXML
    private TextField txtUserName;

    @FXML
    void onConnect(ActionEvent event) {
        DatabaseConnection dbConnect = new DatabaseConnection();
        String userName = txtUserName.getText();
        String password = pwPassword.getText();

        // IO.println(userName);
        // IO.println(password);
        Connection connection = dbConnect.getConnection(userName, password);
     
        String query = "select name, house, age from wizzards";

        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {
                String wizzardsName = rs.getString("name");
                String wizzardsHouse = rs.getString("house");
                int age = rs.getInt("age");

                StringBuilder sb = new StringBuilder();
                sb.append(wizzardsName).append(", ");
                sb.append(wizzardsHouse).append(", ");
                sb.append(age);

                lstWizzards.getItems().add(sb.toString());
            }

        } catch (SQLException e) {
            e.getMessage();
        }
    }

}
