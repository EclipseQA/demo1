package com.example.demo1;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create the main menu and show it
        MainMenu mainMenu = new MainMenu(primaryStage);
        mainMenu.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
