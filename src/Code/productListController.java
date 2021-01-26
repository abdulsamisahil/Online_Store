package Code;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class productListController implements Initializable
{
    @FXML
    private TableView<Product> productsview;

    @FXML
    private TableColumn<Product, Integer> colpid;

    @FXML
    private TableColumn<Product, String> colpname;

    @FXML
    private TableColumn<Product, String> colsname;

    @FXML
    private TableColumn<Product, Double> colbase_price;

    @FXML
    private TableColumn<Product, Integer> colquantity;

    @FXML
    private TableColumn<Product, Integer> colquantitySold;

    @FXML
    private Button backButton, productListButton;

    @FXML
    void backButtonClicked(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../fxmlFiles/sample.fxml"));
        Stage window = (Stage) backButton.getScene().getWindow();
        window.setScene(new Scene(root, 601, 343));
    }

    ObservableList<Product> data;
    public void fetchAllProducts(){
        Connection connection;
        data = FXCollections.observableArrayList();
        try {
            connection = new sqlconnection().connect();
            String sql = "Select * from Application_3_Onlinestore.dbo.Products";
            ResultSet rs = connection.createStatement().executeQuery(sql);

          /*  for (int i = 0; i < rs.getMetaData().getColumnCount(); i++){
                final int j = i;

            }*/

            while (rs.next()){

            }

        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Error when fetching products from table product");
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colpid.setCellValueFactory(new PropertyValueFactory<Product, Integer>("Product_Id"));
        colpname.setCellValueFactory(new PropertyValueFactory<Product, String>("Name"));
        colsname.setCellValueFactory(new PropertyValueFactory<Product, String>("Supplier"));
        colbase_price.setCellValueFactory(new PropertyValueFactory<Product, Double>("Base_Price"));
        colquantity.setCellValueFactory(new PropertyValueFactory<Product, Integer>("Quantity"));
        colquantitySold.setCellValueFactory(new PropertyValueFactory<Product, Integer>("QuantitySold"));

        productsview.setItems(data);
    }
}
