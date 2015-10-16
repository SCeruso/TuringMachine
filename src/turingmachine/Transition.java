package turingmachine;

public class Transition {
	
	private State origin;
	private State destiny;
	private String[] symbolToRead;
	private String[] symbolToWrite;
	private Moves[] moveToApply;
	private Integer numberOfTapes;
	
	public Transition(State origin, State destiny, String[] symbolToRead,
			String[] symbolToWrite, Moves[] moveToApply, Integer numberOfTapes) {
		super();
		this.origin = origin;
		this.destiny = destiny;
		this.symbolToRead = symbolToRead;
		this.symbolToWrite = symbolToWrite;
		this.moveToApply = moveToApply;
		this.numberOfTapes = numberOfTapes;
	}

	public State getOrigin() {
		return origin;
	}

	public State getDestiny() {
		return destiny;
	}

	public String[] getSymbolToRead() {
		return symbolToRead;
	}

	public String[] getSymbolToWrite() {
		return symbolToWrite;
	}

	public Moves[] getMoveToApply() {
		return moveToApply;
	}

	public Integer getNumberOfTapes() {
		return numberOfTapes;
	}
	
	
	
}
