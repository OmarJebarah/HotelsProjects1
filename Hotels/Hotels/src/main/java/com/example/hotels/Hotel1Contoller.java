package com.example.hotels;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class Hotel1Contoller implements Initializable {
    @FXML
    private TableView<Hotels> table_hotels;

    @FXML
    private TableColumn<Hotels, Integer> col_id;

    @FXML
    private TableColumn<Hotels, String> col_name;

    @FXML
    private TableColumn<Hotels, String> col_address;

    @FXML
    private TableColumn<Hotels, String> col_evaluation;

    public static final ObservableList<Hotels> listH = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        col_id.setCellValueFactory(new PropertyValueFactory<Hotels, Integer>("hotel_id"));
        col_name.setCellValueFactory(new PropertyValueFactory<Hotels, String>("name"));
        col_address.setCellValueFactory(new PropertyValueFactory<Hotels, String>("address"));
        col_evaluation.setCellValueFactory(new PropertyValueFactory<Hotels, String>("evaluation"));

        try {
            hotelsList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        table_hotels.setItems(listH);

    }

    public void hotelsList() throws Exception {
        String sql = "SELECT * FROM myHotels";
        PreparedStatement ps = DbConnection.ConnectDB().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            listH.add(new Hotels(Integer.parseInt(rs.getString("hotel_id")), rs.getString("hotel_name"), rs.getString("hotel_address"), rs.getString("hotel_evaluation")));
        }

    }
}
