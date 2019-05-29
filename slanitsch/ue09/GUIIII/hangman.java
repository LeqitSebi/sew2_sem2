package slanitsch.ue09.GUIIII;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import java.io.IOException;

public class hangman extends Application {

    @Override
    public void start(Stage stage) throws IOException {

        String Worts = Wort_Raten_1.getWord();
        String[] Wort = new String[Worts.length()];
        for (int i = 0; i < Worts.length(); i++) {
            Wort[i] = "" + Worts.charAt(i);
        }

        Button[] viele = new Button[Worts.length()];
        for (int i = 0; i < Wort.length; i++) {
            viele[i]=new Button("?");
        }


        stage.setTitle("HBox Sample");

        HBox hbox = new HBox();
        Scene scene = new Scene(hbox, 600, 100);
        stage.setScene(scene);

        hbox.setPadding(new Insets(10)); 	// Set all sides to 10
        hbox.setSpacing(15);			// Gap between nodes
        hbox.setAlignment(Pos.TOP_CENTER);
        for (int i = 0; i < Worts.length(); i++) {
            hbox.getChildren().add(viele[i]);
        }
        TextField tf = new TextField();


        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}