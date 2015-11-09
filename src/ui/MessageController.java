package ui;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class MessageController implements Initializable {
	
	@FXML
	public AnchorPane anchor;
	@FXML
	public Label messageLabel;

	@Override
	public void initialize(java.net.URL location, java.util.ResourceBundle resources) {
		
	}
	
	public void initData(String message) {
		messageLabel.setText(message);
	}
}
