import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CalcController {

    private int z1;
    private int z2;
    private int resultat;

    @FXML
    private Label lblStatus;

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnMty;

    @FXML
    private Button btnQuit;

    @FXML
    private Button btnSub;

    @FXML
    private Button txtDiv;

    @FXML
    private TextField txtResult;

    @FXML
    private TextField txtZahl1;

    @FXML
    private TextField txtZahl2;

    @FXML
    void onAdd(ActionEvent event) {

        z1 = checkInput()[0];
        z2 = checkInput()[1];

        resultat = z1 + z2;
        txtResult.setText(String.format("%s", resultat));
    }

    @FXML
    void onDiv(ActionEvent event) {

        z1 = checkInput()[0];
        z2 = checkInput()[1];

        if (z2 > 0) {
            double r;
            r = (double)z1 / (double)z2;
            txtResult.setText(String.format("%s", r));
        }
    }

    @FXML
    void onMty(ActionEvent event) {
        
        z1 = checkInput()[0];
        z2 = checkInput()[1];

        resultat = z1 * z2;
        txtResult.setText(String.format("%s", resultat));
    }

    @FXML
    void onQuit(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void onSub(ActionEvent event) {

        z1 = checkInput()[0];
        z2 = checkInput()[1];

        resultat = z1 - z2;
        txtResult.setText(String.format("%s", resultat));
    }

    private int[] checkInput() {

        int[] zahlen = new int[2];

        try {
            z1 = Integer.parseInt(txtZahl1.getText());
            z2 = Integer.parseInt(txtZahl2.getText());

            zahlen[0] = z1;
            zahlen[1] = z2;

        } catch (Exception e) {
            lblStatus.setText("Beide Felder müssen ganze Zahlen enthalten!");
            System.err.println(e.getMessage());
        }
        return zahlen;
    }

}
