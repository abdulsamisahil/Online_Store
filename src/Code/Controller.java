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
    // Adding new product components
    @FXML TextField productidtxf, productnametxf, supplieridtxf, pricetxf, quantitytxf;

    @FXML //Label when product adds
    Label lblStatus, welcomeLbl;

    //Creating new user admin/customer components
    @FXML Button btnCreateUser;
    @FXML TextField firstnameTxf, lastnameTxf, emailTxf, usernameTxf, passwordTxf, cityTxf, countryTxf,
    phoneTxf, addressTxf, useridTxf;
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
    // Add Product button clicked
    public void addProductScene() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../fxmlFiles/addingProduct.fxml"));
        Stage window = (Stage) addProductButton.getScene().getWindow();
        window.setScene(new Scene(root, 601, 400));
    }
    // Add Supplier button clicked
    public void addSupplierButtonClicked() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../fxmlFiles/addSupplier.fxml"));
        Stage window = (Stage) addSBtn.getScene().getWindow();
        window.setScene(new Scene(root, 601, 400));
    }
    //Adding product to the store
    public void addProduct () throws SQLException, ClassNotFoundException {
        Connection connection = connection();
        if (connection != null)
        {
            System.out.println("Connected!");
            String pid = productidtxf.getText();
            String pname = productnametxf.getText();
            String sid = supplieridtxf.getText();
            String price = pricetxf.getText();
            String quantity = quantitytxf.getText();
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
            stm.close();
        }
    }
    public void createUser() throws SQLException, ClassNotFoundException {
        Connection connection = connection();
        if (connection != null)
        {
            System.out.println("Connected!");
           if (admin.isSelected() || customer.isSelected()){

               String userid = useridTxf.getText();
               String firstname = firstnameTxf.getText();
               String lastname = lastnameTxf.getText();
               String email = emailTxf.getText();
               String address = addressTxf.getText();
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
               String query = "insert into online_store.dbo.app_user(userId, Firstname," +
                       "Lastname, Email, Address, City, Country, Phone, Role, username, password) " +
                       "values(?,?,?,?,?,?,?,?,?,?,?)";
               PreparedStatement stm = connection.prepareStatement(query);
               //waiting for adding product scene!
               stm.setString(1,userid );
               stm.setString(2,firstname );
               stm.setString(3, lastname);
               stm.setString(4, email );
               stm.setString(5,address);
               stm.setString(6,city);
               stm.setString(7,country);
               stm.setString(8,phone);
               stm.setString(9,userType);
               stm.setString(10,username);
               stm.setString(11, password);

               stm.executeUpdate();
               JOptionPane.showMessageDialog(null, "New user added successfully");
               firstnameTxf.setText("");
               lastnameTxf.setText("");
               emailTxf.setText("");
               addressTxf.setText("");
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
    public Connection connection() throws ClassNotFoundException, SQLException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String user = "onlinestore";
        String password = "Inshallah123";

        String dbURL = "jdbc:sqlserver://localhost";

        Connection connection = DriverManager.getConnection(dbURL, user, password);
        if (connection != null)
        {
            System.out.println("Connected!");
            return connection;

        }
        return null;
    }
    public void signIn() throws SQLException, ClassNotFoundException, IOException {
        Connection connection = connection();
        String query = "Select * from online_store.dbo.app_user where Role = ? and username = ? and " +
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
        Connection connection = connection();
        ObservableList<Product> list = FXCollections.observableArrayList();

        String query = "Select * from online_store.dbo.Product";
        PreparedStatement pst = connection.prepareStatement(query);
        ResultSet rs = pst.executeQuery();
        while (rs.next()){
            list.add(new Product(Integer.parseInt(rs.getString("ProductId")), rs.getString("ProductName"),
                    Integer.parseInt(rs.getString("SupplierId")),
                    Double.parseDouble(rs.getString("basePrice")), Integer.parseInt(rs.getString("unitsInStock"))));
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
    //Adding new supplier components
    @FXML TextField supplierid, supcompanyname, supphone, supaddress;
    @FXML Button btnAddSupplier;
    public void addSupplier() throws SQLException, ClassNotFoundException, InterruptedException {
        Connection connection = connection();
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
}
