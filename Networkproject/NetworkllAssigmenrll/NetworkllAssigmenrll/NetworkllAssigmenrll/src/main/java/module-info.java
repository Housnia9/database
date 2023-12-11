module com.example.networkllassigmenrll {
    requires javafx.controls;
    requires javafx.fxml;
  //  requires com.google.gson;
    requires java.net.http;
    requires json;


    opens com.example.networkllassigmentll to javafx.fxml;
    exports com.example.networkllassigmentll;
}