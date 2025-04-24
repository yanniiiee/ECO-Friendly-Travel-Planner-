package org.example.ecotravelplanner;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class PlanRouteController {
    @FXML private TextField startingPoint;
    @FXML private TextField destination;
    @FXML private ChoiceBox<String> transportOption;
    @FXML private Label emissionLabel;
    @FXML private Label weatherLabel;

    @FXML
    public void initialize() {
        transportOption.getItems().addAll("Bike", "Bus", "Walk", "Train");
    }

    @FXML
    protected void handleBuildRoute() {
        // Dummy data for now
        String transport = transportOption.getValue();
        String emissions = transport.equals("Bike") ? "0.2 kg" : "0.8 kg";
        emissionLabel.setText("Carbon Emission: " + emissions);
        weatherLabel.setText("Weather: 72°C, Good");
    }
}
