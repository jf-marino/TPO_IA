package ui;

import java.util.List;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class ResultsController  implements Initializable {

	@FXML
	public VBox resultsVBox; 
	
	@Override
	public void initialize(java.net.URL location, java.util.ResourceBundle resources) {
		
	}
	
	public void initData(List<String> resultados) {
		for(String resultado : resultados) {
			// Agregar labels
			Label r = new Label(resultado);
			resultsVBox.getChildren().add(r);
		}
	}
}
