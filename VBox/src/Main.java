import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        
        VBox root = new VBox();
        root.setAlignment(Pos.TOP_RIGHT);

        Button knopf1 = new Button("Knopf 2");
        knopf1.setMaxWidth(Double.MAX_VALUE);
        VBox.setMargin(knopf1, new Insets(13, 13, 13, 13));

        Button knopf2 = new Button("Knopf 2");
        VBox.setMargin(knopf2, new Insets(0, 13, 13, 13));
        
        Button knopf3 = new Button("Knopf 3");
        VBox.setMargin(knopf3, new Insets(0, 13, 13, 13));

        root.getChildren().addAll(knopf1, knopf2, knopf3);

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
