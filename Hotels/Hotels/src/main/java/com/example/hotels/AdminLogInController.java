package com.example.hotels;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AdminLogInController {
    @FXML
    private TextField txt_user;

    @FXML
    private TextField txt_password;

    @FXML
    private Button login;


    public void adminPage() throws Exception {
        Connection conn = DbConnection.ConnectDB();
        String sql = "SELECT * FROM users WHERE username=? AND password=? AND type = 'Admin'";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, txt_user.getText());
        ps.setString(2, txt_password.getText());
        ResultSet rs = ps.executeQuery();

        if(!rs.isBeforeFirst()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("User Not Found");
            alert.show();
        }else {
            while(rs.next()){
                login.getScene().getWindow().hide();
                Stage logedin = new Stage();
                Parent root = FXMLLoader.load(getClass().getResource("AdminPage.fxml"));
                Scene scene = new Scene(root);
                logedin.setTitle("Admin Page");
                logedin.setScene(scene);
                logedin.show();
            }
        }

    }



}
