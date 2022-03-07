package com.example.hotels;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.sql.PreparedStatement;

public class SignUpController {
    @FXML
    private TextField txt_name;

    @FXML
    private TextField txt_password;

    @FXML
    private TextField txt_phone;

    @FXML
    private TextField txt_type;

    public void addUser() throws Exception {
        DbConnection.ConnectDB();
        String sql = "insert into users (username , password , phone, type) values (? , ? , ? , Customer)";
        PreparedStatement ps = DbConnection.ConnectDB().prepareStatement(sql);
        ps.setString(1, txt_name.getText());
        ps.setString(2, txt_password.getText());
        ps.setString(3, txt_phone.getText());


        int insert = ps.executeUpdate();

        if(insert != 1){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("successfully registered");
            alert.show();
        }

    }

}
