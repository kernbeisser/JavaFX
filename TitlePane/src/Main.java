import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        
        BorderPane root = new BorderPane();

        TitledPane titledPane = new TitledPane();
        titledPane.setPadding(new Insets(14));
        titledPane.setContent(creatGridPane());
        titledPane.setText("Address");
        titledPane.setCollapsible(false);

        root.setLeft(titledPane);

        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();


    }

    private GridPane creatGridPane(){
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10));
        gridPane.setVgap(10);
        gridPane.setHgap(10);

        gridPane.add(new Label("Street Name"), 0, 1);
        gridPane.add(new TextField(), 1, 1);
        gridPane.add(new Label("Street Number"), 0, 0);
        gridPane.add(new TextField(), 1, 0);
        gridPane.add(new Label("City"), 0, 2);
        gridPane.add(new TextField(), 1, 2);
        gridPane.add(new Label("Providence"), 0, 3);
        gridPane.add(new TextField(), 1, 3);
        gridPane.add(new Label("Postal Code"), 0, 4);
        gridPane.add(new TextField(), 1, 4);

        return gridPane;
    }
}
