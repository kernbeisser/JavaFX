import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        
        BorderPane root = new BorderPane();
        Button knopf = new Button("Drück mich!");
        knopf.setOnAction(event -> System.out.println("Huhu, Schnuffel!"));

        root.setCenter(knopf);

        Scene scene = new Scene(root, 640, 480);

        stage.setScene(scene);
        stage.show();
    }
}
