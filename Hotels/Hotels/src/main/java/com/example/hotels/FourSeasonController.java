package com.example.hotels;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class FourSeasonController implements Initializable {
    @FXML
    private TableView<Rooms> table_rooms;

    @FXML
    private TableColumn<Rooms, Integer> col_id;

    @FXML
    private TableColumn<Rooms, Integer> col_number;

    @FXML
    private TableColumn<Rooms, Integer> col_cost;

    @FXML
    private TableColumn<Rooms, String> col_status;

    public static final ObservableList<Rooms> listF = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            DbConnection.ConnectDB();
        } catch (Exception e) {
            e.printStackTrace();
        }

        col_id.setCellValueFactory(new PropertyValueFactory<Rooms, Integer>("id"));
        col_number.setCellValueFactory(new PropertyValueFactory<Rooms, Integer>("roomNumber"));
        col_cost.setCellValueFactory(new PropertyValueFactory<Rooms, Integer>("cost"));
        col_status.setCellValueFactory(new PropertyValueFactory<Rooms, String>("status"));

        try {
            RoyalRoomsList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        table_rooms.setItems(listF);

    }

    public void RoyalRoomsList() throws Exception {
        String sql = "SELECT * FROM rooms WHERE hotel_name='Four Season'";
        PreparedStatement ps = DbConnection.ConnectDB().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            listF.add(new Rooms(Integer.parseInt(rs.getString("room_id")), rs.getInt("room_number"), rs.getInt("cost"), rs.getString("status")));
        }
    }
}
