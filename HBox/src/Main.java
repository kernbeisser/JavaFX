import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        
        HBox root = new HBox();

        Button knopf1 = new Button("Knopf 1");
        // knopf1.setPrefWidth(120);
        knopf1.setMaxWidth(Integer.MAX_VALUE);
        HBox.setMargin(knopf1, new Insets(13, 0, 13, 13));
        HBox.setHgrow(knopf1, Priority.SOMETIMES);
        knopf1.setOnAction(event -> IO.println("Huhu, Schnuffel!"));
        
        Button knopf2 = new Button("Knopf 2");
        knopf2.setMaxWidth(Integer.MAX_VALUE);
        HBox.setMargin(knopf2, new Insets(13, 0, 13, 13));
        HBox.setHgrow(knopf2, Priority.SOMETIMES);
        knopf2.setPrefWidth(120);
        
        Region region = new Region();
        HBox.setHgrow(region, Priority.ALWAYS);
        
        Button knopf3 = new Button("Knopf 3");
        knopf3.setMaxWidth(Integer.MAX_VALUE);
        HBox.setMargin(knopf3, new Insets(13, 13, 13, 13));
        HBox.setHgrow(knopf3, Priority.SOMETIMES);
        knopf3.setPrefWidth(120);
        

        root.getChildren().addAll(knopf1, knopf2, knopf3);

        Scene scene = new Scene(root, 400, 300);
        stage.setScene(scene);
        stage.show();
    }
}
