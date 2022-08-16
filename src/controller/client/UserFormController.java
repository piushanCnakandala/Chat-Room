package controller.client;

import com.jfoenix.controls.JFXTextArea;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import util.ConnectionUtil;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class UserFormController {
    public AnchorPane userFormPane;
    public TextField txtSendMessage;
    public JFXTextArea txtChatArea;

    Socket socket = null;
    public String userName;
    PrintWriter printWriter;

    public void initialize() throws IOException {

        System.out.println("userName is : " + userName);
        socket = new Socket(ConnectionUtil.host, ConnectionUtil.port);
        txtChatArea.appendText("Connect. \n");
        printWriter = new PrintWriter(socket.getOutputStream());
        TaskReadThread task = new TaskReadThread(socket, this);
        Thread thread = new Thread(task);
        thread.start();
    }

    public void sentOnAction(ActionEvent actionEvent) throws IOException {
        PrintWriter printWriter= new PrintWriter(socket.getOutputStream());
        printWriter.println(userName + " : " + txtSendMessage.getText());
        printWriter.flush();
        txtSendMessage.clear();
    }
}
