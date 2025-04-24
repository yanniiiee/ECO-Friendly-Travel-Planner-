module org.example.ecotravelplanner {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.ecotravelplanner to javafx.fxml;
    exports org.example.ecotravelplanner;
}