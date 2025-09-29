package view;

import controller.Controller;
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

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }
    
    public void openWindow(String window, Event event, User user) {
        Stage stage = new Stage();
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("UserInfoWindow.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            
            UserInfoController contInfo = new UserInfoController();
            contInfo.setUser(user);
            
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.close();
        } catch (IOException ex) {
            errorText.setText("Error opening data window.");
            ex.printStackTrace();
        }
    }
}
