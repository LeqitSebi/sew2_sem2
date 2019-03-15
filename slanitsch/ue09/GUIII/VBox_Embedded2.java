package slanitsch.ue09.GUIII;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class VBox_Embedded2 extends Application {

    public void start(Stage stage){

        stage.setTitle("VBox in BorderPane2");

        BorderPane borderPane = new BorderPane();
        Scene scene = new Scene(borderPane, 400, 200); // w, h
        stage.setScene(scene);

        CheckBox box1 = new CheckBox("Bild");
        CheckBox box2 = new CheckBox("Text");
        Button button1 = new Button("Darstellen");

        box1.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        box2.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

        StackPane button = new StackPane();
        button.setAlignment(Pos.BOTTOM_CENTER); // always bottom
        VBox.setVgrow(button, Priority.ALWAYS); // always max height for big setMaxSize
        button.getChildren().add(button1);

        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10));
        vbox.setSpacing(15);
        vbox.setBackground(new Background(new BackgroundFill[]{
                new BackgroundFill(Color.MAGENTA, CornerRadii.EMPTY, Insets.EMPTY)}));

        vbox.getChildren().addAll(box1, box2, button);

        BorderPane.setMargin(vbox, new Insets(5));

        borderPane.setRight(vbox);
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
