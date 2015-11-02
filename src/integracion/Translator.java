package integracion;

import javafx.collections.FXCollections;

public class Translator {
	
	private static Translator instance;
	
	private String[] afeccionPartesOseas = {"fractura_expuesta", "fractura_cerrada"};
	private String[] obstruccionViaAerea = {"habla", "tose", "no_respira"};
	private String[] afeccionPartesBlandas = {"hematoma", "inflamacion", "no"};
	private String[] tipoSangrado = {"sin_sangrado_visible", "sangrado_lento", "sangrado_abundante", "sangrado_interno"};
	private String[] medicacionConvulsion = {"tomo", "no_tomo", "no_usa"};
	private String[] estadoViaAerea = {"no_obstruida", "semi_obstruida", "obstruida"};
	private String[] posicion = {"boca_abajo", "boca_arriba", "de_lado", "sentado", "parado", "posicion_lateral_de_seguridad"};
	private String[] claseLesionOsteoMuscular = {"fractura", "fisura", "esguince", "calambre", "desgarro", "torcedura"};
	private String[] conciencia = {"alerta", "responde_a_estimulo_verbal", "responde_a_estimulo_doloroso", "inconciente"};
	private String[] tipoSintoma = {"quemadura", "lesion_osteo_articular", "obstruccion_via_aerea", "lesion_corto_punzante"};
	private String[] zonaLesionOsteoMuscular = {"riesgosa", "no_riesgosa"};
	private String[] tamanioQuemadura = {"pequenia", "media", "extensa"};
	private String[] claseHeridaSangrado = {"cortante", "punzante", "laceracion", "contucion", "arma_de_fuego", "raspadura"};
	private String[] profundidadQuemadura = {"superficial", "profunda"};
	private String[] estadoConvulsion = {"si", "no", "se_detuvo"};
	private String[] profundidadSangrado = {"superficial", "moderado", "profundo"};
	private String[] accesoVictima = {"facil", "dificil"};
	private String[] dea = {"no_presente", "presente_cargado", "presente_descargado"};
	private String[] ubicacionSintoma = {"piernas", "brazos", "torso", "espalda", "cabeza", "manos_o_pies", "genitales"};
	private String[] dolorQuemadura = {"indoloro", "dolor_leve", "dolor_grave", "dolor_moderado"};
	private String[] zonaSangrado = {"riesgosa", "no_riesgosa"};
	private String[] respiracion = {"no_respira", "respira_rapido", "respira_normal", "respira_lento"};
	private String[] seguridad = {"segura", "peligro_derrumbe", "olor_extranio", "transito", "humo", "fuego", "otro"};
	private String[] tipoQuemadura = {"externa", "interna"};
	private String[] tamanioSangrado = {"pequenia", "media", "extensa"};
	private String[] temperatura = {"hipotermia", "normal", "hipertermia"};
	private String[] zonaQuemadura = {"riesgosa", "no_riesgosa"};
	private String[] insulinoDependiente = {"si_y_aplico_insulina", "si_y_no_aplico_insulina", "no"};
	private String[] edad = {"bebe", "ninio", "adulto"};
	//private String[] cantidadDeVictimas = {"1", "2"};
	private String[] diabetes = {"si", "no"};
	private String[] amputacionSangrado = {"si", "no"};
	private String[] objetoExtranioSangrado = {"si", "no"};
	private String[] epilepsia = {"si", "no"};
	private String[] crisisDiabetica = {"si", "no"};
	private String[] tejidoNecroso = {"si", "no"};
	private String[] fiebreConvulsion = {"si", "no"};
	private String[] epilepsiaConvulsion = {"si", "no"};
	private String[] comio = {"si", "no"};
	private String[] inflamacion = {"si", "no"};
	private String[] curiosoPresente = {"si", "no"};
	private String[] ciclicaConvulsion = {"si", "no"};
	private String[] cianosis = {"si", "no"};
	//private String duracionConvulsion = "";
	
	
	private Translator() {}
	
	public static Translator get() {
		if(instance == null) {
			instance = new Translator();
		}
		return instance;
	}
	
