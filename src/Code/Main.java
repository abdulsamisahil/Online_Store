package Code;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.SQLException;

/**
 * @author Abdul Sami Sahil
 * Online Store Application
 * Course: R+DBMS Datase Technology
 * Malmo University
 * @since 2020-12-22
 *
 *
 * The main class of javafx
 */
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        Parent root = FXMLLoader.load(getClass().getResource("../fxmlFiles/sample.fxml"));
        primaryStage.setTitle("Online Store");
        primaryStage.setScene(new Scene(root, 601, 343));
        primaryStage.show();
    }
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        //SQLConnection sql = new SQLConnection();
        try {
            launch(args);
        }catch (Exception e ){

        }
    }
}
