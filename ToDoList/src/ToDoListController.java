import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class ToDoListController {

    @FXML
    private Button btnAddNewEntry;

    @FXML
    private Button btnCompleted;

    @FXML
    private Button btnDeleteToDo;

    @FXML
    private ListView<String> lstTodos;

    @FXML
    private TextField txtNewEntry;

    @FXML
    private Button btnQuit;

    @FXML
    void onAddNewEntry(ActionEvent event) {
        lstTodos.getItems().add(txtNewEntry.getText());
    }

    @FXML
    void onCompleted(ActionEvent event) {
        char haken = '✔';

        if (!lstTodos.getItems().isEmpty()) {
            int idx = lstTodos.getSelectionModel().getSelectedIndex();
            String item = lstTodos.getItems().get(idx);
            lstTodos.getItems().remove(idx);
            String completed = haken + " " + item;
            lstTodos.getItems().add(completed);
        }

    }

    @FXML
    void onDeleteToDo(ActionEvent event) {
        if (!lstTodos.getItems().isEmpty()) {
            int idx = lstTodos.getSelectionModel().getSelectedIndex();
            lstTodos.getItems().remove(idx);
        }
    }

    @FXML
    void onQuit(ActionEvent event) {
        System.exit(0);
    }

}
