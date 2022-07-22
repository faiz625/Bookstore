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
import javafx.stage.Stage;

public class Scene2Controller extends Main implements Initializable {

    @FXML
    private Button bookButton;
    @FXML
    private Button customerButton;
    @FXML
    private Button logoutButton;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }    

    @FXML
    private void bookButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Scene3.fxml"));
        Stage window = (Stage)bookButton.getScene().getWindow();
        window.setScene(new Scene(root));
    }

    @FXML
    private void customerButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Scene4.fxml"));
        Stage window = (Stage)customerButton.getScene().getWindow();
        window.setScene(new Scene(root));
    }

    @FXML
    private void backButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Scene1.fxml"));
        Stage window = (Stage)logoutButton.getScene().getWindow();
        window.setScene(new Scene(root));
        logout();
    }
    
}
