package Code;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.sql.*;

public class productController
{
    @FXML
    Button addProductButton, logoutBtn, addSBtn, btnBack;
    // Adding new product components
    @FXML
    TextField productidtxf, productnametxf, supplieridtxf, pricetxf, quantitytxf;

    @FXML //Label when product adds
    Label lblStatus, welcomeLbl;

    // Add Product button clicked
    public void addProductScene() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../fxmlFiles/addingProduct.fxml"));
        Stage window = (Stage) addProductButton.getScene().getWindow();
        window.setScene(new Scene(root, 601, 400));
    }
    //Back to home page
    public void backToStartScene() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../fxmlFiles/sample.fxml"));
        Stage window = (Stage) logoutBtn.getScene().getWindow();
        window.setScene(new Scene(root, 601, 343));
    }
    // Add Supplier button clicked
    public void addSupplierButtonClicked() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../fxmlFiles/addSupplier.fxml"));
        Stage window = (Stage) addSBtn.getScene().getWindow();
        window.setScene(new Scene(root, 601, 400));
    }
    public void backToAdminScene() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../fxmlFiles/productListWhenLogin.fxml"));
        Stage window = (Stage) btnBack.getScene().getWindow();
        window.setScene(new Scene(root, 601, 400));
    }

    //Adding product to the store
    public void addProduct () throws SQLException, ClassNotFoundException {
        Connection connection = new sqlconnection().connection();
        if (connection != null)
        {
            System.out.println("Connected!");
            String pid = productidtxf.getText();
            String pname = productnametxf.getText();
            String sname = supplieridtxf.getText();
            String price = pricetxf.getText();
            String quantity = quantitytxf.getText();
            String query = "insert into Application_3_Onlinestore.dbo.Products(Product_Id, Name," +
                    "Supplier, Base_Price, Quantity) values(?,?,?,?,?)";
            PreparedStatement stm = connection.prepareStatement(query);
            //waiting for adding product scene!
            stm.setString(1,pid );
            stm.setString(2,pname );
            stm.setString(3,sname);
            stm.setString(4,price );
            stm.setString(5,quantity);

            stm.executeUpdate();
            lblStatus.setText("Product added successfully");
            productidtxf.setText("");
            productnametxf.setText("");
            supplieridtxf.setText("");
            pricetxf.setText("");
            quantitytxf.setText("");
            stm.close();
        }
    }

    public void deleteProduct() throws SQLException, ClassNotFoundException {
        Connection connection = new sqlconnection().connection();
        String sql = "Delete From Application_3_Onlinestore.dbo.Products where name = ?";

        if (connection != null){
            Statement stm = connection.createStatement();
            ResultSet rs = stm.executeQuery(sql);
        }else {
            JOptionPane.showMessageDialog(null, "Connection failed");
        }
    }
}
