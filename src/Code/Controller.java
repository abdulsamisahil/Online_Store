package Code;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author Abdul Sami Sahil
 * Online Store Application
 * Course: R+DBMS Datase Technology
 * Malmo University
 * @since 2020-12-22
 *
 *
 * This class handles the logic behind the app and switches between the different scenes.
 */

public class Controller {

    @FXML
    Button newUserButton, signInButton, productListButton, backButton, addProductButton;
    @FXML TextField productidtxf, productnametxf, supplieridtxf, pricetxf, quantitytxf;
    @FXML
    Label lblStatus;

    public Controller() throws SQLException, ClassNotFoundException
    {


    }

    //New User Button Clicked
    public void newUserButtonClicked() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../fxmlFiles/newUser.fxml"));
        Stage window = (Stage) newUserButton.getScene().getWindow();
        window.setScene(new Scene(root, 601, 400));
    }
    // Sign in button clicked
    public void signInButtonClicked() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../fxmlFiles/signIn.fxml"));
        Stage window = (Stage) signInButton.getScene().getWindow();
        window.setScene(new Scene(root, 601, 400));
    }
    // Product List button clicked
    public void productListButtonClicked() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../fxmlFiles/productList.fxml"));
        Stage window = (Stage) productListButton.getScene().getWindow();
        window.setScene(new Scene(root, 601, 400));
    }
    //Back to home page
    public void backButtonClicked() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../fxmlFiles/sample.fxml"));
        Stage window = (Stage) backButton.getScene().getWindow();
        window.setScene(new Scene(root, 601, 343));
    }
    //Adding new user
    public void createButtonClicked() throws SQLException, ClassNotFoundException {

    }
    // Add Product button clicked
    public void addProductScene() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../fxmlFiles/addingProduct.fxml"));
        Stage window = (Stage) addProductButton.getScene().getWindow();
        window.setScene(new Scene(root, 601, 400));
    }
    //Adding product to the store
    public void addProduct () throws SQLException, ClassNotFoundException {
        String pid = productidtxf.getText();
        String pname = productnametxf.getText();
        String sid = supplieridtxf.getText();
        String price = pricetxf.getText();
        String quantity = quantitytxf.getText();

        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String user = "onlinestore";
        String password = "Inshallah123";

        String dbURL = "jdbc:sqlserver://localhost";

        Connection connection = DriverManager.getConnection(dbURL, user, password);
        if (connection != null)
        {
            System.out.println("Connected!");

        }
        String query = "insert into online_store.dbo.Product(ProductId, ProductName," +
                "SupplierId, basePrice, unitsInStock) values(?,?,?,?,?)";
        PreparedStatement stm = connection.prepareStatement(query);
        //waiting for adding product scene!
        stm.setString(1,pid );
        stm.setString(2,pname );
        stm.setString(3,sid);
        stm.setString(4,price );
        stm.setString(5,quantity);

        stm.executeUpdate();
        lblStatus.setText("Product added successfully");
        productidtxf.setText("");
        productnametxf.setText("");
        supplieridtxf.setText("");
        pricetxf.setText("");
        quantitytxf.setText("");
    }
}
