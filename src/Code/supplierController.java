package Code;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class supplierController
{
    //Adding new supplier components
    @FXML
    TextField supplierid, supcompanyname, supphone, supaddress;
    @FXML
    Button btnAddSupplier, btnBack;
    public void addSupplier() throws SQLException, ClassNotFoundException, InterruptedException {
        Connection connection = new sqlconnection().connection();
        String query = "insert into online_store.dbo.suppliers (supplierId, CompanyName, phone, Address) " +
                "values (?, ?, ?, ?)";
        if (connection != null){
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setString(1,supplierid.getText() );
            pst.setString(2, supcompanyname.getText());
            pst.setString(3, supphone.getText());
            pst.setString(4, supaddress.getText());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "New Supplier Added Successfully");
            supplierid.setText("");
            supcompanyname.setText("");
            supphone.setText("");
            supaddress.setText("");
            pst.close();
        }
    }
    public void backToAdminScene() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../fxmlFiles/productListWhenLogin.fxml"));
        Stage window = (Stage) btnBack.getScene().getWindow();
        window.setScene(new Scene(root, 601, 400));
    }
}
