package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import model.User;

public class UserInfoController implements Initializable {

    private User user;
    @FXML
    private Label iconLabel;
    @FXML
    private Label nameLabel;
    @FXML
    private Label dateLabel;
    @FXML
    private Label descLabel;

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
     * Loads user data passed from previous window then updates 
     * label data by calling a method to do so
     *
     * @param newUser new user data
     */
    public void setUser(User newUser){
        this.user = newUser;
        updateLabels();
    }
    
    /**
     * Updates window labels to visualize the corresponding viewer data
     * using the local user variable
     */
    public void updateLabels(){
        iconLabel.setText(String.valueOf(user.getUsername().charAt(0)).toUpperCase());
        nameLabel.setText(user.getUsername());
        dateLabel.setText(user.getBirthDate());
        descLabel.setText(user.getDesc());
    }
}
