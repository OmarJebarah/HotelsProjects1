package com.example.hotels;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class HotelsController implements Initializable {
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

    @FXML
    private TextField txt_name;

    @FXML
    private TextField txt_address;

    @FXML
    private TextField txt_evaluation;

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

    public void addhotels() throws Exception {
        DbConnection.ConnectDB();
        String sql = "insert into myHotels (hotel_name , hotel_address , hotel_evaluation) values (? , ? , ?)";
        PreparedStatement ps =DbConnection.ConnectDB().prepareStatement(sql);
        ps.setString(1, txt_name.getText());
        ps.setString(2, txt_address.getText());
        ps.setString(3, txt_evaluation.getText());
        int insert = ps.executeUpdate();

        if(insert != 1){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("New Hotel Inserted");
            alert.show();
        }

    }

    public void edithotel() throws Exception {
        DbConnection.ConnectDB();
        String sql = "UPDATE myhotels SET hotel_name = ? , hotel_address = ? , hotel_evaluation = ? WHERE hotel_name = ?";
        PreparedStatement ps =DbConnection.ConnectDB().prepareStatement(sql);
        ps.setString(1, txt_name.getText());
        ps.setString(2, txt_address.getText());
        ps.setString(3, txt_evaluation.getText());
        int update = ps.executeUpdate();
        if(update != 1){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText(txt_name + " Updated");
            alert.show();
        }

    }

    public void deletehotel() throws Exception {
        DbConnection.ConnectDB();
        String sql = "DELETE FROM myhotels WHERE hotel_name = ?";
        PreparedStatement ps =DbConnection.ConnectDB().prepareStatement(sql);
        ps.setString(1, txt_name.getText());
        ps.setString(2, txt_address.getText());
        ps.setString(3, txt_evaluation.getText());
        int delete = ps.executeUpdate();
        if(delete != 1){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText(txt_name + " deleted");
            alert.show();
        }

    }
}
