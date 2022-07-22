
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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 */
public class Scene6Controller extends Main implements Initializable {
    private double cost;
    @FXML
    private Label costLabel;
    @FXML
    private Label pointLabel;
    @FXML
    private Label statusLabel;
    @FXML
    private Button logoutButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cost = getCost();
        int pointsAdded = (int)cost * 10;
        ((Customers)getUser()).setPoints(pointsAdded);
        ((Customers)getUser()).setStatus();
        costLabel.setText(cost + "");
        pointLabel.setText(((Customers)getUser()).getPoints() + "");
        statusLabel.setText(((Customers)getUser()).getStatus() + ""); 
    }    

    @FXML
    private void logout(ActionEvent event) throws IOException {
        logout();
        Parent root1 = FXMLLoader.load(getClass().getResource("Scene1.fxml"));
        Stage window = (Stage)logoutButton.getScene().getWindow();
        window.setScene(new Scene(root1));
    }
    
}
