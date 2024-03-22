package javafx;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;

/*
 *  The goal of this is to make it look like an old website
 *  Something I would have seen as a kid, at least the style of it
 */

public class TwoOperandCalculator extends Application {
	// Data members (would be better in a text file but eh
	private final Label lblTitle = new Label("Two Operand Calculator");
	private Label lblInfo = new Label(
			" Thank you for\n using the " + "Two\n Operand Calculator.\n We know this is\n obviously\n the "
					+ "application\n you want to use.\n\n A special\n Thank you to\n our sponser:\n"
					+ " \"Reson To\n Leave Your Man\".\n A New York\n Times Best\n Selling Pamphlet.\n"
					+ " Buy it on\n Amazon Today.");
	private Label lblNumber1 = new Label("Enter first number:");
	private Label lblNumber2 = new Label("Enter second number:");
	private Label lblInstruction = new Label("Click an operand below to\n\tcalculate");
	private Label lblcopyrightInfo = new Label("Copyright (c) 2024, Seraphina Morrison. All rights reserved");
	private Label lblCatPic = new Label(
			"Here is a picture \nof a cat. \nThere is no \nreason for this. \nShe is just cute. ");
	private TextField tfNumber1 = new TextField();
	private TextField tfNumber2 = new TextField();
	private TextField tfCalculation = new TextField();
	private Button btAdd = new Button("+");
	private Button btSubtract = new Button("-");
	private Button btMultiply = new Button("*");
	private Button btDivide = new Button("/");

