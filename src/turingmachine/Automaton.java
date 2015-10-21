package turingmachine;
/**
 * Complejidad computacional.
 * Universidad de la Laguna.
 * 
 * @author Sabato Ceruso.
 * @email sab7093@gmail..com
 */
import java.util.ArrayList;
import java.util.HashMap;

public class Automaton {
	private HashMap<State, ArrayList<Transition>> automaton;
	
	public Automaton() {
		this.automaton = new HashMap<State, ArrayList<Transition>>();
	}
	
	
	public void addTransitionToState(Transition t) {
		getAutomaton().keySet().forEach((state)-> {if (state.equals(t.getDestiny())) t.getDestiny().setIsFinal(state.getIsFinal());});
		getAutomaton().keySet().forEach((state)-> {if (state.equals(t.getOrigin())) t.getOrigin().setIsFinal(state.getIsFinal());});
		
		getAutomaton().get(t.getOrigin()).add(t);
	}
	
	
	public ArrayList<Transition> getTransitionsFromState(State state) {
		return getAutomaton().get(state);
	}
	/**
	 * Verifica si el estado existe en el automata.
	 * @param state
	 * @return True si existe.
	 */
	public boolean stateExist(String state) {
		return getAutomaton().containsKey(new State(state));
	}
	
	/**
	 * A�ade un nuevo estado final.
	 * @param finalState
	 */
	public void addFinalState(String finalState) {
	
			getAutomaton().keySet().forEach((state)-> {if (state.equals(new State(finalState))) state.setIsFinal(true);});
	}
	
	/**
	 * A�ade un nuevo estado.
	 * @param newState
	 */
	public void addState(String newState){
		
		if (getAutomaton().containsKey(new State(newState)))
			throw new IllegalArgumentException("El estado " + newState + " ya existe.");
		else
			getAutomaton().put(new State(newState), new ArrayList<Transition>());
	}
	
	public HashMap<State, ArrayList<Transition>> getAutomaton() {
		return automaton;
	}

	public void setAutomaton(HashMap<State, ArrayList<Transition>> automaton) {
		this.automaton = automaton;
	}
	
	
}
