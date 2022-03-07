package com.example.hotels;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;


public class HelloController {
    @FXML
    private Button admin_log;

    @FXML
    private Button customer_log;

    public void adminLogin() throws IOException {
        Parent root = null;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloController.class.getResource("AdminLogIn.fxml"));
        root = fxmlLoader.load();
        Scene scene = new Scene(root, 600, 400);
        Stage stage = new Stage();
        stage.setTitle("Admin Log In");
        stage.setScene(scene);
        stage.show();

    }

    public void customerLogin() throws IOException {
        Parent root = null;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloController.class.getResource("CustomerLogIn.fxml"));
        root = fxmlLoader.load();
        Scene scene = new Scene(root, 600, 400);
        Stage stage = new Stage();
        stage.setTitle("Customer Log In");
        stage.setScene(scene);
        stage.show();

    }

}
