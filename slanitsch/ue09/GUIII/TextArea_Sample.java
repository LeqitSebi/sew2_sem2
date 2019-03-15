package slanitsch.ue09.GUIII;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class TextArea_Sample extends Application {

	@Override
	public void start(Stage stage) {
		stage.setTitle("Scrollable TextArea");
		BorderPane borderPane = new BorderPane();
		Scene scene = new Scene(borderPane, 600, 200);
		stage.setScene(scene);
		borderPane.setPadding(new Insets(10)); // top, right, bottom, left
      
        TextArea textArea = new TextArea();
 
        Button writeButton = new Button("Schreibe in TextArea");
        writeButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	String text = "Programm Ausgabe\n";
            	textArea.appendText(text);
            }
        });
        
        Button readButton = new Button("Lese aus TextArea");
        readButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	System.out.println(textArea.getText());
            	textArea.clear();
            	textArea.requestFocus(); // set cursor back to textArea
            }
        });
        
        writeButton.setMaxWidth(Double.MAX_VALUE); // to have same width
        readButton.setMaxWidth(Double.MAX_VALUE);  // for both buttons
        
	    VBox vbox = new VBox();
	    BorderPane.setMargin(vbox, new Insets(0, 0, 0, 10)); // left
        vbox.setSpacing(10);				// Gap between buttons
        vbox.setAlignment(Pos.TOP_CENTER);  // Set buttons to top
        vbox.getChildren().addAll(writeButton, readButton);
        
        borderPane.setCenter(textArea);
		borderPane.setRight(vbox);

		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
