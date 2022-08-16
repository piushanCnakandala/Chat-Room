package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


import java.io.IOException;

public class LoginFormController {
    public AnchorPane loginformPane;
    public JFXTextField txtUserName;
    public JFXButton btnLogin;

    public String userName;

    public void loginOnAction(ActionEvent actionEvent) throws IOException {
        userName = txtUserName.getText().isEmpty() ? "Unknown" : txtUserName.getText();
        Data.userName = userName;
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../view/UserForm.fxml"));
        Scene scene = new Scene(root);

    }
}
