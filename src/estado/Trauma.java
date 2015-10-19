package estado;

public enum Trauma {
	Fractura, Fractura_Expuesta, Inflamacion;
	
	@Override
	public String toString() {
	  switch(this) {
	    case Fractura: return "Fractura";
	    case Fractura_Expuesta: return "Fractura Expuesta";
	    case Inflamacion: return "Inflamacion";
	    default: throw new IllegalArgumentException();
	  }
	}
}
