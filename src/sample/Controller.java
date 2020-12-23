package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
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
    Button newUserButton, signInButton, productListButton;
    //New User Button Clicked
    public void newUserButtonClicked() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("newUser.fxml"));
        Stage window = (Stage) newUserButton.getScene().getWindow();
        window.setScene(new Scene(root, 601, 400));
    }
    // Sign in button clicked
    public void setSignInButtonClicked()
    {
        
    }
    // Product List button clicked
    public void productListButtonClicked()
    {

    }
}
