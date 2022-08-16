package controller.server;

import com.jfoenix.controls.JFXTextArea;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

import javax.jnlp.FileContents;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ServerFormController implements Initializable {
    public JFXTextArea txtChatArea;
    ServerSocket serverSocket;
    List<ClientConnection> connectionList = new ArrayList<>();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
         new Thread(()->{
             try{
                 serverSocket = new ServerSocket(5000);
                 System.out.println("Server Started!");
                 while (true) {
                     Socket accept = serverSocket.accept();
                     System.out.println("Connect new");
                     ClientConnection connection = new ClientConnection(accept, this,"user");
                     connectionList.add(connection);

                     Thread thread = new Thread(connection);
                     thread.start();

                 }

             }catch (Exception e){
                 e.printStackTrace();
             }

         }).start();
    }
    public void broadcast(String message) {
        for (ClientConnection clientConnection : this.connectionList) {
            clientConnection.sendMessage(message);
        }
    }

}
