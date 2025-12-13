import javafx.event.EventHandler;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.IntegerStringConverter;

public class CreateCustomTable {

    private TableView<Person> table;
    private TableColumn<Person, String> firstNameColumn;
    private TableColumn<Person, String> lastNameColumn;
    private TableColumn<Person, Integer> ageColumn;


    public CreateCustomTable(){
        table = new TableView<Person>();
        table.setEditable(true);
    }

    public TableView<Person> getTable(){

        firstNameColumn = new TableColumn<>("First Name");
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        firstNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        firstNameColumn.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Person,String>>() {
            @Override
            public void handle(CellEditEvent<Person, String> event) {
                Person person = event.getRowValue();
                person.setFirstName(event.getNewValue());
            }
        });
        
        lastNameColumn = new TableColumn<>("Last Name");
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        lastNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        lastNameColumn.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Person,String>>() {
            @Override
            public void handle(CellEditEvent<Person, String> event) {
                Person person = event.getRowValue();
                person.setLastName(event.getNewValue());
            }
        });
        
        ageColumn = new TableColumn<>("Age");
        ageColumn.setCellValueFactory(new PropertyValueFactory<>("age"));
        ageColumn.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        ageColumn.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Person,Integer>>() {
            @Override
            public void handle(CellEditEvent<Person, Integer> event) {
                Person person = event.getRowValue();
                person.setAge(event.getNewValue());
            }
        });

        table.getColumns().add(firstNameColumn);
        table.getColumns().add(lastNameColumn);
        table.getColumns().add(ageColumn);
        
        // Set all columns to prefered width in one shot
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY_ALL_COLUMNS);
        
        table.getItems().add(new Person("Harry", "Potter", 12));
        table.getItems().add(new Person("Hermione", "Granger", 11));
        table.getItems().add(new Person("Roanld", "Weasley", 12));
        table.getItems().add(new Person("Seamus", "Finnaghan", 12));
        table.getItems().add(new Person("Dean", "Thomas", 13));
        table.getItems().add(new Person("Luna", "Lovegood", 12));
        table.getItems().add(new Person("Tom", "Riddle", 96));

        return table;
    }
}
