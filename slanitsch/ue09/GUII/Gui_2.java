package slanitsch.ue09.GUII;
//final
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Gui_2 extends Application {

    public void start(Stage stage) {

        stage.setTitle("GUI 2 - Scene with button");
        StackPane stackPane = new StackPane();
        stage.setScene(new Scene(stackPane, 300, 100)); // width, height
        Button button = new Button ("Hello, my friend"); // Mit Hilfe eines Lambdas wird der Empfänger des click-Ereignisses benachrichtigt.
        button.setOnAction(event -> System.out.println("Hello World!"));
        stackPane.getChildren().add(button);
        stage.show();
    }
}
