package slanitsch.ue09.GUIII;
//final
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class PopUpFx {

	public static void print(String message) {
		 showMessageDialog(null, message);
    }

    public static void print(Stage parentStage, String message) {
    	showMessageDialog(parentStage, message);
    }

    public static boolean confirm(String question) {
    	return showConfirmDialog(null, question);
    }

    public static boolean confirm(Stage parentStage, String question) {
    	return showConfirmDialog(parentStage, question);
    }

    public static String readLine(String prompt) {
        return readLine(null, prompt);
    }

    public static String readLine(Stage parentStage, String prompt) {
    	return showInputDialog(parentStage, prompt);
    }

    public static String readWord(String prompt) {
        return readWord(null, prompt);
    }

    public static String readWord(Stage parentStage, String prompt) {
        //return readLine(parentStage, prompt).split("[\\W&&[^צה�ײ�ִ�]]")[0];
          return readLine(parentStage, prompt).replaceAll("[\\p{Punct}\\s]+", " ").trim().split(" ")[0];
    }

    public static int readInt(String prompt) {
    	return readInt(null, prompt);
    }

    public static int readInt(Stage parentStage, String prompt) {
    	String s = readLine(parentStage, prompt);
       	while (true) {
    		try {
    			return s.isEmpty() ? 0 : Integer.parseInt(s);
    		}
    		catch (NumberFormatException e) {
    			s = readLine(parentStage, "\"" + s + "\" ist keine int-Zahl!\n\n" + prompt);
    		}
    	}
    }

    public static long readLong(String prompt) {
    	return readLong(null, prompt);
    }

    public static long readLong(Stage parentStage, String prompt) {
    	String s = readLine(parentStage, prompt);
       	while (true) {
    		try {
    			return s.isEmpty() ? 0L : Long.parseLong(s);
    		}
    		catch (NumberFormatException e) {
    			s = readLine(parentStage, "\"" + s + "\" ist keine long-Zahl!\n\n" + prompt);
    		}
    	}
    }

    public static float readFloat(String prompt) {
    	return readFloat(null, prompt);
    }

    public static float readFloat(Stage parentStage, String prompt) {
    	String s = readLine(parentStage, prompt);
       	while (true) {
    		try {
    			return s.isEmpty() ? 0F : Float.parseFloat(s);
    		}
    		catch (NumberFormatException e) {
    			s = readLine(parentStage, "\"" + s + "\" ist keine float-Zahl!\n\n" + prompt);
    		}
    	}
    }

    public static double readDouble(String prompt) {
    	return readDouble(null, prompt);
    }

    public static double readDouble(Stage parentStage, String prompt) {
    	String s = readLine(parentStage, prompt);
       	while (true) {
    		try {
    			return s.isEmpty() ? 0D : Double.parseDouble(s);
    		}
    		catch (NumberFormatException e) {
    			s = readLine(parentStage, "\"" + s + "\" ist keine double-Zahl!\n\n" + prompt);
    		}
    	}
    }

	private static String showInputDialog(Stage parentStage, String prompt) {
		Stage stage = new Stage();
        stage.setMinWidth(266);
        stage.setMinHeight(122);
		stage.setTitle("Eingabe");
		if (parentStage != null) {
			stage.initModality(Modality.WINDOW_MODAL);
			stage.initOwner(parentStage);
		}
		BorderPane borderPane = new BorderPane();
        stage.setScene(new Scene(borderPane));

        Label promptLabel = new Label(prompt);
        TextField textField = new TextField();
	    VBox vbox = new VBox();
		vbox.setPadding(new Insets(5, 10, 0, 10));
        vbox.setSpacing(4);
        vbox.setAlignment(Pos.CENTER_LEFT);
		vbox.getChildren().addAll(promptLabel, textField);
		borderPane.setTop(vbox);

		Button buttonOk     = new Button("OK");
		Button buttonCancel = new Button("Abbrechen");
		buttonOk.setPrefWidth(80);
		buttonCancel.setPrefWidth(80);
	    HBox hbox = new HBox();
		hbox.setPadding(new Insets(0, 10, 10, 10));
        hbox.setSpacing(6);
        hbox.setAlignment(Pos.TOP_CENTER);
		hbox.getChildren().addAll(buttonOk, buttonCancel);
		borderPane.setBottom(hbox);

        SimpleStringProperty entry = new SimpleStringProperty();
        entry.bind((ObservableValue<String>)textField.textProperty());
        textField.setOnAction(e -> stage.close());
        buttonOk.setOnAction(e -> stage.close());
        buttonCancel.setOnAction(e -> { textField.setText(""); stage.close(); });
        stage.setOnCloseRequest(e ->  { textField.setText(""); stage.close(); });

        stage.setResizable(false);
        stage.showAndWait();
        return entry.getValue();
	}

	private static void showMessageDialog(Stage parentStage, String message) {
		Stage stage = new Stage();
		stage.setMinWidth(268);
		stage.setMinHeight(116);
		stage.setTitle("Ausgabe");
		if (parentStage != null) {
			stage.initModality(Modality.WINDOW_MODAL);
			stage.initOwner(parentStage);
		}
		BorderPane borderPane = new BorderPane();
        stage.setScene(new Scene(borderPane));
 
        Label promptLabel = new Label(message);
        BorderPane.setMargin(promptLabel, new Insets(18, 10, 0, 10));
        BorderPane.setAlignment(promptLabel, Pos.CENTER_LEFT);
        borderPane.setTop(promptLabel);

		Button buttonOk = new Button("OK");
		buttonOk.setPrefWidth(70);
        BorderPane.setMargin(buttonOk, new Insets(0, 10, 10, 10));
        BorderPane.setAlignment(buttonOk, Pos.TOP_CENTER);
        borderPane.setBottom(buttonOk);		

        buttonOk.setOnAction(e -> stage.close());
        stage.setOnCloseRequest(e -> stage.close());

        stage.setResizable(false);
        stage.showAndWait();
        return;
	}

	private static boolean showConfirmDialog(Stage parentStage, String question) {
		Stage stage = new Stage();
        stage.setMinWidth(268);
        stage.setMinHeight(116);
		stage.setTitle("Frage");
		if (parentStage != null) {
			stage.initModality(Modality.WINDOW_MODAL);
			stage.initOwner(parentStage);
		}
		BorderPane borderPane = new BorderPane();
        stage.setScene(new Scene(borderPane));

        Label promptLabel = new Label(question);
        BorderPane.setMargin(promptLabel, new Insets(18, 10, 0, 10));
        BorderPane.setAlignment(promptLabel, Pos.CENTER_LEFT);
        borderPane.setTop(promptLabel);
        
		Button buttonOk     = new Button("Ja");
		Button buttonCancel = new Button("Nein");
		buttonOk.setPrefWidth(70);
		buttonCancel.setPrefWidth(70);
	    HBox hbox = new HBox();
		hbox.setPadding(new Insets(0, 10, 10, 10));
        hbox.setSpacing(6);
        hbox.setAlignment(Pos.TOP_CENTER);
		hbox.getChildren().addAll(buttonOk, buttonCancel);
		borderPane.setBottom(hbox);

		SimpleBooleanProperty state = new SimpleBooleanProperty();
        buttonOk.setOnAction(e -> { state.set(true); stage.close(); });
        buttonCancel.setOnAction(e -> { state.set(false); stage.close(); });
        stage.setOnCloseRequest(e ->  { state.set(false); stage.close(); });

        stage.setResizable(false);
        stage.showAndWait();
        return state.getValue();
	}
}
