package integracion;

import java.util.Set;

import net.sf.clipsrules.jni.Environment;
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
		clips.eval("(remove \"outputLesion.txt\")");
		clips.eval("(remove \"outputViaAerea.txt\")");
		clips.eval("(remove \"outputSangrado.txt\")");
		clips.eval("(remove \"outputQuemaduras.txt\")");
		clips.eval("(remove \"outputLesionOsteoMuscular.txt\")");
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
		String convulsion = t.getConvulsionFactString();
		clips.eval(victima);
		clips.eval(convulsion);
		clips.run();
	}
	
	public void runLesion() {
		this.openLesionFile();
		Translator t = Translator.get();
		String lesion = t.getLesionFactString();
		clips.eval(lesion);
		clips.run();
	}
	
	public void runViaAerea() {
		this.openViaAereaFile();
		Translator t = Translator.get();
		String viaAerea = t.getViaAereaFactString();
		clips.eval(viaAerea);
		clips.run();
	}
	
	public void runSangrado() {
		this.openSangradoFile();
		Translator t = Translator.get();
		String sangrado = t.getSangradoFactString();
		clips.eval(sangrado);
		clips.run();
	}
	
	public void runQuemadura() {
		this.openQuemadurasFile();
		Translator t = Translator.get();
		String quemadura = t.getQuemaduraFactString();
		clips.eval(quemadura);
		clips.run();
	}
	
	public void runLesionOsteoMuscular() {
		this.openLesionOsteoMuscularFile();
		Translator t = Translator.get();
		String lesionOsteoMuscular = t.getLesionOsteoMuscularFactString();
		clips.eval(lesionOsteoMuscular);
		clips.run();
	}
	
	public void close() {
		this.closeEscenaFile();
		this.closeVictimaFile();
		this.closeLesionFile();
		this.closeViaAereaFile();
		this.closeSangradoFile();
		this.closeQuemadurasFile();
		this.closeLesionOsteoMuscularFile();
		
		clips.eval("(remove \"outputEscena.txt\")");
		clips.eval("(remove \"outputVictima.txt\")");
		clips.eval("(remove \"outputLesion.txt\")");
		clips.eval("(remove \"outputViaAerea.txt\")");
		clips.eval("(remove \"outputSangrado.txt\")");
		clips.eval("(remove \"outputQuemaduras.txt\")");
		clips.eval("(remove \"outputLesionOsteoMuscular.txt\")");
	}
	
	private void openEscenaFile() {
		clips.eval("(open \"outputEscena.txt\" escenaTarget \"w\")");
	}
	
	private void openVictimaFile() {
		clips.eval("(open \"outputVictima.txt\" victimaTarget \"w\")");
	}
	
	private void openLesionFile() {
		clips.eval("(open \"outputLesion.txt\" lesionesTarget \"w\")");
	}
	
	private void openViaAereaFile() {
		clips.eval("(open \"outputViaAerea.txt\" viaAereaTarget \"w\")");
	}
	
	private void openSangradoFile() {
		clips.eval("(open \"outputSangrado.txt\" sangradoTarget \"w\")");
	}
	
	private void openQuemadurasFile() {
		clips.eval("(open \"outputQuemaduras.txt\" quemadurasTarget \"w\")");
	}
	
	private void openLesionOsteoMuscularFile() {
		clips.eval("(open \"outputLesionOsteoMuscular.txt\" lesionOsteoMuscularTarget \"w\")");
	}
	
	private void closeEscenaFile() {
		clips.eval("(close escenaTarget)");	
	}
	
	private void closeVictimaFile() {
		clips.eval("(close victimaTarget)");
	}
	
	private void closeLesionFile() {
		clips.eval("(close lesionesTarget)");
	}
	
	private void closeViaAereaFile() {
		clips.eval("(close viaAereaTarget)");	
	}
	
	private void closeSangradoFile() {
		clips.eval("(close sangradoTarget)");	
	}
	
	private void closeQuemadurasFile() {
		clips.eval("(close quemadurasTarget)");	
	}
	
	private void closeLesionOsteoMuscularFile() {
		clips.eval("(close lesionOsteoMuscularTarget)");	
	}
	
	public Set<String> resultadosEscena() {
		this.closeEscenaFile();
		return ResultReader.read("outputEscena.txt"); 
	}
	
	public Set<String> resultadosVictima() {
		this.closeVictimaFile();
		return ResultReader.read("outputVictima.txt");
	}
	
	public Set<String> resultadosLesiones() {
		this.closeLesionFile();
		return ResultReader.read("outputLesion.txt");
	}
	
	public Set<String> resultadosViaAerea() {
		this.closeViaAereaFile();
		return ResultReader.read("outputViaAerea.txt");
	}
	
	public Set<String> resultadosSangrado() {
		this.closeSangradoFile();
		return ResultReader.read("outputSangrado.txt");
	}
	
	public Set<String> resultadosQuemaduras() {
		this.closeQuemadurasFile();
		return ResultReader.read("outputQuemaduras.txt");
	}
	
	public Set<String> resultadosLesionOsteoMuscular() {
		this.closeLesionOsteoMuscularFile();
		return ResultReader.read("outputLesionOsteoMuscular.txt");
	}
	
}
