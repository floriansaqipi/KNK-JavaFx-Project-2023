module com.example.knk_project {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.knk_project to javafx.fxml;
    exports com.example.knk_project;
}