package slanitsch.ue09.GUIIII;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;


public class Wort_Raten_1 extends Application {
    public static int get_to_solve=0;
    public static String getWord() throws IOException {
        try (
                BufferedReader in = Files.newBufferedReader(Paths.get("resources/words.txt"), Charset.forName("UTF-8"));
        ) {
            int rnd = (int) (Math.random() * 26);
            String line = "nix";
            for (int j = 0; j < rnd; j++) {
                line = in.readLine();
            }
            return line;
        }
    }

    public static void Button() {

    }

    public void start(Stage stage) throws IOException {

        String Worts = getWord();
        String[] Wort = new String[Worts.length()];
        for (int i = 0; i < Worts.length(); i++) {
            Wort[i] = "" + Worts.charAt(i);
        }
        GridPane gridPane = new GridPane();
        Scene scene = new Scene(gridPane, 550, 210); // w, h
        gridPane.setHgap(20);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(10));
        stage.setScene(scene);
        stage.setTitle("Wörter erraten");
        stage.setScene(scene);
        Button submit = new Button("prüfen");
        EditableButton[] viele = new EditableButton[Wort.length];
        for (int i = 0; i < Wort.length; i++) {
            viele[i]=new EditableButton(Wort[i]);    
        }
        TextField z1 = new TextField();
        z1.setPrefColumnCount(10);
        Label tries = new Label("0");
        stage.show();
        for (int i = 0; i < viele.length; i++) {
            gridPane.add(viele[i],i, 0);
        }
        gridPane.add(z1,0,2);
        gridPane.add(submit, 0,3);
        gridPane.add(tries, 0, 4);

        submit.setOnAction(event -> {
            try {
                String versuch = z1.getText();
                if(versuch.equals(Worts)){
                    z1.setText("Richtig!!!");
                }else{
                    z1.setText("Falsch!!!");
                }
                tries.setText("Du hast " + get_to_solve + " Tipps gebraucht");
            }catch (NumberFormatException e) {
                z1.setText(e.getMessage());
            }
        });
    }

    public static void main(String[] args) throws IOException {
        launch(args);
    }
}

