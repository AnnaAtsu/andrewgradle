module org.example.gradleandrew {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires eu.hansolo.tilesfx;
    //requires org.junit.jupiter.api;

    opens org.example.gradleandrew to javafx.fxml;
    exports org.example.gradleandrew;
}