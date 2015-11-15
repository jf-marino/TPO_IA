package ui;

import java.util.List;
import java.util.Set;

import javax.swing.GroupLayout.Alignment;

import integracion.AppState;
import integracion.ClipsHandler;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;
import utils.NumericField;

public class NorberController implements Initializable {
	
	private int showingPane = 0;
	
	private ClipsHandler clips = ClipsHandler.get();
	
	private int showLesionPane = -1;
	
	
	@FXML
	public ScrollPane mainScrollPane;
	@FXML
	public AnchorPane rootAnchor;
	@FXML
	public VBox scenePane;
	@FXML
	public VBox personalBackgroundPane;
	@FXML
	public VBox woundsPane;
	@FXML
	public VBox airwayPane;
	@FXML
	public VBox bleedingPane;
	@FXML
	public VBox burnPane;
	@FXML
	public VBox musclePane;
	
	/**
	 * Previous and next pane buttons
	 */
	@FXML
	public Button nextPaneButton;
	
	/**
	 * UI Controls
	 */
	
	@FXML
	public ChoiceBox<String> afeccionPartesOseasChoice;
	@FXML
	public ChoiceBox<String> obstruccionViaAereaChoice;
	@FXML
	public CheckBox diabetesCheck;
	@FXML
	public CheckBox amputacionSangradoCheck;
	@FXML
	public ChoiceBox<String> afeccionPartesBlandasChoice;
	@FXML
	public ChoiceBox<String> tipoSangradoChoice;
	@FXML
	public CheckBox objetoExtranioSangradoCheck;
	@FXML
	public ChoiceBox<String> medicacionConvulsionChoice;
	@FXML
	public ChoiceBox<String> estadoViaAereaChoice;
	@FXML
	public TextField duracionConvulsionNumericField;
	@FXML
	public CheckBox epilepsiaCheck;
	@FXML
	public ChoiceBox<String> claseLesionOsteoMuscularChoice;
	@FXML
	public ChoiceBox<String> concienciaChoice;
	@FXML
	public CheckBox crisisDiabeticaCheck;
	@FXML
	public ChoiceBox<String> tipoSintomaChoice;
	@FXML
	public CheckBox tejidoNecrosoCheck;
	@FXML
	public ChoiceBox<String> zonaLesionOsteoMuscularChoice;
	@FXML
	public ChoiceBox<String> tamanioQuemaduraChoice;
	@FXML
	public ChoiceBox<String> claseHeridaSangradoChoice;
	@FXML
	public ChoiceBox<String> profundidadQuemaduraChoice;
	@FXML
	public ChoiceBox<String> estadoConvulsionChoice;
	@FXML
	public CheckBox fiebreConvulsionCheck;
	@FXML
	public CheckBox epilepsiaConvulsionCheck;
	@FXML
	public CheckBox comioCheck;
	@FXML
	public ChoiceBox<String> profundidadSangradoChoice;
	@FXML
	public ChoiceBox<String> accesoAVictimaChoice;
	@FXML
	public ChoiceBox<String> deaChoice;
	@FXML
	public ChoiceBox<String> ubicacionSintomaChoice;
	@FXML
	public ChoiceBox<String> dolorQuemaduraChoice;
	@FXML
	public ChoiceBox<String> zonaSangradoChoice;
	@FXML
	public CheckBox inflamacionCheck;
	@FXML
	public CheckBox curiosoPresenteCheck;
	@FXML
	public ChoiceBox<String> respiracionChoice;
	@FXML
	public ChoiceBox<String> seguridadChoice;
	@FXML
	public ChoiceBox<String> tipoQuemaduraChoice;
	@FXML
	public ChoiceBox<String> tamanioSangradoChoice;
	@FXML
	public ChoiceBox<String> temperaturaChoice;
	@FXML
	public CheckBox ciclicaConvulsionCheck;
	@FXML
	public ChoiceBox<String> zonaQuemaduraChoice;
	@FXML
	public ChoiceBox<String> insulinoDependienteChoice;
	@FXML
	public CheckBox cianosisCheck;
	@FXML
	public ChoiceBox<String> edadChoice;
	@FXML
	public TextField cantidadDeVictimasNumericField;
	
	
	/**
	 * Barra de estado
	 */
	@FXML
	public VBox estadoEscenaBox;
	@FXML
	public VBox estadoVictimaBox;
	@FXML
	public VBox estadoLesionBox;
	@FXML
	public VBox estadoViaAereaBox;
	@FXML
	public VBox estadoSangradoBox;
	@FXML
	public VBox estadoQuemadurasBox;
	@FXML
	public VBox estadoLesionOsteoMuscularBox;
	
