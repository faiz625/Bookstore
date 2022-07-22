/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
 * @author yehud
 */
public class Scene7Controller extends Main implements Initializable {
    private double cost = getCost();;
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
        cost = costAfterPoints();
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
    private double costAfterPoints() {
        int dollarEquiv = ((Customers)getUser()).getPoints() / 100;
        if (cost >= dollarEquiv) {
            cost -= dollarEquiv;
            ((Customers)getUser()).setPoints( ((Customers)getUser()).getPoints() * -1 );
            ((Customers)getUser()).setPoints( (int)cost * 10);
        }
        else {
            ((Customers)getUser()).setPoints( (int)cost * 100 * -1 );
            cost = dollarEquiv - cost;
            
        }
        ((Customers)getUser()).setStatus();
        return cost;
    }
    
}
