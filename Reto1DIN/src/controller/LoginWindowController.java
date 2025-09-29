package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.User;

/**
 * @author Jago128
 */
public class LoginWindowController implements Initializable {

    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Label errorText;

    /**
     * When button is clicked, form data is extracted and verified in the
     * database and in the files
     *
     * @param event which is triggered by pressing the login button
     */
    @FXML
    private void handleButtonAction(ActionEvent event) {
        User user = null;

        String username = usernameField.getText();
        String password = passwordField.getText();

        Controller cont = new Controller();
        user = cont.loginDB(username, password);

        if (user == null) {
            user = cont.loginFich(username, password);

            if (user == null) {
                errorText.setText("No user found.");
            } else {
                openWindow("UserInfoWindow", event, user);
            }
        } else {
            openWindow("UserInfoWindow", event, user);
        }
    }

    /**
     * Initializes the controller class. Called automatically after the FXML
     * file has been loaded.
     *
     * @param url location used to resolve relative paths
     * @param rb resources used to localize the root object
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    /**
     * Opens a new window with the given FXML file and passes the user information to it. 
     * Closes the current window after the new one is displayed
     *
     * @param window the name of the window to open 
     * @param event the event that triggered the window change 
     * @param user the user data to be passed to the next controller
     */
    public void openWindow(String window, Event event, User user) {
        Stage stage = new Stage();
        Parent root;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/UserInfoWindow.fxml"));
            root = loader.load();

            UserInfoController contInfo = loader.getController();
            contInfo.setUser(user);

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.close();
        } catch (IOException ex) {
            errorText.setText("Error opening data window.");
            ex.printStackTrace();
        }
    }
}
