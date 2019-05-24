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
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;


public class Wort_Raten_1 extends Application {
    public static int get_to_solve=0;
    public static int versuche_all = 0;
    public static double percent = 0.0;
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
        Scene scene = new Scene(gridPane, 950, 350); // w, h
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
        Button reset = new Button("Reset");
        Button stats = new Button("Statistiken");
        TextField z1 = new TextField();
        z1.setPrefColumnCount(10);
        Label tries = new Label("0");
        stage.show();
        for (int i = 0; i < viele.length; i++) {
            gridPane.add(viele[i],i, 0);
        }
        gridPane.add(z1,0,2);
        gridPane.add(submit, 0,3);
        gridPane.add(reset,1,3);
        gridPane.add(stats, 2,3);
        gridPane.add(tries, 0, 4);

        submit.setOnAction(event -> {
            try {
                String versuch = z1.getText();
                if(versuch.equals(Worts)){
                    z1.setText("Richtig!!!");
                    tries.setText("Du hast " + get_to_solve + " Tipps gebraucht");
                    double thistry = Worts.length() / get_to_solve;
                    percent += thistry;
                    versuche_all++;
                }else{
                    z1.setText("Falsch!!!");
                }
            }catch (NumberFormatException e) {
                z1.setText(e.getMessage());
            }
        });

        reset.setOnAction(event -> {
            try {
                get_to_solve=0;
                start(stage);
            }catch (NumberFormatException | IOException e) {
                z1.setText(e.getMessage());
            }
        });

        stats.setOnAction(event -> {
            try {
                start2(stage);
            }catch (NumberFormatException e) {
                z1.setText(e.getMessage());
            }
        });
    }

    public void start2(Stage stage) {
        GridPane gridPane = new GridPane();
        Scene scene = new Scene(gridPane, 550, 350); // w, h
        gridPane.setHgap(20);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(10));
        stage.setScene(scene);
        stage.setTitle("Statistiken");
        stage.setScene(scene);
        double all_tries = percent / versuche_all;
        Label spiele =  new Label("Du hast bis jetzt "+ versuche_all + " Spiele gespielt");
        Label prozent = new Label("Im Durchschnitt hast du " + all_tries*100 + "% aller Buchstaben gebraucht um das Wort zu lösen");
        Button goback = new Button("zurück zum Spiel");

        gridPane.add(spiele, 0, 0);
        gridPane.add(prozent, 0,1);
        gridPane.add(goback, 0, 2);
        stage.show();

        goback.setOnAction(event -> {
            try {
                start(stage);
            }catch (NumberFormatException | IOException e) {
            }
        });
    }

    public static void main(String[] args) throws IOException {
        launch(args);
    }
}

