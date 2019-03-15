package slanitsch.ue09.GUIII;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Rectangle2D;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class GridPane_Sample extends Application {

	@Override
	public void start(Stage stage) {
		stage.setTitle("GridPane Sample");
		stage.setMinWidth(390);
		stage.setMinHeight(200);

		GridPane gridPane = new GridPane();
		Scene scene = new Scene(gridPane, 300, 200); // w, h
		stage.setScene(scene);

		gridPane.setHgap(50);
		gridPane.setVgap(10);
		gridPane.setPadding(new Insets(10)); // top, right, bottom, left

		Button button1 = new Button("supercooler Button");
		Button button2 = new Button("bu");
		Button button3 = new Button("mega mäßig cooler dritter Button");
		Button button4 = new Button("cool");
		Button button5 = new Button("Der HTL Rennweg ist toll Button");
		Button button6 = new Button("b");
		
		Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
		// button1.setPrefSize(screenBounds.getWidth(), screenBounds.getHeight()); //Hier wird die präferierte Größe für button1 festgelegt
		// button2.setPrefSize(screenBounds.getWidth(), screenBounds.getHeight()); //Hier wird die präferierte Größe für button2 festgelegt
		// button3.setPrefSize(screenBounds.getWidth(), screenBounds.getHeight()); //Hier wird die präferierte Größe für button3 festgelegt
		// button4.setPrefSize(screenBounds.getWidth(), screenBounds.getHeight()); //Hier wird die präferierte Größe für button4 festgelegt
		// button5.setPrefSize(screenBounds.getWidth(), screenBounds.getHeight()); //Hier wird die präferierte Größe für button5 festgelegt
		// button6.setPrefSize(screenBounds.getWidth(), screenBounds.getHeight()); //Hier wird die präferierte Größe für button6 festgelegt
		
		button1.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE); // w, h
		button2.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		button3.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		button4.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		button5.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		button6.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

		gridPane.add(button1, 0, 0, 1, 2);  // col 1, row 1, colspan 1, rowspan 2
		gridPane.add(button2, 1, 0);  		// col 2, row 1
		gridPane.add(button3, 2, 0);  		// col 3, row 1
		gridPane.add(button4, 1, 1, 2, 1);  // col 2, row 2, colspan 2, rowspan 1
		gridPane.add(button5, 0, 2);   		// col 1, row 3
		gridPane.add(button6, 3, 3);   		// col 4, row 4
		
		GridPane.setValignment(button1, VPos.CENTER);
		GridPane.setHalignment(button4, HPos.CENTER);

	  	gridPane.setGridLinesVisible(true);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
