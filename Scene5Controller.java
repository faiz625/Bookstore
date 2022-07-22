/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528project;

import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author yehud
 */
public class Scene5Controller extends Main implements Initializable {
    
    @FXML
    private Label userLabel;
    @FXML
    private Label pointLabel;
    @FXML
    private Label statusLabel;
    @FXML
    private Button redeemButton;
    @FXML
    private Button buyButton;
    @FXML
    private Button logoutButton;
    @FXML
    private TableView<Books> tableview;
    @FXML
    private TableColumn<Books, CheckBox> colCheck;
    @FXML
    private TableColumn<Books, String> colTitle;
    @FXML
    private TableColumn<Books, Double> colPrice;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        colCheck.setCellValueFactory(new PropertyValueFactory<>("CheckBox"));
        colTitle.setCellValueFactory(new PropertyValueFactory<>("Title"));
        colPrice.setCellValueFactory(new PropertyValueFactory<>("Price"));
        
        ((Customers)getUser()).setStatus();
        
        userLabel.setText(getUser().getUsername());
        pointLabel.setText(((Customers)getUser()).getPoints() + "");
        statusLabel.setText(((Customers)getUser()).getStatus() + "");
        tableview.setItems(o3); 
        
    }   
    
    ObservableList<Books> o3 = FXCollections.observableList(books);   

    @FXML
    private void redeemPoints(ActionEvent event) throws IOException {
        Parent root7 = FXMLLoader.load(getClass().getResource("Scene7.fxml"));
        Stage window = (Stage)redeemButton.getScene().getWindow();
        window.setScene(new Scene(root7));
    }

    @FXML
    private void buyBook(ActionEvent event) throws IOException {
        Parent root6 = FXMLLoader.load(getClass().getResource("Scene6.fxml"));
        Stage window = (Stage)buyButton.getScene().getWindow();
        window.setScene(new Scene(root6));
    }

    @FXML
    private void logout(ActionEvent event) throws IOException {
        logout();
        Parent root1 = FXMLLoader.load(getClass().getResource("Scene1.fxml"));
        Stage window = (Stage)logoutButton.getScene().getWindow();
        window.setScene(new Scene(root1));
        
    }
    
}
