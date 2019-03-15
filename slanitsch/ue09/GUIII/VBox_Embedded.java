package slanitsch.ue09.GUIII;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class VBox_Embedded extends Application {

	@Override
	public void start(Stage stage) {
		stage.setTitle("VBox in BorderPane");

		BorderPane borderPane = new BorderPane();
		Scene scene = new Scene(borderPane, 400, 200); // w, h
		stage.setScene(scene);
		
		CheckBox button1 = new CheckBox("Button1");
		Button button2 = new Button("Button2");
		Button button3 = new Button("Button3");

		button1.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE); // w, h; to show stretching if possible
		button2.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE); // w, h
//		button3.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE); // w, h; to prevent stretching

		StackPane stackPane_with_button3 = new StackPane();
		stackPane_with_button3.setAlignment(Pos.BOTTOM_CENTER); // always bottom
		VBox.setVgrow(stackPane_with_button3, Priority.ALWAYS); // always max height for big setMaxSize
		stackPane_with_button3.getChildren().add(button3);		

	    VBox vbox = new VBox();
		vbox.setPadding(new Insets(10)); 	// Set all sides to 10
        vbox.setSpacing(15);				// Gap between nodes
        vbox.setBackground(new Background(new BackgroundFill[]{  // to see whole area
             new BackgroundFill(Color.HONEYDEW, CornerRadii.EMPTY, Insets.EMPTY)}));
//      vbox.setAlignment(Pos.TOP_CENTER);  // here no effect
		vbox.getChildren().addAll(button1, button2, stackPane_with_button3);

		BorderPane.setMargin(vbox, new Insets(5)); // margin to border
//		borderPane.setTop(vbox); // to test select only one area of BorderPane
//		borderPane.setCenter(vbox);
//		borderPane.setBottom(vbox);
		borderPane.setLeft(vbox);
//		borderPane.setRight(vbox);

		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
