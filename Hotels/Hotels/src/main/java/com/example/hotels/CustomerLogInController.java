package com.example.hotels;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CustomerLogInController {
    @FXML
    private TextField txt_user;

    @FXML
    private TextField txt_password;

    @FXML
    private Button login;

    public void customerPage() throws Exception {
        Connection conn = DbConnection.ConnectDB();
        String sql = "SELECT * FROM users WHERE username=? AND password=? AND type = 'Customer'";
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
                Stage logedin = new Stage();
                Parent root = FXMLLoader.load(getClass().getResource("CustomerPage.fxml"));
                Scene scene = new Scene(root);
                logedin.setTitle("Customer Page");
                logedin.setScene(scene);
                logedin.show();
            }
        }

    }

    public void signUp() throws IOException {
        DbConnection.view("SignUp.fxml", "Sign Up");
    }
}
