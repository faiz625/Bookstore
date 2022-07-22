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

public class Scene3Controller extends Main implements Initializable {
    @FXML
    private Label errorLabel;
    @FXML
    private TextField titleField;
    @FXML
    private TextField priceField;
    @FXML
    private Button addButton;
    @FXML
    private Button delButton;
    @FXML
    private Button backButton;
    @FXML
    private TableView<Books> tableview;
    @FXML
    private TableColumn<Books, CheckBox> colCheck;
    @FXML
    private TableColumn<Books, String> colTitle;
    @FXML
    private TableColumn<Books, Double> colPrice;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        colCheck.setCellValueFactory(new PropertyValueFactory<>("CheckBox"));
        colTitle.setCellValueFactory(new PropertyValueFactory<>("Title"));
        colPrice.setCellValueFactory(new PropertyValueFactory<>("Price"));
        
        tableview.setItems(ol); 
    }   
    
    ObservableList<Books> ol = FXCollections.observableList(books);    

    @FXML
    private void addBook(ActionEvent event) {
        String title = titleField.getText().trim();
        double price;
        try {
            price = Double.parseDouble(priceField.getText().trim());
            price = Math.round(price*100.0)/100.0;
            errorLabel.setText("");
            if (!(title.equals(""))){
                getUser().addItem(new Books(title,price));
                tableview.refresh();
            }   
        }
        catch (Exception e) {
            errorLabel.setText("Invalid price!");
        }
        finally {
            titleField.setText("");
            priceField.setText("");
        }
         
    }

    @FXML
    private void deleteBook(ActionEvent event) {
        List<Books> removeBooks = findCheckedBooks();
        books.removeAll(removeBooks);
        tableview.refresh();
    }

    @FXML
    private void goBack(ActionEvent event) throws IOException {
        Parent root2 = FXMLLoader.load(getClass().getResource("Scene2.fxml"));
        Stage window = (Stage)addButton.getScene().getWindow();
        window.setScene(new Scene(root2));
    }  
    
}