	public String getEscenaFactString() {
		AppState state = AppState.get();
		return String.format("(assert (escena (cantidad_victimas %s) (curioso_presente %s) (seguridad %s) (acceso_victima %s) (DEA %s)))",
				state.cantidadDeVictimas,
				this.curiosoPresente[state.curiosoPresente],
				this.seguridad[state.seguridad],
				this.accesoVictima[state.accesoVictima],
				this.dea[state.dea]
				);
	}
	
	public String getVictimaFactString() {
		AppState state = AppState.get();
		return String.format("(assert (victima (edad %s) (posicion %s) (conciencia %s) (respiracion %s) (temperatura %s) (epilepsia %s) (obstruccion_via_aerea %s) (comio %s) (diabetes %s) (insulino_dependiente %s) (crisis_diabetica %s)))", 
				this.edad[state.edad],
				this.posicion[state.posicion],
				this.conciencia[state.conciencia],
				this.respiracion[state.respiracion],
				this.temperatura[state.temperatura],
				this.epilepsia[state.epilepsia],
				this.obstruccionViaAerea[state.obstruccionViaAerea],
				this.comio[state.comio],
				this.diabetes[state.diabetes],
				this.insulinoDependiente[state.insulinoDependiente],
				this.crisisDiabetica[state.crisisDiabetica]
				);
	}
	
	public String getLesionFactString() {
		AppState state = AppState.get();
		return String.format("(assert (lesion (tipo %s) (ubicacion %s)))", 
				this.tipoSintoma[state.tipoSintoma],
				this.ubicacionSintoma[state.ubicacionSintoma]
				);
	}
	
	public String getQuemaduraFactString() {
		AppState state = AppState.get();
		return String.format("(assert (quemadura (profundidad %s) (tejido_necroso %s) (dolor %s) (inflamacion %s) (tamanio %s) (tipo %s) (zona %s)))", 
				this.profundidadQuemadura[state.profundidadQuemadura],
				this.tejidoNecroso[state.tejidoNecroso],
				this.dolorQuemadura[state.dolorQuemadura],
				this.inflamacion[state.inflamacion],
				this.tamanioQuemadura[state.tamanioQuemadura],
				this.tipoQuemadura[state.tipoQuemadura],
				this.zonaQuemadura[state.zonaQuemadura]
				);
	}
	
	public String getLesionOsteoMuscularFactString() {
		AppState state = AppState.get();
		return String.format("(assert (lesion_osteo_muscular (clase %s) (afeccion_partes_blandas %s) (afeccion_partes_oseas %s) (zona %s)))", 
				this.claseLesionOsteoMuscular[state.claseLesionOsteoMuscular],
				this.afeccionPartesBlandas[state.afeccionPartesBlandas],
				this.afeccionPartesOseas[state.afeccionPartesOseas],
				this.zonaLesionOsteoMuscular[state.zonaLesionOsteoMuscular]
				);
	}
	
	public String getViaAereaFactString() {
		AppState state = AppState.get();
		return String.format("(assert (via_aerea (estado %s) (cianosis %s)))", 
				this.estadoViaAerea[state.estadoViaAerea],
				this.cianosis[state.cianosis]
				);
	}
	
	public String getSangradoFactString() {
		AppState state = AppState.get();
		return String.format("(assert (sangrado (clase_herida %s) (profundidad %s) (objeto_extranio %s) (tamanio %s) (amputacion %s) (tipo %s) (zona %s)))", 
				this.claseHeridaSangrado[state.claseHeridaSangrado],
				this.profundidadSangrado[state.profundidadSangrado],
				this.objetoExtranioSangrado[state.objetoExtranioSangrado],
				this.tamanioSangrado[state.tamanioSangrado],
				this.amputacionSangrado[state.amputacionSangrado],
				this.tipoSangrado[state.tipoSangrado],
				this.zonaSangrado[state.zonaSangrado]
				);
	}
	
	public String getConvulsionFactString() {
		AppState state = AppState.get();
		return String.format("(assert (convulsion (estado %s) (epilepsia %s) (duracion %d) (ciclica %s) (medicacion %s) (fiebre %s)))", 
				this.estadoConvulsion[state.estadoConvulsion],
				this.epilepsiaConvulsion[state.epilepsiaConvulsion],
				state.duracionConvulsion,
				this.ciclicaConvulsion[state.ciclicaConvulsion],
				this.medicacionConvulsion[state.medicacionConvulsion],
				this.fiebreConvulsion[state.fiebreConvulsion]
				);
	}
}
