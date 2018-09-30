import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;



public class GuessNode implements DecisionNode{
	
	String data;
	
	/**
	 * @name: GuessNode
	 * @param: none
	 * @return: constructor
	 */
	public GuessNode(String d) {
		data = d;
	}
	
/**
 * @name: countObjects
 * @param: none
 * @return: int 1;
 */
	public int countObjects() {
		return 1;
		
	}
	
	/**
	 * @name: guess
	 * @param: Scanner
	 * @return: DecisionNode
	 */
	public DecisionNode guess(Scanner in) {
		System.out.println("Are you thinking of a " + data + "?");
		String answer = in.nextLine().toLowerCase();
		if (answer.equals("yes")) {
			System.out.println("Excellent!");
			return this;
		} else {
			System.out.println("Oh no! I was wrong!");
			System.out.println("What animal were you thinking of?");
			String newThing = in.nextLine();
			System.out.println("What is a yes/no question that distinguishes a " + data + " from a " + newThing + "?");
			System.out.println("(Yes corresponds to " + data + "; No corresponds to " + newThing +  ")");
			String newQuestion = in.nextLine();
			System.out.println("Thanks!  I'll learn from this experience!");
			return new QuestionNode(newQuestion, this, new GuessNode(newThing));
			
		}
		
	}
	/**
	 * @name: write
	 * @param: FileWriter
	 * @return: void
	 */
	public void write(FileWriter out) throws IOException{
		out.write(data + "\n");
	
	}
	
	
	
	
	
	
}
