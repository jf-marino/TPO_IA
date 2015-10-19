package estado;

public enum Sangrado {
	Visible, Moreton;
	
	@Override
	public String toString() {
	  switch(this) {
	    case Visible: return "Visible";
	    case Moreton: return "Moreton";
	    default: throw new IllegalArgumentException();
	  }
	}
}
