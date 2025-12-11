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

    private StringBuilder sb;

     @FXML
    private Button btnClear;

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
    private ComboBox<String> cmbSubjects;

    @FXML
    private RadioButton rbBusinessAnakyst;

    @FXML
    private RadioButton rbComputerScience;


    @FXML
    private ToggleGroup tglGroup;


    @FXML
    private TextArea taDisplay;

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

        sb.append("Personal Details:\n");

        sb.append(txtFirstName.getText()).append("\n");
        sb.append(txtAddress.getText()).append("\n");
        sb.append(txtPrivince.getText()).append("\n");
        sb.append(txtCity.getText()).append("\n");
        sb.append(txtPhoneNo.getText()).append("\n");
        sb.append(txtPostalCode.getText()).append("\n");
        sb.append(txtEmail.getText());

        sb.append("\nAcademcis\n");
        if (rbComputerScience.isSelected()) {
            sb.append("Computer Science\n");
        } else if (rbBusinessAnakyst.isSelected()) {
            sb.append("Bussiness Analyst\n");
        }
        
        sb.append("Subjcts:\n");
        sb.append(cmbSubjects.getValue());

        sb.append("\nActivities\n");
        if (cbBasketball.isSelected()) {
            sb.append("Basketball\n");
        }
        
        if (cbVolleyball.isSelected()) {
            sb.append("Volleyball\n");
        }
        
        if (cbSwimming.isSelected()) {
            sb.append("Swimming\n");
        }
        
        if (cbStudentsCouncil.isSelected()) {
            sb.append("Student's Council\n");
        }
        
        if (cbVolunteerWork.isSelected()) {
            sb.append("Doing volonteer work\n");
        }
                
        taDisplay.setText(sb.toString());
    }

    @FXML
    void onQuit(ActionEvent event) {
        System.exit(0);
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        ToggleGroup tglGroup = new ToggleGroup();
        sb = new StringBuilder();

        tglGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {

            @Override
            public void changed(ObservableValue<? extends Toggle> arg0, Toggle arg1, Toggle arg2) {
                RadioButton selectedRB = (RadioButton) tglGroup.getSelectedToggle();

                lblStatus.setText(""+ selectedRB.getText());

                if (selectedRB.getText().equals("Computer Science")) {
                    cmbSubjects.getItems().clear();
                    cmbSubjects.getItems().addAll("Java", "Python", "C++");
                } else if (selectedRB.getText().equals("Business Analyst")) {
                    cmbSubjects.getItems().clear();
                    cmbSubjects.getItems().addAll("Process Mangement", "Supply Chain", "Resource Planing");
                }
            }
            
        });

        this.rbComputerScience.setToggleGroup(tglGroup);
        this.rbBusinessAnakyst.setToggleGroup(tglGroup);

    }

    @FXML
    void onClear(ActionEvent event) {
        taDisplay.clear();
    }
}
