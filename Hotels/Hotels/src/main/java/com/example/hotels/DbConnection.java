package com.example.hotels;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
    public static Connection ConnectDB() throws Exception {

        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Hotels","root" , "");
        return conn;
    }

    public static void view(String fxmlFile , String title) throws IOException {
        Parent root = null;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloController.class.getResource(fxmlFile));
        root = fxmlLoader.load();
        Scene scene = new Scene(root, 600, 400);
        Stage stage = new Stage();
        stage.setTitle(title);
        stage.setScene(scene);
        stage.show();
    }
}
