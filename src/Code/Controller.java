package Code;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

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

public class Controller{

    @FXML // All buttons that switches between scenes
    Button newUserButton, signInButton, productListButton, backButton, addProductButton, addSBtn;

    @FXML
    Label welcomeLbl;

    //Creating new user admin/customer components
    @FXML Button btnCreateUser;
    @FXML TextField firstnameTxf, lastnameTxf, emailTxf, usernameTxf, passwordTxf, cityTxf, countryTxf,
    phoneTxf, streetTxf, useridTxf;
    @FXML RadioButton admin, customer;

    //Sign in scene components
    @FXML TextField usernametxf, passwordtxf;
    @FXML RadioButton customerbutton, adminbutton;
    @FXML Button SignInButton;
    @FXML Label signStatusLbl;




    //Adding products to tableview
    @FXML
    TableView<Product> productsview;
    @FXML TableColumn<Product, Integer> colpid;
    @FXML TableColumn<Product, String> colpname;
    @FXML TableColumn<Product, Integer> colsid;
    @FXML TableColumn<Product, Double> colprice;
    @FXML TableColumn<Product, Integer> colstock;

    public Controller() throws Exception {

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
    // Product List button clicked, when not signed in
    public void productListButtonClicked() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../fxmlFiles/productList.fxml"));
        Stage window = (Stage) productListButton.getScene().getWindow();
        window.setScene(new Scene(root, 601, 400));
    }
    public void adminScene() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../fxmlFiles/productListWhenLogin.fxml"));
        Stage window = (Stage) SignInButton.getScene().getWindow();
        window.setScene(new Scene(root, 601, 400));
    }
    // Customer scene after log in succeeded
    public void customerSceneAfterLogin() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../fxmlFiles/productListWhenCustomerLogin.fxml"));
        Stage window = (Stage) SignInButton.getScene().getWindow();
        window.setScene(new Scene(root, 601, 400));

    }
    //Back to home page
    public void backButtonClicked() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../fxmlFiles/sample.fxml"));
        Stage window = (Stage) backButton.getScene().getWindow();
        window.setScene(new Scene(root, 601, 343));
    }
    public void createUser() throws SQLException, ClassNotFoundException {
        Connection connection = new sqlconnection().connect();
        if (connection != null)
        {
            System.out.println("Connected!");
           if (admin.isSelected() || customer.isSelected()){

               String customerId = useridTxf.getText();
               String firstname = firstnameTxf.getText();
               String lastname = lastnameTxf.getText();
               String email = emailTxf.getText();
               String street = streetTxf.getText();
               String city = cityTxf.getText();
               String country = countryTxf.getText();
               String phone = phoneTxf.getText();
               String username = usernameTxf.getText();
               String password = passwordTxf.getText();
               String userType = null;
               if (admin.isSelected()){
                   userType = "Admin";}
               else if (customer.isSelected())
               {
                   userType = "Customer";
               }
               String query = "insert into Application_3_Onlinestore.dbo.Customer(Customer_Id, Firstname," +
                       "Lastname, Email, Phone, Country, City, Street, Username, Password, Role) " +
                       "values(?,?,?,?,?,?,?,?,?,?,?)";
               PreparedStatement stm = connection.prepareStatement(query);
               //waiting for adding product scene!
               stm.setString(1,customerId );
               stm.setString(2,firstname );
               stm.setString(3, lastname);
               stm.setString(4, email );
               stm.setString(5,phone);
               stm.setString(6,country);
               stm.setString(7,city);
               stm.setString(8,street);
               stm.setString(9,username);
               stm.setString(10,password);
               stm.setString(11, userType);

               stm.executeUpdate();
               JOptionPane.showMessageDialog(null, "New user added successfully");
               firstnameTxf.setText("");
               lastnameTxf.setText("");
               emailTxf.setText("");
               streetTxf.setText("");
               cityTxf.setText("");
               countryTxf.setText("");
               phoneTxf.setText("");
               useridTxf.setText("");
               passwordTxf.setText("");
               admin.setSelected(false);
               customer.setSelected(false);
               stm.close();
           }
           else {
               JOptionPane.showMessageDialog(null, "Please select user type");
           }
        }

    }
    public void signIn() throws SQLException, ClassNotFoundException, IOException {
        Connection connection = new sqlconnection().connect();
        String query = "Select * from Application_3_Onlinestore.dbo.Customer where Role = ? and username = ? and " +
                "password = ?";
        PreparedStatement pst = connection.prepareStatement(query);
        String username = usernametxf.getText();
        String password = passwordtxf.getText();
        String role = null;
        if (adminbutton.isSelected()){
            role = "Admin";
        }
        else if (customerbutton.isSelected())
        {
            role = "Customer";
        }
        pst.setString(1, role);
        pst.setString(2, username);
        pst.setString(3, password);
        ResultSet rs = pst.executeQuery();

        if (rs.next()){
            signStatusLbl.setText("Login succeeded");
            if (role.equals("Admin")){
                adminScene();
            }
            else if (role.equals("Customer")){
                customerSceneAfterLogin();
            }
        }
        else {
            signStatusLbl.setText("Login failed, check username, password and login type!");
            usernametxf.setText("");
            passwordtxf.setText("");
            adminbutton.setSelected(false);
            customerbutton.setSelected(false);
        }
        connection.close();
    }
    public ObservableList<Product> fetchAllProducts() throws SQLException, ClassNotFoundException {
        Connection connection = new sqlconnection().connect();
        ObservableList<Product> list = FXCollections.observableArrayList();

        String query = "Select * from Application_3_Onlinestore.dbo.Products";

        ResultSet rs = connection.createStatement().executeQuery(query);

        while (rs.next()){
           ObservableList<Product> row = FXCollections.observableArrayList();

        }

        return list;
    }

    public void initialize(URL url, ResourceBundle resourceBundle) {
        colpid.setCellValueFactory(new PropertyValueFactory<Product, Integer>("ProductId"));
        colpname.setCellValueFactory(new PropertyValueFactory<Product, String>("ProductName"));
        colsid.setCellValueFactory(new PropertyValueFactory<Product, Integer>("SupplierId"));
        colprice.setCellValueFactory(new PropertyValueFactory<Product, Double>("basePrice"));
        colstock.setCellValueFactory(new PropertyValueFactory<Product, Integer>("unitsInStock"));

        ObservableList<Product> productslist;
        try {
            productslist = fetchAllProducts();
            productsview.setItems(productslist);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
