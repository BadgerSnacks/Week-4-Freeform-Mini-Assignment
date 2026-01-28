package com.badgersnacks.miniassignment;
// My week 4 freeform mini assignment for CS&141

// Look at all the beautiful imports!
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MiniAssignment extends Application {

    @Override
    public void start(Stage stage) {

        //Variables
        int repeatLittle = 3;
        int repeatBig = 5;

        //theses are all the labels
        Label l = new Label("Here is my MiniAssignment that is not so mini!");
        Label output = new Label("This is where the output will go!");
        output.setWrapText(true);
        output.setStyle("-fx-border-color: black;" + "-fx-border-width: 1;" + "-fx-padding: 6;" + "-fx-border-radius: 4;");

        //These are all the input fields
        TextField input = new TextField("Give me a sentence! Any Sentence!");

        //These are all the buttons.
        Button button = new Button("What did I say?.");
        Button button2 = new Button("Count characters.");
        Button button3 = new Button("Is the count even?");
        Button button4 = new Button("Repeat the phrase a little");
        Button button5 = new Button("Repeat the phrase a LOT!");

        //These are the button actions, how the button is to behave when you click on it.
        button.setOnAction(event ->{
            String text = input.getText();
            output.setText("You typed: " + text);
        });

        button2.setOnAction(event -> {
            String text = input.getText();
            output.setText("This sentence has " + countLetters(text) + " letters.");
        });

        button3.setOnAction(event -> {
            String text = input.getText();
            output.setText("The amount of characters is " + evenOdd(text));
        });

        button4.setOnAction(event -> {
            String text = input.getText();
            output.setText(repeat(text, repeatLittle));
        });

        button5.setOnAction(event -> {
            String text = input.getText();
            output.setText(repeat(text, repeatBig));
        });

        //this is where all the output text boxes go
        VBox root = new VBox(10);

        //This is the layout of window and styling.
        root.getChildren().addAll(l, input, button, button2, button3, button4, button5, output);
        root.setStyle("-fx-padding: 20;");

        //This is what actually creates the window
        Scene scene = new Scene(new StackPane(root), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    // Main method that calls the launch function that opens the window be built above.
    public static void main() {
        launch();
    }

    // Function to count the number of characters in a string and return it as a string.
    public static String countLetters(String text) {
        int sum = 0;
        for (int i = 0; i < text.length(); i++){
            sum ++;
        };
        return String.valueOf(sum);
    }

    //A simple if else statement to check if the length of a string is odd or even.
    public static String evenOdd(String text){
        if (text.length() % 2 == 0){
            return "Even";
        } else {
            return "Odd";
        }
    }

    //Method to repeat a string exponentially
    public static String repeat(String text, int num){
        for (int i = 0; i <= num; i++){
            text = text + text;
        }
        return text;
    }
}
