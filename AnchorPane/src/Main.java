import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        
        AnchorPane root = new AnchorPane();

        
        TextArea textArea = new TextArea();
        
        AnchorPane.setTopAnchor(textArea, 14.0);
        AnchorPane.setBottomAnchor(textArea, 100.0);
        AnchorPane.setLeftAnchor(textArea, 14.0);
        AnchorPane.setRightAnchor(textArea, 14.0);


        Button knopf1 = new Button("Knopf 1");
        Button quitKnopf = new Button("Quit");

        knopf1.setMinWidth(75.0);
        quitKnopf.setMinWidth(75.0);
        
        AnchorPane.setBottomAnchor(quitKnopf, 14.0);
        AnchorPane.setRightAnchor(quitKnopf, 14.0);
        
        AnchorPane.setBottomAnchor(knopf1, 14.0);
        
        // double quitKnopfWidth = quitKnopf.getWidth();
        // textArea.setText("" + quitKnopfWidth);


        AnchorPane.setRightAnchor(knopf1, 100.0);
        
        quitKnopf.setOnAction(event -> System.exit(0));
        root.getChildren().addAll(textArea, knopf1, quitKnopf);

        Scene scene = new Scene(root, 400, 300);

        stage.setScene(scene);
        stage.show();

    }
}
