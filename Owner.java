package coe528project;

import static coe528project.Main.addBook;
import static coe528project.Main.addCustomer;


public class Owner extends User {
    public Owner() {
        super("Admin", "Admin");
    }
    @Override
    public void addItem(Object o) {
        if (o instanceof Customers) {
            addCustomer((Customers)o);
        }
        if (o instanceof Books) {
            addBook((Books)o);
        }
    };
}
