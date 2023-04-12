package com.example.demo1;


import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;


public class CompletionTest {

    private Stage stage;
    private String[] irregularVerbs = {"be", "begin", "break", "bring", "build", "buy", "catch", "choose", "come",
            "cost", "cut", "do", "draw", "drink", "drive", "eat", "fall", "feel", "find", "fly", "forget",
            "get", "give", "go", "grow", "have", "hear", "hide", "hit", "hold", "keep", "know", "leave",
            "let", "lie", "lose", "make", "mean", "meet", "pay", "put", "read", "ride", "ring", "rise",
            "run", "say", "see", "sell", "send", "set", "shine", "shoot", "show", "sing", "sink", "sit",
            "sleep", "speak", "spend", "stand", "swim", "take", "teach", "tear", "tell", "think", "throw",
            "understand", "wake", "wear", "win", "write"};

    private int currentIndex = 0;

    private Label verbLabel;
    private TextField pastTenseField;
    private TextField pastParticipleField;
    private Button nextButton;
    private Button checkButton;
    private Button backButton;

    public void show() {
        // Create UI components
        verbLabel = new Label();
        pastTenseField = new TextField();
        pastParticipleField = new TextField();
        nextButton = new Button("Next");
        checkButton = new Button("Check");
        backButton = new Button("Back");

        // Set up event handling for the Next button
        nextButton.setOnAction(e -> nextVerb());

        // Set up event handling for the Check button
        checkButton.setOnAction(e -> checkAnswer());

        // Set up event handling for the Check button
        backButton.setOnAction(e -> goBack());

        // Set up the layout
        GridPane layout = new GridPane();
        layout.setAlignment(Pos.CENTER);
        layout.setHgap(10);
        layout.setVgap(10);
        layout.setPadding(new Insets(25, 25, 25, 25));
        layout.add(new Label("Irregular Verb:"), 0, 0);
        layout.add(verbLabel, 1, 0);
        layout.add(new Label("Past Tense:"), 0, 1);
        layout.add(pastTenseField, 1, 1);
        layout.add(new Label("Past Participle:"), 0, 2);
        layout.add(pastParticipleField, 1, 2);
        VBox buttonBox = new VBox(10);
        buttonBox.setAlignment(Pos.CENTER_RIGHT);
        buttonBox.getChildren().addAll(checkButton, nextButton, backButton);
        layout.add(buttonBox, 1, 3);

        // Set up the scene and show the window
        Scene scene = new Scene(layout, 400, 250);
        stage.setScene(scene);
        stage.setTitle("Completion Test");
        stage.show();

        // Start with the first verb
        nextVerb();
    }

    private void nextVerb() {
        // Update the UI with the next verb
        String verb = irregularVerbs[currentIndex];
        verbLabel.setText(verb);
        pastTenseField.setText("");
        pastParticipleField.setText("");
        currentIndex = (currentIndex + 1) % irregularVerbs.length;
    }

