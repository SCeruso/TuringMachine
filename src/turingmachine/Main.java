package turingmachine;
/**
 * @author Sabato Ceruso.
 * @email sab7093@gmail.com
 * Complejidad computacional.
 * Universidad de la Laguna, España.
 */
import java.io.IOException;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		TuringMachine automaton = null;
		TuringMachineFrame frame; 
		if (args.length < 1) {
			System.err.println("Se debe pasar por parametro el archivo a leer");
			return;
		}
		try {
			automaton = TuringMachineParser.parseFromFile("maquinas/" + args[0]);
			frame  = new TuringMachineFrame(automaton);
		} catch (IOException | ParsingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
		//automaton.setInputString("aaabbb");
		//System.out.println(automaton.evaluateEntry());
		
		 frame.setTitle("Maquina de turing");
		 frame.setSize(600, 300);
		// frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
	 	 frame.setLocationRelativeTo(null); // Center the frame
	     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 frame.setVisible(true);
	}
}