	@FXML
	public VBox estadoEscenaContainer;
	@FXML
	public VBox estadoVictimaContainer;
	@FXML
	public VBox estadoLesionContainer;
	@FXML
	public VBox estadoViaAereaContainer;
	@FXML
	public VBox estadoSangradoContainer;
	@FXML
	public VBox estadoQuemadurasContainer;
	@FXML
	public VBox estadoLesionOsteoMuscularContainer;
	
	
	
	
	@Override
	public void initialize(java.net.URL location, java.util.ResourceBundle resources) {
		System.out.println("Inicializando a Norber...");
		mainScrollPane.setHbarPolicy(ScrollBarPolicy.NEVER);
		this.initializeValues();
		this.setDefaultValues();
	}
	
	private void animatePanesLeft(VBox currentPane, VBox nextPane) {
		TranslateTransition slideCurrent = new TranslateTransition(Duration.seconds(1), currentPane);
		TranslateTransition slideNext = new TranslateTransition(Duration.seconds(1), nextPane);
		
		slideCurrent.setOnFinished(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent arg0) {
            	currentPane.setVisible(false);
            }
        });
		
		slideCurrent.setFromX(0);
		slideCurrent.setToX(-(rootAnchor.getWidth()));
		slideNext.setFromX(rootAnchor.getWidth());
		slideNext.setToX(0);
		slideCurrent.play();
		slideNext.play();
		nextPane.setVisible(true);
	}
	
	private void animatePanesRight(VBox currentPane, VBox nextPane) {
		TranslateTransition slideCurrent = new TranslateTransition(Duration.seconds(1), currentPane);
		TranslateTransition slideNext = new TranslateTransition(Duration.seconds(1), nextPane);
		
		slideCurrent.setOnFinished(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent arg0) {
            	currentPane.setVisible(false);
            }
        });
		
		slideCurrent.setFromX(0);
		slideCurrent.setToX(rootAnchor.getWidth());
		slideNext.setFromX(-(rootAnchor.getWidth()));
		slideNext.setToX(0);
		slideCurrent.play();
		slideNext.play();
		nextPane.setVisible(true);
	}
	
	private void slideLeft() {
		Set<String> resultados;
		switch(showingPane) {
			case 0:
				this.armarEstadoEscena();
				this.setEstadoEscena();
				this.clips.runEscena();
				resultados = this.clips.resultadosEscena();
				this.openResultWindow("Procedimiento", resultados);
				// show pane 1
				animatePanesLeft(scenePane, personalBackgroundPane);
				this.showingPane = 1;
				break;
			case 1:
				this.armarEstadoVictima();
				this.setEstadoVictima();
				this.armarEstadoConvulsion();
				this.clips.runVictima();
				resultados = this.clips.resultadosVictima();
				this.openResultWindow("Diagnostico sobre la víctima", resultados);
				// show pane 2
				animatePanesLeft(personalBackgroundPane, woundsPane);
				this.showingPane = 2;
				break;
			case 2:
				int tipo = tipoSintomaChoice.getSelectionModel().getSelectedIndex();
				int ubicacion = ubicacionSintomaChoice.getSelectionModel().getSelectedIndex();
				this.showLesionPane = (tipo > 0) ? tipo : -1;
				if(tipo > 0) {
					this.armarEstadoLesion();
					this.clips.runLesion();
					resultados = this.clips.resultadosLesiones();
					this.openResultWindow("Diagnostico sobre la lesíon", resultados);
				} else {
					this.openMessageWindow("Debe haber una lesión para poder continuar...");
				}
				switch(this.showLesionPane) {
					case 1:
						this.setEstadoLesion();
						// show pane 3
						animatePanesLeft(woundsPane, airwayPane);
						this.showingPane = 3;
						nextPaneButton.setText("Finalizar");
						break;
					case 2:
						if(ubicacion > 0) {
							this.setEstadoLesion();
							// show pane 4
							animatePanesLeft(woundsPane, bleedingPane);
							this.showingPane = 4;
							nextPaneButton.setText("Finalizar");
						} else {
							this.openMessageWindow("¿Cual es la ubicación de la lesión corto-punzante?");
						}
						break;
					case 3:
						if(ubicacion > 0) {
							this.setEstadoLesion();
							// show pane 5
							animatePanesLeft(woundsPane, burnPane);
							this.showingPane = 5;
							nextPaneButton.setText("Finalizar");
						} else {
							this.openMessageWindow("¿Cual es la ubicación de la quemadura?");
						}
						break;
					case 4:
						if(ubicacion > 0) {
							this.setEstadoLesion();
							// show pane 6
							animatePanesLeft(woundsPane, musclePane);
							this.showingPane = 6;
							nextPaneButton.setText("Finalizar");
						} else {
							this.openMessageWindow("¿Cual es la ubicación de la lesión osteo-articular?");
						}
						break;
				}
				break;
			case 3:
				this.armarEstadoViaAerea();
				this.setEstadoViaAerea();
				this.clips.runViaAerea();
				resultados = this.clips.resultadosViaAerea();
				this.openResultWindow("Diagnostico sobre la vía aérea", resultados);
				break;
			case 4:
				this.armarEstadoSangrado();
				this.setEstadoSangrado();
				this.clips.runSangrado();
				resultados = this.clips.resultadosSangrado();
				this.openResultWindow("Diagnostico sobre el sangrado", resultados);
				break;
			case 5:
				this.armarEstadoQuemadura();
				this.setEstadoQuemaduras();
				this.clips.runQuemadura();
				resultados = this.clips.resultadosQuemaduras();
				this.openResultWindow("Diagnostico sobre quemaduras", resultados);
				break;
			case 6:
				this.armarEstadoLesionOsteoMuscular();
				this.setEstadoLesionOsteoMuscular();
				this.clips.runLesionOsteoMuscular();
				resultados = this.clips.resultadosLesionOsteoMuscular();
				this.openResultWindow("Diagnostico sobre lesiones osteo-musculares", resultados);
				break;
		}
	}
	
	private void slideRight() {
		switch(showingPane) {
			case 0:
				// if on first pane do nothing
				break;
			case 1:
				// show pane 0
				animatePanesRight(personalBackgroundPane, scenePane);
				this.showingPane = 0;
				break;
			case 2:
				// show pane 1
				animatePanesRight(woundsPane, personalBackgroundPane);
				this.showingPane = 1;
				break;
			case 3:
				// show pane 2
				animatePanesRight(airwayPane, woundsPane);
				this.showingPane = 2;
				this.showLesionPane = -1;
				break;
			case 4:
				// show pane 3
				animatePanesRight(bleedingPane, woundsPane);
				this.showingPane = 2;
				this.showLesionPane = -1;
				break;
			case 5:
				// show pane 4
				animatePanesRight(burnPane, woundsPane);
				this.showingPane = 2;
				this.showLesionPane = -1;
				break;
			case 6:
				// show pane 5
				animatePanesRight(musclePane, woundsPane);
				this.showingPane = 2;
				this.showLesionPane = -1;
				break;
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
	
	private void initializeValues() {
		afeccionPartesOseasChoice.setItems(FXCollections.observableArrayList("Fractura cerrada", "Fractura expuesta"));
		obstruccionViaAereaChoice.setItems(FXCollections.observableArrayList("Habla", "Tose", "No respira"));
		afeccionPartesBlandasChoice.setItems(FXCollections.observableArrayList("No", "Hematoma", "Inflamación"));
		tipoSangradoChoice.setItems(FXCollections.observableArrayList("Sin sangrado visible", "Sangrado lento (a gotas)", "Sangrado abundante", "Sangrado interno (moretón)"));
		medicacionConvulsionChoice.setItems(FXCollections.observableArrayList("No usa", "Tomo", "No tomo"));
		estadoViaAereaChoice.setItems(FXCollections.observableArrayList("No obstruida", "Semi-obstruida", "Obstruida"));
		claseLesionOsteoMuscularChoice.setItems(FXCollections.observableArrayList("Fractura", "Fisura", "Esguince", "Calambre", "Desgarro", "Torcedura"));
		concienciaChoice.setItems(FXCollections.observableArrayList("Alerta", "Responde a estimulo verbal", "Responde a estimulo doloroso", "Inconciente"));
		tipoSintomaChoice.setItems(FXCollections.observableArrayList("Ninguna", "Obstrucción de vía aérea", "Lesión corto-punzante", "Quemadura", "Lesión osteo-articular"));
		zonaLesionOsteoMuscularChoice.setItems(FXCollections.observableArrayList("No riesgosa", "Riesgosa"));
		tamanioQuemaduraChoice.setItems(FXCollections.observableArrayList("Pequeña", "Mediana", "Extensa"));
		claseHeridaSangradoChoice.setItems(FXCollections.observableArrayList("Raspadura", "Cortante", "Punzante", "Laceración", "Contunción", "Arma de fuego"));
		profundidadQuemaduraChoice.setItems(FXCollections.observableArrayList("Superficial", "Profunda"));
		estadoConvulsionChoice.setItems(FXCollections.observableArrayList("No", "Si", "Se detuvo"));
		profundidadSangradoChoice.setItems(FXCollections.observableArrayList("Superficial", "Moderado", "Profundo"));
		accesoAVictimaChoice.setItems(FXCollections.observableArrayList("Facil", "Dificil"));
		deaChoice.setItems(FXCollections.observableArrayList("No presente", "Presente cargado", "Presente descargado"));
		ubicacionSintomaChoice.setItems(FXCollections.observableArrayList("No tiene", "Piernas", "Brazos", "Torso", "Espalda", "Cabeza", "Manos o pies", "Genitales"));
		dolorQuemaduraChoice.setItems(FXCollections.observableArrayList("Indoloro", "Dolor leve", "Dolor grave", "Dolor moderado"));
		zonaSangradoChoice.setItems(FXCollections.observableArrayList("No riesgosa", "Riesgosa"));
		respiracionChoice.setItems(FXCollections.observableArrayList("Respira normal", "No respira", "Respira rapido", "Respira lento"));
		seguridadChoice.setItems(FXCollections.observableArrayList("Segura", "Peligro de derrumbe", "Olor extraño", "Tránsito", "Humo", "Fuego", "Otro"));
		tipoQuemaduraChoice.setItems(FXCollections.observableArrayList("Externa", "Interna"));
		tamanioSangradoChoice.setItems(FXCollections.observableArrayList("Pequeña", "Media", "Extensa"));
		temperaturaChoice.setItems(FXCollections.observableArrayList("Normal", "Hipotermia", "Hipertermia"));
		zonaQuemaduraChoice.setItems(FXCollections.observableArrayList("No riesgosa", "Riesgosa"));
		insulinoDependienteChoice.setItems(FXCollections.observableArrayList("No", "Si y se aplicó insulina", "Si y no se aplicó insulina"));
		edadChoice.setItems(FXCollections.observableArrayList("Adulto (mayor a 8 años)", "Bebé (0 a 12 meses)", "Niño (1 a 8 años)"));
	}
	
	private void setDefaultValues() {
		afeccionPartesOseasChoice.getSelectionModel().selectFirst();
		obstruccionViaAereaChoice.getSelectionModel().selectFirst();
		diabetesCheck.setSelected(false);
		amputacionSangradoCheck.setSelected(false);
		afeccionPartesBlandasChoice.getSelectionModel().selectFirst();
		tipoSangradoChoice.getSelectionModel().selectFirst();
		objetoExtranioSangradoCheck.setSelected(false);
		medicacionConvulsionChoice.getSelectionModel().selectFirst();
		estadoViaAereaChoice.getSelectionModel().selectFirst();
		duracionConvulsionNumericField.setText("0");
		epilepsiaCheck.setSelected(false);
		claseLesionOsteoMuscularChoice.getSelectionModel().selectFirst();
		concienciaChoice.getSelectionModel().selectFirst();
		crisisDiabeticaCheck.setSelected(false);
		tipoSintomaChoice.getSelectionModel().selectFirst();
		tejidoNecrosoCheck.setSelected(false);
		zonaLesionOsteoMuscularChoice.getSelectionModel().selectFirst();
		tamanioQuemaduraChoice.getSelectionModel().selectFirst();
		claseHeridaSangradoChoice.getSelectionModel().selectFirst();
		profundidadQuemaduraChoice.getSelectionModel().selectFirst();
		estadoConvulsionChoice.getSelectionModel().selectFirst();
		fiebreConvulsionCheck.setSelected(false);
		epilepsiaConvulsionCheck.setSelected(false);
		comioCheck.setSelected(false);
		profundidadSangradoChoice.getSelectionModel().selectFirst();
		accesoAVictimaChoice.getSelectionModel().selectFirst();
		deaChoice.getSelectionModel().selectFirst();
		ubicacionSintomaChoice.getSelectionModel().selectFirst();
		dolorQuemaduraChoice.getSelectionModel().selectFirst();
		zonaSangradoChoice.getSelectionModel().selectFirst();
		inflamacionCheck.setSelected(false);
		curiosoPresenteCheck.setSelected(false);
		respiracionChoice.getSelectionModel().selectFirst();
		seguridadChoice.getSelectionModel().selectFirst();
		tipoQuemaduraChoice.getSelectionModel().selectFirst();
		tamanioSangradoChoice.getSelectionModel().selectFirst();
		temperaturaChoice.getSelectionModel().selectFirst();
		ciclicaConvulsionCheck.setSelected(false);
		zonaQuemaduraChoice.getSelectionModel().selectFirst();
		insulinoDependienteChoice.getSelectionModel().selectFirst();
		cianosisCheck.setSelected(false);
		edadChoice.getSelectionModel().selectFirst();
		cantidadDeVictimasNumericField.setText("1");
	}
	
	private int $(CheckBox box) {
		return box.isSelected() ? 0:1;
	}
	
	private void armarEstadoEscena() {
		AppState state = AppState.get();
		state.cantidadDeVictimas = Integer.parseInt(this.cantidadDeVictimasNumericField.getText());
		state.curiosoPresente = $(this.curiosoPresenteCheck);
		state.seguridad = this.seguridadChoice.getSelectionModel().getSelectedIndex();
		state.accesoVictima = this.accesoAVictimaChoice.getSelectionModel().getSelectedIndex();
		state.dea = this.deaChoice.getSelectionModel().getSelectedIndex();
	}
	
	private void armarEstadoVictima() {
		AppState state = AppState.get();
		state.edad = this.edadChoice.getSelectionModel().getSelectedIndex();
		state.conciencia = this.concienciaChoice.getSelectionModel().getSelectedIndex();
		state.respiracion = this.respiracionChoice.getSelectionModel().getSelectedIndex();
		state.temperatura = this.temperaturaChoice.getSelectionModel().getSelectedIndex();
		state.epilepsia = $(this.epilepsiaCheck);
		state.obstruccionViaAerea = this.obstruccionViaAereaChoice.getSelectionModel().getSelectedIndex();
		state.comio = $(this.comioCheck);
		state.diabetes = $(this.diabetesCheck);
		state.insulinoDependiente = this.insulinoDependienteChoice.getSelectionModel().getSelectedIndex();
		state.crisisDiabetica = $(this.crisisDiabeticaCheck);
	}
	
	private void armarEstadoLesion() {
		AppState state = AppState.get();
		state.tipoSintoma = this.tipoSintomaChoice.getSelectionModel().getSelectedIndex();
		state.ubicacionSintoma = this.ubicacionSintomaChoice.getSelectionModel().getSelectedIndex();
	}
	
	private void armarEstadoQuemadura() {
		AppState state = AppState.get();
		state.profundidadQuemadura = this.profundidadQuemaduraChoice.getSelectionModel().getSelectedIndex();
		state.tejidoNecroso = $(this.tejidoNecrosoCheck);
		state.dolorQuemadura = this.dolorQuemaduraChoice.getSelectionModel().getSelectedIndex();
		state.inflamacion = $(this.inflamacionCheck);
		state.tamanioQuemadura = this.tamanioQuemaduraChoice.getSelectionModel().getSelectedIndex();
		state.tipoQuemadura = this.tipoQuemaduraChoice.getSelectionModel().getSelectedIndex();
		state.zonaQuemadura = this.zonaQuemaduraChoice.getSelectionModel().getSelectedIndex();
	}
	
	private void armarEstadoLesionOsteoMuscular() {
		AppState state = AppState.get();
		state.claseLesionOsteoMuscular = this.claseLesionOsteoMuscularChoice.getSelectionModel().getSelectedIndex();
		state.afeccionPartesBlandas = this.afeccionPartesBlandasChoice.getSelectionModel().getSelectedIndex();
		state.afeccionPartesOseas = this.afeccionPartesOseasChoice.getSelectionModel().getSelectedIndex();
		state.zonaLesionOsteoMuscular = this.zonaLesionOsteoMuscularChoice.getSelectionModel().getSelectedIndex();
	}
	
	private void armarEstadoViaAerea() {
		AppState state = AppState.get();
		state.estadoViaAerea = this.estadoViaAereaChoice.getSelectionModel().getSelectedIndex();
		state.cianosis = $(this.cianosisCheck);
	}
	
	private void armarEstadoSangrado() {
		AppState state = AppState.get();
		state.claseHeridaSangrado = this.claseHeridaSangradoChoice.getSelectionModel().getSelectedIndex();
		state.profundidadSangrado = this.profundidadSangradoChoice.getSelectionModel().getSelectedIndex();
		state.objetoExtranioSangrado = $(this.objetoExtranioSangradoCheck);
		state.tamanioSangrado = this.tamanioSangradoChoice.getSelectionModel().getSelectedIndex();
		state.amputacionSangrado = $(this.amputacionSangradoCheck);
		state.tipoSangrado = this.tipoSangradoChoice.getSelectionModel().getSelectedIndex();
		state.zonaSangrado = this.zonaSangradoChoice.getSelectionModel().getSelectedIndex();
	}
	
	private void armarEstadoConvulsion() {
		AppState state = AppState.get();
		state.estadoConvulsion = this.estadoConvulsionChoice.getSelectionModel().getSelectedIndex();
		state.epilepsiaConvulsion = $(this.epilepsiaConvulsionCheck);
		state.duracionConvulsion = Integer.parseInt(this.duracionConvulsionNumericField.getText());
		state.ciclicaConvulsion = $(this.ciclicaConvulsionCheck);
		state.medicacionConvulsion = this.medicacionConvulsionChoice.getSelectionModel().getSelectedIndex();
		state.fiebreConvulsion = $(this.fiebreConvulsionCheck);
	}
	
	private void openResultWindow(String title, Set<String> resultados) {
		if(resultados.size() > 0) {
			try{
	          FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("results.fxml"));
	          Parent root1 = (Parent) fxmlLoader.load();
	          Stage stage = new Stage();
	          stage.initModality(Modality.APPLICATION_MODAL);
	          stage.setTitle(title);
	          stage.setScene(new Scene(root1));
	          stage.show();
	          
	          ResultsController controller = fxmlLoader.<ResultsController>getController();
	          controller.initData(resultados);
	        } catch(Exception e) {
	       	  e.printStackTrace();
	        }
		}
	}
	
	private void openMessageWindow(String message) {
		try{
	      FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("message.fxml"));
	      Parent root1 = (Parent) fxmlLoader.load();
	      Stage stage = new Stage();
	      stage.initModality(Modality.APPLICATION_MODAL);
	      stage.setTitle("Información");
	      stage.setScene(new Scene(root1));
	      stage.show();
	      
	      MessageController controller = fxmlLoader.<MessageController>getController();
	      controller.initData(message);
	    } catch(Exception e) {
	      e.printStackTrace();
	    }
	}
	
	
	@FXML
	private void reset() {
		this.clips.reset();
		AppState state = AppState.get();
		state.reset();
		this.setDefaultValues();
		
		this.resetEstadoEscena();
		this.resetEstadoVictima();
		this.resetEstadoLesion();
		this.resetEstadoViaAerea();
		this.resetEstadoSangrado();
		this.resetEstadoQuemaduras();
		this.resetEstadoLesionOsteoMuscular();
		
		nextPaneButton.setText("Siguiente");
		switch(this.showingPane) {
			case 0: break;
			case 1:
				this.animatePanesRight(personalBackgroundPane, scenePane);
				break;
			case 2:
				this.animatePanesRight(woundsPane, scenePane);
				break;
			case 3:
				this.animatePanesRight(airwayPane, scenePane);
				break;
			case 4:
				this.animatePanesRight(bleedingPane, scenePane);
				break;
			case 5:
				this.animatePanesRight(burnPane, scenePane);
				break;
			case 6:
				this.animatePanesRight(musclePane, scenePane);
				break;
		}
		
		this.showingPane = 0;
		this.showLesionPane = -1;
	}
	
	/**
	 * Barra de estado
	 */
	private String _(CheckBox box) {
		return box.isSelected() ? "Si" : "No";
	}
	
	private void addStateField(String label, String state, VBox container) {
		Label title = new Label(label);
		Label value = new Label(state);
		title.setStyle("-fx-font-fill: #b3b3b3;");
		value.setStyle("-fx-font-weight: bold;");
		title.setUnderline(true);
		title.setPadding(new Insets(5.0));
		value.setPadding(new Insets(5.0));
		container.getChildren().add(title);
		container.getChildren().add(value);
	}
	
	private void setEstadoEscena() {
		estadoEscenaContainer.getChildren().clear();
		
		String cantidadDeVictimas = this.cantidadDeVictimasNumericField.getText();
		String curiosoPresente = _(this.curiosoPresenteCheck);
		String seguridad = this.seguridadChoice.getSelectionModel().getSelectedItem();
		String accesoVictima = this.accesoAVictimaChoice.getSelectionModel().getSelectedItem();
		String dea = this.deaChoice.getSelectionModel().getSelectedItem();
		
		this.addStateField("Cantidad de víctimas", cantidadDeVictimas, estadoEscenaContainer);
		this.addStateField("Curioso presente", curiosoPresente, estadoEscenaContainer);
		this.addStateField("Seguridad", seguridad, estadoEscenaContainer);
		this.addStateField("Acceso a la víctima", accesoVictima, estadoEscenaContainer);
		this.addStateField("DEA", dea, estadoEscenaContainer);
		
		estadoEscenaBox.setVisible(true);
	}
	
	private void resetEstadoEscena() {
		estadoEscenaBox.setVisible(false);
	}
	
	private void setEstadoVictima() {
		estadoVictimaContainer.getChildren().clear();
		
		String edad = this.edadChoice.getSelectionModel().getSelectedItem();
		String conciencia = this.concienciaChoice.getSelectionModel().getSelectedItem();
		String respiracion = this.respiracionChoice.getSelectionModel().getSelectedItem();
		String temperatura = this.temperaturaChoice.getSelectionModel().getSelectedItem();
		String epilepsia = _(this.epilepsiaCheck);
		String obstruccionViaAerea = this.obstruccionViaAereaChoice.getSelectionModel().getSelectedItem();
		String comio = _(this.comioCheck);
		String diabetes = _(this.diabetesCheck);
		String insulinoDependiente = this.insulinoDependienteChoice.getSelectionModel().getSelectedItem();
		String crisisDiabetica = _(this.crisisDiabeticaCheck);
		String estadoConvulsion = this.estadoConvulsionChoice.getSelectionModel().getSelectedItem();
		String epilepsiaConvulsion = _(this.epilepsiaConvulsionCheck);
		String duracionConvulsion = this.duracionConvulsionNumericField.getText();
		String ciclicaConvulsion = _(this.ciclicaConvulsionCheck);
		String medicacionConvulsion = this.medicacionConvulsionChoice.getSelectionModel().getSelectedItem();
		String fiebreConvulsion = _(this.fiebreConvulsionCheck);
		
		this.addStateField("Edad", edad, estadoVictimaContainer);
		this.addStateField("Conciencia", conciencia, estadoVictimaContainer);
		this.addStateField("Respiración", respiracion, estadoVictimaContainer);
		this.addStateField("Temperatura", temperatura, estadoVictimaContainer);
		this.addStateField("Epilepsia", epilepsia, estadoVictimaContainer);
		this.addStateField("Obstrucción de la vía aérea", obstruccionViaAerea, estadoVictimaContainer);
		this.addStateField("Comió", comio, estadoVictimaContainer);
		this.addStateField("Diabetes", diabetes, estadoVictimaContainer);
		this.addStateField("Insulino dependiente", insulinoDependiente, estadoVictimaContainer);
		this.addStateField("Crisis diabetica", crisisDiabetica, estadoVictimaContainer);
		this.addStateField("Estado de la convulsión", estadoConvulsion, estadoVictimaContainer);
		this.addStateField("Epilepsia", epilepsiaConvulsion, estadoVictimaContainer);
		this.addStateField("Duración", duracionConvulsion, estadoVictimaContainer);
		this.addStateField("Cíclica", ciclicaConvulsion, estadoVictimaContainer);
		this.addStateField("Medicación", medicacionConvulsion, estadoVictimaContainer);
		this.addStateField("Fibre", fiebreConvulsion, estadoVictimaContainer);
		
		estadoVictimaBox.setVisible(true);
	}
	
	private void resetEstadoVictima() {
		estadoVictimaBox.setVisible(false);
	}
	
	private void setEstadoLesion() {
		estadoLesionContainer.getChildren().clear();
		
		String tipoSintoma = this.tipoSintomaChoice.getSelectionModel().getSelectedItem();
		String ubicacionSintoma = this.ubicacionSintomaChoice.getSelectionModel().getSelectedItem();
		
		this.addStateField("Tipo", tipoSintoma, estadoLesionContainer);
		this.addStateField("Ubicación", ubicacionSintoma, estadoLesionContainer);
		
		estadoLesionBox.setVisible(true);
	}
	
	private void resetEstadoLesion() {
		estadoLesionBox.setVisible(false);
	}
	
	private void setEstadoViaAerea() {
		estadoViaAereaContainer.getChildren().clear();
		
		String estadoViaAerea = this.estadoViaAereaChoice.getSelectionModel().getSelectedItem();
		String cianosis = _(this.cianosisCheck);
		
		this.addStateField("Estado de la vía aérea", estadoViaAerea, estadoViaAereaContainer);
		this.addStateField("Cianósis", cianosis, estadoViaAereaContainer);
		
		estadoViaAereaBox.setVisible(true);
	}
	
	private void resetEstadoViaAerea() {
		estadoViaAereaBox.setVisible(false);
	}
	
	private void setEstadoSangrado() {
		estadoSangradoContainer.getChildren().clear();
		
		String claseHeridaSangrado = this.claseHeridaSangradoChoice.getSelectionModel().getSelectedItem();
		String profundidadSangrado = this.profundidadSangradoChoice.getSelectionModel().getSelectedItem();
		String objetoExtranioSangrado = _(this.objetoExtranioSangradoCheck);
		String tamanioSangrado = this.tamanioSangradoChoice.getSelectionModel().getSelectedItem();
		String amputacionSangrado = _(this.amputacionSangradoCheck);
		String tipoSangrado = this.tipoSangradoChoice.getSelectionModel().getSelectedItem();
		
		this.addStateField("Clase de herida", claseHeridaSangrado, estadoSangradoContainer);
		this.addStateField("Profundidad", profundidadSangrado, estadoSangradoContainer);
		this.addStateField("Objeto extraño", objetoExtranioSangrado, estadoSangradoContainer);
		this.addStateField("Tamaño", tamanioSangrado, estadoSangradoContainer);
		this.addStateField("Amputación", amputacionSangrado, estadoSangradoContainer);
		this.addStateField("Tipo de sangrado", tipoSangrado, estadoSangradoContainer);
		
		estadoSangradoBox.setVisible(true);
	}
	
	private void resetEstadoSangrado() {
		estadoSangradoBox.setVisible(false);
	}
	
	private void setEstadoQuemaduras() {
		estadoQuemadurasContainer.getChildren().clear();
		
		String profundidadQuemadura = this.profundidadQuemaduraChoice.getSelectionModel().getSelectedItem();
		String tejidoNecroso = _(this.tejidoNecrosoCheck);
		String dolorQuemadura = this.dolorQuemaduraChoice.getSelectionModel().getSelectedItem();
		String inflamacion = _(this.inflamacionCheck);
		String tamanioQuemadura = this.tamanioQuemaduraChoice.getSelectionModel().getSelectedItem();
		String tipoQuemadura = this.tipoQuemaduraChoice.getSelectionModel().getSelectedItem();
		
		this.addStateField("Profundidad", profundidadQuemadura, estadoQuemadurasContainer);
		this.addStateField("Tejido necroso", tejidoNecroso, estadoQuemadurasContainer);
		this.addStateField("Dolor", dolorQuemadura, estadoQuemadurasContainer);
		this.addStateField("Inflamación", inflamacion, estadoQuemadurasContainer);
		this.addStateField("Tamaño", tamanioQuemadura, estadoQuemadurasContainer);
		this.addStateField("Tipo", tipoQuemadura, estadoQuemadurasContainer);
		
		estadoQuemadurasBox.setVisible(true);
	}
	
	private void resetEstadoQuemaduras() {
		estadoQuemadurasBox.setVisible(false);
	}
	
	private void setEstadoLesionOsteoMuscular() {
		estadoLesionOsteoMuscularContainer.getChildren().clear();
		
		String claseLesionOsteoMuscular = this.claseLesionOsteoMuscularChoice.getSelectionModel().getSelectedItem();
		String afeccionPartesBlandas = this.afeccionPartesBlandasChoice.getSelectionModel().getSelectedItem();
		String afeccionPartesOseas = this.afeccionPartesOseasChoice.getSelectionModel().getSelectedItem();
		
		this.addStateField("Clase de lesión osteo-muscular", claseLesionOsteoMuscular, estadoLesionOsteoMuscularContainer);
		this.addStateField("Afección de las partes blandas", afeccionPartesBlandas, estadoLesionOsteoMuscularContainer);
		this.addStateField("Afección de las partes oseas", afeccionPartesOseas, estadoLesionOsteoMuscularContainer);
				
		estadoLesionOsteoMuscularBox.setVisible(true);
	}
	
	private void resetEstadoLesionOsteoMuscular() {
		estadoLesionOsteoMuscularBox.setVisible(false);
	}

}
