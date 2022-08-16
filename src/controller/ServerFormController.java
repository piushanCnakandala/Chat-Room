package controller;

import javafx.fxml.Initializable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ServerFormController implements Initializable {
    ServerSocket serverSocket;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
         new Thread(()->{
             try{
                 serverSocket = new ServerSocket(5000);
                 System.out.println("Server Started!");
                 Socket accept=serverSocket.accept();
                 System.out.println("Client connected");

                 InputStreamReader inputStreamReader =  new InputStreamReader(accept.getInputStream());
                 BufferedReader bufferedReader= new BufferedReader(inputStreamReader);
                 String recod =bufferedReader.readLine();
                 System.out.println(recod);

             }catch (Exception e){
                 e.printStackTrace();
             }

         }).start();
    }

}
