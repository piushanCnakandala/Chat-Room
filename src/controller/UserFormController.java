package controller;

import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class UserFormController {
    public AnchorPane userFormPane;
    public TextField txtSendMessage;

    Socket socket = null;
    public void initialize() throws IOException {
        socket = new Socket("localhost", 5000);

    }

    public void sentOnAction(ActionEvent actionEvent) throws IOException {
        PrintWriter printWriter= new PrintWriter(socket.getOutputStream());
        printWriter.println(txtSendMessage.getText());
        printWriter.flush();
        txtSendMessage.clear();
    }
}
