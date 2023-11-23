module com.example.comp1008fall2023thursdays2pmgui {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;


    opens com.example.comp1008fall2023thursdays2pmgui to javafx.fxml;
    exports com.example.comp1008fall2023thursdays2pmgui;
}