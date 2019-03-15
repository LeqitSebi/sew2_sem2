package slanitsch.ue09.GUIII;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class HBoxLayout extends Application {

    public void start(Stage stage){

        stage.setTitle("BorderLayout");
        stage.setMinWidth(200);
        stage.setMinHeight(200);

        String eingabe = PopUpFx.readLine("Abstand zwischen den GUI-Elementen");

        BorderPane borderPane = new BorderPane();
        Scene scene = new Scene(borderPane, 400, 300);
        stage.setScene(scene);

        String eingabe2 = PopUpFx.readLine("Rahmen Abstände: oben, rechts, unten, links");

        BorderPane borderPane2 = new BorderPane();
        Scene scene2 = new Scene(borderPane2, 400, 300);
        stage.setScene(scene2);

        String eingabe3 = PopUpFx.readLine("Position im Fenster:[oben|mitte|unten], [links|mitte|rechts]");

        BorderPane borderPane3 = new BorderPane();
        Scene scene3 = new Scene(borderPane3, 400, 300);
        stage.setScene(scene3);


        String[] parts = eingabe2.split(",", 4);

        double gui_abstand = Double.parseDouble(eingabe);


        HBox hbox = new HBox();
        Scene end = new Scene(hbox, 600, 100);
        stage.setScene(end);

        hbox.setPadding(new Insets(Double.parseDouble(parts[0]), Double.parseDouble(parts[1]), Double.parseDouble(parts[2]), Double.parseDouble(parts[3])));
        hbox.setSpacing(gui_abstand);

        if(eingabe3.contains("oben") && eingabe3.contains("links")){
            hbox.setAlignment(Pos.TOP_LEFT);
        }

        if(eingabe3.contains("oben") && eingabe3.contains("mitte")){
            hbox.setAlignment(Pos.TOP_CENTER);
        }

        if(eingabe3.contains("mitte") && eingabe3.contains("rechts")){
            hbox.setAlignment(Pos.CENTER_RIGHT);
        }

        if(eingabe3.contains("oben") && eingabe3.contains("links")){
            hbox.setAlignment(Pos.TOP_LEFT);
        }

        if(eingabe3.equals("mitte, mitte")){
            hbox.setAlignment(Pos.CENTER);
        }

        if(eingabe3.contains("mitte") && eingabe3.contains("links")){
            hbox.setAlignment(Pos.CENTER_LEFT);
        }

        if(eingabe3.contains("unten") && eingabe3.contains("rechts")){
            hbox.setAlignment(Pos.BOTTOM_RIGHT);
        }

        if(eingabe3.contains("unten") && eingabe3.contains("links")){
            hbox.setAlignment(Pos.BOTTOM_LEFT);
        }

        if(eingabe3.contains("unten") && eingabe3.contains("mitte")){
            hbox.setAlignment(Pos.BOTTOM_CENTER);
        }


        Label text1 = new Label("Label1");
        Label text2 = new Label("Label2");
        Button button1 = new Button("Button1");
        Button button2 = new Button("Button2");

        hbox.getChildren().addAll(text1, button1, text2, button2);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
