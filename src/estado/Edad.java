package estado;

public enum Edad {
	Adulto, Niño, Bebe;
	
	@Override
	public String toString() {
	  switch(this) {
	    case Adulto: return "Adulto";
	    case Niño: return "Niño";
	    case Bebe: return "Bebe";
	    default: throw new IllegalArgumentException();
	  }
	}
}
