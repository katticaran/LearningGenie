import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class DecisionTree {
	DecisionNode root;
	/**
	 * @name: DecisionTree
	 * @param: none
	 * @return: constructor
	 */
	public DecisionTree() {
		this.root = new GuessNode("Dog");
	}
	/**
	 * @name: DecisionTree
	 * @param: File;
	 * @return: constructor
	 */
	public DecisionTree(File file) throws FileNotFoundException {

		Scanner input = new Scanner(file);
		if (!input.hasNextLine()) {
			input.close();
			throw new IllegalArgumentException();
		}
		String nextLine = input.nextLine();
		if (nextLine.startsWith("#")) {
			root = new QuestionNode(nextLine, input);
		}
		else {
			root = new GuessNode(nextLine);
		}
		input.close();
	}
	/**
	 * @name: countObjects
	 * @param: none
	 * @return: int, the number of GuessNode in the tree;
	 */
	public int countObjects() {
		return root.countObjects();
	}
	/**
	 * @name: guess
	 * @param: none
	 * @return: none
	 */
	public void guess(Scanner in) {
		root = root.guess(in);
	}
	/**
	 * @name: write
	 * @param: FileWriter
	 * @return: none
	 */
	public void write(FileWriter out) throws IOException { //public void write(FileWriter out)
		root.write(out);
	}

}
