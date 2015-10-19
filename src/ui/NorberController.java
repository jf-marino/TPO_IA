package ui;

import java.util.ArrayList;
import java.util.List;

import estado.Edad;
import estado.Estado;
import javafx.collections.FXCollections;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

public class NorberController implements Initializable {
	
	private Estado estado;
	
	/**
	 * Datos Personales
	 */
	public ChoiceBox<String> edadChoiceBox;
	public CheckBox diabetesCheckBox;
	public CheckBox asmaCheckBox;
	public CheckBox alergiasCheckBox;
	public TextField queAlergiasTextField;
	public CheckBox epilepsiaCheckBox;
	public TextField epilepsiaMedicacionTextField;
	
	/**
	 * Contexto
	 */
	public CheckBox conscienteCheckBox;
	public CheckBox respiraCheckBox;
	public CheckBox sangradoCheckBox;
	public ChoiceBox<String> sangradoZonaChoiceBox;
	public ChoiceBox<String> sangradoTipoChoiceBox;
	public TextField sangradoCantidadTextField;
	public TextField sangradoTamanioTextField;
	public CheckBox traumaCheckBox;
	public ChoiceBox<String> traumaZonaChoiceBox;
	public ChoiceBox<String> traumaTipoChoiceBox;
	public CheckBox quemaduraCheckBox;
	public ChoiceBox<String> quemaduraZonaChoiceBox;
	public Slider quemaduraExtensionSlider;
	public Slider quemaduraProfundidadSlider;
	public CheckBox quemaduraDolorCheckBox;
	public CheckBox convulsionCheckBox;
	public TextField convulsionTiempoTextField;
	
	
	@Override
	public void initialize(java.net.URL location, java.util.ResourceBundle resources) {
		System.out.println("Inicializando a Norber...");
		this.estado = Estado.instance();
		
		this.edadChoiceBox.setItems(FXCollections.observableArrayList(estado.getEdades()));
		this.edadChoiceBox.getSelectionModel().select(0);
		
		this.sangradoZonaChoiceBox.setItems(FXCollections.observableArrayList(estado.getZonas()));
		this.sangradoTipoChoiceBox.setItems(FXCollections.observableArrayList(estado.getSangrados()));
		this.sangradoZonaChoiceBox.getSelectionModel().select(0);
		this.sangradoTipoChoiceBox.getSelectionModel().select(0);
		
		this.traumaZonaChoiceBox.setItems(FXCollections.observableArrayList(estado.getZonas()));
		this.traumaTipoChoiceBox.setItems(FXCollections.observableArrayList(estado.getTraumas()));
		this.traumaZonaChoiceBox.getSelectionModel().select(0);
		this.traumaTipoChoiceBox.getSelectionModel().select(0);
		
		this.quemaduraZonaChoiceBox.setItems(FXCollections.observableArrayList(estado.getZonas()));
		this.quemaduraZonaChoiceBox.getSelectionModel().select(0);
	}
	
	public void submit() {
		System.out.println("Imprimiendo el estado");
		System.out.println("edad");
		System.out.println(this.edadChoiceBox.getSelectionModel().getSelectedItem());
		System.out.println("diabetes");
		System.out.println(this.diabetesCheckBox.isSelected());
		System.out.println("asma");
		System.out.println(this.asmaCheckBox.isSelected());
		System.out.println("alergias");
		System.out.println(this.alergiasCheckBox.isSelected());
		System.out.println("a que");
		System.out.println(this.queAlergiasTextField.getText());
		System.out.println("epilepsia");
		System.out.println(this.epilepsiaCheckBox.isSelected());
		System.out.println("medicacion");
		System.out.println(this.epilepsiaMedicacionTextField.getText());
	}
	
	public void reset() {
		
	}

}
