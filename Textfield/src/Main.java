import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        
        HBox root = new HBox();

        Label label = new Label("Name: ");
        TextField textField = new TextField();
        textField.setPromptText("Enter your name");
        textField.setFocusTraversable(false);

        Button button = new Button("Quit");
        button.setOnAction(event -> System.exit(0));

        root.getChildren().add(label);
        root.getChildren().add(textField);
        root.getChildren().add(button);


        Scene scene = new Scene(root, 400, 300);
        
        stage.setScene(scene);
        stage.show();
    
    }
}
