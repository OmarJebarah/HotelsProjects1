package com.example.hotels;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ReversationController {
    @FXML
    private TextField txt_username;

    @FXML
    private TextField txt_phone;

    @FXML
    private TextField txt_roomid;

    public void reserve() throws Exception {
        Connection conn = DbConnection.ConnectDB();
        String sql = "UPDATE rooms SET status = 'reserved' WHERE room_id = ?";
        String sql2 = "UPDATE users SET room_id = ? WHERE username=?";
        PreparedStatement ps1 = conn.prepareStatement(sql);
        ps1.setInt(1, Integer.parseInt(txt_roomid.getText()));
        int rows = ps1.executeUpdate();

        PreparedStatement ps2 = conn.prepareStatement(sql2);
        ps2.setInt(1, Integer.parseInt(txt_roomid.getText()));
        ps2.setString(2, txt_username.getText());
        int rows1 = ps2.executeUpdate();

    }
}
