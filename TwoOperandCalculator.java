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
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public class TwoOperandCalculator extends Application {
	// Data members (would be better in a text file but eh)
	private TextField tfNumber1 = new TextField();
	private TextField tfNumber2 = new TextField();
	private TextField tfCalculation = new TextField();
	private final Button BT_ADD = new Button("+");
	private final Button BT_SUBTRACT = new Button("-");
	private final Button BT_MULTIPLY = new Button("*");
	private final Button BT_DIVIDE = new Button("/");
	private final Label LBL_TITLE = new Label("Two Operand Calculator");
	private final Label LBL_INFO = new Label("Thank you for\nusing the "
			+ "Two\nOperand Calculator.\nWe know this is\nobviously\nthe " 
			+ "application\nyou want to use.\n\n");
	private final Label LBL_SPONSOR = new Label("A special\nThank you to\nour sponser:\n"
			+ "\"Reson To\nLeave Your Man\"\nA New York\nTimes Best\nSelling Novel.\n"
			+ "Find it at your\nlocal unsuspecting\nwhiteboard today.");
	private final Label LBL_NUMBER_1 = new Label("Enter first number:");
	private final Label LBL_NUMBER_2 = new Label("Enter second number:");
	private final Label LBL_INSTRUCTION = new Label("Click an operand below to calculate");
	private final Label LBL_COPYRIGHT_INFO = new Label("Copyright (c) 2024, Seraphina Morrison. All rights reserved");
	private final Label LBL_CAT_PIC = new Label(
			"Here is a picture\nof a cat.\nThere is no\nreason for this.\nShe is just cute.");

	// Start method
	@Override
	public void start(Stage primaryStage) {
		// Create border pane and style it
		BorderPane borderPane = new BorderPane();
		borderPane.setStyle("-fx-background-color: #eda4cf; -fx-border-color: #d6298e;");

		// Create HBox for top node
		HBox topHBox = new HBox();

		// Sets the font and the alignment of label for top node
		LBL_TITLE.setFont(Font.font("Lucida Console", 30));
		BorderPane.setAlignment(LBL_TITLE, Pos.CENTER);

		// Create and style image of cat for top node
		String topUrl = "https://i.pinimg.com/564x/dd/33/d7/dd33d7691b8e734aab844d4f311cd10e.jpg";
		ImageView topImageView = new ImageView();
		topImageView.setFitHeight(30);
		topImageView.setFitWidth(30);
		topImageView.setImage(new Image(topUrl));
		BorderPane.setAlignment(topImageView, Pos.CENTER);
		
		// Compose and style top HBox
		topHBox.setPadding(new Insets(5, 5, 5, 5));
		topHBox.getChildren().addAll(topImageView, LBL_TITLE);
		HBox.setMargin(LBL_TITLE, new Insets(10, 10, 0, 10));
		HBox.setMargin(topImageView, new Insets(10, 10, 0, 10));
		topHBox.setAlignment(Pos.CENTER);
		
		// Set top node
		borderPane.setTop(topHBox);

		// Create VBox for right node
		VBox rightVBox = new VBox();

		// Sets the font and alignment of label for right node
		LBL_CAT_PIC.setFont(Font.font("Lucida Console", 12));
		BorderPane.setAlignment(LBL_CAT_PIC, Pos.CENTER);

		// Create and style image of cat for right node
		String rightUrl = "https://stickerly.pstatic.net/sticker_pack/VWr1nyZRjbPjfUbkTY3K6g/QH4RTN/2/fb9bfa5f-227b-4f05-933f-a606def64619.png";
		ImageView rightImageView = new ImageView();
		rightImageView.setFitHeight(115);
		rightImageView.setFitWidth(115);
		rightImageView.setImage(new Image(rightUrl));
		BorderPane.setAlignment(rightImageView, Pos.CENTER);

		// Compose and style right VBox
		rightVBox.setPadding(new Insets(15, 5, 5, 5));
		rightVBox.getChildren().addAll(LBL_CAT_PIC, rightImageView);
		VBox.setMargin(LBL_CAT_PIC, new Insets(20, 20, 20, 40));
		VBox.setMargin(rightImageView, new Insets(20, 20, 20, 40));
		rightVBox.setAlignment(Pos.CENTER);

		// Sets right node
		borderPane.setRight(rightVBox);

		// Style the bottom
		LBL_COPYRIGHT_INFO.setFont(Font.font("Lucida Console", 8));
		BorderPane.setAlignment(LBL_COPYRIGHT_INFO, Pos.CENTER);

		// Sets bottom node
		borderPane.setBottom(LBL_COPYRIGHT_INFO);

		// Create VBox
		VBox leftVBox = new VBox();

		// Style the left labels
		LBL_INFO.setFont(Font.font("Lucida Console", 12));
		BorderPane.setAlignment(LBL_INFO, Pos.CENTER);
		LBL_SPONSOR.setFont(Font.font("Lucida Console", 12));
		BorderPane.setAlignment(LBL_SPONSOR, Pos.CENTER);

		// Compose and style left vBox
		leftVBox.setPadding(new Insets(5, 5, 5, 5));
		leftVBox.getChildren().addAll(LBL_INFO, LBL_SPONSOR);
		VBox.setMargin(LBL_INFO, new Insets(20, 20, 20, 20));
		VBox.setMargin(LBL_SPONSOR, new Insets(20, 20, 20, 20));
		leftVBox.setAlignment(Pos.CENTER);

		// Sets left node
		borderPane.setLeft(leftVBox);

		// Create top grid pane for center node
		GridPane centerGridTop = new GridPane();
		
		// Alignment top grid pane for center node
		centerGridTop.setHgap(7);
		centerGridTop.setVgap(5);
		centerGridTop.setAlignment(Pos.CENTER);
		
		// Populate grid
		centerGridTop.add(LBL_NUMBER_1, 0, 0);
		centerGridTop.add(tfNumber1, 1, 0);
		centerGridTop.add(LBL_NUMBER_2, 0, 1);
		centerGridTop.add(tfNumber2, 1, 1);
		
		// Create array of labels
		Label[] centerGridTopArray = { LBL_NUMBER_1, LBL_NUMBER_2 };
		
		// Iterate through array to set font
		for (int i = 0; i < centerGridTopArray.length; i++) {
			centerGridTopArray[i].setFont(Font.font("Lucida Console", 14));
		}
		
		// Change the color of the text fields
		TextField[] textFields = { tfNumber1, tfNumber2, tfCalculation };

		// Iterate through array to set colors
		for (int i = 0; i < textFields.length; i++) {
			textFields[i].setStyle("-fx-background-color: #d6a5c2; -fx-border-color: cf80ae;");
		}

		// Create button grid for center node
		GridPane buttonGrid = new GridPane();
		
		// Align button grid
		buttonGrid.setHgap(5);
		buttonGrid.setVgap(5);
		buttonGrid.setAlignment(Pos.CENTER);
		
		// Add buttons to grid
		buttonGrid.add(BT_ADD, 0, 0);
		buttonGrid.add(BT_SUBTRACT, 0, 1);
		buttonGrid.add(BT_MULTIPLY, 1, 0);
		buttonGrid.add(BT_DIVIDE, 1, 1);
		
		// Event handling for buttons
		BT_ADD.setOnAction(e -> calculate('+'));
		BT_SUBTRACT.setOnAction(e -> calculate('-'));
		BT_MULTIPLY.setOnAction(e -> calculate('*'));
		BT_DIVIDE.setOnAction(e -> calculate('/'));
		
		// Create an array of buttons
		Button[] buttons = { BT_ADD, BT_SUBTRACT, BT_MULTIPLY, BT_DIVIDE };

		// Iteration to style buttons
		for (int i = 0; i < buttons.length; i++) {
			buttons[i].setStyle(
					"-fx-border-color: #d6298e; " + "-fx-border-width: 1.5px;" + "-fx-background-color: #cf80ae;");
			buttons[i].setFont(Font.font("Lucida Console", 15));
			buttons[i].setMinSize(40, 45);
		}

		// Style for tfCalculation node
		tfCalculation.setEditable(false);
		tfCalculation.setFont(Font.font("Lucida Console", 12));
		GridPane.setHalignment(tfCalculation, HPos.CENTER);
		
		// Style for LBL_INSTRUCTION node
		LBL_INSTRUCTION.setFont(Font.font("Lucida Console", 15));
		GridPane.setHalignment(LBL_INSTRUCTION, HPos.CENTER);

		// Create outer center node
		VBox centerVBox = new VBox();
		
		// Add children to outer center node
		centerVBox.getChildren().addAll(centerGridTop, LBL_INSTRUCTION, buttonGrid, tfCalculation);
		
		// Align outer center node
		centerVBox.setPadding(new Insets(10, 5, 5, 5));
		VBox.setMargin(LBL_INSTRUCTION, new Insets(10, 20, 20, 40));
		VBox.setMargin(tfCalculation, new Insets(10, 20, 20, 40));
		VBox.setMargin(centerGridTop, new Insets(20, 20, 20, 40));
		VBox.setMargin(buttonGrid, new Insets(5, 20, 20, 40));
		centerVBox.setAlignment(Pos.CENTER);
		
		// Set the center node
		borderPane.setCenter(centerVBox);

		// Create a scene and place it in the stage
		Scene scene = new Scene(borderPane, 800, 450);
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
