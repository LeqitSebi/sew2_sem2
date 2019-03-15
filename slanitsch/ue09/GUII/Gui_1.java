package slanitsch.ue09.GUII;
//final

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class Gui_1 extends Application {
    @Override public void start(Stage stage) {

        stage.setTitle("GUI 1 - empty");
        stage.setMinWidth(200D);
        stage.setMinHeight(200D);

        // stage.centerOnScreen();
        stage.setX(100D);
        stage.setY(200D);

        Group group = new Group();
        Scene scene = new Scene(group);

        Label label = new Label("HALLO");

        Label label1 = new Label("Hello");
        label1.setLayoutX(10);
        label1.setLayoutY(20);

        Label label2 = new Label();
        label2.setText("World!");
        label2.setLayoutX(10);
        label2.setLayoutY(40);

        group.getChildren().addAll(label1, label2);
        group.getChildren().add(new Label("Hallo"));
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

