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
    private TableColumn<Product, Integer> colsid;

    @FXML
    private TableColumn<Product, Double> colprice;

    @FXML
    private TableColumn<Product, Integer> colstock;

    @FXML
    private Button backButton, productListButton;

    @FXML
    void backButtonClicked(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../fxmlFiles/sample.fxml"));
        Stage window = (Stage) backButton.getScene().getWindow();
        window.setScene(new Scene(root, 601, 343));
    }

    ObservableList<Product> list = FXCollections.observableArrayList(
      new Product(1, "Diningtable", 102, 10.15, 12),
            new Product(2, "iPhone", 104, 200.15, 24),
            new Product(3, "Mac", 110, 28.00, 14),
            new Product(4, "hp", 102, 300.24, 24),
            new Product(5, "watch", 104, 23.4, 48)
    );

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colpid.setCellValueFactory(new PropertyValueFactory<Product, Integer>("colpid"));
        colpname.setCellValueFactory(new PropertyValueFactory<Product, String>("colpname"));
        colsid.setCellValueFactory(new PropertyValueFactory<Product, Integer>("colsid"));
        colprice.setCellValueFactory(new PropertyValueFactory<Product, Double>("colprice"));
        colstock.setCellValueFactory(new PropertyValueFactory<Product, Integer>("colstock"));

        productsview.setItems(list);
    }
}