    private void checkAnswer() {
        // Get the user's answers
        String pastTense = pastTenseField.getText().trim();
        String pastParticiple = pastParticipleField.getText().trim();

        // Get the correct answers
        String verb = irregularVerbs[(currentIndex - 1 + irregularVerbs.length) % irregularVerbs.length];
        String pastTenseCorrect = getPastTense(verb);
        String pastParticipleCorrect = getPastParticiple(verb);

        // Check the answers
        boolean pastTenseCorrectFlag = pastTense.equalsIgnoreCase(pastTenseCorrect);
        boolean pastParticipleCorrectFlag = pastParticiple.equalsIgnoreCase(pastParticipleCorrect);

        // Show the result
        String message = "Past Tense: " + (pastTenseCorrectFlag ? "Correct" : "Incorrect")
                + "\nPast Participle: " + (pastParticipleCorrectFlag ? "Correct" : "Incorrect");
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Result");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private String getPastTense(String verb) {
        return switch (verb) {
            case "be" -> "was/were";
            case "begin" -> "began";
            case "break" -> "broke";
            case "bring" -> "brought";
            case "build" -> "built";
            case "buy" -> "bought";
            case "catch" -> "caught";
            case "choose" -> "chose";
            case "come" -> "came";
            case "cost" -> "cost";
            case "cut" -> "cut";
            case "do" -> "did";
            case "draw" -> "drew";
            case "drink" -> "drank";
            case "drive" -> "drove";
            case "eat" -> "ate";
            case "fall" -> "fell";
            case "feel" -> "felt";
            case "find" -> "found";
            case "fly" -> "flew";
            case "forget" -> "forgot";
            case "get" -> "got";
            case "give" -> "gave";
            case "go" -> "went";
            case "grow" -> "grew";
            case "have" -> "had";
            case "hear" -> "heard";
            case "hide" -> "hid";
            case "hit" -> "hit";
            case "hold" -> "held";
            case "keep" -> "kept";
            case "know" -> "knew";
            case "leave" -> "left";
            case "let" -> "let";
            case "lie" -> "lay";
            case "lose" -> "lost";
            case "make" -> "made";
            case "mean" -> "meant";
            case "meet" -> "met";
            case "pay" -> "paid";
            case "put" -> "put";
            case "read" -> "read";
            case "ride" -> "rode";
            case "ring" -> "rang";
            case "rise" -> "rose";
            case "run" -> "ran";
            case "say" -> "said";
            case "see" -> "saw";
            case "sell" -> "sold";
            case "send" -> "sent";
            case "set" -> "set";
            case "shine" -> "shone";
            case "shoot" -> "shot";
            case "show" -> "showed";
            case "sing" -> "sang";
            case "sink" -> "sank";
            case "sit" -> "sat";
            case "sleep" -> "slept";
            case "speak" -> "spoke";
            case "spend" -> "spent";
            case "stand" -> "stood";
            case "swim" -> "swam";
            case "take" -> "took";
            case "teach" -> "taught";
            case "tear" -> "tore";
            case "tell" -> "told";
            case "think" -> "thought";
            case "throw" -> "threw";
            case "understand" -> "understood";
            case "wake" -> "woke";
            case "wear" -> "wore";
            case "win" -> "won";
            case "write" -> "wrote";
            default -> verb + "ed";
        };
    }

    private String getPastParticiple(String verb) {
        return switch (verb) {
            case "be" -> "been";
            case "begin" -> "begun";
            case "break" -> "broken";
            case "bring" -> "brought";
            case "build" -> "built";
            case "buy" -> "bought";
            case "catch" -> "caught";
            case "choose" -> "chosen";
            case "come" -> "come";
            case "cost" -> "cost";
            case "cut" -> "cut";
            case "do" -> "done";
            case "draw" -> "drawn";
            case "drink" -> "drunk";
            case "drive" -> "driven";
            case "eat" -> "eaten";
            case "fall" -> "fallen";
            case "feel" -> "felt";
            case "find" -> "found";
            case "fly" -> "flown";
            case "forget" -> "forgotten";
            case "get" -> "got";
            case "give" -> "given";
            case "go" -> "gone";
            case "grow" -> "grown";
            case "have" -> "had";
            case "hear" -> "heard";
            case "hide" -> "hidden";
            case "hit" -> "hit";
            case "hold" -> "held";
            case "keep" -> "kept";
            case "know" -> "known";
            case "leave" -> "left";
            case "let" -> "let";
            case "lie" -> "lain";
            case "lose" -> "lost";
            case "make" -> "made";
            case "mean" -> "meant";
            case "meet" -> "met";
            case "pay" -> "paid";
            case "put" -> "put";
            case "read" -> "read";
            case "ride" -> "ridden";
            case "ring" -> "rung";
            case "rise" -> "risen";
            case "run" -> "run";
            case "say" -> "said";
            case "see" -> "seen";
            case "sell" -> "sold";
            case "send" -> "sent";
            case "set" -> "set";
            case "shine" -> "shone";
            case "shoot" -> "shot";
            case "show" -> "shown";
            case "sing" -> "sung";
            case "sink" -> "sunk";
            case "sit" -> "sat";
            case "sleep" -> "slept";
            case "speak" -> "spoken";
            case "spend" -> "spent";
            case "stand" -> "stood";
            case "swim" -> "swum";
            case "take" -> "taken";
            case "teach" -> "taught";
            case "tear" -> "torn";
            case "tell" -> "told";
            case "think" -> "thought";
            case "throw" -> "thrown";
            case "understand" -> "understood";
            case "wake" -> "woken";
            case "wear" -> "worn";
            case "win" -> "won";
            case "write" -> "written";
            default -> verb + "ed";
        };
    }

    private void goBack() {
        TestsMenu testsMenu = new TestsMenu(stage);
        testsMenu.show();
    }

    public CompletionTest(Stage stage) {
        this.stage = stage;
    }
}
