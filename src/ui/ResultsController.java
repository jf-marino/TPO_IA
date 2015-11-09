package ui;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class ResultsController  implements Initializable {
	
	private static final Map<String, String> imageMap = new HashMap<String, String>();
    static {
        imageMap.put("1", "file:diagnosticos/01.Llamada SEM.jpg");
        imageMap.put("2", "file:diagnosticos/02. RCP Adultos.jpg");
        imageMap.put("3", "file:diagnosticos/03. RCP Niños.jpg");
        imageMap.put("4", "file:diagnosticos/04. RCP Bebes.jpg");
        imageMap.put("5", "file:diagnosticos/05.PLS.jpg");
        imageMap.put("6", "file:diagnosticos/06.Obstruccion via aerea Total Adultos.jpg");
        imageMap.put("7", "file:diagnosticos/07.Obstruccion via aerea Total Niños.jpg");
        imageMap.put("8", "file:diagnosticos/08.Obstruccion via aerea Total Bebes.jpg");
        imageMap.put("9", "file:diagnosticos/09.Obstruccion via aerea Parcial Adultos.jpg");
        imageMap.put("10", "file:diagnosticos/10.Obstruccion via aerea Parcial Niños.jpg");
        imageMap.put("11", "file:diagnosticos/");
        imageMap.put("12", "file:diagnosticos/12.Hemorragias.jpg");
        imageMap.put("13", "file:diagnosticos/13.Raspaduras y Heridas cortantes.jpg");
        imageMap.put("14", "file:diagnosticos/14.Quemaduras Leves.jpg");
        imageMap.put("15", "file:diagnosticos/15.Quemaduras Externas y graves.jpg");
        imageMap.put("16", "file:diagnosticos/16.Lesiones en huesos musculos y articulaciones.jpg");
        imageMap.put("17", "file:diagnosticos/17.Vendajes.jpg");
        imageMap.put("18", "file:diagnosticos/18.Convulsiones.jpg");
        imageMap.put("19", "file:diagnosticos/19.Diabetes.jpg");
        imageMap.put("20", "file:diagnosticos/20.Hipotermia.jpg");
        imageMap.put("21", "file:diagnosticos/21.Hipertermia.jpg");
        imageMap.put("22", "file:diagnosticos/22.Triage.jpg");
        imageMap.put("23", "file:diagnosticos/23.Asegurar escena por transito.jpg");
        imageMap.put("24", "file:diagnosticos/24.Bajar temperatura chicos convulsiones.jpg");
        imageMap.put("25", "file:diagnosticos/25.Via aerea semiobstruida bebe.jpg");
        imageMap.put("26", "file:diagnosticos/26.Recuperar parte y ponerla en hielo.jpg");
        imageMap.put("27", "file:diagnosticos/27.Fijar Objeto.jpg");
        imageMap.put("28", "file:diagnosticos/28.Herida de arma de fuego en zona riesgosa.jpg");
        imageMap.put("29", "file:diagnosticos/29.Herida de bala Instrucciones para ciertas regiones del cuerpo.jpg");
        imageMap.put("30", "file:diagnosticos/30.Herida de arma de fuego en zona no riesgosa.jpg");
    }

	@FXML
	public VBox resultsVBox;
	@FXML
	public ScrollPane resultsScroll;
	
	@Override
	public void initialize(java.net.URL location, java.util.ResourceBundle resources) {
		resultsScroll.setHbarPolicy(ScrollBarPolicy.NEVER);
	}
	
	public void initData(Set<String> resultados) {
		System.out.println("ResultsController =>");
		for(String resultado : resultados) {
			// Agregar imagenes
			System.out.println(String.format("Showing image %s", imageMap.get(resultado)));
			ImageView iv = new ImageView();
			iv.setImage(new Image(imageMap.get(resultado)));
			resultsVBox.getChildren().add(iv);
		}
	}
}
