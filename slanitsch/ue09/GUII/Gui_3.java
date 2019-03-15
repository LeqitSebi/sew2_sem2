package slanitsch.ue09.GUII;
//final
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class Gui_3 extends Application {

    public void start(Stage stage) {
        stage.setTitle("GUI 3 - FlowPane");
        FlowPane flowPane = new FlowPane(Orientation.HORIZONTAL); // = new FlowPane()
        // FlowPane flowPane = new FlowPane(Orientation.VERTICAL);
        Scene scene = new Scene(flowPane, 300, 250);
        stage.setScene(scene);

        flowPane.setPadding(new Insets(10, 0, 0, 10)); // top, right, buttom, left
        flowPane.setVgap(20);
        flowPane.setHgap(30);
        flowPane.setRowValignment(VPos.BOTTOM); // vertical: align on buttom
        flowPane.setColumnHalignment(HPos.RIGHT); // hoizontal align on right

        Label text1 = new Label("Label1 --------------- long");
        Label text2 = new Label("Label2");
        Label text3 = new Label("Label3");

        Button button1 = new Button("button1 --------------- long");
        Button button2 = new Button("button2");
        Button button3 = new Button("button3");

        flowPane.getChildren().addAll(text1, text2, text3, button1, button2, button3);
        stage.show();

    }
}
