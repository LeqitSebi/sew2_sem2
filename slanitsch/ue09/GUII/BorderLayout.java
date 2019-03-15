package slanitsch.ue09.GUII;
//final
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;



public class BorderLayout extends Application{
    @Override
    public void start(Stage stage) {
        PopUpFx popUp = new PopUpFx();
        String input = popUp.readLine("Kombination von: TCBLR");
        System.out.println(input);
        Scene scene;
        BorderPane borderPane = new BorderPane();
        stage.setTitle("BorderLayout");
        scene = new Scene(borderPane, 400, 300);
        stage.setScene(scene);

        if (input.contains("T") || input.contains("t")){
            Button top = new Button(" top ");
            top.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
            borderPane.setTop(top);
            borderPane.setPadding(new Insets(5, 5, 5, 5)); // top, right, bottom, left
            BorderPane.setAlignment(top,    Pos.CENTER);
            BorderPane.setMargin(top, new Insets(10, 0, 10, 0));
        }
        if (input.contains("C") || input.contains("c")){
            Button center = new Button(" center ");
            center.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
            borderPane.setCenter(center);
            borderPane.setPadding(new Insets(5, 5, 5, 5)); // top, right, bottom, left
            BorderPane.setAlignment(center,    Pos.CENTER);
        }
        if (input.contains("B") || input.contains("b")){
            Button bottom = new Button(" bottom ");
            bottom.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
            borderPane.setBottom(bottom);
            borderPane.setPadding(new Insets(5, 5, 5, 5)); // top, right, bottom, left
            BorderPane.setAlignment(bottom,    Pos.CENTER);
        }
        if (input.contains("L") || input.contains("l")){
            Button left = new Button(" left ");
            left.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
            borderPane.setLeft(left);
            borderPane.setPadding(new Insets(5, 5, 5, 5)); // top, right, bottom, left
            BorderPane.setAlignment(left,    Pos.CENTER);
        }
        if (input.contains("R") || input.contains("r")){
            Button right = new Button(" right ");
            right.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
            borderPane.setRight(right);
            borderPane.setPadding(new Insets(5, 5, 5, 5)); // top, right, bottom, left
            BorderPane.setAlignment(right,    Pos.CENTER);
        }
        stage.show();
    }
}
