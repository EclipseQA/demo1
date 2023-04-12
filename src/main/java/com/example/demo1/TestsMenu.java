package com.example.demo1;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TestsMenu {

    private Stage stage;

    public void show() {
        Button multipleChoiceTestButton = new Button("Sentence practice");
        Button completionTestButton = new Button("Table practice");
        Button backButton = new Button("Back");

        // Set the action for the play button
        multipleChoiceTestButton.setOnAction(event -> {
            // Create the TicTacToeGame and show it
            MultipleChoiceTest multipleChoiceTest = new MultipleChoiceTest(stage);
            multipleChoiceTest.show();
        });

        // Set the action for the exit button
        completionTestButton.setOnAction(event -> {
            CompletionTest completionTest = new CompletionTest(stage);
            completionTest.show();
        });

        backButton.setOnAction(actionEvent -> {
            MainMenu mainMenu = new MainMenu(stage);
            mainMenu.show();
        });

        // Add the buttons to the layout
        VBox layout = new VBox(20, multipleChoiceTestButton, completionTestButton, backButton);
        layout.setAlignment(Pos.CENTER);

        // Create the scene and show it
        Scene scene = new Scene(layout, 400, 400);
        stage.setScene(scene);
        stage.setTitle("Tests Menu");
        stage.show();
    }

    public TestsMenu(Stage stage) {
        this.stage = stage;
    }
}
