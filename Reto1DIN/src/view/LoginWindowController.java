package view;

import controller.Controller;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

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
        String username = usernameField.getText();
        String password = passwordField.getText();
        
        Controller cont = new Controller();
        System.out.println(cont.loginDB(username, password).getUsername());
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
}
