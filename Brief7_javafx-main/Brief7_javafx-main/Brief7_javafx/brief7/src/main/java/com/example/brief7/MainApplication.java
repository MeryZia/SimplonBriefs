package com.example.brief7;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("hello-view.fxml")));
        stage.setTitle("Registration form");

        Image icon = new Image(getClass().getResourceAsStream("icon.png"));
        stage.getIcons().add(icon);

        stage.setScene(scene);
        stage.show();


    }

    public static void main(String[] args) {

        launch();
    }
}