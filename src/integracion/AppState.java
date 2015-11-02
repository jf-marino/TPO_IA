package integracion;

public class AppState {
	
	private static AppState instance;
	
	public int afeccionPartesOseas = 0;
	public int obstruccionViaAerea = 0;
	public int afeccionPartesBlandas = 0;
	public int tipoSangrado = 0;
	public int medicacionConvulsion = 0;
	public int estadoViaAerea = 0;
	public int posicion = 0;
	public int claseLesionOsteoMuscular = 0;
	public int conciencia = 0;
	public int tipoSintoma = 0;
	public int zonaLesionOsteoMuscular = 0;
	public int tamanioQuemadura = 0;
	public int claseHeridaSangrado = 0;
	public int profundidadQuemadura = 0;
	public int estadoConvulsion = 0;
	public int profundidadSangrado = 0;
	public int accesoVictima = 0;
	public int dea = 0;
	public int ubicacionSintoma = 0;
	public int dolorQuemadura = 0;
	public int zonaSangrado = 0;
	public int respiracion = 0;
	public int seguridad = 0;
	public int tipoQuemadura = 0;
	public int tamanioSangrado = 0;
	public int temperatura = 0;
	public int zonaQuemadura = 0;
	public int insulinoDependiente = 0;
	public int edad = 0;
	
	public int cantidadDeVictimas = 0;
	public int diabetes = 1;
	public int amputacionSangrado = 1;
	public int objetoExtranioSangrado = 1;
	public int epilepsia = 1;
	public int crisisDiabetica = 1;
	public int tejidoNecroso = 1;
	public int fiebreConvulsion = 1;
	public int epilepsiaConvulsion = 1;
	public int comio = 1;
	public int inflamacion = 1;
	public int curiosoPresente = 1;
	public int ciclicaConvulsion = 1;
	public int cianosis = 1;
	public int duracionConvulsion = 0;
	
	
	private AppState() {}
	
	public static AppState get() {
		if(instance == null) {
			instance = new AppState();
		}
		return instance;
	}
	
	public void reset() {
		afeccionPartesOseas = 0;
		obstruccionViaAerea = 0;
		afeccionPartesBlandas = 0;
		tipoSangrado = 0;
		medicacionConvulsion = 0;
		estadoViaAerea = 0;
		posicion = 0;
		claseLesionOsteoMuscular = 0;
		conciencia = 0;
		tipoSintoma = 0;
		zonaLesionOsteoMuscular = 0;
		tamanioQuemadura = 0;
		claseHeridaSangrado = 0;
		profundidadQuemadura = 0;
		estadoConvulsion = 0;
		profundidadSangrado = 0;
		accesoVictima = 0;
		dea = 0;
		ubicacionSintoma = 0;
		dolorQuemadura = 0;
		zonaSangrado = 0;
		respiracion = 0;
		seguridad = 0;
		tipoQuemadura = 0;
		tamanioSangrado = 0;
		temperatura = 0;
		zonaQuemadura = 0;
		insulinoDependiente = 0;
		edad = 0;
		cantidadDeVictimas = 0;
		diabetes = 1;
		amputacionSangrado = 1;
		objetoExtranioSangrado = 1;
		epilepsia = 1;
		crisisDiabetica = 1;
		tejidoNecroso = 1;
		fiebreConvulsion = 1;
		epilepsiaConvulsion = 1;
		comio = 1;
		inflamacion = 1;
		curiosoPresente = 1;
		ciclicaConvulsion = 1;
		cianosis = 1;
		duracionConvulsion = 0;
	}
}
