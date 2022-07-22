package coe528project;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.stage.Stage;


public class Main extends Application {
    private static User u;
    private Stage window;
    protected static List<Books> books = initializeBooks();
    protected static List<Customers> customers = initializeCustomers();
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        window = primaryStage;
        Parent root1 = FXMLLoader.load(getClass().getResource("Scene1.fxml"));
        window.setTitle("Bookstore App");
        window.setScene(new Scene(root1));
        window.setResizable(false);
        window.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    public static void addCustomer(Customers c) {
        customers.add(c);
    }
    public static void addBook(Books b) {
        books.add(b);
    }
    public List<Customers> findCheckedCustomers() {
        List<Customers> removeCustomers = new ArrayList<Customers>();
        for (Customers c : customers) {
            if (c.getCheckBox().isSelected()) removeCustomers.add(c);
        }
        return removeCustomers;
    }
    public List<Books> findCheckedBooks() {
        List<Books> removeBooks = new ArrayList<Books>();
        for (Books b : books) {
            if (b.getCheckBox().isSelected()) removeBooks.add(b);
        }
        return removeBooks;
    }
    public double getCost() {
        List<Books> removeBooks = findCheckedBooks();
        double cost = 0;
        for (Books b: removeBooks) {
            cost += b.getPrice();
            books.removeAll(removeBooks);
        }
        return cost;
    }
    public boolean isCustomerValid(String username) {
        for (Customers c: customers) {
            if (c.getUsername().equals(username)) return false;
        }
        return true;
    }
    public static ArrayList<Books> initializeBooks() {
        ArrayList<Books> bookList = new ArrayList<Books>();
        int i = 0;
        String s1 = "";
        double d1 = 0;
        try {
            File file = new File("User_Info/Books.txt");
            Scanner scan = new Scanner(file);
            while(scan.hasNext()) {
                if (i%2 == 0) s1 = scan.nextLine();
                else if (i%2 == 1) { 
                    d1 = Double.parseDouble(scan.nextLine());
                    bookList.add(new Books(s1,d1));
                }         
                i++;
            }
            scan.close();
        } catch (IOException e) {
            //System.out.println(new File(".").getAbsolutePath());
            System.out.println("An error occurred.");
            e.printStackTrace();
        } 
        return bookList;
    }
    public static ArrayList<Customers> initializeCustomers() {
        ArrayList<Customers> customerList = new ArrayList<Customers>();
        int i = 0;
        String user = "";
        String pass = "";
        int pts = 0;
        try {
            File file = new File("User_Info/Customers.txt");
            Scanner scan = new Scanner(file);
            while(scan.hasNext()) {
                if (i%3 == 0) user = scan.nextLine();
                else if (i%3 == 1) pass = scan.nextLine();
                else if (i%3 == 2) { 
                    pts = Integer.parseInt(scan.nextLine());
                    customerList.add(new Customers(user, pass, pts));
                }         
                i++;
            }
            scan.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return customerList;  
    }
    
    public void logout() {
        try {
            File file = new File("User_Info/Customers.txt");
            FileWriter fw = new FileWriter(file, false);
            file = new File("User_Info/Books.txt");
            fw = new FileWriter(file, false);
        }catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        try {
            File file = new File("User_Info/Customers.txt");
            FileWriter fw = new FileWriter(file, true);
            for (Customers c : customers) {
                fw.write(c.getUsername()+ "\n");
                fw.write(c.getPassword()+ "\n");
                fw.write(c.getPoints() + "\n");
            }
            fw.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        try {
            File file = new File("User_Info/Books.txt");
            FileWriter fw = new FileWriter(file, true);
            for (Books b : books) {
                fw.write(b.getTitle() + "\n");
                fw.write(b.getPrice() + "\n");
            }
            fw.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        for (Books b : books) {
            b.getCheckBox().setSelected(false);
        }
        for (Customers c : customers) {
            c.getCheckBox().setSelected(false);
        }
    }
    public void setUser(User u) {
        this.u = u;
    }
    public User getUser(){
        return this.u;
    }
    
}
