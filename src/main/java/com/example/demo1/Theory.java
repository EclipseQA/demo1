package com.example.demo1;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Theory {

    private Stage stage;
    private Scene scene;
    private BorderPane root;

    public void show() {
        // Load the image
        Image image = new Image("theory.png");

        // Create the ImageView and set its properties
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(800);
        imageView.setFitHeight(10099);
        imageView.setPreserveRatio(true);
        imageView.setSmooth(true);
        imageView.setCache(true);

        // Create the ScrollPane and set its properties
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(imageView);
        scrollPane.setFitToWidth(true);
        scrollPane.setFitToHeight(true);

        // Set up the Back button
        Button backButton = new Button("Back");
        backButton.getStyleClass().add("theory-back-button");
        backButton.setOnAction(e -> goBack());
        HBox topPane = new HBox(backButton);
        topPane.setAlignment(Pos.CENTER_LEFT);

        // Create the BorderPane and set the ScrollPane as its center
        BorderPane root = new BorderPane();
        root.setCenter(scrollPane);
        root.setTop(topPane);

        // Create the Scene and set the BorderPane as its root
        Scene scene = new Scene(root, 800, 550);
        scene.getStylesheets().add("style.css");

        // Set the Stage properties and show it
        stage.setScene(scene);
        stage.setTitle("Theory");
        stage.show();
    }

    private void goBack() {
        MainMenu mainMenu = new MainMenu(stage);
        mainMenu.show();
    }

    public Theory(Stage stage) {
        this.stage = stage;
    }
}