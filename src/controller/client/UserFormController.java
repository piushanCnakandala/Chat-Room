package controller.client;

import com.jfoenix.controls.JFXTextArea;
import controller.Data;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import util.ConnectionUtil;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class UserFormController {
    public AnchorPane userFormPane;
    public TextField txtSendMessage;
    public JFXTextArea txtChatArea;
    public Pane paneEmoji;

    Socket socket = null;
    public String userName;
    PrintWriter printWriter;

    public void initialize() throws IOException {
        paneEmoji.setVisible(false);
        System.out.println("userName is : " + Data.userName);
        socket = new Socket(ConnectionUtil.host, ConnectionUtil.port);
        txtChatArea.appendText("Connect. \n");
        printWriter = new PrintWriter(socket.getOutputStream());
        TaskReadThread task = new TaskReadThread(socket, this);
        Thread thread = new Thread(task);
        thread.start();
    }

    public void sentOnAction(ActionEvent actionEvent) throws IOException {
        PrintWriter printWriter= new PrintWriter(socket.getOutputStream());
        printWriter.println(Data.userName + " : " + txtSendMessage.getText());
        printWriter.flush();
        txtSendMessage.clear();
    }


    public void onMouseClickEmojiBar(MouseEvent mouseEvent) {
        if (!paneEmoji.isVisible()) {
            paneEmoji.setVisible(true);
        } else {
            paneEmoji.setVisible(false);
        }
    }

    public void onMouseClickEmojiGrinningFace(MouseEvent mouseEvent) {
        txtSendMessage.appendText("\uD83D\uDE00");
    }

    public void onMouseClickEmojiRedHeart(MouseEvent mouseEvent) {
        txtSendMessage.appendText("❤");
    }

    public void onMouseClickEmojiSmilingFacewithHeartEyes(MouseEvent mouseEvent) {
        txtSendMessage.appendText("\uD83D\uDE0D");
    }

    public void onMouseClickEmojiFacewithTearsofJoy(MouseEvent mouseEvent) {
        txtSendMessage.appendText("\uD83D\uDE02");
    }

    public void onMouseClickEmojiSad(MouseEvent mouseEvent) {
        txtSendMessage.appendText("\uD83D\uDE25");
    }

    public void onMouseClickEmojiWorry(MouseEvent mouseEvent) {
        txtSendMessage.appendText("\uD83D\uDE14");
    }

    public void onMouseClickEmojiWow(MouseEvent mouseEvent) {
        txtSendMessage.appendText("\uD83D\uDE2E");
    }
}
