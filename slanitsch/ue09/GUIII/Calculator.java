package slanitsch.ue09.GUIII;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Calculator extends Application {

    Scene scene;


    public void start(Stage stage){


        GridPane gridPane = new GridPane();
        Scene scene = new Scene(gridPane, 250, 110); // w, h
        gridPane.setHgap(20);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(10));
        stage.setScene(scene);
        stage.setTitle("Calculator");

        stage.setScene(scene);

        TextField z1 = new TextField();
        z1.setPrefColumnCount(10);

        TextField z2 = new TextField();
        z2.setPrefColumnCount(10);

        Button buttonPlus = new Button("+");
        Button buttonMult = new Button("*");
        Button buttonMinus = new Button("-");
        Button buttonDiv = new Button("/");

        Label erg = new Label("Ergebnis");

        gridPane.add(z1, 0, 0);
        gridPane.add(z2, 0, 1);
        gridPane.add(buttonPlus, 1, 0);
        gridPane.add(buttonMinus, 2, 0);
        gridPane.add(buttonMult, 1, 1);
        gridPane.add(buttonDiv, 2, 1);
        gridPane.add(erg, 0, 2);


        buttonPlus.setOnAction(event -> {
                    try {
                        double zahl1 = Double.parseDouble(z1.getText());
                        double zahl2 = Double.parseDouble(z2.getText());
                        double sum = zahl1 + zahl2;
                        erg.setText("" + sum);
                    } catch (NumberFormatException e) {
                        erg.setText(e.getMessage());
                    }
                });

        buttonMinus.setOnAction(event -> {
                try {
                    double zahl1 = Double.parseDouble(z1.getText());
                    double zahl2 = Double.parseDouble(z2.getText());
                    double sum = zahl1 - zahl2;
                    erg.setText("" + sum);
                }catch (NumberFormatException e) {
                    erg.setText(e.getMessage());
                }
        });


        buttonMult.setOnAction(event -> {
                try {
                    double zahl1 = Double.parseDouble(z1.getText());
                    double zahl2 = Double.parseDouble(z2.getText());
                    double sum = zahl1 * zahl2;
                    erg.setText("" + sum);
                }catch (NumberFormatException e) {
                    erg.setText(e.getMessage());
                }
        });

        buttonDiv.setOnAction(event -> {
                try{
                double zahl1 = Double.parseDouble(z1.getText());
                double zahl2 = Double.parseDouble(z2.getText());
                double sum = zahl1 / zahl2;
                erg.setText(""+sum);
            }catch (NumberFormatException e) {
                    erg.setText(e.getMessage());
                }
        });

        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
