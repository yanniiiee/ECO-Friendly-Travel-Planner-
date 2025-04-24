package org.example.ecotravelplanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class HelloController {
    @FXML
    protected void handleLogin(ActionEvent event) throws IOException {
        Parent dashboard = FXMLLoader.load(getClass().getResource("planRoute.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(dashboard));
        stage.show();
    }
}