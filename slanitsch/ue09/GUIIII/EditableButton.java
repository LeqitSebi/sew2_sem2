package slanitsch.ue09.GUIIII;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import static slanitsch.ue09.GUIIII.Wort_Raten_1.get_to_solve;

class EditableButton extends Button {
    TextField tf = new TextField();
    public EditableButton(String right_letter) {
        setText("?");
        setOnMouseClicked(e -> {
            tf.setText(getText());
            setText(right_letter);
            get_to_solve++;
        });
    }
}
