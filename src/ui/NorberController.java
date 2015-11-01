package ui;

import java.util.ArrayList;
import java.util.List;

import estado.Edad;
import estado.Estado;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

public class NorberController implements Initializable {
	
	private Estado estado;
	private int showingPane = 0;
	
	public ScrollPane mainScrollPane;
	public AnchorPane rootAnchor;
	public VBox scenePane;
	public VBox personalBackgroundPane;
	public VBox woundsPane;
	
	
	@Override
	public void initialize(java.net.URL location, java.util.ResourceBundle resources) {
		System.out.println("Inicializando a Norber...");
		System.out.println(mainScrollPane.getId());;
		mainScrollPane.setHbarPolicy(ScrollBarPolicy.NEVER);
	}
	
	private void slideLeft() {
		TranslateTransition slideForScenePane = new TranslateTransition(Duration.seconds(1), scenePane);
		TranslateTransition slideForPersonalBackgroundPane = new TranslateTransition(Duration.seconds(1), personalBackgroundPane);
		TranslateTransition slideForWoundsPane = new TranslateTransition(Duration.seconds(1), woundsPane);
		
		// if on last pane do nothing
		if(showingPane == 2) {
			return;
		}
		
		if(showingPane == 0) {
			// show pane 1
			slideForScenePane.setFromX(0);
			slideForScenePane.setToX(-(rootAnchor.getWidth()));
			slideForPersonalBackgroundPane.setFromX(rootAnchor.getWidth());
			slideForPersonalBackgroundPane.setToX(0);
			slideForScenePane.play();
			slideForPersonalBackgroundPane.play();
			this.showingPane = 1;
		} else if(showingPane == 1) {
			// show pane 2
			slideForPersonalBackgroundPane.setFromX(0);
			slideForPersonalBackgroundPane.setToX(-(rootAnchor.getWidth()));
			slideForWoundsPane.setFromX(rootAnchor.getWidth());
			slideForWoundsPane.setToX(0);
			slideForPersonalBackgroundPane.play();
			slideForWoundsPane.play();
			this.showingPane = 2;
		}
		
		/*
		tt.setFromX( -(logoImage.getFitWidth()) );
		tt.setToX( rootPane.getPrefWidth() );
		tt.setCycleCount( Timeline.INDEFINITE );
		tt.play();
		*/
	}
	
	private void slideRight() {
		TranslateTransition slideForScenePane = new TranslateTransition(Duration.seconds(1), scenePane);
		TranslateTransition slideForPersonalBackgroundPane = new TranslateTransition(Duration.seconds(1), personalBackgroundPane);
		TranslateTransition slideForWoundsPane = new TranslateTransition(Duration.seconds(1), woundsPane);
		
		// if on last pane do nothing
		if(showingPane == 0) {
			return;
		}
		
		if(showingPane == 2) {
			// show pane 1
			slideForWoundsPane.setFromX(0);
			slideForWoundsPane.setToX(rootAnchor.getWidth());
			slideForPersonalBackgroundPane.setFromX(-(rootAnchor.getWidth()));
			slideForPersonalBackgroundPane.setToX(0);
			slideForWoundsPane.play();
			slideForPersonalBackgroundPane.play();
			this.showingPane = 1;
		} else if(showingPane == 1) {
			// show pane 0
			slideForPersonalBackgroundPane.setFromX(0);
			slideForPersonalBackgroundPane.setToX(rootAnchor.getWidth());
			slideForScenePane.setFromX(-(rootAnchor.getWidth()));
			slideForScenePane.setToX(0);
			slideForPersonalBackgroundPane.play();
			slideForScenePane.play();
			this.showingPane = 0;
		}
	}
	
	@FXML
	private void next() {
		this.slideLeft();
	}
	
	@FXML
	private void previous() {
		this.slideRight();
	}

}
