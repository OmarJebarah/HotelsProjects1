package com.example.hotels;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class CustomerPageController {
   public void hotel1Rooms() throws IOException {
       DbConnection.view("Royal.fxml", "Royal");
   }

    public void hotel2Rooms() throws IOException {
        DbConnection.view("Movinpick.fxml", "Movinpick");

    }

    public void hotel3Rooms() throws IOException {
        DbConnection.view("FourSeason.fxml", "Four Season");

    }

}
