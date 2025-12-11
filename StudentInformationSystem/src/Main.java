import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("students.fxml"));


        Scene scene = new Scene(root);
        primaryStage.setScene(scene);

        primaryStage.setMinWidth(960);
        primaryStage.setMinHeight(900);

        primaryStage.show();
    }
}
