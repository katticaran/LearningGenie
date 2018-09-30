import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class LearningGenie {
	
	public static void main(String[] args) throws IOException {
		File f = new File("learning.txt");
		DecisionTree tree = new DecisionTree(f);
		System.out.println("I am the learning genie!");
		System.out.println("I can figure out whatever you are thinking of by asking questions.");
		System.out.println("I know " + tree.countObjects() + " thing(s)!\n");
		
		boolean running = true;
		Scanner in = new Scanner(System.in);
		while (running) {
			System.out.println("Think of an object!");
			tree.guess(in);
			System.out.println("Do you want to play again? ");
			String answer = in.nextLine().toLowerCase();
			if (answer.equals("no")) {
				running = false;
			}
		}
		
		FileWriter fw = new FileWriter("learning.txt", false);
		tree.write(fw);
		fw.close();
	}

}
