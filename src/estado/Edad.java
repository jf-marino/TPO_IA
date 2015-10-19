package estado;

public enum Edad {
	Adulto, Ni�o, Bebe;
	
	@Override
	public String toString() {
	  switch(this) {
	    case Adulto: return "Adulto";
	    case Ni�o: return "Ni�o";
	    case Bebe: return "Bebe";
	    default: throw new IllegalArgumentException();
	  }
	}
}
