package gui.util;

import javafx.scene.control.TextField;

public class Constraints {

	public static void setTextFieldSalario(TextField txt) {
		txt.textProperty().addListener((obs, oldValue, newValue) -> {
			if (newValue != null && (!newValue.matches("\\d*([\\.]\\d*)?") || newValue.length() > 7)) {
				txt.setText(oldValue);
			}
		});
	}

	public static void setTextField(TextField txt) {
		txt.textProperty().addListener((obs, oldValue, newValue) -> {
			if (newValue == null || newValue.isEmpty()) {
				return;
			}
			if (!newValue.matches("\\d*([\\.]\\d*)?") || newValue.length() > 3) {
				txt.setText(oldValue);
			}
		});
	}
}