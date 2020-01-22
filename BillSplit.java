package billSplitter;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


public class BillSplit extends Application{

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws FileNotFoundException {
		initUI(stage);
	}

	private void initUI(Stage stage) throws FileNotFoundException {

		// Create a layout pane that contains the elements
		VBox pane = new VBox(10);
		pane.setPadding(new Insets(10));
		pane.setSpacing(10);

		// Logo
		FileInputStream inputstream = new FileInputStream("C:\\Users\\Nika\\eclipse-workspace-oxygen\\personalProjects\\src\\billSplitter\\billsplitter1.png"); 
		Image image = new Image(inputstream); 
		ImageView imageView = new ImageView(image);
		imageView.setTranslateX(15);
		pane.getChildren().add(imageView);
		imageView.setStyle("-fx-alignment: center;");
		pane.setStyle("-fx-background-color: rgba(0, 100, 100, 0.5);");
	     
		// Create the fields
		TextField totalAmount = new TextField();
		TextField splitAmount = new TextField();
		
		totalAmount.setPromptText("Total");
		splitAmount.setPromptText("Number of People");

		// Put the buttons on the pane
		pane.getChildren().addAll(totalAmount, splitAmount);

		// Create a text field
		TextField calculatedAmount = new TextField();
		calculatedAmount.setPrefColumnCount(20);
		calculatedAmount.setDisable(true);
		
		// Add Button for calculation
		Button calculate = new Button("Split!");
		calculate.setOnAction(new View(calculatedAmount, totalAmount, splitAmount));
		//
		
		// Put the text field on the pane
		pane.getChildren().addAll(calculate, calculatedAmount);
		
		// Use pane as the root of the scene
		Scene scene = new Scene(pane);
		stage.setScene(scene);
		
		// Set the title of the window
		stage.setTitle("Bill Splitter");
		
		// Show the window
		stage.show();	
	}

}
