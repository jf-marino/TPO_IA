package estado;

public enum Zona {
	Cabeza, Torso, Brazos, Piernas;
	
	@Override
	public String toString() {
	  switch(this) {
	    case Cabeza: return "Cabeza";
	    case Torso: return "Torso";
	    case Brazos: return "Brazos";
	    case Piernas: return "Piernas";
	    default: throw new IllegalArgumentException();
	  }
	}
}
