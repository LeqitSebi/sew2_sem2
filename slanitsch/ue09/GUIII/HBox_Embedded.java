package slanitsch.ue09.GUIII;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class HBox_Embedded extends Application {

	@Override
	public void start(Stage stage) {
		stage.setTitle("HBox in BorderPane");
		
		BorderPane borderPane = new BorderPane();
		Scene scene = new Scene(borderPane, 400, 200); // w, h
		stage.setScene(scene);
		
		Button button1 = new Button("Button1");
		Button button2 = new Button("Button2");
		Button button3 = new Button("Button3");
		
		button1.setMinWidth(Control.USE_PREF_SIZE); // to prevent squeezing to three points
		button2.setMinWidth(Control.USE_PREF_SIZE);
		button3.setMinWidth(Control.USE_PREF_SIZE);
		
		button1.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE); // w, h; to show stretching if possible
		button2.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE); // w, h
//		button3.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE); // w, h; to prevent stretching

		StackPane stackPane_with_button3 = new StackPane();
		stackPane_with_button3.setAlignment(Pos.CENTER_RIGHT);  // always right
		HBox.setHgrow(stackPane_with_button3, Priority.ALWAYS); // always max width for big setMaxSize 
		stackPane_with_button3.getChildren().add(button3);

	    HBox hbox = new HBox();
		hbox.setPadding(new Insets(10)); 	// Set all sides to 10
        hbox.setSpacing(15);				// Gap between nodes
        hbox.setBackground(new Background(new BackgroundFill[]{  // to see whole area
             new BackgroundFill(Color.HONEYDEW, CornerRadii.EMPTY, Insets.EMPTY)}));
      //hbox.setAlignment(Pos.BOTTOM_RIGHT); // here no effect
		hbox.getChildren().addAll(button1, button2, stackPane_with_button3);
        
		BorderPane.setMargin(hbox, new Insets(5)); // margin to border
		borderPane.setTop(hbox); // to test select only one area of BorderPane
//		borderPane.setCenter(hbox);
//		borderPane.setBottom(hbox);
//		borderPane.setLeft(hbox);
//		borderPane.setRight(hbox);

		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
