package estado;

import java.util.ArrayList;
import java.util.List;

public class Estado {
	
	/**
	 * Datos Personales
	 */
	public Edad edad;
	public boolean diabetes;
	public boolean asma;
	public boolean alergias;
	public String queAlergias;
	public boolean epilepsia;
	public String medicacion;
	
	/**
	 * Contexto
	 */
	public boolean consciente;
	public boolean respira;
	public boolean sangrado;
	public Zona zonaSangrado;
	public Sangrado tipoSangrado;
	public String cantidadSangrado;
	public String tamañoMoreton;
	public boolean trauma;
	public Zona zonaTrauma;
	public Trauma tipoTrauma;
	public boolean quemadura;
	public Zona zonaQuemadura;
	public int extensionQuemadura;
	public int profundidadQuemadura;
	public boolean dolorQuemadura;
	public boolean convulsion;
	public String tiempoConvulsion;
	
	
	
	private static Estado estado;
	
	public static Estado instance() {
		if(estado == null) {
			estado = new Estado();
		}
		return estado;
	}
	
	private Estado() {}
	
	public List<String> getZonas() {
		ArrayList<String> zonas = new ArrayList<String>(); 
		for(Zona z : Zona.values()) {
			zonas.add(z.toString());
		}
		return zonas;
	}
	
	public List<String> getEdades() {
		ArrayList<String> edades = new ArrayList<String>(); 
		for(Edad e : Edad.values()) {
			edades.add(e.toString());
		}
		return edades;
	}
	
	public List<String> getTraumas() {
		ArrayList<String> traumas = new ArrayList<String>(); 
		for(Trauma t : Trauma.values()) {
			traumas.add(t.toString());
		}
		return traumas;
	}
	
	public List<String> getSangrados() {
		ArrayList<String> sangrados = new ArrayList<String>(); 
		for(Sangrado s : Sangrado.values()) {
			sangrados.add(s.toString());
		}
		return sangrados;
	}
	
	
}
