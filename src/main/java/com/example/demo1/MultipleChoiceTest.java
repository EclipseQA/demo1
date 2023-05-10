package com.example.demo1;

import javafx.geometry.Pos;
import javafx.scene.control.RadioButton;
import javafx.scene.Scene;
import javafx.scene.text.TextAlignment;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class MultipleChoiceTest {

    private Stage stage;
    // Irregular verb sentences with blank fields
    private String[] sentences = {
            "I ___ breakfast this morning.",
            "She ___ her homework last night.",
            "We ___ to the beach on the weekend.",
            "He ___ his ankle playing football.",
            "They ___ the movie last night.",
            "He ___ his phone at the party.",
            "She ___ her car this morning.",
            "They ___ their dog to the vet.",
            "I ___ the letter to the post office.",
            "She ___ a cake for her friend's birthday."
    };

    // Possible options for the blank fields
    private String[][] options = {
            {"ate", "ated", "eat"},
            {"did", "done", "does"},
            {"gone", "wented", "went"},
            {"hurt", "hurten", "hurted"},
            {"watch", "watched", "watches"},
            {"forgotted", "forgot", "forgeted"},
            {"washed", "wash", "washen"},
            {"taked", "take", "took"},
            {"mailed", "mail", "mails"},
            {"baked", "bake", "book"}
    };
    int numCorrect = 0;
    int numIncorrect = 0;

    // Answers to the sentences
    private String[] answers = {"ate", "did", "went", "hurt", "watched"
            , "forgot", "washed", "took", "mailed", "baked"};

    public void show() {
        VBox root = new VBox(20);
        root.setAlignment(Pos.CENTER);

        // Title label
        Label taskLabel = new Label(" Fill in the gap with a verb in its correct form:");
        taskLabel.getStyleClass().add("task-label");
        taskLabel.setTextAlignment(TextAlignment.CENTER);

        // Sentence label
        Label sentenceLabel = new Label();
        sentenceLabel.getStyleClass().add("sentence-label");
        sentenceLabel.setTextAlignment(TextAlignment.CENTER);

        // Radio buttons for options
        ToggleGroup toggleGroup = new ToggleGroup();
        RadioButton option1 = new RadioButton();
        RadioButton option2 = new RadioButton();
        RadioButton option3 = new RadioButton();
        option1.setToggleGroup(toggleGroup);
        option2.setToggleGroup(toggleGroup);
        option3.setToggleGroup(toggleGroup);

        // Check button
        Button checkButton = new Button("Check");
        Button backButton = new Button("Back");
        backButton.getStyleClass().add("grey-button");

        // Add components to the root pane
        root.getChildren().addAll(taskLabel, sentenceLabel, option1, option2, option3, checkButton, backButton);

        // Set the first sentence and options
        setSentenceAndOptions(sentenceLabel, option1, option2, option3, 0);

        // Event handler for back button
        backButton.setOnAction(event -> {
            TestsMenu testsMenu = new TestsMenu(stage);
            testsMenu.show();
        });
// Event handler for check button
        checkButton.setOnAction(event -> {
// Get the selected option
            RadioButton selectedOption = (RadioButton) toggleGroup.getSelectedToggle();
            String selectedAnswer = selectedOption.getText();
// Get the correct answer
            String correctAnswer = answers[getSentenceIndex(sentenceLabel.getText())];
// Check if the answer is correct
            if (selectedAnswer.equals(correctAnswer)) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Result");
                alert.setHeaderText(null);
                alert.setContentText("Correct!");
                alert.showAndWait();
                numCorrect++;
            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Result");
                alert.setHeaderText(null);
                alert.setContentText("Incorrect. The correct answer is " + correctAnswer + ".");
                alert.showAndWait();
                numIncorrect++;
            }
            // Set the next sentence and options or show final results page
            int currentIndex = getSentenceIndex(sentenceLabel.getText());
            if (currentIndex == sentences.length - 1) {
                // Show final results page
                root.getChildren().clear();
                Label finalResultsLabel = new Label("Final Results:");
                finalResultsLabel.setFont(new Font("Arial", 24));
                finalResultsLabel.setTextAlignment(TextAlignment.CENTER);
                Label numCorrectLabel = new Label("Number of correct answers: " + numCorrect);
                numCorrectLabel.setFont(new Font("Arial", 16));
                numCorrectLabel.setTextAlignment(TextAlignment.CENTER);
                Label numIncorrectLabel = new Label("Number of incorrect answers: " + numIncorrect);
                numIncorrectLabel.setFont(new Font("Arial", 16));
                numIncorrectLabel.setTextAlignment(TextAlignment.CENTER);
                Button tryAgainButton = new Button("Try Again");
                tryAgainButton.setOnAction(e -> {
                    // Reset game and start again
                    numCorrect = 0;
                    numIncorrect = 0;
                    root.getChildren().clear();
                    root.getChildren().addAll(taskLabel, sentenceLabel, option1, option2, option3, checkButton, backButton);
                    setSentenceAndOptions(sentenceLabel, option1, option2, option3, 0);
                });
                root.getChildren().addAll(finalResultsLabel, numCorrectLabel, numIncorrectLabel, tryAgainButton);
            } else {
                // Set the next sentence and options
                int nextIndex = (currentIndex + 1) % sentences.length;
                setSentenceAndOptions(sentenceLabel, option1, option2, option3, nextIndex);
            }
        });

        // Create the scene
        Scene scene = new Scene(root, 800, 550);
        scene.getStylesheets().add("style.css");

        // Set the stage properties
        stage.setTitle("MultipleChoice Test");
        stage.setScene(scene);
        stage.show();

    }

    // Helper method to set the sentence and options
    private void setSentenceAndOptions(Label sentenceLabel, RadioButton option1, RadioButton option2, RadioButton option3, int index) {
        // Set the sentence
        String sentence = sentences[index];
        sentenceLabel.setText(sentence);
        // Set the options
        String[] optionArray = options[index];
        option1.setText(optionArray[0]);
        option2.setText(optionArray[1]);
        option3.setText(optionArray[2]);
    }

    // Helper method to get the index of the current sentence
    private int getSentenceIndex(String sentence) {
        for (int i = 0; i < sentences.length; i++) {
            if (sentences[i].equalsIgnoreCase(sentence)) {
                return i;
            }
        }
        return -1;
    }

    public MultipleChoiceTest(Stage stage) {
        this.stage = stage;
    }
}
