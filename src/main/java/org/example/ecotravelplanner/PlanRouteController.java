package org.example.ecotravelplanner;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.web.WebView;
import javafx.scene.web.WebEngine;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;


public class PlanRouteController {
    @FXML private TextField startingPoint;
    @FXML private TextField destination;
    @FXML private ChoiceBox<String> transportOption;
    @FXML private Label emissionLabel;
    @FXML private Label weatherLabel;
    @FXML private WebView mapView;

    @FXML
    public void initialize() {
        transportOption.getItems().addAll("Bike", "Bus", "Walk", "Train");

        WebEngine webEngine = mapView.getEngine();
        webEngine.load(getClass().getResource("/resources/map.html").toExternalForm());
    }


    @FXML
    protected void handleBuildRoute() {
        // Dummy data for now
        String transport = transportOption.getValue();
        String emissions = transport.equals("Bike") ? "0.2 kg" : "0.8 kg";
        emissionLabel.setText("Carbon Emission: " + emissions);
        weatherLabel.setText("Weather: 72°C, Good");
    }
    public String getWeather(String city) throws IOException {
        String apiKey = "YOUR_API_KEY"; // получи с openweathermap.org
        String url = "https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + apiKey + "&units=metric";
        HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection();
        con.setRequestMethod("GET");
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        JSONObject json = new JSONObject(response.toString());
        return json.getJSONArray("weather").getJSONObject(0).getString("description") + ", " +
                json.getJSONObject("main").getDouble("temp") + "°C";
    }
    public double calculateCO2(double distanceKm, String transportType) {
        switch (transportType) {
            case "Bike": return 0.0;
            case "Walk": return 0.0;
            case "Bus": return distanceKm * 0.1;
            case "Train": return distanceKm * 0.05;
            default: return 0.0;
        }
    }

}
