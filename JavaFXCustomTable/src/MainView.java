import javafx.application.Application;
import javafx.geometry.NodeOrientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainView extends Application {


    public void callLaunch(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        
        Scene scene = new Scene(createRoot(), 500, 400);
        scene.getStylesheets().add("style.css");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    private Button createButton(){
        Button btnQuit = new Button("Quit");
        btnQuit.setOnAction(event -> System.exit(0));

        return btnQuit;
    }

    private BorderPane createRoot(){
        BorderPane root = new BorderPane();
        root.setCenter(new CreateCustomTable().getTable());
        root.setBottom(createButton());
        
        // Not specific to only one orientation like 'Bottom', it turns 
        // all nodes.
        // root.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);

        return root;
    }
}
