package ui;

import java.util.List;

import integracion.AppState;
import integracion.ClipsHandler;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;
import utils.NumericField;

public class NorberController implements Initializable {
	
	private int showingPane = 0;
	
	private ClipsHandler clips = ClipsHandler.get();
	
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
	
	/**
	 * UI Controls
	 */
	
	@FXML
	public ChoiceBox afeccionPartesOseasChoice;
	@FXML
	public ChoiceBox obstruccionViaAereaChoice;
	@FXML
	public CheckBox diabetesCheck;
	@FXML
	public CheckBox amputacionSangradoCheck;
	@FXML
	public ChoiceBox afeccionPartesBlandasChoice;
	@FXML
	public ChoiceBox tipoSangradoChoice;
	@FXML
	public CheckBox objetoExtranioSangradoCheck;
	@FXML
	public ChoiceBox medicacionConvulsionChoice;
	@FXML
	public ChoiceBox estadoViaAereaChoice;
	@FXML
	public NumericField duracionConvulsionNumericField;
	@FXML
	public CheckBox epilepsiaCheck;
	@FXML
	public ChoiceBox posicionChoice;
	@FXML
	public ChoiceBox claseLesionOsteoMuscularChoice;
	@FXML
	public ChoiceBox concienciaChoice;
	@FXML
	public CheckBox crisisDiabeticaCheck;
	@FXML
	public ChoiceBox tipoSintomaChoice;
	@FXML
	public CheckBox tejidoNecrosoCheck;
	@FXML
	public ChoiceBox zonaLesionOsteoMuscularChoice;
	@FXML
	public ChoiceBox tamanioQuemaduraChoice;
	@FXML
	public ChoiceBox claseHeridaSangradoChoice;
	@FXML
	public ChoiceBox profundidadQuemaduraChoice;
	@FXML
	public ChoiceBox estadoConvulsionChoice;
	@FXML
	public CheckBox fiebreConvulsionCheck;
	@FXML
	public CheckBox epilepsiaConvulsionCheck;
	@FXML
	public CheckBox comioCheck;
	@FXML
	public ChoiceBox profundidadSangradoChoice;
	@FXML
	public ChoiceBox accesoAVictimaChoice;
	@FXML
	public ChoiceBox deaChoice;
	@FXML
	public ChoiceBox ubicacionSintomaChoice;
	@FXML
	public ChoiceBox dolorQuemaduraChoice;
	@FXML
	public ChoiceBox zonaSangradoChoice;
	@FXML
	public CheckBox inflamacionCheck;
	@FXML
	public CheckBox curiosoPresenteCheck;
	@FXML
	public ChoiceBox respiracionChoice;
	@FXML
	public ChoiceBox seguridadChoice;
	@FXML
	public ChoiceBox tipoQuemaduraChoice;
	@FXML
	public ChoiceBox tamanioSangradoChoice;
	@FXML
	public ChoiceBox temperaturaChoice;
	@FXML
	public CheckBox ciclicaConvulsionCheck;
	@FXML
	public ChoiceBox zonaQuemaduraChoice;
	@FXML
	public ChoiceBox insulinoDependienteChoice;
	@FXML
	public CheckBox cianosisCheck;
	@FXML
	public ChoiceBox edadChoice;
	@FXML
	public NumericField cantidadDeVictimasNumericField;
	
	
	
	
	@Override
	public void initialize(java.net.URL location, java.util.ResourceBundle resources) {
		System.out.println("Inicializando a Norber...");
		mainScrollPane.setHbarPolicy(ScrollBarPolicy.NEVER);
		this.initializeValues();
		this.setDefaultValues();
	}
	
