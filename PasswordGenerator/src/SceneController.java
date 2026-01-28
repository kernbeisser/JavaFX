import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;

public class SceneController implements Initializable {

    @FXML
    private Label lblCopiedPassword;

    @FXML
    private TextField txtGenPassword;

    @FXML
    void onClose(ActionEvent event) {
        javafx.application.Platform.exit();
    }

    @FXML
    void onCopy(ActionEvent event) {

        String generatedPw = txtGenPassword.getText();

        // System-Zwischenablage abrufen
        Clipboard clipboard = Clipboard.getSystemClipboard();

        // Content-Container erstellen und befüllen
        ClipboardContent content = new ClipboardContent();
        content.putString(generatedPw);

        // In die Zwischenablage schreiben
        clipboard.setContent(content);

        lblCopiedPassword.setText("Password copied!");
        txtGenPassword.clear();
    }

    @FXML
    void onGenerate(ActionEvent event) {
        txtGenPassword.setText(generatePassword());
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

    }

    public static String generatePassword() {
        String chars = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ!#$%&*+,-./:;<=>?@^_{|}";

        int randomNumber = 0;
        int passwordLength = 14;
        String password = "";

        for (int i = 0; i < passwordLength; i++) {
            randomNumber = (int) Math.floor(Math.random() * chars.length());
            password += chars.substring(randomNumber, randomNumber + 1);
        }

        return password;
    }
}
