package turingmachine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;



public class TuringMachine {
	
	public static String BLANK = "$";							// Simbolo que representa el blanco.
	
	private Automaton automaton;									// Asociacion de estados a transiciones.
	private State actualState;										// Estado actual del automata.
	private Alphabet sigma;										// Alfabeto de la cadena de entrada (sigma).	
	private Alphabet tau;
	private State startingState;									// Estado inicial.
	private ArrayList<Tape> tapes;												// Cinta de la máquina.
	private Integer numberOfTapes;
	
	/**
	 * Evalua la entrada actual.
	 * @return True si es aceptada.
	 */
	public boolean evaluateEntry() {
		Transition t;
		do {
			t = getNextTransitionToApply();
			
			if (t == null)
				break;
			
			applyTransition(t);
			
		}while(true);
		
		return entryAccepted();
	}
	private void applyTransition(Transition t) {
		setActualState(t.getDestiny());
		String[] toWrite = t.getSymbolToWrite();
		Moves[] moves = t.getMoveToApply();
		
		for (int i = 0; i < getNumberOfTapes(); i++) {
			getTapes().get(i).Write(toWrite[i]);
			
			switch (moves[i]) {
			case LEFT:
				getTapes().get(i).moveLeft();
				break;
			case RIGHT:
				getTapes().get(i).moveRight();
				break;
			default:
				break;
			}
		}
		
	}
	private Transition getNextTransitionToApply() {
		ArrayList<Transition> possibleTransitions;
		
		possibleTransitions = getAutomaton().getTransitionsFromState(getActualState());
		
		for (int i = 0; i < possibleTransitions.size(); i++)
			if (canApplyTransition(possibleTransitions.get(i)))
				return possibleTransitions.get(i);
		
		
		return null;
	}
	
	private Boolean canApplyTransition(Transition t) {
		String[] symbols = t.getSymbolToRead();
		
		for (int i = 0; i < getTapes().size(); i++) {
			if (!getTapes().get(i).read().equals(symbols[i]))
				return false;
		}
		return true;
	}
	/**
	 * Devuelve true si en el estado en el que esta
	 * se puede dar por aceptada la entrada.
	 * @return
	 */
	private boolean entryAccepted() {
		return getActualState().getIsFinal();
	}

	/**
	 * Verifica si el estado existe en el automata.
	 * @param state
	 * @return True si existe.
	 */
	public boolean stateExist(String state) {
		return getAutomaton().stateExist(state);
	}
	/**
	 * Añade un nuevo estado.
	 * @param newState
	 */
	public void addState(String newState){
		getAutomaton().addState(newState);
	}
	/**
	 * Añade un nuevo estado final.
	 * @param finalState
	 */
	public void addFinalState(String finalState) {
		getAutomaton().addFinalState(finalState);
	}
	/**
	 * Añade un nuevo elemento al alfabeto sigma.
	 * @param newElement
	 */
	public void addElementToSigma(String newElement) {
		getSigma().addElementToAlphabet(newElement);
	}
	/**
	 * 
	 * @param newElement
	 */
	public void addElementToTau(String newElement) {
		getTau().addElementToAlphabet(newElement);
	}
	/**
	 * Añade una nueva transicion.
	 * @param origin
	 * @param entryToConsume
	 * @param stackSymbolToConsume
	 * @param destiny
	 * @param symbolsToPush
	 * @throws IllegalArgumentException
	 */
	public void addTransition(String origin,  String destiny, String[] symbolsToRead, String[] symbolsToWrite, Moves[] moves) throws IllegalArgumentException {
		Transition transition;
		
		if (!stateExist(origin))
			throw new IllegalArgumentException("El elemento " + origin + " no forma parte del conjunto de estados.");
		if (!stateExist(destiny))
			throw new IllegalArgumentException("El elemento " + destiny + " no forma parte del conjunto de estados.");
		if (getNumberOfTapes() != symbolsToRead.length || getNumberOfTapes() != symbolsToWrite.length || getNumberOfTapes() !=  moves.length)
			throw new IllegalArgumentException("Fallo en las transiciones");
		
	
		transition = new Transition(new State(origin), new State(destiny), symbolsToRead, symbolsToWrite, moves, getNumberOfTapes());
		
		getAutomaton().addTransitionToState(origin, transition);
	}
	/**
	 **************************************** Getters y Setters.*********************
	 */

	public Automaton getAutomaton() {
		return automaton;
	}

	public void setAutomaton(Automaton automaton) {
		this.automaton = automaton;
	}

	public State getActualState() {
		return actualState;
	}

	public void setActualState(State actualState) {
		this.actualState = actualState;
	}


	public State getStartingState() {
		return startingState;
	}

	public void setStartingState(State startingState) {
		this.startingState = startingState;
		if (!getAutomaton().stateExist(startingState.getName()))
			throw new IllegalArgumentException("No existe el estado " + startingState.getName());
	}

	public ArrayList<Tape> getTapes() {
		return tapes;
	}

	public void setTapes(ArrayList<Tape> tapes) {
		this.tapes = tapes;
	}

	public Integer getNumberOfTapes() {
		return numberOfTapes;
	}

	public void setNumberOfTapes(Integer numberOfTapes) {
		this.numberOfTapes = numberOfTapes;
	}
	public Alphabet getSigma() {
		return sigma;
	}
	public void setSigma(Alphabet sigma) {
		this.sigma = sigma;
	}
	public Alphabet getTau() {
		return tau;
	}
	public void setTau(Alphabet tau) {
		this.tau = tau;
	}
	
	
}
