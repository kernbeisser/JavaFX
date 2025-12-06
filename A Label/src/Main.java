import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        
        BorderPane root = new BorderPane();

        Label label = new Label("Huhu, Schnuffel!");
        label.setFont(new Font("Zapfino", 24));
        
        Button button = new Button("Quit");
        button.setOnAction(event -> System.exit(0));
        
        root.setCenter(label);
        root.setBottom(button);

        Scene scene = new Scene(root, 640, 480);
        
        stage.setScene(scene);
        stage.show();
    }
}
