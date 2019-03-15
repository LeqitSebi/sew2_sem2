package slanitsch.ue09.GUIII;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class HBox_Embedded2 extends Application {
    @Override
    public void start(Stage stage) {
        stage.setTitle("Hbox_Embedded2");

        BorderPane borderPane = new BorderPane();
        Scene scene = new Scene(borderPane, 400, 200);
        stage.setScene(scene);

        Button button = new Button("Bearbeiten");
        Label label = new Label("Dateiname");
        TextField textField = new TextField();

        button.setMinWidth(Control.USE_PREF_SIZE);

        label.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        textField.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

        StackPane stackPane_with_button = new StackPane();
        stackPane_with_button.setAlignment(Pos.CENTER_RIGHT);
        HBox.setHgrow(stackPane_with_button, Priority.ALWAYS);
        stackPane_with_button.getChildren().add(button);

        HBox hbox = new HBox();
        hbox.setPadding(new Insets(10));
        hbox.setSpacing(15);
        hbox.setBackground(new Background(new BackgroundFill[]{  // to see whole area
                new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY)}));
        hbox.getChildren().addAll(label, textField, stackPane_with_button);

        BorderPane.setMargin(hbox, new Insets(5));
        borderPane.setTop(hbox);

        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
