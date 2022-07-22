package coe528project;

import javafx.scene.control.CheckBox;

public class Books {
    private String title;
    private double price;
    private CheckBox cb;
    public Books(String title, double price) {
        this.title = title;
        this.price = price;
        cb = new CheckBox();
    }
    
    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }
    public CheckBox getCheckBox() {
        return cb;
    } 
}
