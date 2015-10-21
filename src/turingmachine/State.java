package turingmachine;
/**
 * Complejidad computacional.
 * Universidad de la Laguna.
 * 
 * @author Sabato Ceruso.
 * @email sab7093@gmail..com
 */
public class State {
	
	private String name;
	private Boolean isFinal = false;
	
	public State(String name) {
		this.name = name;
	}
	public State(String name, Boolean isFinal) {
		this(name);
		this.isFinal = isFinal;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Boolean getIsFinal() {
		return isFinal;
	}
	public void setIsFinal(Boolean isFinal) {
		this.isFinal = isFinal;
	}

	@Override
	public boolean equals(Object arg0) {
		if (this.name.equals(((State)arg0).getName()))
			return true;
		return false;
	}
	@Override
	public int hashCode() {	
		return getName().hashCode();
	}
	
}
