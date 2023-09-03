package org.behavioral.state;

//class that will use the Connection interface for connecting with different types of connection
public class Controller {

    public static Sales sales;
    public static Management management;
    public Accounting acct;
    private Connection con;

    Controller() {
        acct = new Accounting();
        sales = new Sales();
        management = new Management();
    }

    public void setAccountingConnection() {
        con = acct;
    }

    public void setSalesConnection() {
        con = sales;
    }

    public void setManagementConnection() {
        con = management;
    }

    public void open() {
        con.open();
    }

    public void close() {
        con.close();
    }

    public void log() {
        con.log();
    }

    public void update() {
        con.update();
    }
}
