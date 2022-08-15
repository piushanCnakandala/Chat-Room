package controller;

import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.Socket;

public class UserFormController {
    public AnchorPane userFormPane;
    public TextField txtSendMessage;

    Socket socket = null;
    public void initialize() throws IOException {
        socket = new Socket("localhost", 5000);

    }

}
