package com.example.demo1;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainMenu {

    private final Stage stage;

    public MainMenu(Stage stage) {
        this.stage = stage;
    }

    public void show() {
        // Create the buttons
        Button testButton = new Button("Test");
        Button theoryButton = new Button("Theory");
        Button exitButton = new Button("Exit");
        Label titleLabel = new Label("- FunLearn -");
        Label subtitleLabel = new Label("Learning Platform");
        subtitleLabel.getStyleClass().add("subheading");
        Label footerLabel = new Label("JavaFX Application for learning grammar");
        footerLabel.getStyleClass().add("footer");

        // Set the action for the play button
        testButton.setOnAction(event -> {
            TestsMenu testsMenu = new TestsMenu(stage);
            testsMenu.show();
        });

        theoryButton.setOnAction(actionEvent -> {
            Theory theory = new Theory(stage);
            theory.show();
        });
        // Set the action for the exit button
        exitButton.setOnAction(event -> {
            stage.close();
        });

        // Add the buttons to the layout
        VBox layout = new VBox(20, titleLabel, subtitleLabel, testButton, theoryButton, exitButton, footerLabel);
        layout.setAlignment(Pos.CENTER);

        // Create the scene and show it
        Scene scene = new Scene(layout, 800, 550);
        scene.getStylesheets().add("style.css");
        stage.setScene(scene);
        stage.setTitle("Main Menu");
        stage.show();
    }
}