	private void slideLeft() {
		TranslateTransition slideForScenePane = new TranslateTransition(Duration.seconds(1), scenePane);
		TranslateTransition slideForPersonalBackgroundPane = new TranslateTransition(Duration.seconds(1), personalBackgroundPane);
		TranslateTransition slideForWoundsPane = new TranslateTransition(Duration.seconds(1), woundsPane);
		
		// if on last pane do nothing
		if(showingPane == 2) {
			this.armarEstadoLesiones();
			this.clips.runLesiones();
			List<String> resultados = this.clips.resultadosLesiones();
			this.openResultWindow(resultados);
			
			return;
		}
		
		if(showingPane == 0) {
			this.armarEstadoEscena();
			this.clips.runEscena();
			List<String> resultados = this.clips.resultadosEscena();
			this.openResultWindow(resultados);
			
			// show pane 1
			slideForScenePane.setFromX(0);
			slideForScenePane.setToX(-(rootAnchor.getWidth()));
			slideForPersonalBackgroundPane.setFromX(rootAnchor.getWidth());
			slideForPersonalBackgroundPane.setToX(0);
			slideForScenePane.play();
			slideForPersonalBackgroundPane.play();
			this.showingPane = 1;
		} else if(showingPane == 1) {
			this.armarEstadoVictima();
			this.clips.runVictima();
			List<String> resultados = this.clips.resultadosVictima();
			this.openResultWindow(resultados);
			
			// show pane 2
			slideForPersonalBackgroundPane.setFromX(0);
			slideForPersonalBackgroundPane.setToX(-(rootAnchor.getWidth()));
			slideForWoundsPane.setFromX(rootAnchor.getWidth());
			slideForWoundsPane.setToX(0);
			slideForPersonalBackgroundPane.play();
			slideForWoundsPane.play();
			this.showingPane = 2;
		}
		
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
	
	private void initializeValues() {
		afeccionPartesOseasChoice.setItems(FXCollections.observableArrayList("Fractura expuesta", "Fractura cerrada"));
		obstruccionViaAereaChoice.setItems(FXCollections.observableArrayList("Habla", "Tose", "No respira"));
		afeccionPartesBlandasChoice.setItems(FXCollections.observableArrayList("Hematoma", "Inflamación", "No"));
		tipoSangradoChoice.setItems(FXCollections.observableArrayList("Sin sangrado visible", "Sangrado lento (a gotas)", "Sangrado abundante", "Sangrado interno (moretón)"));
		medicacionConvulsionChoice.setItems(FXCollections.observableArrayList("Tomo", "No tomo", "No usa"));
		estadoViaAereaChoice.setItems(FXCollections.observableArrayList("No obstruida", "Semi-obstruida", "Obstruida"));
		posicionChoice.setItems(FXCollections.observableArrayList("Boca abajo", "Boca arriba", "De lado", "Sentado", "Parado", "Posicion lateral de seguridad"));
		claseLesionOsteoMuscularChoice.setItems(FXCollections.observableArrayList("Fractura", "Fisura", "Esguince", "Calambre", "Desgarro", "Torcedura"));
		concienciaChoice.setItems(FXCollections.observableArrayList("Alerta", "Responde a estimulo verbal", "Responde a estimulo doloroso", "Inconciente"));
		tipoSintomaChoice.setItems(FXCollections.observableArrayList("Quemadura", "Lesion osteo-articular", "Obstrucción de vía aérea", "Lesión corto-punzante"));
		zonaLesionOsteoMuscularChoice.setItems(FXCollections.observableArrayList("Riesgosa", "No riesgosa"));
		tamanioQuemaduraChoice.setItems(FXCollections.observableArrayList("Pequeña", "Mediana", "Extensa"));
		claseHeridaSangradoChoice.setItems(FXCollections.observableArrayList("Cortante", "Punzante", "Laceración", "Contunción", "Arma de fuego", "Raspadura"));
		profundidadQuemaduraChoice.setItems(FXCollections.observableArrayList("Superficial", "Profunda"));
		estadoConvulsionChoice.setItems(FXCollections.observableArrayList("Si", "No", "Se detuvo"));
		profundidadSangradoChoice.setItems(FXCollections.observableArrayList("Superficial", "Moderado", "Profundo"));
		accesoAVictimaChoice.setItems(FXCollections.observableArrayList("Facil", "Dificil"));
		deaChoice.setItems(FXCollections.observableArrayList("No presente", "Presente cargado", "Presente descargado"));
		ubicacionSintomaChoice.setItems(FXCollections.observableArrayList("Piernas", "Brazos", "Torso", "Espalda", "Cabeza", "Manos o pies", "Genitales"));
		dolorQuemaduraChoice.setItems(FXCollections.observableArrayList("Indoloro", "Dolor leve", "Dolor grave", "Dolor moderado"));
		zonaSangradoChoice.setItems(FXCollections.observableArrayList("Riesgosa", "No riesgosa"));
		respiracionChoice.setItems(FXCollections.observableArrayList("No respira", "Respira rapido", "Respira normal", "Respira lento"));
		seguridadChoice.setItems(FXCollections.observableArrayList("Segura", "Peligro de derrumbe", "Olor extraño", "Tránsito", "Humo", "Fuego", "Otro"));
		tipoQuemaduraChoice.setItems(FXCollections.observableArrayList("Externa", "Interna"));
		tamanioSangradoChoice.setItems(FXCollections.observableArrayList("Pequeña", "Media", "Extensa"));
		temperaturaChoice.setItems(FXCollections.observableArrayList("Hipotermia", "Normal", "Hipertermia"));
		zonaQuemaduraChoice.setItems(FXCollections.observableArrayList("Riesgosa", "No riesgosa"));
		insulinoDependienteChoice.setItems(FXCollections.observableArrayList("Si y se aplicó insulina", "Si y no se aplicó insulina", "No"));
		edadChoice.setItems(FXCollections.observableArrayList("Bebé (0 a 12 meses)", "Niño (1 a 8 años)", "Adulto (mayor a 8 años)"));
		//cantidadDeVictimasChoice.setItems(FXCollections.observableArrayList("Una", "Mas de una"));
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
		posicionChoice.getSelectionModel().selectFirst();
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
		state.posicion = this.posicionChoice.getSelectionModel().getSelectedIndex();
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
	
	private void armarEstadoLesiones() {
		this.armarEstadoLesion();
		this.armarEstadoQuemadura();
		this.armarEstadoLesionOsteoMuscular();
		this.armarEstadoViaAerea();
		this.armarEstadoSangrado();
		this.armarEstadoConvulsion();
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
	
	private void openResultWindow(List<String> resultados) {
		 try{
	            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("results.fxml"));
	            Parent root1 = (Parent) fxmlLoader.load();
	            Stage stage = new Stage();
	            stage.initModality(Modality.APPLICATION_MODAL);
	            stage.setTitle("Resultados");
	            stage.setScene(new Scene(root1));
	            stage.show();
	            
	            ResultsController controller = fxmlLoader.<ResultsController>getController();
	            controller.initData(resultados);
	          } catch(Exception e) {
	        	  e.printStackTrace();
	          }
	}
	
	public void reset() {
		this.clips.reset();
		AppState state = AppState.get();
		state.reset();
		this.setDefaultValues();
		while(this.showingPane != 0) {
			this.slideRight();
		}
	}

}
