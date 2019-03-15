package slanitsch.ue09.GUIII;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class HBox_Sample extends Application {

	@Override
	public void start(Stage stage) {
		stage.setTitle("HBox Sample");

	    HBox hbox = new HBox();
		Scene scene = new Scene(hbox, 600, 100);
		stage.setScene(scene);

		hbox.setPadding(new Insets(10)); 	// Set all sides to 10
                hbox.setSpacing(15);			// Gap between nodes
                hbox.setAlignment(Pos.TOP_CENTER);

		Label text1 = new Label("Label1");
		Label text2 = new Label("Label2");
		Button button1 = new Button("Button1");
		Button button2 = new Button("Button2");

//		button1.setMaxHeight(Double.MAX_VALUE); // to show stretching
//		button2.setMaxHeight(Double.MAX_VALUE);

		hbox.getChildren().addAll(text1, button1, text2, button2);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
