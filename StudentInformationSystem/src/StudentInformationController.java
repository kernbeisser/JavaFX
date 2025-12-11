import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;


public class StudentInformationController implements Initializable{

    @FXML
    private Label lblStatus;

     @FXML
    private Button btnQuit;

    @FXML
    private Button btnDisplay;

    @FXML
    private CheckBox cbBasketball;

    @FXML
    private CheckBox cbStudentsCouncil;

    @FXML
    private CheckBox cbSwimming;

    @FXML
    private CheckBox cbVolleyball;

    @FXML
    private CheckBox cbVolunteerWork;

    @FXML
    private ComboBox<?> cmbSunjects;

    @FXML
    private RadioButton rbBusinessAnakyst;

    @FXML
    private RadioButton rbComputerScience;


    @FXML
    private ToggleGroup tglGroup;


    @FXML
    private TextArea tadisplay;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtCity;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtFirstName;

    @FXML
    private TextField txtPhoneNo;

    @FXML
    private TextField txtPostalCode;

    @FXML
    private TextField txtPrivince;

    @FXML
    private CheckBox xbfootball;

    @FXML
    void onDisplay(ActionEvent event) {
        StringBuilder sb = new StringBuilder();

        sb.append(txtFirstName.getText()).append("\n");
        sb.append(txtAddress.getText()).append("\n");
        sb.append(txtPrivince.getText()).append("\n");
        sb.append(txtCity.getText()).append("\n");
        sb.append(txtPhoneNo.getText()).append("\n");
        sb.append(txtPostalCode.getText()).append("\n");
        sb.append(txtEmail.getText());

        tadisplay.setText(sb.toString());
    }

    @FXML
    void onQuit(ActionEvent event) {
        System.exit(0);
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        ToggleGroup tglGroup = new ToggleGroup();

        tglGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {

            @Override
            public void changed(ObservableValue<? extends Toggle> arg0, Toggle arg1, Toggle arg2) {
                RadioButton slectedRB = (RadioButton) tglGroup.getSelectedToggle();
                lblStatus.setText(""+ slectedRB.getText());
            }
            
        });

        this.rbComputerScience.setToggleGroup(tglGroup);
        this.rbBusinessAnakyst.setToggleGroup(tglGroup);
    }

}
