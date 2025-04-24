package org.example.ecotravelplanner;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.Label;

public class DashboardController {
    @FXML private ListView<String> tripList;
    @FXML private Label achievement1;
    @FXML private Label achievement2;

    @FXML
    public void initialize() {
        tripList.getItems().addAll(
                "April 15 - Bus to Downtown",
                "April 10 - Walk to Central Park",
                "April 10 - 5 Miles Walked"
        );
        achievement1.setText("5 Miles Walked");
        achievement2.setText("Used bike 5 times this week");
    }
}