package coe528project;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class Scene4Controller extends Main implements Initializable {
    
    @FXML
    private Label errorLabel;
    @FXML
    private TextField userField;
    @FXML
    private TextField passField;
    @FXML
    private Button delButton;
    @FXML
    private Button addButton;
    @FXML
    private Button backButton;
    @FXML
    private TableView<Customers> tableview;
    @FXML
    private TableColumn<Customers, CheckBox> colCheck;
    @FXML
    private TableColumn<Customers, String> colUser;
    @FXML
    private TableColumn<Customers, String> colPass;
    @FXML
    private TableColumn<Customers, Double> colPoints;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        colCheck.setCellValueFactory(new PropertyValueFactory<>("CheckBox"));
        colUser.setCellValueFactory(new PropertyValueFactory<>("Username"));
        colPass.setCellValueFactory(new PropertyValueFactory<>("Password"));
        colPoints.setCellValueFactory(new PropertyValueFactory<>("Points"));
        
        tableview.setItems(o2);
        
    }
    ObservableList<Customers> o2 = FXCollections.observableList(customers);    
    /**
     * deletes customers from the customer list
     * @param event delete button being pressed
     */
    @FXML
    private void deleteCustomer(ActionEvent event) {
        List<Customers> removeCustomers = findCheckedCustomers();
        customers.removeAll(removeCustomers);
        tableview.refresh();
    }

    @FXML
    private void addCustomer(ActionEvent event) {
        String user = userField.getText().trim();
        String pass = passField.getText().trim();
        if (!(user.equals("") || pass.equals("") || user.equals("Admin")) && isCustomerValid(user)){
            getUser().addItem(new Customers(user,pass));
            tableview.refresh();
            errorLabel.setText("");
        }
        else errorLabel.setText("Invalid username or password!");
        userField.setText("");
        passField.setText("");    
    }

    @FXML
    private void goBack(ActionEvent event) throws IOException {
        Parent root2 = FXMLLoader.load(getClass().getResource("Scene2.fxml"));
        Stage window = (Stage)addButton.getScene().getWindow();
        window.setScene(new Scene(root2));
    }
    
}
