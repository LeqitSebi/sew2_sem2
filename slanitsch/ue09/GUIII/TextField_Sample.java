package slanitsch.ue09.GUIII;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class TextField_Sample extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("TextField Sample");
        HBox hbox = new HBox();
        stage.setScene(new Scene(hbox, 460, 60));
        hbox.setPadding(new Insets(15));   // top, right, bottom, left
        hbox.setSpacing(10);

        Label label = new Label("Eingabe:");
        
        TextField textField = new TextField();
        textField.setPrefColumnCount(24);          // new width
        textField.setPromptText("Text eingeben");  // help text
        
        Button button = new Button("Bearbeiten");
        
        // Define the event handler
        EventHandler<ActionEvent> textReader = new EventHandler<ActionEvent>() {
     	   @Override
     	   public void handle(ActionEvent e) {
     		  System.out.println("Eingabe: " + textField.getText());
     		  textField.clear();
     		  textField.requestFocus();    // set cursor back to textField 
     	   }
        };
 
        textField.setOnAction(textReader); // attach handler for Enter key
        button.setOnAction(textReader);    // attach handler for button (mouse click)
        
        hbox.getChildren().addAll(label, textField, button);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
