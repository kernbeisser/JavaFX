
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        
        BorderPane root = new BorderPane();
        GridPane grid = new GridPane();

        Label lblFirstName = new Label("First Name");
        Label lblLastName = new Label("Last Name");
        TextField txtFirstName = new TextField();
        TextField txtLastName = new TextField();
        Button btnSave = new Button("Save");
        Button btnCancel = new Button("Cancel");

        ButtonBar btnBar = new ButtonBar();
        btnBar.getButtons().addAll(btnSave, btnCancel);
        
        grid.add(lblFirstName, 0, 0, 1, 1);
        grid.add(txtFirstName, 1, 0, 1, 1);
        grid.add(lblLastName, 0, 1, 1, 1);
        grid.add(txtLastName, 1, 1, 1, 1);
        grid.add(btnBar, 0, 2, 2, 1);

        grid.setHgap(10);
        grid.setVgap(10);

        grid.setPadding(new Insets(10,10,101,10));

        ColumnConstraints column1 = new ColumnConstraints();
        ColumnConstraints column2 = new ColumnConstraints();

        grid.getColumnConstraints().add(column1);
        grid.getColumnConstraints().add(column2);

        column1.setPrefWidth(100);
        column2.setPrefWidth(200);

        // column1.setPercentWidth(50);
        // column2.setPercentWidth(100);

        GridPane.setHalignment(lblFirstName, HPos.RIGHT);
        GridPane.setHalignment(lblLastName, HPos.RIGHT);

        GridPane.setHgrow(txtFirstName, Priority.ALWAYS);
        GridPane.setHgrow(txtLastName, Priority.ALWAYS);

        // GridPane.setHalignment(txtFirstName, HPos.LEFT);
        // GridPane.setHalignment(txtLastName, HPos.LEFT);

        root.setCenter(grid);

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Huhu, Schnuffel!");
        stage.show();
    }
}
