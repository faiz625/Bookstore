package coe528project;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Scene1Controller extends Main implements Initializable {
    
    @FXML
    private TextField userField;
    @FXML
    private Label errorLabel;
    @FXML
    private PasswordField passField;
    @FXML
    private Button loginButton;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void login(ActionEvent event) throws IOException {
        setUser(new Owner());
        boolean loginOwner = getUser().verifyLogin(userField,passField);
        boolean loginCustomer = false;
        if (loginOwner) {
            Parent root2 = FXMLLoader.load(getClass().getResource("Scene2.fxml"));
            Stage window = (Stage)loginButton.getScene().getWindow();
            window.setScene(new Scene(root2));
        }
        else {
            for (Customers c : customers) {
                setUser(c);
                if (getUser().verifyLogin(userField,passField)) {
                    loginCustomer = true; errorLabel.setText(""); break;
                }
            }
            errorLabel.setText("Invalid username or password!");
            userField.setText("");
            passField.setText("");
        }
        if (loginCustomer) {
            Parent root3 = FXMLLoader.load(getClass().getResource("Scene5.fxml"));
            Stage window = (Stage)loginButton.getScene().getWindow();
            window.setScene(new Scene(root3));
        }
    }
    
}
