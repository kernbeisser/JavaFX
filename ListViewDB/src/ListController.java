import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

public class ListController implements Initializable {

    @FXML
    private ListView<String> lstWizzards;

    public void initialize(URL location, ResourceBundle resources) {
        DatabaseConnection dbConnect = new DatabaseConnection();

        Connection connection = dbConnect.getConnection();

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
