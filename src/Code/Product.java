package Code;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Product
{
    public int getPid() {
        return pid.get();
    }

    public SimpleIntegerProperty pidProperty() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid.set(pid);
    }

    public String getPname() {
        return pname.get();
    }

    public SimpleStringProperty pnameProperty() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname.set(pname);
    }

    public int getSid() {
        return sid.get();
    }

    public SimpleIntegerProperty sidProperty() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid.set(sid);
    }

    public double getPprice() {
        return pprice.get();
    }

    public SimpleDoubleProperty ppriceProperty() {
        return pprice;
    }

    public void setPprice(double pprice) {
        this.pprice.set(pprice);
    }

    public int getUnitsInStock() {
        return unitsInStock.get();
    }

    public SimpleIntegerProperty unitsInStockProperty() {
        return unitsInStock;
    }

    public void setUnitsInStock(int unitsInStock) {
        this.unitsInStock.set(unitsInStock);
    }

    private SimpleIntegerProperty pid;
    private SimpleStringProperty pname;
    private SimpleIntegerProperty sid;
    private SimpleDoubleProperty pprice;
    private SimpleIntegerProperty unitsInStock;

    public Product(int id, String name, int spid, double price, int stock){
        this.pid = new SimpleIntegerProperty(id);
        this.pname = new SimpleStringProperty(name);
        this.sid = new SimpleIntegerProperty(spid);
        this.pprice = new SimpleDoubleProperty(price);
        this.unitsInStock = new SimpleIntegerProperty(stock);
    }
}
