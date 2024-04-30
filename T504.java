import java.util.Random;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class T504 extends Application {
    private int randomNumber;
    private int attempts;

    @Override
    public void start(Stage stage) {
        // Generate a random number between 1 and 100
        Random random = new Random();
        randomNumber = random.nextInt(100) + 1;
        System.out.print(randomNumber);

        // create and configure a text field for user entry
        TextField guessTextField = new TextField();
        guessTextField.setMaxWidth(250);

        // create and configure a label to display the output
        Label resultLabel = new Label();
        resultLabel.setTextFill(Color.RED);
        resultLabel.setFont(Font.font("Arial", 16));

        // create and configure a button to check the guess
        Button checkButton = new Button();
        checkButton.setText("Check Guess");
        checkButton.setOnAction(e -> {
            String guessText = guessTextField.getText();
            if (!guessText.isEmpty()) {
                int guess = Integer.parseInt(guessText);
                if (guess == randomNumber) {
                    resultLabel.setText("Congratulations! You guessed the number in " + (attempts + 1) + " attempts.");
                    checkButton.setDisable(true);
                } else {
                    attempts++;
                    if (guess < randomNumber) {
                        resultLabel.setText("Try a higher number. Attempts: " + attempts);
                    } else {
                        resultLabel.setText("Try a lower number. Attempts: " + attempts);
                    }
                }
            }
        });

        // create and configure a VBox to hold our components
        VBox root = new VBox();
        root.setSpacing(10);
        root.setAlignment(Pos.CENTER);

        // add the components to the VBox
        root.getChildren().addAll(guessTextField, checkButton, resultLabel);

        // create a new scene
        Scene scene = new Scene(root, 350, 150);

        // add the scene to the stage, then configure the stage and make it visible
        stage.setScene(scene);
        stage.setTitle("Number Guessing Game");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}