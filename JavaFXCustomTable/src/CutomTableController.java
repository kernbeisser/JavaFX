import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class CutomTableController {

    @FXML
    private Button btnClose;

    @FXML
    void onclose(ActionEvent event) {
        System.exit(0);
    }

}
