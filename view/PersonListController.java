package csc202.FinalProject.view;

import csc202.FinalProject.model.Person;
import csc202.FinalProject.model.PersonDB;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import org.apache.commons.lang3.StringUtils;

import java.net.URL;
import java.util.ResourceBundle;

public class PersonListController implements Initializable {


    @FXML private TableView<Person> tableView;
    @FXML private TableColumn<Person, String> colName;
    @FXML private TableColumn<Person, String> colAddress;
    @FXML private TableColumn<Person, String> colCity;
    @FXML private TableColumn<Person, String> colState;
    @FXML private TableColumn<Person, Integer> colZip;
    @FXML private TableColumn<Person, Double> colLat;
    @FXML private TableColumn<Person, Double> colLong;
    @FXML private TextField txtFieldSearch;
    @FXML private Button btnSearch;

    public void updateSearch(ActionEvent actionEvent){
        int zipCode;

        if(StringUtils.isNumeric(txtFieldSearch.getText())) {
             zipCode = Integer.parseInt(txtFieldSearch.getText());
        } else {
            zipCode = -1;
        }
        Person personKey = new Person();
        personKey.setZipCode(zipCode);

        ObservableList<Person> searchPersonResultTable = FXCollections.observableArrayList();


        if (PersonDB.getPersonList().search(personKey)){
            searchPersonResultTable.add(PersonDB.getPersonList().get(personKey));
            tableView.setItems(searchPersonResultTable);
        } else if((Integer)zipCode==-1){
            tableView.setItems(getPerson());

        } else{
            searchPersonResultTable.clear();
            tableView.setItems(searchPersonResultTable);
        }

    }


    public ObservableList<Person> getPerson(){
        ObservableList<Person> persons = FXCollections.observableArrayList();
        for (Person e: PersonDB.person){
            persons.add(e);
        }

        return persons;

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        colName.setCellValueFactory(new PropertyValueFactory<Person, String>("firstName"));
        colAddress.setCellValueFactory(new PropertyValueFactory<Person, String>("address"));
        colCity.setCellValueFactory(new PropertyValueFactory<Person, String>("city"));
        colState.setCellValueFactory(new PropertyValueFactory<Person, String>("state"));
        colZip.setCellValueFactory(new PropertyValueFactory<Person, Integer>("zipCode"));
        colLat.setCellValueFactory(new PropertyValueFactory<Person, Double>("latitude"));
        colLong.setCellValueFactory(new PropertyValueFactory<Person, Double>("longitude"));

        tableView.setItems(getPerson());
    }


}
