import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class T505 extends Application {

    @Override
    public void start(Stage primaryStage) {

        TextField num1Field = new TextField();
        TextField num2Field = new TextField();

        Button addButton = new Button("+");
        Button subtractButton = new Button("-");
        Button multiplyButton = new Button("*");
        Button divideButton = new Button("/");

        Label resultLabel = new Label();

        addButton.setOnAction(e -> calculateResult(num1Field, num2Field, resultLabel, "+"));
        subtractButton.setOnAction(e -> calculateResult(num1Field, num2Field, resultLabel, "-"));
        multiplyButton.setOnAction(e -> calculateResult(num1Field, num2Field, resultLabel, "*"));
        divideButton.setOnAction(e -> calculateResult(num1Field, num2Field, resultLabel, "/"));

        VBox root = new VBox(10);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(20));

        root.getChildren().addAll(
                new Label("Enter first number:"), num1Field,
                new Label("Enter second number:"), num2Field,
                addButton, subtractButton, multiplyButton, divideButton,
                resultLabel);

        Scene scene = new Scene(root, 300, 300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Simple Calculator");
        primaryStage.show();
    }

    private void calculateResult(TextField num1Field, TextField num2Field, Label resultLabel, String operation) {
        try {
            double num1 = Double.parseDouble(num1Field.getText());
            double num2 = Double.parseDouble(num2Field.getText());
            double result = 0;

            switch (operation) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    if (num2 != 0) {
                        result = num1 / num2;
                    } else {
                        resultLabel.setText("Cannot divide by zero!");
                        return;
                    }
                    break;
                default:
                    break;
            }

            resultLabel.setText("Result: " + result);
        } catch (NumberFormatException e) {
            resultLabel.setText("Invalid input!");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}