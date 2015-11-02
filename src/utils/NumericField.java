package utils;

import javafx.scene.control.TextField;

public class NumericField extends TextField {

	
	public NumericField() {
		this.setPromptText("Números enteros...");
	}
	
	@Override
	public void replaceText(int i, int il, String string) {
		if(string.matches("[0-9]") || string.isEmpty()) {
			super.replaceText(i, il, string);
		}
	}
	
	@Override
	public void replaceSelection(String string) {
		super.replaceSelection(string);
	}
}
