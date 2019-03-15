package slanitsch.ue09.GUIII;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.control.TextField;

public class Login extends Application {

    public void start(Stage stage){

        stage.setTitle("Login");
        GridPane gridPane = new GridPane();
        Scene scene = new Scene(gridPane, 250, 115); // w, h
        stage.setScene(scene);

        gridPane.setHgap(20);
        gridPane.setVgap(5);
        gridPane.setPadding(new Insets(10));

        Label email = new Label("E-Mail:");
        Label pass = new Label("Passwort:");
        TextField textfield = new TextField();
        textfield.setPrefColumnCount(10);
        textfield.setPromptText("Text eingeben");

        Button login = new Button("Login");

        PasswordField password = new PasswordField();

        EventHandler<ActionEvent> textReader = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                System.out.println("Eingabe: " + textfield.getText());
                textfield.clear();
                textfield.requestFocus();
            }
        };

        gridPane.add(email, 0, 0);
        gridPane.add(textfield, 1, 0);
        gridPane.add(pass, 0, 1);
        gridPane.add(password, 1, 1);
        gridPane.add(login, 1, 2);
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
