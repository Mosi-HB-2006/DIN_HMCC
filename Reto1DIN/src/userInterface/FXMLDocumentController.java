package userInterface;

import controller.Controller;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * @author Jago128
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Label label;
    private String username;
    private String password;

    @FXML
    private void handleButtonAction(ActionEvent event) {
        Controller cont = new Controller();
        cont.loginDB(username, password);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
}