	// Start method
	@Override
	public void start(Stage primaryStage) {
		// Change the color of the text feilds
		TextField[] textFields = { tfNumber1, tfNumber2, tfCalculation };

		for (int i = 0; i < textFields.length; i++) {
			textFields[i].setStyle("-fx-background-color: #d6a5c2; -fx-border-color: cf80ae;");
		}
		// Create border pane and style it
		BorderPane borderPane = new BorderPane();
		borderPane.setStyle("-fx-background-color: #eda4cf; -fx-border-color: black;");

		// Set the top and style it
		lblTitle.setFont(Font.font("Lucida Console", 15));
		borderPane.setTop(lblTitle);
		BorderPane.setAlignment(lblTitle, Pos.CENTER);

		// Set the right and style it
		VBox rightVBox = new VBox();

		lblCatPic.setFont(Font.font("Lucida Console", 12));
		BorderPane.setAlignment(lblCatPic, Pos.CENTER);

		String url = "https://stickerly.pstatic.net/sticker_pack/VWr1nyZRjbPjfUbkTY3K6g/QH4RTN/2/fb9bfa5f-227b-4f05-933f-a606def64619.png";
		ImageView imageView = new ImageView();
		imageView.setFitHeight(100);
		imageView.setFitWidth(100);
		imageView.setImage(new Image(url));
		
		rightVBox.setPadding(new Insets(15, 5, 5, 5));
		rightVBox.getChildren().addAll(lblCatPic, imageView);
		VBox.setMargin(lblCatPic, new Insets(20, 20, 20, 40));
		VBox.setMargin(imageView, new Insets(20, 20, 20, 40));
		rightVBox.setAlignment(Pos.CENTER);
		borderPane.setRight(rightVBox);

		/*
		 * I really wanna set a cute pic of a cat here in a v box w a label above that
		 * says something dumb
		 */

		// Set the bottom and style it
		lblcopyrightInfo.setFont(Font.font("Lucida Console", 8));
		borderPane.setBottom(lblcopyrightInfo);
		BorderPane.setAlignment(lblcopyrightInfo, Pos.CENTER);

		// Set the left and style it
		lblInfo.setFont(Font.font("Lucida Console", 12));
		borderPane.setLeft(lblInfo);
		BorderPane.setAlignment(lblInfo, Pos.CENTER);

		// CENTER
		// Create grid for entering input
		GridPane gridPane1 = new GridPane();
		gridPane1.setHgap(7);
		gridPane1.setVgap(5);
		gridPane1.add(lblNumber1, 0, 0);
		lblNumber1.setFont(Font.font("Lucida Console", 10));
		gridPane1.add(tfNumber1, 1, 0);
		gridPane1.add(lblNumber2, 0, 1);
		lblNumber2.setFont(Font.font("Lucida Console", 10));
		gridPane1.add(tfNumber2, 1, 1);
		gridPane1.add(lblInstruction, 0, 2);
		lblInstruction.setFont(Font.font("Lucida Console", 10));

		// Grid of buttons
		GridPane gridPane2 = new GridPane();
		gridPane2.setHgap(5);
		gridPane2.setVgap(5);
		gridPane2.add(btAdd, 0, 0);
		btAdd.setOnAction(e -> calculate('+'));
		gridPane2.add(btSubtract, 0, 1);
		btSubtract.setOnAction(e -> calculate('-'));
		gridPane2.add(btMultiply, 1, 0);
		btMultiply.setOnAction(e -> calculate('*'));
		gridPane2.add(btDivide, 1, 1);
		btDivide.setOnAction(e -> calculate('/'));
		gridPane2.add(tfCalculation, 4, 1);

		// Create an array of buttons
		Button[] buttons = { btAdd, btSubtract, btMultiply, btDivide };

		// Iteration to style buttons
		for (int i = 0; i < buttons.length; i++) {
			buttons[i].setStyle(
					"-fx-border-color: #d6298e; " + "-fx-border-width: 1.5px;" + "-fx-background-color: #cf80ae;");
			buttons[i].setFont(Font.font("Lucida Console", 15));
			buttons[i].setMinSize(30, 35);
		}

		// Alignment
		gridPane1.setAlignment(Pos.CENTER);
		gridPane2.setAlignment(Pos.CENTER);
		tfCalculation.setEditable(false);
		GridPane.setHalignment(tfCalculation, HPos.CENTER);

		// Put grids into a VBox
		VBox centerVBox = new VBox();
		centerVBox.setPadding(new Insets(15, 5, 5, 5));
		centerVBox.getChildren().addAll(gridPane1, gridPane2);
		VBox.setMargin(gridPane1, new Insets(20, 20, 20, 40));
		VBox.setMargin(gridPane2, new Insets(20, 20, 20, 40));
		centerVBox.setAlignment(Pos.CENTER);
		borderPane.setCenter(centerVBox);

		// Create a scene and place it in the stage
		Scene scene = new Scene(borderPane, 750, 400);
		primaryStage.setTitle("TwoOperandCalculator.exe"); // Set title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
	}

	// Method that takes in operator and calculates binary digits
	private void calculate(char operator) {
		// Gets text from user
		String number1Text = tfNumber1.getText();
		String number2Text = tfNumber2.getText();

		// Makes sure the user entered numbers
		if (isValidNumber(number1Text) && isValidNumber(number2Text)) {

			// Variables to set the numbers and initialize result
			double num1 = Double.parseDouble(number1Text);
			double num2 = Double.parseDouble(number2Text);
			double result = 0;

			// Switch case to perform operation
			switch (operator) {
			case '+':
				result = num1 + num2;
				break;
			case '-':
				result = num1 - num2;
				break;
			case '*':
				result = num1 * num2;
				break;
			case '/':
				// Error checking
				if (num2 != 0) {
					result = num1 / num2;
				} else {
					tfCalculation.setText("Error: (Division by zero)");
					return;
				}
				break;
			}

			tfCalculation.setText(String.format("Result: %.8f", result));
		} else {
			tfCalculation.setText("Error: Invalid Input");
		}
	}

	// Regular expressions to check if the user entered valid numbers
	private boolean isValidNumber(String text) {
		return text.matches("-?\\d*\\.?\\d+");
	}

	// Main method
	public static void main(String[] args) {
		launch(args);
	}
}
