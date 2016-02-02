package com.company.chapter5;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class JavaFxHelloWorld extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Label message = new Label("Hello World");
        message.setFont(new Font(50));

        primaryStage.setScene(new Scene((message)));
        primaryStage.setTitle("Hello");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
