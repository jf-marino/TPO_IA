package integracion;

import java.util.List;

import net.sf.clipsrules.jni.Environment;
import net.sf.clipsrules.jni.PrimitiveValue;
import utils.ResultReader;

public class ClipsHandler {

	private Environment clips;
	private static ClipsHandler handler;
	
	private ClipsHandler() {
		this.clips = new Environment();
	}
	
	public static ClipsHandler get() {
		if(handler == null) {
			handler = new ClipsHandler();
			handler.initialize();
		}
		return handler;
	}
	
	private void initialize() {
		this.reset();
	}
	
	public void reset() {
		clips.clear();
		clips.reset();
		clips.load("clips/rules.clp");
		clips.eval("(remove \"outputEscena.txt\")");
		clips.eval("(remove \"outputVictima.txt\")");
		clips.eval("(remove \"outputLesiones.txt\")");
	}
	
	public void runEscena() {
		this.openEscenaFile();
		Translator t = Translator.get();
		String escena = t.getEscenaFactString();
		clips.eval(escena);
		clips.run();
	}
	
	public void runVictima() {
		this.openVictimaFile();
		Translator t = Translator.get();
		String victima = t.getVictimaFactString();
		clips.eval(victima);
		clips.run();
	}
	
	public void runLesiones() {
		this.openLesionesFile();
		Translator t = Translator.get();
		String lesion = t.getLesionFactString();
		String quemadura = t.getQuemaduraFactString();
		String convulsion = t.getConvulsionFactString();
		String sangrado = t.getSangradoFactString();
		String lesionOsteoMuscular = t.getLesionOsteoMuscularFactString();
		String viaAerea = t.getViaAereaFactString();
		clips.eval(lesion);
		clips.eval(quemadura);
		clips.eval(convulsion);
		clips.eval(sangrado);
		clips.eval(lesionOsteoMuscular);
		clips.eval(viaAerea);
		clips.run();
	}
	
	public void close() {
		this.closeEscenaFile();
		this.closeVictimaFile();
		this.closeLesionesFile();
		System.out.println("Closed all target files.");
	}
	
	private void openEscenaFile() {
		clips.eval("(open \"outputEscena.txt\" escenaTarget \"w\")");
	}
	
	private void openVictimaFile() {
		clips.eval("(open \"outputVictima.txt\" victimaTarget \"w\")");
	}
	
	private void openLesionesFile() {
		clips.eval("(open \"outputLesiones.txt\" lesionesTarget \"w\")");
	}
	
	private void closeEscenaFile() {
		clips.eval("(close escenaTarget)");	
	}
	
	private void closeVictimaFile() {
		clips.eval("(close victimaTarget)");
	}
	
	private void closeLesionesFile() {
		clips.eval("(close lesionesTarget)");
	}
	
	public List<String> resultadosEscena() {
		this.closeEscenaFile();
		return ResultReader.read("outputEscena.txt"); 
	}
	
	public List<String> resultadosVictima() {
		this.closeVictimaFile();
		return ResultReader.read("outputVictima.txt");
	}
	
	public List<String> resultadosLesiones() {
		this.closeLesionesFile();
		return ResultReader.read("outputLesiones.txt");
	}
	
}
