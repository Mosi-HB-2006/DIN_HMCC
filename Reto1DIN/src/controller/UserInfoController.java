package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
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

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    
    public void setUser(User newUser){
        this.user = newUser;
        updateLabels();
    }
    
    public void updateLabels(){
        iconLabel.setText(String.valueOf(user.getUsername().charAt(0)).toUpperCase());
        nameLabel.setText(user.getUsername());
        dateLabel.setText(user.getBirthDate());
        descLabel.setText(user.getDesc());
    }
}
