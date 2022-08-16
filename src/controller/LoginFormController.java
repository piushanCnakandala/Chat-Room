package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


import java.io.IOException;
import java.net.URL;

public class LoginFormController {
    public AnchorPane loginformPane;
    public JFXTextField txtUserName;
    public JFXButton btnLogin;

    public String userName;

    public void loginOnAction(ActionEvent actionEvent) throws IOException {
        userName = txtUserName.getText().isEmpty() ? "Unknown" : txtUserName.getText();
        Data.userName = userName;
        System.out.println(Data.userName);
        URL resource = getClass().getResource("../view/UserForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage stage = new Stage();
        Scene scene = new Scene(load);
        stage.setScene(scene);
       stage.show();

        loginformPane.getScene().getWindow().hide();
    }
}
