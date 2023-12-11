package com.example.networkllassigmentll;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Objects;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 842, 574);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        HelloController load=fxmlLoader.getController();
        load.getmystage(stage);
        scene.getStylesheets().add(Objects.requireNonNull(this.getClass().getResource("CSS/login.css")).toExternalForm());
        stage.show();
        stage.setResizable(false);
    }

    public static void main(String[] args)
    {
        launch();
    }
}