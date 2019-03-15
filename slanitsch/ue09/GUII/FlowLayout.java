package slanitsch.ue09.GUII;
//final
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.scene.Scene;




public class FlowLayout extends Application {
    @Override
    public void start(Stage stage) {
        PopUpFx popUp = new PopUpFx();
        String input = popUp.readLine("FlowLayout Ausrichtung angeben: H oder V");
        System.out.println(input);
        Scene scene;
        FlowPane fp;

        if (input.equals("h") || input.equals("H")){
            stage.setTitle("FlowLayout Horizontal");
            fp = new FlowPane(Orientation.HORIZONTAL); // = new FlowPane()
            scene = new Scene(fp, 500, 50);
            stage.setScene(scene);
            fp.setPadding(new Insets(10, 0, 0, 10)); // top, right, buttom, left
            fp.setVgap(20);
            fp.setHgap(30);
            Button play = new Button(" Play ");
            Button rewind = new Button(" rewind ");
            Button forward = new Button(" Forward ");
            Button pause = new Button(" Pause ");
            Button stop = new Button(" Stop ");
            fp.getChildren().addAll(play,rewind,forward,pause,stop);
        }
        else if (input.equals("v") || input.equals("V")){
            stage.setTitle("FlowLayout Vertical");
            fp = new FlowPane(Orientation.VERTICAL); // = new FlowPane()
            scene = new Scene(fp, 50, 500);
            stage.setScene(scene);
            fp.setPadding(new Insets(10, 0, 0, 10)); // top, right, buttom, left
            fp.setVgap(20);
            fp.setHgap(30);
            Button play = new Button(" Play ");
            Button rewind = new Button(" rewind ");
            Button forward = new Button(" Forward ");
            Button pause = new Button(" Pause ");
            Button stop = new Button(" Stop ");
            fp.getChildren().addAll(play,rewind,forward,pause,stop);
        }else {
            PopUpFx.print("Deine Eingabe ist falsch oder du hast auf "
                    + '"' + "Abbrechen" + '"' + " gedrückt!");
            throw new IllegalArgumentException(input + "Deine Eingabe ist falsch oder du hast auf "
                    + '"' + "Abbrechen" + '"' + " gedrückt!");
        }
        stage.show();
    }
}
