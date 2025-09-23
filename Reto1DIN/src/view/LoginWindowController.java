package view;

import controller.Controller;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
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
    private void handleButtonAction(ActionEvent event) {
        User user = null;

        String username = usernameField.getText();
        String password = passwordField.getText();

        Controller cont = new Controller();
        user = cont.loginDB(username, password);

        if (user == null) {
            user = cont.loginFich(username, password);

            if (user == null) {
                System.out.println("No user found.");
            } else {
                System.out.println("File: " + user.toString());
            }
        } else {
            System.out.println("Database: " + user.toString());
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }
}
