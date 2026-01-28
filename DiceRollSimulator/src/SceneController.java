import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class SceneController implements Initializable{

    private String[] dice = {"\u2680", "\u2681", "\u2682", "\u2683", "\u2684", "\u2685"};

    @FXML
    private Label lblDice;

    @FXML
    private ListView<String> lstRolls;

    @FXML
    void onClose(ActionEvent event) {
        javafx.application.Platform.exit();
    }

    @FXML
    void onRoll(ActionEvent event) {
        int randomRoll = (int )Math.floor(Math.random() * dice.length);
        lblDice.setText(dice[randomRoll]);
        lstRolls.getItems().add(String.valueOf(randomRoll+1));
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        lstRolls.setStyle("-fx-font-size: 24px;");
        lblDice.setStyle("-fx-font-size: 72px;");
        this.lblDice.setText("...");
    }

}
