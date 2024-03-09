module org.example.plophci {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.plophci to javafx.fxml;
    exports org.example.plophci;
}