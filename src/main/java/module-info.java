module com.example.firstproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires javafx.graphics;
    requires java.sql;


    opens com.example.firstproject to javafx.fxml;
    opens com.example.firstproject.launch to javafx.fxml;
    exports com.example.firstproject.controllers;
    opens com.example.firstproject.controllers to javafx.fxml;
}