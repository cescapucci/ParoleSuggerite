module com.example.parolesuggerite {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.parolesuggerite to javafx.fxml;
    exports com.example.parolesuggerite;
}