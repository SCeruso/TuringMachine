package turingmachine;

/**
 * @author Sabato Ceruso.
 * @email sab7093@gmail.com
 * Complejidad computacional.
 * Universidad de la Laguna, Espa�a.
 */

/**
 * Clase encargada de definir un error durante el parsing.
 */
public class ParsingException extends Exception {

	public ParsingException(String m) {
		super(m);
	}
}
