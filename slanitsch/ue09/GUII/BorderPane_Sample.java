package slanitsch.ue09.GUII;
//final
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
public class BorderPane_Sample extends Application {

	@Override
	public void start(Stage stage) {
		stage.setTitle("BorderPane Sample");
		stage.setMinWidth(200);
		stage.setMinHeight(200);

		BorderPane borderPane = new BorderPane();
		Scene scene = new Scene(borderPane, 400, 300);
		stage.setScene(scene);

		Button button_top    = new Button("top");
		Button button_center = new Button("center");
		Button button_bottom = new Button("bottom");
		Button button_left   = new Button("left");
		Button button_right  = new Button("right");

		button_top.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE); // w, h
		button_center.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		button_bottom.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		button_left.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		button_right.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

		borderPane.setTop(button_top);
		borderPane.setCenter(button_center);
		borderPane.setBottom(button_bottom);
		borderPane.setLeft(button_left);
		borderPane.setRight(button_right);

		borderPane.setPadding(new Insets(5, 5, 5, 5)); // top, right, bottom, left
		BorderPane.setAlignment(button_top,    Pos.CENTER);
		BorderPane.setAlignment(button_center, Pos.CENTER);
		BorderPane.setAlignment(button_bottom, Pos.CENTER);
		BorderPane.setAlignment(button_left,   Pos.CENTER);
		BorderPane.setAlignment(button_right,  Pos.CENTER);

		BorderPane.setMargin(button_top, new Insets(10, 0, 10, 0));
		BorderPane.setMargin(button_bottom, new Insets(10, 10, 10, 10));

		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
