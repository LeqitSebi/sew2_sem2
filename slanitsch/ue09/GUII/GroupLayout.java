package slanitsch.ue09.GUII;
//final
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;


public class GroupLayout extends Application {
    @Override
    public void start(Stage stage) {
        FlowPane fp = new FlowPane(Orientation.HORIZONTAL);
        stage.setTitle("GroupLayout");
        Scene scene = new Scene(fp, 210, 80);
        stage.setScene(scene);
        fp.setPadding(new Insets(5, 10, 0, 10)); // top, right, buttom, left
        fp.setVgap(10);
        fp.setHgap(10);

        stage.show();

        Button play = new Button(" Play");
        Button pause = new Button(" Pause");
        Button stop = new Button(" Stop");

        Button rewind = new Button(" Rewind");
        Button forward = new Button(" Forward");

        pause.setPrefSize(55,20);

        play.setPrefSize(pause.getPrefWidth(),pause.getPrefHeight());
        stop.setPrefSize(pause.getPrefWidth(),pause.getPrefHeight());

        rewind.setPrefSize((play.getPrefWidth() * 3)/2 + fp.getHgap()/2, pause.getPrefHeight());
        forward.setPrefSize(rewind.getPrefWidth(), pause.getPrefHeight());

        fp.getChildren().addAll(play,pause,stop,rewind,forward);
    }
}
