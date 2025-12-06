import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
            stage.setWidth(1024);
            stage.setHeight(768);
			stage.show();
    }
}
